package com.bangla.nobijider.kahini.todo_kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangla.nobijider.kahini.todo_kotlin.databinding.TodoItemBinding
import com.bangla.nobijider.kahini.todo_kotlin.entities.TodoModel
import com.bangla.nobijider.kahini.todo_kotlin.getFormattedDateTime

class TodoAdapter : ListAdapter<TodoModel,TodoAdapter.TodoViewHolder>(TodoDiffCallBack()){
    private lateinit var binding: TodoItemBinding
    class TodoViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(todoModel: TodoModel){
            //binding.text.text = todoModel.name
            //binding.isCompleted.isChecked = todoModel.isCompleted
            binding.todo = todoModel
           // binding.date.text = getFormattedDateTime(todoModel.date,"dd/MM/yyyy")
           // binding.time.text = getFormattedDateTime(todoModel.time,"hh:mm a")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todoModel = getItem(position)
        holder.bind(todoModel)
    }
}

class TodoDiffCallBack : DiffUtil.ItemCallback<TodoModel>(){
    override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return  oldItem == newItem
    }

}