package com.codermi.beans;

/**
 * @author qiudm
 * @date 2019/1/21 17:23
 * @desc
 */
public class MyBean {

    private String id;

    private String name;


    public MyBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "MyBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
