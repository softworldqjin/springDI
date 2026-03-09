package com.beyond.di.owner;

import com.beyond.di.pet.Cat;
import com.beyond.di.pet.Dog;

public class Owner {
    private String name;
    private int age;
    private Cat cat;

    public Owner() {
    }

    public Owner(String name, int age, Cat cat) {
        this.name = name;
        this.age = age;
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Cat getCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + cat +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
