package com.bangla.nobijider.kahini.todo_kotlin.repositories

import androidx.lifecycle.LiveData
import com.bangla.nobijider.kahini.todo_kotlin.daos.TodoDao
import com.bangla.nobijider.kahini.todo_kotlin.entities.TodoModel

class TodoLocalRepository (val dao: TodoDao){

    suspend fun addTodo(todoModel: TodoModel){
        dao.addTodo(todoModel)
    }
    suspend fun updateTodo(todoModel: TodoModel){
        dao.updateTodo(todoModel)
    }
    suspend fun deleteTodo(todoModel: TodoModel){
        dao.deleteTodo(todoModel)
    }

    fun getAllTodo() : LiveData<List<TodoModel>> = dao.getAllTodo()
}