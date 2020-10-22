package com.giftcard.utilityclasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;

public class MasterData {

	public static GiftCardOrderDetailsDTO getGiftCardOrderDetailsDTO() {

		GiftCardOrderDetailsDTO orderDetails = new GiftCardOrderDetailsDTO();
		orderDetails.setOrderId("1");
		orderDetails.setBuyerFirstName("buyerFirstName");
		orderDetails.setBuyerLastName("buyerLastName");
		orderDetails.setEmail("email@gmail.com");
		Long amount = 100L;
		
		orderDetails.setGiftAmount(amount);
		orderDetails.setPhoneNumber("9999999999");
		orderDetails.setRecipientLastName("recepientName");
		orderDetails.setRecipientFirstName("recipientFirstName");
		
		return orderDetails;
	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
