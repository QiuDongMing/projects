package com.codermi.mybatis.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author qiudm
 * @date 2019/2/14 16:08
 * @desc 定义一个实现ApplicationEvent的邮件发送事件
 */
public class EmailEvent extends ApplicationEvent {

    private String address;
    private String text;

    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(String address,  String text, Object source) {
        super(source);
        this.address = address;
        this.text = text;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
