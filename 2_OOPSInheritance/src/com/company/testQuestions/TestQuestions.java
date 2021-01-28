package com.company.testQuestions;

public abstract class TestQuestions {
    protected String question;

    TestQuestions(){
    }

    TestQuestions(String question){
        this.question = question;
    }



    protected abstract void readQuestion();

}
