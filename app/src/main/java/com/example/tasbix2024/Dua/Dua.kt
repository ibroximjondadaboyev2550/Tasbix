package com.example.tasbix2024.Dua

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dua_table")
data class Dua(@PrimaryKey(autoGenerate = true) val id: Int = 0,
               val title: String,
               val startValue: Int,
               val targetValue: Int,
               val reminder: Int,
               val note: String? = null)
