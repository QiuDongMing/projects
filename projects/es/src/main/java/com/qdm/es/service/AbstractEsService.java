package com.qdm.es.service;

import com.alibaba.fastjson.JSON;
import com.qdm.es.utils.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @author qiudm
 * @date 2018/11/30 17:15
 * @desc
 */
public class AbstractEsService<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEsService.class);

    @Autowired
    protected TransportClient client;

    protected T getById(String id, String index, String type, Class<T> clazz) {
        T t = null;
        GetResponse documentFields = client.prepareGet(index, type, id).get();
        Map<String, Object> source = documentFields.getSource();
        if(!CollectionUtils.isEmpty(source)) {
            try {
                t = (T) MapUtil.mapToBean(source, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    protected void index(String id, T t, String index, String type) {
        try {
            Map<String, Object> map = MapUtil.beanToMap(t);
            IndexRequestBuilder indexRequestBuilder = client.prepareIndex(index, type).setSource(map);
            if(StringUtils.isNotEmpty(id)) {
                indexRequestBuilder.setId(id);
            }
            IndexResponse indexResponse = indexRequestBuilder.get();
            LOGGER.info("indexResponse:{}", JSON.toJSONString(indexResponse));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }















}
