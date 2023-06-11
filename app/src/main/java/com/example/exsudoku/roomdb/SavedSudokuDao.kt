package com.example.exsudoku.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SavedSudokuDao {
    @Query("SELECT * FROM SavedSudoku")
    fun getAll():List<SavedSudoku>

    @Query("SELECT * FROM SavedSudoku WHERE arrayId = :arrayId")
    fun getSpecificSudoku(arrayId:Int):SavedSudoku

    @Insert
    fun insertSudoku(savedSudoku:SavedSudoku)

    @Delete
    fun deleteSudoku(savedSudoku: SavedSudoku)

    @Query("DELETE FROM SavedSudoku")
    fun deleteAll()
}