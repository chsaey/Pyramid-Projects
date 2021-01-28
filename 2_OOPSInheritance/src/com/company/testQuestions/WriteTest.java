package com.company.testQuestions;

import java.io.File;
import java.util.Scanner;

public class WriteTest {
    static Scanner scan;

    public static void main(String[] args) {


        try {
            scan = new Scanner(new File("C:\\Users\\chsae\\Documents\\_Code\\_Pyramid-Projects\\2_OOPSInheritance\\src\\testbank.dat"));
            TestQuestions[] questions = new TestQuestions[Integer.parseInt(scan.nextLine().trim())];
            for(int i =0; i < questions.length;i++){
                String testType = scan.nextLine().trim();
                if(testType.equals("e")){
                    Essay essay = new Essay();
                    essay.readQuestion();
                    questions[i]=essay;
                } else{
                    MultChoice mc = new MultChoice();
                    mc.readQuestion();
                    questions[i]=mc;
                }
            }
            int count = 1;
            for(TestQuestions question: questions){
                System.out.println(count + ". " +question.toString());
                count++;
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }

}
