package com.bangla.nobijider.kahini.todo_kotlin.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bangla.nobijider.kahini.todo_kotlin.entities.TodoModel

@Dao
interface TodoDao {

    @Insert
    suspend fun addTodo(todoModel: TodoModel)

    @Update
    suspend fun updateTodo(todoModel: TodoModel)

    @Delete
    suspend fun deleteTodo(todoModel: TodoModel)

    @Query("Select * from tbl_todo order by id desc")
    fun getAllTodo(): LiveData<List<TodoModel>>
}