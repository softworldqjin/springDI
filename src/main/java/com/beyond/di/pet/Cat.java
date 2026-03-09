package com.beyond.di.pet;

public class Cat {
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String bark() {
        return "야옹";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }


}
