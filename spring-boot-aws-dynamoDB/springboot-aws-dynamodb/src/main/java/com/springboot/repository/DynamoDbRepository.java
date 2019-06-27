package com.springboot.repository;

import java.util.HashMap;
import java.util.Map;

import com.springboot.domain.OrderDynamo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

@Repository
public class DynamoDbRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DynamoDbRepository.class);

	@Autowired
	private DynamoDBMapper mapper;

	public OrderDynamo insertIntoDynamoDB(OrderDynamo order) {

		mapper.save(order);

		return mapper.load(OrderDynamo.class, order.getOrderId());
	}

	public OrderDynamo getOrderDetailsFromDynamoDB(String orderId) {
		return mapper.load(OrderDynamo.class, orderId);
	}

	public void updateOrderDetails(OrderDynamo order) {
		try {
			mapper.save(order, buildDynamoDBSaveExpression(order));
			LOGGER.info("successfully updated order - " + order.getOrderId());
		} catch (ConditionalCheckFailedException exception) {
			LOGGER.error("invalid data - " + exception.getMessage());
		}
	}

	public void deleteOrderDetails(OrderDynamo order) {
		mapper.delete(order);
		LOGGER.info("successfully deleted order - " + order.getOrderId());
	}

	public DynamoDBSaveExpression buildDynamoDBSaveExpression(OrderDynamo order) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("orderId", new ExpectedAttributeValue(new AttributeValue(order.getOrderId()))
				.withComparisonOperator(ComparisonOperator.EQ));
		saveExpression.setExpected(expected);
		return saveExpression;
	}
}