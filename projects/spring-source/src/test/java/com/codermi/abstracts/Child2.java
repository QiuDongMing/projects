package com.codermi.abstracts;

/**
 * @author qiudm
 * @date 2019/1/22 17:25
 * @desc
 */
public class Child2 extends Parent {

    public Child2() {
    }

    public Child2(String name, int age) {
        super(name, age);
    }

    @Override
    protected String getNameAndAge() {
        return "child2:" + getName() + getAge();
    }
}
