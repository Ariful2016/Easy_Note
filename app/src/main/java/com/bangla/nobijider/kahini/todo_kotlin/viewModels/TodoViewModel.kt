package com.bangla.nobijider.kahini.todo_kotlin.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangla.nobijider.kahini.todo_kotlin.db.TodoDatabase
import com.bangla.nobijider.kahini.todo_kotlin.entities.TodoModel
import com.bangla.nobijider.kahini.todo_kotlin.repositories.TodoLocalRepository
import kotlinx.coroutines.launch

class TodoViewModel(val ctx : Application) : AndroidViewModel(ctx) {

    private val repository = TodoLocalRepository(TodoDatabase.getDb(ctx).todoDao())

    fun insertTodo(todoModel: TodoModel){
        viewModelScope.launch {
            repository.addTodo(todoModel)
        }
    }
    fun editTodo(todoModel: TodoModel){
        viewModelScope.launch {
            repository.updateTodo(todoModel)
        }
    }
    fun removeTodo(todoModel: TodoModel){
        viewModelScope.launch {
            repository.deleteTodo(todoModel)
        }
    }

    fun getTodos() : LiveData<List<TodoModel>> = repository.getAllTodo()
}