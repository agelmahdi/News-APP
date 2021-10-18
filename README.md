# NewsAPP Android Intermediate Level

This is a practical project for intermediate android developers that covers the following skills: Real-like coding with Kotlin, MVVM Design pattern, Kotlin Coroutines, Room database, Recyclerview, Retrofit, and Navigation Controller.

# Kotlin Coroutine

1. Threads and Functions?
   - Function: is a sequence of instructions that takes inputs and gives us the output.
   - Thread: Describes in which context this sequence of instructions should be executed. 
   - Multithreading: Without it, all instructions in a program will be executed one after another that is because executed in the same single thread.

2. Difference between Synchronous and Asynchronous?
   - Synchronous: The instruction will be executed in the same thread.
   - Asynchronous: The instruction will be executed in a different thread.
   
3. Why is threading important for android apps?
  - All instructions are generally executed in a single thread which is called the Main thread that can lead to some problems:
    - The UI needed to be updated in the same thread,
    - When making a network call that takes a long time to be executed, other instructions won't be executed.
     - for That, we start a separate thread to not block other important threads.

4. When to use Multithreading?
  - Network calls. 
  - Database operations. 
  - Complex calculations.

5. What distinguish Coroutines from Threads?
   - Coroutines are actually a lightweight threads with some useful extra functionality.
  - Executed without a thread: so we can start many coroutines inside of a single thread.
  - Coroutines are suspendable: that means we can execute some instructions pause the coroutine in the middle of execution and let it continue when we wanted to.
  - Easily switch their context: Threads can't do that, which means a coroutine that was started on one thread can easily switch the thread is running in.
     
6. Dependencies:

  - implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
  - implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

7. Coroutine Scope:
   - Every coroutine must start in a coroutine scope.
     - Global scope, means this will live as long as our application does,  
       of course if coroutine finishes its job it will be destroyed and not kept alive util the apps dies,
       but let say coroutine still has instructions to do but apps dies it also dies because of Global scope.
       
     - ViewModel Scope: A scope bound to a view model. Use this when including the architecture components ktx library. 
       This scope binds coroutines to the view model. When it is destroyed, the coroutines running within the ViewModel’s context will be cancelled automatically.
     - Custom Scope: A scope bound to an object extending Coroutine scope. When you extend CoroutineScope from your object and tie it to an associated Job, you can manage the coroutines running within this scope. For example, you call job = Job() from your activity’s onCreate and job.cancel() from onDestroy() to cancel any coroutines running within this component’s custom scope.
       - if the main tread finishes his work, means all other threads or coroutines will be canceled.
     
    
9. Difference between delay and sleep?
   - Delay: only pause the current coroutine and not block and whole thread.
   - Sleep: unlike delay, this blocks the main thread.
   
10. Suspend function: that can only be executed within another suspend function or inside a coroutine.

11. Coroutine Contexts: coroutines always start in a specific context, and the context will describe in which thread the coroutine will be started.

12. Dispatcher: depends on what coroutine should do we should pass a different dispatcher.
   - Dispatcher.Main: if we need to do UI operations, because we only update UI from the main thread. 
   - Dispatcher.IO: if we need to do data operations, such as networking, writing to database, or read/write files. 
   - Dispatcher.Default: if we need to do a complex or long running calculations, that would block the main thread. 
   - Dispatcher.Unconfined: its not confined to a specific thread, it calls the suspend function it will stay in the thread the suspend function resumed. 
    
13. runBlocking: this block the main thread until finishing its work.
   - if you don't care about that it is not asynchronous. 
   - for testing with Junit to actually access the suspend function from within a test function.
   - Quickly play around coroutines to figure out how actually they work behind the sence.

# Android Architecture Components

 - Android Architecture Components are a set of libraries to help with various challenges in dealing with Android architecture.
 
1. Room handles database persistence.
2. Lifecycle helps you create components that are aware of the current Android lifecycle state.
3. ViewModel holds data and survives configuration changes.
4. LiveData provides observable data to views.
5. Data binding allows Android Views to observe changes to data in XML.
6. Paging handles displaying infinite lists.
7. Navigation handles complex navigation.
8. WorkManager manages background tasks.

![image](https://user-images.githubusercontent.com/26491505/137820915-37e83a88-c8e2-4316-a356-5309d975ef92.png)

# Room Database

1. What is Room?

  - The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
  - Basically, with the help of room we can quickly create sqlite databases and perform the operations like create, read, update and delete. Room makes everything very easy and quick.

2. Components of Room

  - We have 3 components of room.
   
    - Entity: Instead of creating the SQLite table, we will create the Entity. Entity is nothing but a model class annotated with @Entity. The variables of this class is our columns, and the class is our table.
    - Database: It is an abstract class where we define all our entities.
    - DAO: Stands for Data Access Object. It is an interface that defines all the operations that we need to perform in our database.

![image](https://user-images.githubusercontent.com/26491505/137813145-a1347b9c-35a8-49a3-9642-02b23d4a3e17.png)

   
# MVVM Design pattern

   - Model: This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
   - View: The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
   - ViewModel: It exposes those data streams which are relevant to the View. Moreover, it servers as a link between the Model and the View.
   
![image](https://user-images.githubusercontent.com/26491505/137802023-883c2834-3b90-479a-ada8-f8ad129d4021.png)

                  
- Ways to Implement MVVM in the Project
   - There are 2 ways to implement MVVM design pattern in Android projects:

  1. Using the DataBinding library released by Google
  2. Using any tool like RxJava for DataBinding.
                   
                  
 All Dependencies for the project.

    // Architectural Components
    
   - implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"

    // Room
   - implementation "androidx.room:room-runtime:2.2.5"
   - kapt "androidx.room:room-compiler:2.2.5"

    // Kotlin Extensions and Coroutines support for Room
   - implementation "androidx.room:room-ktx:2.2.5"

    // Coroutines
   - implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5'
   - implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5'

    // Coroutine Lifecycle Scopes
   - implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
   - implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"

    // Retrofit
   - implementation 'com.squareup.retrofit2:retrofit:2.6.0'
   - implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
   - implementation "com.squareup.okhttp3:logging-interceptor:4.5.0"

    // Navigation Components
   - implementation "androidx.navigation:navigation-fragment-ktx:2.2.1"
   - implementation "androidx.navigation:navigation-ui-ktx:2.2.1"

    // Glide
   - implementation 'com.github.bumptech.glide:glide:4.11.0'
   - kapt 'com.github.bumptech.glide:compiler:4.11.0'
  
  Thanks to Philipp Lackner
  https://github.com/philipplackner
