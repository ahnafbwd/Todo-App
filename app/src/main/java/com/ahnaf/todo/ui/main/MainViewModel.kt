package com.ahnaf.todo.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahnaf.todo.data.local.database.Task
import com.ahnaf.todo.data.repository.TaskRepository

class MainViewModel(
    private val mTaskRepository: TaskRepository
) : ViewModel() {
    fun getAllTasks(): LiveData<List<Task>> = mTaskRepository.getAllTasks()
    fun updateTask(task: Task) {
        mTaskRepository.update(task)
    }
}