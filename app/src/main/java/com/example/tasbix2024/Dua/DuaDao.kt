package com.example.tasbix2024.Dua

import androidx.room.*

@Dao
interface DuaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dua: Dua)

    @Update
    suspend fun update(dua: Dua)

    @Delete
    suspend fun delete(dua: Dua)

    @Query("SELECT * FROM dua_table")
    suspend fun getAllDuas(): List<Dua>
}
