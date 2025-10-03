package com.ahnaf.todo.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.ahnaf.todo.data.local.database.Task
import com.ahnaf.todo.data.local.database.TaskDao
import com.ahnaf.todo.data.local.database.TaskRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class TaskRepository(
    private val mTasksDao: TaskDao
) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getAllTasks(): LiveData<List<Task>> = mTasksDao.getAllTasks()

    fun insert(task: Task) {
        executorService.execute { mTasksDao.insert(task) }
    }

    fun delete(task: Task) {
        executorService.execute { mTasksDao.delete(task) }
    }

    fun update(task: Task) {
        executorService.execute { mTasksDao.update(task) }
    }
}