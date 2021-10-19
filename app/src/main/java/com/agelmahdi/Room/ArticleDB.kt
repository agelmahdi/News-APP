package com.agelmahdi.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.agelmahdi.newsapp.Model.NewsModel.Article

@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class ArticleDB : RoomDatabase() {

    abstract fun getArticleDAO(): ArticleDB

    companion object {
        @Volatile // other threads can immediately see when a thread changes this instance
        private var instance: ArticleDB? = null

        // to sync setting that instance
        // make sure that there is only a single instance of DB at once
        private val LOCK = Any()

        // called whenever we create an instance of DB
        // basically, when we initialize or instantiate this object
        operator fun invoke(context: Context) =
            instance ?: synchronized(LOCK) { // can't be accessed by other threads at same time
                instance ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDB::class.java,
                "articles_db.db"
            ).build()
    }
}