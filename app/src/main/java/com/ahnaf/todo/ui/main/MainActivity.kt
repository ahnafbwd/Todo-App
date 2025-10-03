package com.ahnaf.todo.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahnaf.todo.databinding.ActivityMainBinding
import com.ahnaf.todo.ui.adapter.TaskAdapter
import com.ahnaf.todo.ui.insert.TaskAddUpdateActivity
import com.ahnaf.todo.ui.ViewModelFactory
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllTasks()

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, TaskAddUpdateActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllTasks() {
        adapter = TaskAdapter(
            onCheckedChange = { task, isChecked ->
                task.status = isChecked
                viewModel.updateTask(task)
            }
        )

        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.setHasFixedSize(true)
        binding.rvTasks.adapter = adapter

        viewModel.getAllTasks().observe(this) { taskList ->
            if (taskList != null) {
                adapter.setListTasks(taskList)
            }
        }
    }
}