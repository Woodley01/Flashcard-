package com.example.flashcard1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val mainLayout = findViewById<RelativeLayout>(R.id.main_layout)
        textView3.visibility = View.VISIBLE

        val isShowingAnswers = findViewById<ImageView>(R.id.toggle_choices_visibility)
        val showAnswers = findViewById<ImageView>(R.id.toggle123)



        flashcardQuestion.visibility = View.VISIBLE


        isShowingAnswers.setOnClickListener {
            if (textView1.visibility == View.VISIBLE) {
                textView1.visibility = View.INVISIBLE
                textView2.visibility = View.INVISIBLE
                textView3.visibility = View.INVISIBLE
                resetTextViewBackgrounds(textView1, textView2, textView3)

                isShowingAnswers.visibility = View.INVISIBLE
                showAnswers.visibility = View.VISIBLE
            } else {
                textView1.visibility = View.VISIBLE
                textView2.visibility = View.VISIBLE
                textView3.visibility = View.VISIBLE
            }
        }
        showAnswers.setOnClickListener {
            if (textView1.visibility == View.INVISIBLE) {
                isShowingAnswers.visibility = View.VISIBLE
                textView1.visibility = View.VISIBLE
                textView2.visibility = View.VISIBLE
                textView3.visibility = View.VISIBLE
                resetTextViewBackgrounds(textView1, textView2, textView3)
                isShowingAnswers.visibility = View.VISIBLE
                showAnswers.visibility = View.INVISIBLE

            }
            else {
                textView1.visibility = View.INVISIBLE
                textView2.visibility = View.INVISIBLE
                textView3.visibility = View.INVISIBLE
            }
        }



        textView1.setOnClickListener {
            textView1.setBackgroundColor(resources.getColor(R.color.red))
            textView3.setBackgroundColor(resources.getColor(R.color.green))
        }

        textView2.setOnClickListener {
            textView2.setBackgroundColor(resources.getColor(R.color.red))
            textView3.setBackgroundColor(resources.getColor(R.color.green))
        }

        textView3.setOnClickListener {
            textView3.setBackgroundColor(resources.getColor(R.color.green))
        }
        mainLayout.setOnClickListener {
            resetTextViewBackgrounds(textView1, textView2, textView3)
        }
    }

    private fun resetTextViewBackgrounds(vararg textViews: TextView) {
        for (textView in textViews) {
            textView.setBackgroundColor(resources.getColor(R.color.beige_clair))
        }
    }
}