package org.jabosu.common.util.search;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.jabosu.common.exception.BusinessRuntimeException;
import org.jabosu.common.services.api.ConfigService;
import org.jabosu.common.util.ConfigLoader;
import org.jabosu.common.util.InjectorHelper;

import java.util.List;
import java.util.Map;

/**
 * Created by satya on 15/8/15.
 */
public class ElasticSearchFactory {

    private static TransportClient client;

    private static ElasticSearchFactory instance;
    private static ConfigService config;

    private ElasticSearchFactory() {

        config = ConfigLoader.getConfig();

        client = new TransportClient();
//                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));


        List elasticSearchServers = config.getList("elastic.search.servers");

        for(Object server: elasticSearchServers) {
            String host = (String) ((Map)server).get("host");
            int port = (int)((Map)server).get("port");

            client.addTransportAddress(new InetSocketTransportAddress(host, port));
        }
    }

    public static ElasticSearchFactory getInstance() {

        if(instance == null)
            instance = new ElasticSearchFactory();

        return instance;
    }

    public Client getClient() {
        return client;
    }


}
