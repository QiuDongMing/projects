package com.qdm.es.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiudm
 * @date 2018/11/29 18:29
 * @desc
 */
public class TestService {

    public static void main(String[] args) {

        List<St> ids = new ArrayList<St>();
        St st;
        for(int i=0;i<3;i++) {
            st = new St();
            st.setA(i);
            System.out.println("st = " + st);
            ids.add(st);
        }

        for (St s : ids) {
            System.out.println("s = " + s);
        }

    }





}
