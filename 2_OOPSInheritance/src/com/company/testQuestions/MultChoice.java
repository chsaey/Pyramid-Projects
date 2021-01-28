package com.company.testQuestions;

public class MultChoice extends TestQuestions {
    private String[] choices;

    MultChoice(){

    }

    MultChoice(String question, int n){
        super(question);
        choices = new String[n];
    }

    @Override
    protected void readQuestion() {
        choices = new String[Integer.parseInt(WriteTest.scan.nextLine())];
        question = WriteTest.scan.nextLine();
        for(int i =0; i < choices.length;i++){
            choices[i] = WriteTest.scan.nextLine();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        char letter = 'A';
        for(String c: choices ){
            sb.append(letter +") " + c+"\n");
            letter++;
        }
        return question +"\n" + sb.toString();

    }
}
