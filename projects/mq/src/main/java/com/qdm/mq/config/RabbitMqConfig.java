package com.qdm.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiudm
 * @date 2018/12/29 16:05
 * @desc
 */
@Configuration
public class RabbitMqConfig {


    /**************** fanout bind USERINFO_FANOUT_EXCHANGE to USERINFO_QUEUE,USERINFO_QUEUE2  ********************/
    @Bean
    public Queue userInfoQueue() {
        return new Queue(MqConstants.USERINFO_QUEUE);
    }

    @Bean
    public Queue userInfoQueue2() {
        return new Queue(MqConstants.USERINFO_QUEUE2);
    }

    @Bean
    public FanoutExchange userInfoExchange() {
       return new FanoutExchange(MqConstants.USERINFO_FANOUT_EXCHANGE);
    }

    @Bean
    public Binding userInfoQueueBinding() {
        return BindingBuilder.bind(userInfoQueue()).to(userInfoExchange());
    }

    @Bean
    public Binding userInfoQueue2Binding() {
        return BindingBuilder.bind(userInfoQueue2()).to(userInfoExchange());
    }
    /**************************************************************************************************************/


    /**************** direct bind USERINFO_DIRECT_EXCHANGE to USERINFO_DIRECT_QUEUE *******************************/

    @Bean
    public Queue userInfoDirectQueue() {
        return new Queue(MqConstants.USERINFO_DIRECT_QUEUE);
    }

    @Bean
    public DirectExchange userInfoDirectExchange()  {
        return new DirectExchange(MqConstants.USERINTO_DIRECT_EXCHANGE);
    }

    @Bean
    public Binding userInfoDirectBind() {
        return BindingBuilder.bind(userInfoDirectQueue()).to(userInfoDirectExchange()).with(MqConstants.USERINTO_DIRECT_ROUTE_KEY);
    }
    /**************************************************************************************************************/



    /**************** direct bind USERINFO_topic_EXCHANGE to USERINFO_DIRECT_QUEUE *******************************/
    @Bean
    public Queue userInfoTopicQueue1() {
        return new Queue(MqConstants.USERINFO_TOPIC_QUEUE1);
    }

    @Bean
    public Queue userInfoTopicQueue2() {
        return new Queue(MqConstants.USERINFO_TOPIC_QUEUE2);
    }

    @Bean
    public TopicExchange userInfoTopicExchange()  {
        return new TopicExchange(MqConstants.USERINTO_TOPIC_EXCHANGE);
    }

    @Bean
    public Binding userInfoTopicBind1() {
        return BindingBuilder.bind(userInfoTopicQueue1()).to(userInfoTopicExchange()).with(MqConstants.USERINTO_TOPIC_ROUTE_KEY1);
    }

    @Bean
    public Binding userInfoTopicBind2() {
        return BindingBuilder.bind(userInfoTopicQueue2()).to(userInfoTopicExchange()).with(MqConstants.USERINTO_TOPIC_ROUTE_KEY2);
    }
    /**************************************************************************************************************/



}
