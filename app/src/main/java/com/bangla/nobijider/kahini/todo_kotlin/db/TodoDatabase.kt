package com.bangla.nobijider.kahini.todo_kotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangla.nobijider.kahini.todo_kotlin.daos.TodoDao
import com.bangla.nobijider.kahini.todo_kotlin.entities.TodoModel

@Database(entities = [TodoModel::class], version = 1)
 abstract class TodoDatabase : RoomDatabase(){

     abstract fun todoDao() : TodoDao

     companion object{
         private var db : TodoDatabase? = null

         fun getDb(context: Context): TodoDatabase{
             return db ?: synchronized(this){
                 val _db = Room.databaseBuilder(
                     context,
                     TodoDatabase::class.java,
                     "todo_db"
                 )//.allowMainThreadQueries()
                     .build()
                 db = _db
                 _db
             }
         }
     }

}