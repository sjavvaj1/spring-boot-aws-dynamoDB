package com.springboot.service;

import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;

/**
 * Created by sk on 28/10/18.
 */
public interface CassandraDynamoDbService {

    OrderCassandraResponse createOrderDynamoCassandra(OrderCassandraRequest orderCassandraRequest);
    OrderCassandraResponse getOrderDynamoCassandra(String orderId);
}
