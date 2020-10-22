package com.giftcard.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class GiftCardOrderDetailsDTO {

	private String orderId;

	@Length(min = 5, max = 30)
	@NotNull
	private String buyerFirstName;

	@Length(min = 3, max = 25)
	@NotNull
	private String buyerLastName;

	@Length(min = 3, max = 25)
	private String recipientFirstName;

	@Length(min = 3, max = 25)
	private String recipientLastName;

	@NotNull
	@Min(0L)
	private Long giftAmount;
	
	@NotNull
	@Length(min = 10, max = 10)
	private String phoneNumber;
	
	@NotNull
	@Email
	private String email;

}
