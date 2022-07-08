package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertTask( todoModel:  TodoModel ): Long

    @Query("Select * from TodoModel Where isFinished ==0")
    fun getTask():LiveData<List<TodoModel>>

    @Query("Update TodoModel set isFinished=1 Where id=:uid")
    fun finishTask(uid:Long)

    @Query("Delete from TodoModel Where id=:uid")
    fun deleteTask(uid:Long)
}