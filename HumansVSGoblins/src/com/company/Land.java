package com.company;

public class Land {

    Object on;
    char value;

    public Land (){
        this.on = new Land();
        this.value = 'L';
    }

    public void setOn(Object on){
        this.on = on;
        switch (on.getClass().getSimpleName()){
            case "Human":
                this.value = 'H';
                break;
            case "Goblin":
                this.value = 'G';
                break;
            case "Treasure":
                this.value = 'T';
                break;
            case "Obstacle":
                this.value = 'O';
                break;
            default:
                this.value ='L';
        }
    }
}
