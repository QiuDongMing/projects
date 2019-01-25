package com.codermi.abstracts;

/**
 * @author qiudm
 * @date 2019/1/22 17:22
 * @desc
 */
public class Child extends Parent {

    public Child() {
    }

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected String getNameAndAge() {
        return getName() + getAge();
    }
}
