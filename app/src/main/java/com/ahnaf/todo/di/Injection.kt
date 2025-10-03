package com.ahnaf.todo.di

import android.content.Context
import com.ahnaf.todo.data.local.database.TaskRoomDatabase
import com.ahnaf.todo.data.repository.TaskRepository

object Injection {
    fun provideTaskRepository(context: Context): TaskRepository {
        val database = TaskRoomDatabase.getDatabase(context)
        val dao = database.taskDao()
        return TaskRepository( dao)
    }
}