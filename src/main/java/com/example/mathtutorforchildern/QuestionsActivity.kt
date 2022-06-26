package com.example.mathtutorforchildern

import android.content.ContentValues
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.*

class QuestionsActivity : AppCompatActivity() {
    var startBtn: Button? = null
    var ScoreTextView: TextView? = null
    var AlertTextView: TextView? = null
    var QuestionTextView: TextView? = null
    var FinalScoreTextView: TextView? = null
    var button0: Button? = null
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null
    var nextBtn: Button? = null
    var constraintLayout: ConstraintLayout? = null
    var lastLayout: ConstraintLayout? = null
    var buttonPlayAgain: Button? = null
    var random = Random()
    var a = 0
    var b = 0
    var c = 1
    var indexOfCorrectAnswer = 0
    var answers = ArrayList<Int>()
    var points = 0
    var wrong = 0
    var totalQuestions = 0
    var operator: String? = null
    var correctAnswer = 0



    //    @SuppressLint("SetTextI18n")
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        startBtn = findViewById(R.id.btnStart) as Button?
        ScoreTextView = findViewById(R.id.ScoreTextView)
        FinalScoreTextView = findViewById(R.id.FinalscoreTextView)
        AlertTextView = findViewById(R.id.AlertTextView)
        QuestionTextView = findViewById(R.id.QuestionTextView)
        operator = getIntent().getStringExtra("operator")
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        nextBtn = findViewById(R.id.nextBtn)
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain)
        constraintLayout = findViewById(R.id.quizUi)
        lastLayout = findViewById(R.id.lastUi)
        with(lastLayout) { this?.setVisibility(View.INVISIBLE) }
        with(constraintLayout) { this?.setVisibility(View.INVISIBLE) }
        nextBtn!!.setOnClickListener { NextQuestion() }
    }

    //    @SuppressLint("SetTextI18n")
    fun NextQuestion() {
        nextBtn!!.visibility = View.INVISIBLE
        AlertTextView!!.text = "Lets do it.."
        if (operator == "+") {
            a = random.nextInt(10)
            b = random.nextInt(10)
            QuestionTextView!!.text = "Q$c: $a+$b"
            if (c == 10) c = 0
            indexOfCorrectAnswer = random.nextInt(4)
            correctAnswer = a + b
            answers.clear()
            for (i in 0..3) {
                if (indexOfCorrectAnswer == i) {
                    answers.add(a + b)
                } else {
                    var wrongAnswer = random.nextInt(20)
                    while (wrongAnswer == a + b) {
                        wrongAnswer = random.nextInt(20)
                    }
                    answers.add(wrongAnswer)
                }
            }
            c++
            button0!!.text = "a. " + Integer.toString(answers[0])
            button1!!.text = "b. " + Integer.toString(answers[1])
            button2!!.text = "c. " + Integer.toString(answers[2])
            button3!!.text = "d. " + Integer.toString(answers[3])
        }
        if (operator == "-") {
            a = random.nextInt(10)
            b = random.nextInt(10)
            QuestionTextView!!.text = "$a-$b"
            indexOfCorrectAnswer = random.nextInt(4)
            correctAnswer = a - b
            answers.clear()
            for (i in 0..3) {
                if (indexOfCorrectAnswer == i) {
                    answers.add(a - b)
                } else {
                    var wrongAnswer = random.nextInt(20)
                    while (wrongAnswer == a - b) {
                        wrongAnswer = random.nextInt(20)
                    }
                    answers.add(wrongAnswer)
                }
            }
            button0!!.text = Integer.toString(answers[0])
            button1!!.text = Integer.toString(answers[1])
            button2!!.text = Integer.toString(answers[2])
            button3!!.text = Integer.toString(answers[3])
        }
        if (operator == "*") {
            a = random.nextInt(5)
            b = random.nextInt(5)
            QuestionTextView!!.text = "$a*$b"
            indexOfCorrectAnswer = random.nextInt(4)
            correctAnswer = a * b
            answers.clear()
            for (i in 0..3) {
                if (indexOfCorrectAnswer == i) {
                    answers.add(a * b)
                } else {
                    var wrongAnswer = random.nextInt(25)
                    while (wrongAnswer == a * b) {
                        wrongAnswer = random.nextInt(25)
                    }
                    answers.add(wrongAnswer)
                }
            }
            button0!!.text = Integer.toString(answers[0])
            button1!!.text = Integer.toString(answers[1])
            button2!!.text = Integer.toString(answers[2])
            button3!!.text = Integer.toString(answers[3])
        }
        if (operator == "/") {
            a = random.nextInt(20)
            do {
                do {
                    b = random.nextInt(20)
                } while (b == 0)
            } while (a % b != 0)
            QuestionTextView!!.text = "$a/$b"
            indexOfCorrectAnswer = random.nextInt(4)
            correctAnswer = a / b
            answers.clear()
            for (i in 0..3) {
                if (indexOfCorrectAnswer == i) {
                    answers.add(a / b)
                } else {
                    var wrongAnswer = random.nextInt(20)
                    while (wrongAnswer == a / b) {
                        wrongAnswer = random.nextInt(20)
                    }
                    answers.add(wrongAnswer)
                }
            }
            button0!!.text = Integer.toString(answers[0])
            button1!!.text = Integer.toString(answers[1])
            button2!!.text = Integer.toString(answers[2])
            button3!!.text = Integer.toString(answers[3])
        }
        if (operator == "comb") {
            val c: Int
            val d: Int
            val e: Int
            c = random.nextInt(3)
            d = random.nextInt(20)
            e = random.nextInt(20)
            a = random.nextInt(20)
            do {
                do {
                    b = random.nextInt(20)
                } while (b == 0)
            } while (a % b != 0)
            QuestionTextView!!.text = "$a/$b*$c-$d+$e"
            indexOfCorrectAnswer = random.nextInt(4)
            correctAnswer = a / b * c - d + e
            answers.clear()
            for (i in 0..3) {
                if (indexOfCorrectAnswer == i) {
                    answers.add(correctAnswer)
                } else {
                    var wrongAnswer = random.nextInt(20)
                    while (wrongAnswer == correctAnswer) {
                        wrongAnswer = random.nextInt(20)
                    }
                    answers.add(wrongAnswer)
                }
            }
            button0!!.text = Integer.toString(answers[0])
            button1!!.text = Integer.toString(answers[1])
            button2!!.text = Integer.toString(answers[2])
            button3!!.text = Integer.toString(answers[3])
        }
    }

    fun optionSelect(view: View) {
        totalQuestions++
        if (Integer.toString(indexOfCorrectAnswer) == view.tag.toString()) {
            points++
            AlertTextView!!.text = "Correct"
        } else {
            wrong++
            AlertTextView!!.text = "Wrong, correct is: $correctAnswer"
        }
        ScoreTextView!!.text =
            "Score: " + Integer.toString(points) + "/" + Integer.toString(
                totalQuestions
            )
        nextBtn!!.visibility = View.VISIBLE
        if (totalQuestions == 10) {
            FinalScoreTextView!!.text =
                "Score: " + Integer.toString(points) + "/" + Integer.toString(
                    totalQuestions
                )
            constraintLayout?.setVisibility(View.INVISIBLE)
            lastLayout?.setVisibility(View.VISIBLE)
        }
    }

    fun playAgain(view: View?) {
        points = 0
        totalQuestions = 0
        ScoreTextView!!.text = "Score: " + Integer.toString(points) + "/" + Integer.toString(
            totalQuestions
        )
        lastLayout?.setVisibility(View.INVISIBLE)
        constraintLayout?.setVisibility(View.VISIBLE)
    }

    fun start(view: View?) {
        startBtn!!.visibility = View.INVISIBLE
        constraintLayout?.setVisibility(View.VISIBLE)
        NextQuestion()
    }

    fun goBack(view: View?) {
        this.finish()

        var helper = MyDBhelper(applicationContext)
        var db = helper.readableDatabase
        var ra = db.rawQuery("SELECT * FROM USERS", null)

        if(ra.moveToNext()) {

            Toast.makeText(applicationContext, ra.getString(1), Toast.LENGTH_LONG).show()

            button.setOnClickListener {
                var cv = ContentValues()

                cv.put("USERNAME", editTextTextEmailAddress.text.toString())
                cv.put("PWD", editTextTextPassword.text.toString())
                db.insert("USERS", null, cv)

                editTextTextEmailAddress.setText("")
                editTextTextPassword.setText("")
                editTextTextEmailAddress.requestFocus()
            }
        }
    }
}