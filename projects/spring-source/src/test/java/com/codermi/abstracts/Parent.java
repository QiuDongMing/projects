package com.codermi.abstracts;

/**
 * @author qiudm
 * @date 2019/1/22 17:20
 * @desc
 */
public abstract class Parent {

    private String name;

    private int age;

    public Parent() {}

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected abstract String getNameAndAge();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
