package com.company.testQuestions;

public class Essay extends TestQuestions {
    private int answerSpace;


    Essay(){
    }

    Essay(String question, int n){
        super(question);
        answerSpace = n;

    }

    @Override
    protected void readQuestion() {
        answerSpace = Integer.parseInt(WriteTest.scan.nextLine());
        question = WriteTest.scan.nextLine();
    }



    @Override
    public String toString() {
        String space ="";
        for(int i = 0; i <= answerSpace;i++){
            space+="\n";
        }
        return question + space;
    }
}
