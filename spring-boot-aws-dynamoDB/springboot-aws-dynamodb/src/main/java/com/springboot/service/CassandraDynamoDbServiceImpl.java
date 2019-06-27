package com.springboot.service;

import com.springboot.domain.OrderCassandra;
import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;
import com.springboot.domain.OrderDynamo;
import com.springboot.mapper.OrderCassandraMapper;
import com.springboot.mapper.OrderDynamoMapper;
import com.springboot.repository.DynamoDbRepository;
import com.springboot.repository.OrderCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by sk on 28/10/18.
 */
@Service
public class CassandraDynamoDbServiceImpl implements CassandraDynamoDbService {

    @Autowired
    OrderCassandraRepository orderCassandraRepository;

    @Autowired
    private DynamoDbRepository repository;

    @Value("${order.dynamo.cassandra.type}")
    public boolean OrderDynamoCassandraType;

    @Override
    public OrderCassandraResponse createOrderDynamoCassandra(OrderCassandraRequest orderCassandraRequest) {

        //System.out.println("entering createInvitation");
        // map request to domain

        OrderCassandraResponse orderCassandraResponse=null;

        if(OrderDynamoCassandraType) {

            OrderCassandra orderCassandraDomain = OrderCassandraMapper.toDomainFromRequest(orderCassandraRequest);

            //System.out.println("after invitationDomain"+orderCassandraRequest.toString());

            OrderCassandra updatedInvitationRequest = orderCassandraRepository.createOrderCassandra(orderCassandraDomain);

            // System.out.println("after updatedInvitationRequest");

            // map domain to response
            orderCassandraResponse = OrderCassandraMapper.toResponseFromDomain(updatedInvitationRequest);

            System.out.println("Order ID after creation"+ orderCassandraResponse.getOrderId());

            // System.out.println("after invitationResponse");

        } else
        {
            System.out.println("Call Goes to Else Condition for Dynamo DB");
            OrderDynamo orderDynamo = OrderDynamoMapper.toDomainFromRequest(orderCassandraRequest);
            OrderDynamo updatedOrderDynamo = repository.insertIntoDynamoDB(orderDynamo);
            orderCassandraResponse = OrderDynamoMapper.toResponseFromDomain(updatedOrderDynamo);

            System.out.println("Order ID after creation"+ orderCassandraResponse.getOrderId());
        }
        return orderCassandraResponse;
    }

    @Override
    public OrderCassandraResponse getOrderDynamoCassandra(String orderId) {

        System.out.println("before getOrderCassandra "+orderId);

        OrderCassandraResponse orderCassandraResponse=null;

        if(OrderDynamoCassandraType) {

            OrderCassandra requestedOrderCassandra = orderCassandraRepository.getOrderCassandra(orderId);

            // map domain to response
            orderCassandraResponse = OrderCassandraMapper.toResponseFromDomain(requestedOrderCassandra);

        }
        else
        {
            OrderDynamo orderDynamo = repository.getOrderDetailsFromDynamoDB(orderId);
            orderCassandraResponse = OrderDynamoMapper.toResponseFromDomain(orderDynamo);

            System.out.println("Order Look Up from Dynamo DB"+ orderCassandraResponse.getOrderId());
        }
        return orderCassandraResponse;

    }
}
