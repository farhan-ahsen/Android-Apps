package com.farhan.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.widget.TextView
//import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
//import java.util.jar.Attributes
//import kotlin.math.log

class QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0
    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData>?=null
    private var selectedOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(setData.name)

        questionList = setData.getQuestion()
        setQuestion()

        option_1.setOnClickListener {
            selectedOptionStyle(option_1, 1)
        }
        option_2.setOnClickListener {
            selectedOptionStyle(option_2, 2)
        }
        option_3.setOnClickListener {
            selectedOptionStyle(option_3, 3)
        }
        option_4.setOnClickListener {
            selectedOptionStyle(option_4, 4)
        }

        submit.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![currentPosition-1]
                if (selectedOption != question.correct_ans)
                {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }else{
                    score++
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)
                if (currentPosition==questionList!!.size)
                    submit.text="FINISH"
                else
                    submit.text="Go to Next"
            }
            else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent = Intent(this,Result::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption=0
        }
    }
            fun setColor(opt:Int,color:Int){
                when(opt){
                    1->{
                        option_1.background=ContextCompat.getDrawable(this,color)
                    }
                    2->{
                        option_2.background=ContextCompat.getDrawable(this,color)
                    }
                    3->{
                        option_3.background=ContextCompat.getDrawable(this,color)
                    }
                    4->{
                        option_4.background=ContextCompat.getDrawable(this,color)
                    }
                }
            }

    fun setQuestion()
    {
        val question = questionList!![currentPosition-1]
        setoptionStyle()

        progress_bar.progress=currentPosition
        progress_bar.max=questionList!!.size
        progress_text.text="${currentPosition}"+"/"+"${questionList!!.size}"
        question_text.text=question.question
        option_1.text=question.option_one
        option_2.text=question.option_two
        option_3.text=question.option_three
        option_4.text=question.option_four
    }

    fun setoptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,option_1)
        optionList.add(1,option_2)
        optionList.add(2,option_3)
        optionList.add(3,option_4)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#A6A2A2"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }
    fun selectedOptionStyle(view: TextView,opt:Int){
        setoptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}