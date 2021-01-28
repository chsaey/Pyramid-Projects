package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RegularBook regBook = new RegularBook("reg","ken jon",7300);
        AudioBook abook = new AudioBook("audio","Bob smith", 7300);
        ReferenceBook refBook = new ReferenceBook("reference",7300);

        System.out.println(regBook.isOverdue(7400));
        System.out.println(regBook.daysOverdue(7400));
        System.out.println(regBook.computeFine(7400));

        System.out.println("");

        System.out.println(abook.isOverdue(7400));
        System.out.println(abook.daysOverdue(7400));
        System.out.println(abook.computeFine(7400));

        System.out.println("");

        System.out.println(refBook.isOverdue(7400));
        System.out.println(refBook.daysOverdue(7400));
        System.out.println(refBook.computeFine(7400));


    }
}
