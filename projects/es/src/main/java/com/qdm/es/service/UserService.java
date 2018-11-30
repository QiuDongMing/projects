package com.qdm.es.service;

import com.alibaba.fastjson.JSON;
import com.qdm.es.data.User;
import com.qdm.es.utils.MapUtil;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author qiudm
 * @date 2018/11/28 15:04
 * @desc
 */
@Service
public class UserService extends AbstractEsService<User> {

    protected String INDEX = "user";
    protected String TYPE = "_doc";

    /**
     * https://www.elastic.co/guide/en/elasticsearch/client/java-api/6.3/java-docs-get.html
     * @param id 非用户id，es的id, 此处我们id为用户id，存储index时设置了id为用户id
     * @return
     */
    User getById(String id) {
        return getById(id, INDEX, TYPE, User.class);
    }

    /**
     * https://www.elastic.co/guide/en/elasticsearch/client/java-api/6.3/java-docs-index.html
     * @param user
     */
    void createUserIndex(User user) {
        index(user.getId(), user, INDEX, TYPE);
    }



}
