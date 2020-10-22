package com.giftcard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.entitys.GiftCardOrderDetails;

import com.giftcard.services.GiftCardOrderService;



@RestController
@CrossOrigin
@RequestMapping("/gift-card")
public class GiftCardController {

	@Autowired
	private GiftCardOrderService giftCardOrderService;
	
	
	@GetMapping("/")
	public String test() {
		return "Hello I am from controller";
	}
		
	@PostMapping(value = "/addGiftCardOrder")
	public GiftCardOrderDetailsDTO addGiftOrder(@RequestBody @Valid GiftCardOrderDetailsDTO giftCardOrderDetails,
																BindingResult result) {
		
		HttpStatus status = HttpStatus.OK;
		
		return giftCardOrderDetails;
	}
	
	@PostMapping(value = "/placeOrder/{giftCardId}/{giftAmount}")
	public ResponseEntity<GiftCardOrderDetailsDTO> placeOrder(@PathVariable("giftCardId") String giftCardId, 
															  @PathVariable("giftAmount") Long giftAmount) {

		return null;
	}
	
	@GetMapping(value = "/viewAllOrders")
	public ResponseEntity<List<GiftCardOrderDetailsDTO>> viewAllOrders() {
		//return null;
		GiftCardOrderDetailsDTO orderDetails = new GiftCardOrderDetailsDTO();
		orderDetails.setOrderId("1");
		orderDetails.setBuyerFirstName("buyerFirstName");
		orderDetails.setBuyerLastName("buyerLastName");
		orderDetails.setEmail("email@gmail.com");
		Long amount = 100L;
		
		orderDetails.setGiftAmount(amount);
		orderDetails.setPhoneNumber("999999999");
		orderDetails.setRecipientLastName("recepientName");
		orderDetails.setRecipientFirstName("recipientFirstName");
		
		List<GiftCardOrderDetailsDTO> list = new ArrayList<GiftCardOrderDetailsDTO>();
		list.add(orderDetails);
		ResponseEntity<List<GiftCardOrderDetailsDTO>> response = 
				new ResponseEntity<List<GiftCardOrderDetailsDTO>>(list,HttpStatus.OK);
		return response;
		
	}
	
	@DeleteMapping(value = "/deleteGiftCards/{giftCardId}")
	public  ResponseEntity<GiftCardOrderDetailsDTO> deleteGiftCards(@PathParam("giftCardId") String giftCardId){
		return null;
	}
	
	@PutMapping(value = "/updateGiftCards")
	public  ResponseEntity<GiftCardOrderDetailsDTO> updateGiftCards(@Valid @RequestBody GiftCardOrderDetailsDTO giftCardOrderDetailsDTO,
																	BindingResult result){
		return null;
	}
	
}