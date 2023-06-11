package com.example.exsudoku.activity

import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.room.Room
import com.example.exsudoku.R
import com.example.exsudoku.databinding.ActivityMainBinding
import com.example.exsudoku.roomdb.SavedSudoku
import com.example.exsudoku.roomdb.SavedSudokuDb
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: SavedSudokuDb
    private lateinit var arrayId: Array<Int>
    lateinit var anotherArray: Array<Int>
    private lateinit var arrayHorId: Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayOptions(androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.action_bar_layout)



        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //supportActionBar?.hide()
        anotherArray = arrayOf(
            R.id.et1,
            R.id.et10,
            R.id.et19,
            R.id.et2,
            R.id.et11,
            R.id.et20,
            R.id.et3,
            R.id.et12,
            R.id.et21,

            R.id.et28,
            R.id.et37,
            R.id.et46,
            R.id.et29,
            R.id.et38,
            R.id.et47,
            R.id.et30,
            R.id.et39,
            R.id.et48,

            R.id.et55,
            R.id.et64,
            R.id.et73,
            R.id.et56,
            R.id.et65,
            R.id.et74,
            R.id.et57,
            R.id.et66,
            R.id.et75,

            R.id.et4,
            R.id.et13,
            R.id.et22,
            R.id.et5,
            R.id.et14,
            R.id.et23,
            R.id.et6,
            R.id.et15,
            R.id.et24,

            R.id.et31,
            R.id.et40,
            R.id.et49,
            R.id.et32,
            R.id.et41,
            R.id.et50,
            R.id.et33,
            R.id.et42,
            R.id.et51,

            R.id.et58,
            R.id.et67,
            R.id.et76,
            R.id.et59,
            R.id.et68,
            R.id.et77,
            R.id.et60,
            R.id.et69,
            R.id.et78,

            R.id.et7,
            R.id.et16,
            R.id.et25,
            R.id.et8,
            R.id.et17,
            R.id.et26,
            R.id.et9,
            R.id.et18,
            R.id.et27,

            R.id.et34,
            R.id.et43,
            R.id.et52,
            R.id.et35,
            R.id.et44,
            R.id.et53,
            R.id.et36,
            R.id.et45,
            R.id.et54,

            R.id.et61,
            R.id.et70,
            R.id.et79,
            R.id.et62,
            R.id.et71,
            R.id.et80,
            R.id.et63,
            R.id.et72,
            R.id.et81,
        )


        arrayId = arrayOf(
            R.id.et1,
            R.id.et2,
            R.id.et3,
            R.id.et4,
            R.id.et5,
            R.id.et6,
            R.id.et7,
            R.id.et8,
            R.id.et9,
            R.id.et10,
            R.id.et11,
            R.id.et12,
            R.id.et13,
            R.id.et14,
            R.id.et15,
            R.id.et16,
            R.id.et17,
            R.id.et18,
            R.id.et19,
            R.id.et20,
            R.id.et21,
            R.id.et22,
            R.id.et23,
            R.id.et24,
            R.id.et25,
            R.id.et26,
            R.id.et27,
            R.id.et28,
            R.id.et29,
            R.id.et30,
            R.id.et31,
            R.id.et32,
            R.id.et33,
            R.id.et34,
            R.id.et35,
            R.id.et36,
            R.id.et37,
            R.id.et38,
            R.id.et39,
            R.id.et40,
            R.id.et41,
            R.id.et42,
            R.id.et43,
            R.id.et44,
            R.id.et45,
            R.id.et46,
            R.id.et47,
            R.id.et48,
            R.id.et49,
            R.id.et50,
            R.id.et51,
            R.id.et52,
            R.id.et53,
            R.id.et54,
            R.id.et55,
            R.id.et56,
            R.id.et57,
            R.id.et58,
            R.id.et59,
            R.id.et60,
            R.id.et61,
            R.id.et62,
            R.id.et63,
            R.id.et64,
            R.id.et65,
            R.id.et66,
            R.id.et67,
            R.id.et68,
            R.id.et69,
            R.id.et70,
            R.id.et71,
            R.id.et72,
            R.id.et73,
            R.id.et74,
            R.id.et75,
            R.id.et76,
            R.id.et77,
            R.id.et78,
            R.id.et79,
            R.id.et80,
            R.id.et81
        )
        arrayHorId = arrayOf(
            R.id.et1,
            R.id.et10,
            R.id.et19,
            R.id.et28,
            R.id.et37,
            R.id.et46,
            R.id.et55,
            R.id.et64,
            R.id.et73,

            R.id.et2,
            R.id.et11,
            R.id.et20,
            R.id.et29,
            R.id.et38,
            R.id.et47,
            R.id.et56,
            R.id.et65,
            R.id.et74,

            R.id.et3,
            R.id.et12,
            R.id.et21,
            R.id.et30,
            R.id.et39,
            R.id.et48,
            R.id.et57,
            R.id.et66,
            R.id.et75,

            R.id.et4,
            R.id.et13,
            R.id.et22,
            R.id.et31,
            R.id.et40,
            R.id.et49,
            R.id.et58,
            R.id.et67,
            R.id.et76,

            R.id.et5,
            R.id.et14,
            R.id.et23,
            R.id.et32,
            R.id.et41,
            R.id.et50,
            R.id.et59,
            R.id.et68,
            R.id.et77,

            R.id.et6,
            R.id.et15,
            R.id.et24,
            R.id.et33,
            R.id.et42,
            R.id.et51,
            R.id.et60,
            R.id.et69,
            R.id.et78,

            R.id.et7,
            R.id.et16,
            R.id.et25,
            R.id.et34,
            R.id.et43,
            R.id.et52,
            R.id.et61,
            R.id.et70,
            R.id.et79,

            R.id.et8,
            R.id.et17,
            R.id.et26,
            R.id.et35,
            R.id.et44,
            R.id.et53,
            R.id.et62,
            R.id.et71,
            R.id.et80,

            R.id.et9,
            R.id.et18,
            R.id.et27,
            R.id.et36,
            R.id.et45,
            R.id.et54,
            R.id.et63,
            R.id.et72,
            R.id.et81,
        )


        for (i in arrayId.indices) {
            findViewById<EditText>(arrayId[i]).setText("")
            findViewById<EditText>(arrayId[i]).inputType = InputType.TYPE_CLASS_NUMBER
            findViewById<EditText>(arrayId[i]).textSize = 20f
            findViewById<EditText>(arrayId[i]).filters = arrayOf(InputFilter.LengthFilter(1))
            findViewById<EditText>(arrayId[i]).showSoftInputOnFocus = false
            findViewById<EditText>(arrayId[i]).setTextColor(Color.WHITE)
            findViewById<EditText>(arrayId[i]).isEnabled = false

            //findViewById<EditText>(arrayId[i]).isCursorVisible = false

        }


        binding.b1.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {

                    etCur.setTextColor(Color.WHITE)

                    etCur.setText("1")
                }
            }
        }
        binding.b2.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("2")
                }
            }
        }
        binding.b3.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("3")
                }
            }
        }
        binding.b4.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("4")
                }
            }
        }
        binding.b5.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("5")
                }
            }
        }
        binding.b6.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("6")
                }
            }
        }
        binding.b7.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("7")
                }
            }
        }
        binding.b8.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("8")
                }
            }
        }
        binding.b9.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("9")
                }
            }
        }

        binding.btnDelete.setOnClickListener {
            for (i in arrayId.indices) {
                var etCur = findViewById<EditText>(arrayId[i])
                if (etCur.hasFocus()) {
                    etCur.setTextColor(Color.WHITE)
                    etCur.setText("")
                }
            }
        }

        binding.imgDown.setOnClickListener {
            for (i in arrayId.indices) {
                if (currentFocus?.id == arrayId[i] && i != 80) {
                    findViewById<EditText>(arrayId[i]).clearFocus()
                    val list = arrayListOf<Int>()
                    for (e in 1..81) {
                        if (i + e < 80) {
                            if (findViewById<EditText>(arrayId[i + e]).isEnabled == false) {
                                list.add(e)
                                println("x")
                            } else {
                                break
                            }
                        }
                    }
                    println(list.size)
                    findViewById<EditText>(arrayId[i + list.size + 1]).requestFocus()

                    list.clear()
                    break
                }
            }
        }
        binding.imgUp.setOnClickListener {
            for (i in arrayId.indices) {
                if (currentFocus?.id == arrayId[i] && i != 0) {
                    findViewById<EditText>(arrayId[i]).clearFocus()
                    val list = arrayListOf<Int>()
                    for (e in 1..81) {
                        if (e < i) {
                            if (findViewById<EditText>(arrayId[i - e]).isEnabled == false) {
                                list.add(e)
                            } else {
                                break
                            }
                        }
                    }
                    println(list.size)
                    findViewById<EditText>(arrayId[i - list.size - 1]).requestFocus()
                    list.clear()
                    break
                }
            }
        }
        binding.imgRight.setOnClickListener {
            for (i in arrayHorId.indices) {
                if (currentFocus?.id == arrayHorId[i] && i != 80) {
                    findViewById<EditText>(arrayHorId[i]).clearFocus()
                    val list = arrayListOf<Int>()
                    for (e in 1..81) {
                        if (i + e < 80) {
                            if (findViewById<EditText>(arrayHorId[i + e]).isEnabled == false) {
                                list.add(e)
                                println("x")
                            } else {
                                break
                            }
                        }
                    }
                    println(list.size)
                    findViewById<EditText>(arrayHorId[i + list.size + 1]).requestFocus()
                    list.clear()
                    break
                }
            }
        }
        binding.imgLeft.setOnClickListener {
            for (i in arrayHorId.indices) {
                if (currentFocus?.id == arrayHorId[i] && i != 0) {
                    findViewById<EditText>(arrayHorId[i]).clearFocus()
                    val list = arrayListOf<Int>()
                    for (e in 1..81) {
                        if (e < i) {
                            if (findViewById<EditText>(arrayHorId[i - e]).isEnabled == false) {
                                list.add(e)
                            } else {
                                break
                            }
                        }
                    }
                    println(list.size)
                    findViewById<EditText>(arrayHorId[i - list.size - 1]).requestFocus()
                    list.clear()
                    break
                }
            }
        }

        binding.btnFinish.setOnClickListener {

            var e = 0

            while (e < 9) {
//                if (
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 9]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 18]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 27]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 36]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 45]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 54]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 63]).text) &&
//                    !findViewById<EditText>(arrayId[e]).text.contains(findViewById<EditText>(arrayId[e + 72]).text) &&
//
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 9]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 18]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 27]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 36]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 45]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 54]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 63]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 72]
//                        ).text
//                    ) &&
//
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 9]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 18]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 27]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 36]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 45]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 54]
//                        ).text
//                    ) &&
//                    !findViewById<EditText>(arrayId[e + 72]).text.contains(
//                        findViewById<EditText>(
//                            arrayId[e + 63]
//                        ).text
//                    )
//
//
//                ) {
//                    y++
//                    if (y == 9) {
//                        //binding.textView.text="State: Success"
//                        var x = 0
//                        var i = 1
//                        while (i < 74) {
//
//                            if (!findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i - 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 1]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 2]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 3]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 4]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 5]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 6]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 7]
//                                    ).text
//                                )
//
//                                && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i - 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 1]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 2]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 3]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 4]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 5]
//                                    ).text
//                                ) && !findViewById<EditText>(arrayId[i + 7]).text.contains(
//                                    findViewById<EditText>(
//                                        arrayId[i + 6]
//                                    ).text
//                                )
//                            ) {
//                                x++
//                                if (x == 9) {
//                                    var w = 0
//                                    var z = 0
//                                    while (w < 73) {
//                                        if (
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 1]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 2]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 3]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 4]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 5]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 6]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 7]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 8]).text
//                                            ) &&
//
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 1]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 2]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 3]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 4]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 5]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 6]).text
//                                            ) &&
//                                            !findViewById<EditText>(anotherArray[w + 8]).text.contains(
//                                                findViewById<EditText>(anotherArray[w + 7]).text
//                                            )
//
//                                        ) {
//                                            z++
//                                            if (z == 9) {
//
//                                                startActivity(
//                                                    Intent(
//                                                        this@MainActivity,
//                                                        FinishActivity::class.java
//                                                    )
//                                                )
//                                                finish()
//                                            }
//                                        } else {
//                                            if (w == 0 || w == 9 || w == 18 || w == 27 || w == 36 || w == 45 || w == 54 || w == 63 || w == 72) {
//
//                                            }
//                                        }
//                                        w = w + 9
//                                    }
//                                }
//
//
//                            } else {
//                                println("fail")
//                                if (i == 1 || i == 10 || i == 19 || i == 28 || i == 37 || i == 46 || i == 55 || i == 64 || i == 73) {
//
//                                }
//
//                            }
//                            i = i + 9
//
//                        }
//                    }
//                } else {
//                    if (e == 0 || e == 1 || e == 2 || e == 3 || e == 4 || e == 5 || e == 6 || e == 7 || e == 8) {
//
//                    }
//                }
                e++

            }


        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sudoku, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.itemNewGame -> {
//                db = Room.databaseBuilder(applicationContext, SavedSudokuDb::class.java, "savedDb")
//                    .allowMainThreadQueries().build()
//                val dao = db.sudokuDao()
//                dao.deleteAll()
                var g = 0

                while (g < 1) {


                    for (i in arrayId.indices) {
                        findViewById<EditText>(arrayId[i]).isEnabled = true
                    }
                    for (i in arrayId.indices) {
                        findViewById<EditText>(arrayId[i]).setText("")
                    }




                    for (i in 0..22) {
                        val rid = kotlin.random.Random.nextInt(0,81)
                        val rnum = kotlin.random.Random.nextInt(1, 10)


                        findViewById<EditText>(arrayId[rid]).setText("$rnum")
                        findViewById<EditText>(arrayId[rid]).isEnabled = false
                        findViewById<EditText>(arrayId[rid]).setTextColor(
                            resources.getColor(
                                R.color.yellow
                            )
                        )

                    }
                    val list = arrayListOf<String>()
                    val list2 = arrayListOf<String>()
                    val list3 = arrayListOf<String>()
                    val list4 = arrayListOf<String>()
                    val list5 = arrayListOf<String>()
                    val list6 = arrayListOf<String>()
                    val list7 = arrayListOf<String>()
                    val list8 = arrayListOf<String>()
                    val list9 = arrayListOf<String>()

                    val horList1 = arrayListOf<String>()
                    val horList2 = arrayListOf<String>()
                    val horList3 = arrayListOf<String>()
                    val horList4 = arrayListOf<String>()
                    val horList5 = arrayListOf<String>()
                    val horList6 = arrayListOf<String>()
                    val horList7 = arrayListOf<String>()
                    val horList8 = arrayListOf<String>()
                    val horList9 = arrayListOf<String>()

                    val sqList1 = arrayListOf<String>()
                    val sqList2 = arrayListOf<String>()
                    val sqList3 = arrayListOf<String>()
                    val sqList4 = arrayListOf<String>()
                    val sqList5 = arrayListOf<String>()
                    val sqList6 = arrayListOf<String>()
                    val sqList7 = arrayListOf<String>()
                    val sqList8 = arrayListOf<String>()
                    val sqList9 = arrayListOf<String>()

                    for (i in 0..8) {
                        sqList1.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 9..17) {
                        sqList2.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 18..26) {
                        sqList3.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 27..35) {
                        sqList4.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 36..44) {
                        sqList5.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 45..53) {
                        sqList6.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 54..62) {
                        sqList7.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 63..71) {
                        sqList8.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }
                    for (i in 72..80) {
                        sqList9.add(findViewById<EditText>(anotherArray[i]).text.toString())
                    }

                    val sqNewList1 = sqList1.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList2 = sqList1.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList3 = sqList1.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList4 = sqList1.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList5 = sqList1.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList6 = sqList1.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList7 = sqList1.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList8 = sqList1.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList9 = sqList1.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList10 = sqList2.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList11 = sqList2.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList12 = sqList2.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList13 = sqList2.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList14 = sqList2.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList15 = sqList2.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList16 = sqList2.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList17 = sqList2.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList18 = sqList2.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList19 = sqList3.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList20 = sqList3.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList21 = sqList3.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList22 = sqList3.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList23 = sqList3.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList24 = sqList3.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList25 = sqList3.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList26 = sqList3.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList27 = sqList3.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList28 = sqList4.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList29 = sqList4.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList30 = sqList4.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList31 = sqList4.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList32 = sqList4.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList33 = sqList4.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList34 = sqList4.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList35 = sqList4.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList36 = sqList4.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList37 = sqList5.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList38 = sqList5.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList39 = sqList5.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList40 = sqList5.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList41 = sqList5.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList42 = sqList5.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList43 = sqList5.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList44 = sqList5.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList45 = sqList5.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList46 = sqList6.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList47 = sqList6.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList48 = sqList6.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList49 = sqList6.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList50 = sqList6.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList51 = sqList6.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList52 = sqList6.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList53 = sqList6.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList54 = sqList6.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList55 = sqList7.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList56 = sqList7.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList57 = sqList7.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList58 = sqList7.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList59 = sqList7.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList60 = sqList7.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList61 = sqList7.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList62 = sqList7.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList63 = sqList7.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList64 = sqList8.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList65 = sqList8.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList66 = sqList8.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList67 = sqList8.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList68 = sqList8.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList69 = sqList8.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList70 = sqList8.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList71 = sqList8.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList72 = sqList8.filter { it.isNotEmpty() && it.contains("9") }

                    val sqNewList73 = sqList9.filter { it.isNotEmpty() && it.contains("1") }
                    val sqNewList74 = sqList9.filter { it.isNotEmpty() && it.contains("2") }
                    val sqNewList75 = sqList9.filter { it.isNotEmpty() && it.contains("3") }
                    val sqNewList76 = sqList9.filter { it.isNotEmpty() && it.contains("4") }
                    val sqNewList77 = sqList9.filter { it.isNotEmpty() && it.contains("5") }
                    val sqNewList78 = sqList9.filter { it.isNotEmpty() && it.contains("6") }
                    val sqNewList79 = sqList9.filter { it.isNotEmpty() && it.contains("7") }
                    val sqNewList80 = sqList9.filter { it.isNotEmpty() && it.contains("8") }
                    val sqNewList81 = sqList9.filter { it.isNotEmpty() && it.contains("9") }

                    for (i in 0..8) {
                        list.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 9..17) {
                        list2.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 18..26) {
                        list3.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 27..35) {
                        list4.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 36..44) {
                        list5.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 45..53) {
                        list6.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 54..62) {
                        list7.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };
                    for (i in 63..71) {
                        list8.add(findViewById<EditText>(arrayId[i]).text.toString())
                    };for (i in 72..80) {
                        list9.add(findViewById<EditText>(arrayId[i]).text.toString())
                    }

                    val new1List = list.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new2List = list.filter { it.isNotEmpty() && it.contains("2") };
                    val new3List = list.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new4List = list.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new5List = list.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new6List = list.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new7List = list.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new8List = list.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new9List = list.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new10List = list2.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new11List = list2.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new12List = list2.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new13List = list2.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new14List = list2.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new15List = list2.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new16List = list2.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new17List = list2.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new18List = list2.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new19List = list3.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new20List = list3.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new21List = list3.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new22List = list3.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new23List = list3.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new24List = list3.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new25List = list3.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new26List = list3.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new27List = list3.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new28List = list4.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new29List = list4.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new30List = list4.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new31List = list4.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new32List = list4.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new33List = list4.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new34List = list4.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new35List = list4.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new36List = list4.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new37List = list5.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new38List = list5.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new39List = list5.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new40List = list5.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new41List = list5.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new42List = list5.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new43List = list5.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new44List = list5.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new45List = list5.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new46List = list6.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new47List = list6.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new48List = list6.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new49List = list6.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new50List = list6.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new51List = list6.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new52List = list6.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new53List = list6.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new54List = list6.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new55List = list7.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new56List = list7.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new57List = list7.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new58List = list7.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new59List = list7.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new60List = list7.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new61List = list7.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new62List = list7.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new63List = list7.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new64List = list8.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new65List = list8.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new66List = list8.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new67List = list8.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new68List = list8.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new69List = list8.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new70List = list8.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new71List = list8.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new72List = list8.filter {
                        it.isNotEmpty() && it.contains("9")
                    };
                    val new73List = list9.filter {
                        it.isNotEmpty() && it.contains("1")
                    };
                    val new74List = list9.filter {
                        it.isNotEmpty() && it.contains("2")
                    };
                    val new75List = list9.filter {
                        it.isNotEmpty() && it.contains("3")
                    };
                    val new76List = list9.filter {
                        it.isNotEmpty() && it.contains("4")
                    };
                    val new77List = list9.filter {
                        it.isNotEmpty() && it.contains("5")
                    };
                    val new78List = list9.filter {
                        it.isNotEmpty() && it.contains("6")
                    };
                    val new79List = list9.filter {
                        it.isNotEmpty() && it.contains("7")
                    };
                    val new80List = list9.filter {
                        it.isNotEmpty() && it.contains("8")
                    };
                    val new81List = list9.filter {
                        it.isNotEmpty() && it.contains("9")
                    }

                    var x1 = 0; while (x1 < 73) {
                        horList1.add(findViewById<EditText>(arrayId[x1]).text.toString())
                        x1 = x1 + 9
                    };
                    var x2 = 1; while (x2 < 74) {
                        horList2.add(findViewById<EditText>(arrayId[x2]).text.toString())
                        x2 = x2 + 9
                    };
                    var x3 = 2; while (x3 < 75) {
                        horList3.add(findViewById<EditText>(arrayId[x3]).text.toString())
                        x3 = x3 + 9
                    };
                    var x4 = 3; while (x4 < 76) {
                        horList4.add(findViewById<EditText>(arrayId[x4]).text.toString())
                        x4 = x4 + 9
                    };
                    var x5 = 4; while (x5 < 77) {
                        horList5.add(findViewById<EditText>(arrayId[x5]).text.toString())
                        x5 = x5 + 9
                    };
                    var x6 = 5; while (x6 < 78) {
                        horList6.add(findViewById<EditText>(arrayId[x6]).text.toString())
                        x6 = x6 + 9
                    };
                    var x7 = 6; while (x7 < 79) {
                        horList7.add(findViewById<EditText>(arrayId[x7]).text.toString())
                        x7 = x7 + 9
                    };
                    var x8 = 7; while (x8 < 80) {
                        horList8.add(findViewById<EditText>(arrayId[x8]).text.toString())
                        x8 = x8 + 9
                    };
                    var x9 = 8; while (x9 < 81) {
                        horList9.add(findViewById<EditText>(arrayId[x9]).text.toString())
                        x9 = x9 + 9
                    }


                    val horNewList =
                        horList1.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList2 =
                        horList1.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList3 =
                        horList1.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList4 =
                        horList1.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList5 =
                        horList1.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList6 =
                        horList1.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList7 =
                        horList1.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList8 =
                        horList1.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList9 =
                        horList1.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList10 =
                        horList2.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList11 =
                        horList2.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList12 =
                        horList2.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList13 =
                        horList2.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList14 =
                        horList2.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList15 =
                        horList2.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList16 =
                        horList2.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList17 =
                        horList2.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList18 =
                        horList2.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList19 =
                        horList3.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList20 =
                        horList3.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList21 =
                        horList3.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList22 =
                        horList3.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList23 =
                        horList3.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList24 =
                        horList3.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList25 =
                        horList3.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList26 =
                        horList3.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList27 =
                        horList3.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList28 =
                        horList4.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList29 =
                        horList4.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList30 =
                        horList4.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList31 =
                        horList4.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList32 =
                        horList4.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList33 =
                        horList4.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList34 =
                        horList4.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList35 =
                        horList4.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList36 =
                        horList4.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList37 =
                        horList5.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList38 =
                        horList5.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList39 =
                        horList5.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList40 =
                        horList5.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList41 =
                        horList5.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList42 =
                        horList5.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList43 =
                        horList5.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList44 =
                        horList5.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList45 =
                        horList5.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList46 =
                        horList6.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList47 =
                        horList6.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList48 =
                        horList6.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList49 =
                        horList6.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList50 =
                        horList6.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList51 =
                        horList6.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList52 =
                        horList6.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList53 =
                        horList6.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList54 =
                        horList6.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList55 =
                        horList7.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList56 =
                        horList7.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList57 =
                        horList7.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList58 =
                        horList7.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList59 =
                        horList7.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList60 =
                        horList7.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList61 =
                        horList7.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList62 =
                        horList7.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList63 =
                        horList7.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList64 =
                        horList8.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList65 =
                        horList8.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList66 =
                        horList8.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList67 =
                        horList8.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList68 =
                        horList8.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList69 =
                        horList8.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList70 =
                        horList8.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList71 =
                        horList8.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList72 =
                        horList8.filter { it.isNotEmpty() && it.contains("9") };

                    val horNewList73 =
                        horList9.filter { it.isNotEmpty() && it.contains("1") };
                    val horNewList74 =
                        horList9.filter { it.isNotEmpty() && it.contains("2") };
                    val horNewList75 =
                        horList9.filter { it.isNotEmpty() && it.contains("3") };
                    val horNewList76 =
                        horList9.filter { it.isNotEmpty() && it.contains("4") };
                    val horNewList77 =
                        horList9.filter { it.isNotEmpty() && it.contains("5") };
                    val horNewList78 =
                        horList9.filter { it.isNotEmpty() && it.contains("6") };
                    val horNewList79 =
                        horList9.filter { it.isNotEmpty() && it.contains("7") };
                    val horNewList80 =
                        horList9.filter { it.isNotEmpty() && it.contains("8") };
                    val horNewList81 =
                        horList9.filter { it.isNotEmpty() && it.contains("9") };




                    if (new1List.size > 1 || new2List.size > 1 || new3List.size > 1 || new4List.size > 1 || new5List.size > 1 || new6List.size > 1 || new7List.size > 1 || new8List.size > 1 || new9List.size > 1 || new10List.size > 1 || new11List.size > 1 || new12List.size > 1 || new13List.size > 1 || new14List.size > 1 || new15List.size > 1 || new16List.size > 1 || new17List.size > 1 || new18List.size > 1 || new19List.size > 1 || new20List.size > 1 || new21List.size > 1 || new22List.size > 1 || new23List.size > 1 || new24List.size > 1 || new25List.size > 1 || new26List.size > 1 || new27List.size > 1 || new28List.size > 1 || new29List.size > 1 || new30List.size > 1 || new31List.size > 1 || new32List.size > 1 || new33List.size > 1 || new34List.size > 1 || new35List.size > 1 || new36List.size > 1 || new37List.size > 1 || new38List.size > 1 || new39List.size > 1 || new40List.size > 1 || new41List.size > 1 || new42List.size > 1 || new43List.size > 1 || new44List.size > 1 || new45List.size > 1 || new46List.size > 1 || new47List.size > 1 || new48List.size > 1 || new49List.size > 1 || new50List.size > 1 || new51List.size > 1 || new52List.size > 1 || new53List.size > 1 || new54List.size > 1 || new55List.size > 1 || new56List.size > 1 || new57List.size > 1 || new58List.size > 1 || new59List.size > 1 || new60List.size > 1 || new61List.size > 1 || new62List.size > 1 || new63List.size > 1 || new64List.size > 1 || new65List.size > 1 || new66List.size > 1 || new67List.size > 1 || new68List.size > 1 || new69List.size > 1 || new70List.size > 1 || new71List.size > 1 || new72List.size > 1 || new73List.size > 1 || new74List.size > 1 || new75List.size > 1 || new76List.size > 1 || new77List.size > 1 || new78List.size > 1 || new79List.size > 1 || new80List.size > 1 || new81List.size > 1 ||

                        horNewList.size > 1 || horNewList2.size > 1 || horNewList3.size > 1 || horNewList4.size > 1 || horNewList5.size > 1 || horNewList6.size > 1 || horNewList7.size > 1 || horNewList8.size > 1 || horNewList9.size > 1 || horNewList10.size > 1 || horNewList11.size > 1 || horNewList12.size > 1 || horNewList13.size > 1 || horNewList14.size > 1 || horNewList15.size > 1 || horNewList16.size > 1 || horNewList17.size > 1 || horNewList18.size > 1 || horNewList19.size > 1 || horNewList20.size > 1 || horNewList21.size > 1 || horNewList22.size > 1 || horNewList23.size > 1 || horNewList24.size > 1 || horNewList25.size > 1 || horNewList26.size > 1 || horNewList27.size > 1 || horNewList28.size > 1 || horNewList29.size > 1 || horNewList30.size > 1 || horNewList31.size > 1 || horNewList32.size > 1 || horNewList33.size > 1 || horNewList34.size > 1 || horNewList35.size > 1 || horNewList36.size > 1 || horNewList37.size > 1 || horNewList38.size > 1 || horNewList39.size > 1 || horNewList40.size > 1 || horNewList41.size > 1 || horNewList42.size > 1 || horNewList43.size > 1 || horNewList44.size > 1 || horNewList45.size > 1 || horNewList46.size > 1 || horNewList47.size > 1 || horNewList48.size > 1 || horNewList49.size > 1 || horNewList50.size > 1 || horNewList51.size > 1 || horNewList52.size > 1 || horNewList53.size > 1 || horNewList54.size > 1 || horNewList55.size > 1 || horNewList56.size > 1 || horNewList57.size > 1 || horNewList58.size > 1 || horNewList59.size > 1 || horNewList60.size > 1 || horNewList61.size > 1 || horNewList62.size > 1 || horNewList63.size > 1 || horNewList64.size > 1 || horNewList65.size > 1 || horNewList66.size > 1 || horNewList67.size > 1 || horNewList68.size > 1 || horNewList69.size > 1 || horNewList70.size > 1 || horNewList71.size > 1 || horNewList72.size > 1 || horNewList73.size > 1 || horNewList74.size > 1 || horNewList75.size > 1 || horNewList76.size > 1 || horNewList77.size > 1 || horNewList78.size > 1 || horNewList79.size > 1 || horNewList80.size > 1 || horNewList81.size > 1 ||

                        sqNewList1.size > 1 || sqNewList2.size > 1 || sqNewList3.size > 1 || sqNewList4.size > 1 || sqNewList5.size > 1 || sqNewList6.size > 1 || sqNewList7.size > 1 || sqNewList8.size > 1 || sqNewList9.size > 1 || sqNewList10.size > 1 || sqNewList11.size > 1 || sqNewList12.size > 1 || sqNewList13.size > 1 || sqNewList14.size > 1 || sqNewList15.size > 1 || sqNewList16.size > 1 || sqNewList17.size > 1 || sqNewList18.size > 1 || sqNewList19.size > 1 || sqNewList20.size > 1 || sqNewList21.size > 1 || sqNewList22.size > 1 || sqNewList23.size > 1 || sqNewList24.size > 1 || sqNewList25.size > 1 || sqNewList26.size > 1 || sqNewList27.size > 1 || sqNewList28.size > 1 || sqNewList29.size > 1 || sqNewList30.size > 1 || sqNewList31.size > 1 || sqNewList32.size > 1 || sqNewList33.size > 1 || sqNewList34.size > 1 || sqNewList35.size > 1 || sqNewList36.size > 1 || sqNewList37.size > 1 || sqNewList38.size > 1 || sqNewList39.size > 1 || sqNewList40.size > 1 || sqNewList41.size > 1 || sqNewList42.size > 1 || sqNewList43.size > 1 || sqNewList44.size > 1 || sqNewList45.size > 1 || sqNewList46.size > 1 || sqNewList47.size > 1 || sqNewList48.size > 1 || sqNewList49.size > 1 || sqNewList50.size > 1 || sqNewList51.size > 1 || sqNewList52.size > 1 || sqNewList53.size > 1 || sqNewList54.size > 1 || sqNewList55.size > 1 || sqNewList56.size > 1 || sqNewList57.size > 1 || sqNewList58.size > 1 || sqNewList59.size > 1 || sqNewList60.size > 1 || sqNewList61.size > 1 || sqNewList62.size > 1 || sqNewList63.size > 1 || sqNewList64.size > 1 || sqNewList65.size > 1 || sqNewList66.size > 1 || sqNewList67.size > 1 || sqNewList68.size > 1 || sqNewList69.size > 1 || sqNewList70.size > 1 || sqNewList71.size > 1 || sqNewList72.size > 1 || sqNewList73.size > 1 || sqNewList74.size > 1 || sqNewList75.size > 1 || sqNewList76.size > 1 || sqNewList77.size > 1 || sqNewList78.size > 1 || sqNewList79.size > 1 || sqNewList80.size > 1 || sqNewList81.size > 1


                    ) {
//                        for (i in 0..80) {
//                            findViewById<EditText>(arrayId[i]).setText("")
//                            findViewById<EditText>(arrayId[i]).isEnabled = false
//                        }

                    } else {
                        g++

                    }
                }
            }

            R.id.itemSaveGame -> {

                db = Room.databaseBuilder(applicationContext, SavedSudokuDb::class.java, "savedDb")
                    .allowMainThreadQueries().build()
                val dao = db.sudokuDao()
                dao.deleteAll()
                for (i in arrayId.indices) {
                    val et = findViewById<EditText>(arrayId[i])
                    val sudoku = SavedSudoku(et.text.toString(), i, et.isEnabled)
                    dao.insertSudoku(sudoku)
                }


            }

            R.id.itemLastGame -> {
                db = Room.databaseBuilder(applicationContext, SavedSudokuDb::class.java, "savedDb")
                    .allowMainThreadQueries().build()
                val dao = db.sudokuDao()

                for (i in arrayId.indices) {
                    val et = findViewById<EditText>(arrayId[i])
                    et.setText(dao.getSpecificSudoku(i).sudoku)
                    et.isEnabled = dao.getSpecificSudoku(i).hasHint
                }
                for (i in arrayId.indices) {
                    val et = findViewById<EditText>(arrayId[i])
                    if (!et.isEnabled) {
                        et.setTextColor(resources.getColor(R.color.yellow))
                    }
                }
            }

        }


        return true
    }


}







