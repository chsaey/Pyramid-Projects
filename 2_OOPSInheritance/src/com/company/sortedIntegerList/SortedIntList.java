package com.company.sortedIntegerList;

public class SortedIntList extends IntList {

    //-------------------------------------------------------------   // Constructor -- creates an integer list of a given size.

    public SortedIntList(int size) {
        super(size);
    }

    //-------------------------------------------------------------   // Adds an integer to the list. If the list is full,
    // prints a message and does nothing.
    @Override
    public void add(int value) {
        if (numElements == list.length) {
            System.out.println("Can't add, list is full");
        }
        else {
            if(numElements==0){
                list[numElements] = value;
                numElements++;
            } else{
                for(int i=0; i <= numElements; i++){
                    if(value <= list[i]){
                        int temp = list[i];
                        list[i] = value;
                        value = temp;
                    }
                }
                list[numElements] = value;
                numElements++;
            }
        }
    }

    //-------------------------------------------------------------   // Returns a string containing the elements of the list with their   // indices.
    public String toString() {
        String returnString = "";
        for (int i = 0; i < numElements; i++)
            returnString += i + ": " + list[i] + "\n";
        return returnString;
    }
}

