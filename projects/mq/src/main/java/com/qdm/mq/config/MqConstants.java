package com.qdm.mq.config;

/**
 * @author qiudm
 * @date 2018/12/29 16:12
 * @desc
 */
public interface MqConstants {

    String USERINFO_QUEUE = "USERINFO-QUEUE";
    String USERINFO_QUEUE2 = "USERINFO-QUEUE2";

    String USERINFO_FANOUT_EXCHANGE = "USERINFO-QUEUE";


    String USERINTO_DIRECT_EXCHANGE = "USERINFO-DIRECT-EXCHANGE";

    String USERINFO_DIRECT_QUEUE = "USERINFO-DIRECT-QUEUE";

    String USERINTO_DIRECT_ROUTE_KEY = "userinfo_route_key";


    String USERINTO_TOPIC_EXCHANGE = "USERINFO-TOPIC-EXCHANGE";
    String USERINFO_TOPIC_QUEUE1 = "USERINFO_TOPIC_QUEUE1";
    String USERINFO_TOPIC_QUEUE2 = "USERINFO_TOPIC_QUEUE2";

    String USERINTO_TOPIC_ROUTE_KEY1 = "userinfo.route.key.*";
    String USERINTO_TOPIC_ROUTE_KEY2 = "*.userinfo.route.key";

}
