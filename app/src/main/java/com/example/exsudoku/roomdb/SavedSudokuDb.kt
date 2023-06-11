package com.example.exsudoku.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SavedSudoku::class], version = 1)
abstract class SavedSudokuDb :RoomDatabase(){
    abstract fun sudokuDao():SavedSudokuDao
}