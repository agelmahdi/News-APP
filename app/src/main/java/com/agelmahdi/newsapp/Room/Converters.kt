package com.agelmahdi.newsapp.Room

import androidx.room.TypeConverter
import com.agelmahdi.newsapp.Model.NewsModel.Source

class Converters {
    // Room can only handle primitive data type and strings
    // TypeConverter to interpret source class to convert that into a string or primitive data type

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name,name)
    }

}