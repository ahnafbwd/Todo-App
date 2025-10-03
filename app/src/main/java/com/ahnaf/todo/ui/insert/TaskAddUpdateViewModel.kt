package com.ahnaf.todo.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ahnaf.todo.data.local.database.Task
import com.ahnaf.todo.data.repository.TaskRepository

class TaskAddUpdateViewModel(
    private val mTaskRepository: TaskRepository
) : ViewModel() {


    fun insert(task: Task) {
        mTaskRepository.insert(task)
    }

    fun update(task: Task) {
        mTaskRepository.update(task)
    }

    fun delete(task: Task) {
        mTaskRepository.delete(task)
    }

}