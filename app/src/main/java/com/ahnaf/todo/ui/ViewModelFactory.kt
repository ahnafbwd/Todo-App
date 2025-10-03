package com.ahnaf.todo.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahnaf.todo.data.repository.TaskRepository
import com.ahnaf.todo.di.Injection
import com.ahnaf.todo.ui.insert.TaskAddUpdateViewModel
import com.ahnaf.todo.ui.main.MainViewModel

class ViewModelFactory private constructor(
    private val taskRepository: TaskRepository,
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(taskRepository) as T
        } else if (modelClass.isAssignableFrom(TaskAddUpdateViewModel::class.java)) {
            return TaskAddUpdateViewModel(taskRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
    companion object {
        fun getInstance(context: Context): ViewModelFactory {
            return ViewModelFactory(
                Injection.provideTaskRepository(context),
            )
        }
    }

}