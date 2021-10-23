package com.farhan.quizapp

object setData {

    const val name:String="name"
    const val score:String="score"
    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var question1=QuestionData(
            "what is the capital of India",
            1,
            "MP",
            "UP",
            "TELANGANA",
            "DELHI",
            4


        )
        var question2=QuestionData(
            "what is the capital of Australia",
            2,
            "SYDNEY",
            "MELBOURNE",
            "PERTH",
            "CANBERRA",
            4


        )
        var question3=QuestionData(
            "what is the TOTAL of 32*8",
            3,
            "265",
            "256",
            "266",
            "246",
            2


        )
        var question4=QuestionData(
            "what is the National animal of Australia",
            4,
            "penguine",
            "peacock",
            "seagull",
            "Kangaroo",
            4


        )
        var question5=QuestionData(
            "what is 5x5?",
            5,
            "52",
            "25",
            "65",
            "15",
            2


        )
        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}