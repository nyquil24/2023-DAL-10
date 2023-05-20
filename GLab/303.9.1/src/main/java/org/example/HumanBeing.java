package org.example;

/*Encapsulation in Java refers to hiding the class variable from other classes and giving access to them only through
methods (setters and getters) */

/* Encapsulation in Java means binding the data (variables) with the code (methods - setters and getters). */

public class HumanBeing{
    private float weight;
    private float height;
    private float bmi;

    public HumanBeing(float weight, float height, float bmi){
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }
    public HumanBeing(){

    }
    public float getWeight(){
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getHeight(){
        return height;
    }
    public void setHeight(float v){
        this.height = height;
    }
    public float getBmi() {
        return bmi;
    }
    public void setBmi(float bmi){
        this.bmi = bmi;
    }

    }
