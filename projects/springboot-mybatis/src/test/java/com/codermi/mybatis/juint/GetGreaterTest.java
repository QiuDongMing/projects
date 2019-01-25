package com.codermi.mybatis.juint;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiudm
 * @date 2019/1/21 13:41
 * @desc
 */
public class GetGreaterTest {



    @Test
    public void getGreater() {
        int n = 132;
        System.out.println("getStrCharacter(n) = " + getGreater(n));
    }

    private int getGreater(int n) {
        n += 1;
        String str = String.valueOf(n);
        Set<Character> characters = getStrCharacterSet(str);
        while (characters.size() != str.length()) {
            n += 1;
            str = String.valueOf(n);
            characters = getStrCharacterSet(str);
        }
        return n;
    }

    private Set<Character> getStrCharacterSet(String str) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }
        return characters;
    }















}
