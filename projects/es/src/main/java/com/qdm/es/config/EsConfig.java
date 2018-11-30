package com.qdm.es.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @author qiudm
 * @date 2018/11/28 14:01
 * @desc
 */
@Configuration
public class EsConfig implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsConfig.class);

    @Value("${elasticsearch.host}")
    private String hostName;

    @Value("${elasticsearch.port}")
    private int hostPort;

    private TransportClient client;

    @Override
    public void destroy() throws Exception {
        try {
            if (client != null) {
                client.close();
            }
        } catch (Exception e) {
            LOGGER.error("close es client error:", e);
        }
    }


    @Override
    public TransportClient getObject() throws Exception {
        return client;
    }

    @Override
    public Class<TransportClient> getObjectType() {
        return TransportClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("init es client...");
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(hostName), hostPort));
//        client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(
//                        new InetSocketTransportAddress(InetAddress.getByName(hostName), hostPort)
//                );
    }
}
