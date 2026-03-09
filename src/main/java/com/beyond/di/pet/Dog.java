package com.beyond.di.pet;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }

    public String bark() {
        return "멍멍";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

}
