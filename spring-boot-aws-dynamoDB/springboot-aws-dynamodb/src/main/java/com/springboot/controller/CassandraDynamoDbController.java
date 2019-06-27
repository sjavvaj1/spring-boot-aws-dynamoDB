package com.springboot.controller;

import com.springboot.domain.OrderCassandraRequest;
import com.springboot.domain.OrderCassandraResponse;
import com.springboot.domain.OrderDynamo;
import com.springboot.repository.DynamoDbRepository;
import com.springboot.service.CassandraDynamoDbService;
import com.springboot.service.CassandraOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/orderDynamoCassandra")
public class CassandraDynamoDbController {

	@Autowired
	CassandraDynamoDbService cassandraDynamoDbService;

	@PostMapping
	public ResponseEntity createOrderDynamoCassandra(@RequestBody OrderCassandraRequest orderCassandraRequest) {

		OrderCassandraResponse createOrderDynamoCassandraResponse = cassandraDynamoDbService.createOrderDynamoCassandra(orderCassandraRequest);

		if (null != createOrderDynamoCassandraResponse) {
			return new ResponseEntity(createOrderDynamoCassandraResponse, OK);
		} else {
			return new ResponseEntity("Issue while writing invitationRequest message", BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity getOrderDynamoCassandra(@RequestParam String orderId) {

		OrderCassandraResponse getOrderDynamoCassandraResponse = cassandraDynamoDbService.getOrderDynamoCassandra(orderId);

		if (null != getOrderDynamoCassandraResponse) {
			return new ResponseEntity(getOrderDynamoCassandraResponse, OK);
		} else {
			return new ResponseEntity("No invitation exists", BAD_REQUEST);
		}
	}
}