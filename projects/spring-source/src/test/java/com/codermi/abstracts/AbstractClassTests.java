package com.codermi.abstracts;

import org.junit.Test;

/**
 * @author qiudm
 * @date 2019/1/22 17:23
 * @desc
 */
public class AbstractClassTests {


    @Test
    public void abstractClassTest() {
        Parent parent1 = new Child("aa1", 1);
        Parent parent2 = new Child2("aa2", 2);
        System.out.println("parent1.getNameAndAge = " + parent1.getNameAndAge());
        System.out.println("parent2.getNameAndAge = " + parent2.getNameAndAge());

    }









}
