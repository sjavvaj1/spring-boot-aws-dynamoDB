package com.springboot.service;

import com.springboot.domain.*;
import com.springboot.mapper.OrderCassandraMapper;
import com.springboot.repository.OrderCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sk on 28/10/18.
 */
@Service
public class CassandraOrderServiceImpl implements CassandraOrderService {

    @Autowired
    OrderCassandraRepository orderCassandraRepository;

    @Override
    public OrderCassandraResponse createOrderCassandra(OrderCassandraRequest orderCassandraRequest) {

        //System.out.println("entering createInvitation");
        // map request to domain
        OrderCassandra orderCassandraDomain = OrderCassandraMapper.toDomainFromRequest(orderCassandraRequest);

        //System.out.println("after invitationDomain"+orderCassandraRequest.toString());

        OrderCassandra updatedInvitationRequest = orderCassandraRepository.createOrderCassandra(orderCassandraDomain);

        // System.out.println("after updatedInvitationRequest");

        // map domain to response
        OrderCassandraResponse orderCassandraResponse = OrderCassandraMapper.toResponseFromDomain(updatedInvitationRequest);

        // System.out.println("after invitationResponse");

        return orderCassandraResponse;
    }

    @Override
    public OrderCassandraResponse getOrderCassandra(String orderId) {

        System.out.println("before getOrderCassandra"+orderId);
        OrderCassandra requestedOrderCassandra = orderCassandraRepository.getOrderCassandra(orderId);

        // map domain to response
        OrderCassandraResponse orderCassandraResponse = OrderCassandraMapper.toResponseFromDomain(requestedOrderCassandra);

        return orderCassandraResponse;

    }
}
