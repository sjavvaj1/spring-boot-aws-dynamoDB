package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.domain.OrderDynamo;
import com.springboot.repository.DynamoDbRepository;

@RestController
@RequestMapping("/dynamoDb")
public class DynamoDbController {

	@Autowired
	private DynamoDbRepository repository;

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String createOrderInDynamoDB(@RequestBody OrderDynamo order) {
		repository.insertIntoDynamoDB(order);
		return "Successfully inserted into DynamoDB table.order ID is :- "+order.getOrderId();
	}

	@RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
	public ResponseEntity<OrderDynamo> getOrderDetails(@RequestParam String orderId) {
		OrderDynamo order = repository.getOrderDetailsFromDynamoDB(orderId);
		return new ResponseEntity<OrderDynamo>(order, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateOrderDetails", method = RequestMethod.PUT)
	public void updateOrderDetails(@RequestBody OrderDynamo order) {
		repository.updateOrderDetails(order);
	}


	@RequestMapping(value = "/deleteOrderDetails/{orderId}", method = RequestMethod.DELETE)
	public void deleteOrderDetails(@PathVariable("orderId") String orderId) {
		OrderDynamo order = new OrderDynamo();
		order.setOrderId(orderId);
		//order.setLastName(lastName);
		repository.deleteOrderDetails(order);

	}
}