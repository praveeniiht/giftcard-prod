package com.giftcard.boundarytestcases;

import static org.mockito.Mockito.*;
import static com.giftcard.utilityclasses.TestUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.junit4.SpringRunner;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;

import com.giftcard.utilityclasses.MasterData;








@RunWith(SpringRunner.class)
public class EntityValidationTest {
	
	

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testGiftOrdersSuccess() throws Exception {
		
			GiftCardOrderDetailsDTO details = MasterData.getGiftCardOrderDetailsDTO();
			Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
			yakshaAssert(currentTest(), 
						 violations.isEmpty()? true : false, 
						 boundaryTestFile);
	}
	
	@Test
	public void testBuyerNameLength() throws Exception {

		GiftCardOrderDetailsDTO buyer = MasterData.getGiftCardOrderDetailsDTO();
		buyer.setBuyerFirstName("ab");
		Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(buyer);
		
		yakshaAssert(currentTest(), 
					 violations.isEmpty()? true : false, 
					 boundaryTestFile);

	}
	
	@Test
	public void testRecipientNameLength() throws Exception {
		GiftCardOrderDetailsDTO buyer = MasterData.getGiftCardOrderDetailsDTO();
		buyer.setRecipientFirstName("ab");
		Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(buyer);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);

	}

	

	@Test
	public void testRecipientMobileNo() throws Exception {
		GiftCardOrderDetailsDTO buyer = MasterData.getGiftCardOrderDetailsDTO();
		buyer.setPhoneNumber("123");
		Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(buyer);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);
	}
	@Test
	public void testGiftAmount() throws Exception {
		GiftCardOrderDetailsDTO buyer = MasterData.getGiftCardOrderDetailsDTO();
		buyer.setGiftAmount(-1L);
		Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(buyer);
		yakshaAssert(currentTest(), 
					violations.isEmpty() ? true : false, 
					 boundaryTestFile);
	}
	
}