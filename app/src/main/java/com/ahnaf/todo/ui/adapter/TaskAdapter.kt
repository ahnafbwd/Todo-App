package com.ahnaf.todo.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahnaf.todo.R
import com.ahnaf.todo.data.local.database.Task
import com.ahnaf.todo.databinding.ItemTaskBinding
import com.ahnaf.todo.ui.insert.TaskAddUpdateActivity
import com.ahnaf.todo.utils.TaskDiffCallback
import java.util.*

class TaskAdapter(
    private val onCheckedChange: (Task, Boolean) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val listTasks = ArrayList<Task>()
    fun setListTasks(listTasks: List<Task>) {
        val diffCallback = TaskDiffCallback(this.listTasks, listTasks)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listTasks.clear()
        this.listTasks.addAll(listTasks)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(listTasks[position])
    }

    override fun getItemCount(): Int {
        return listTasks.size
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            with(binding) {
                tvItemTitle.text = task.title
                tvItemStatus.text = if (task.status == true) "Selesai" else "Belum Dikerjakan"
                iconStatus.setImageResource(if (task.status == true) R.drawable.ic_checked else R.drawable.ic_unchecked)
                tvItemDescription.text = task.description
                cvItemTask.setOnClickListener {
                    val intent = Intent(it.context, TaskAddUpdateActivity::class.java)
                    intent.putExtra(TaskAddUpdateActivity.EXTRA_TASK, task)
                    it.context.startActivity(intent)
                }
                iconStatus.setOnClickListener {
                    val newStatus = !(task.status ?: false) // Toggle status, handle null
                    task.status = newStatus // Update the task object

                    // Update UI immediately for better UX
                    iconStatus.setImageResource(
                        if (newStatus) R.drawable.ic_checked else R.drawable.ic_unchecked
                    )
                    tvItemStatus.text = if (newStatus) "Selesai" else "Belum Dikerjakan"

                    onCheckedChange(task, newStatus)
                }


            }
        }
    }
}