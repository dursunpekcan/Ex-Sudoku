package com.example.exsudoku.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.IdentityHashMap

@Entity
data class SavedSudoku(
    @ColumnInfo("sudoku")
    var sudoku: String,

    @ColumnInfo("arrayId")
    var arrayId: Int,

    @ColumnInfo("hasHint")
    var hasHint: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}