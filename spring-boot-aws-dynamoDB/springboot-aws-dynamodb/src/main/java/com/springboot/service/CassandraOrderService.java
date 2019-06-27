package com.springboot.service;

import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;
import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;

/**
 * Created by sk on 28/10/18.
 */
public interface CassandraOrderService {

    OrderCassandraResponse createOrderCassandra(OrderCassandraRequest orderCassandraRequest);
    OrderCassandraResponse getOrderCassandra(String invitationId);
}
