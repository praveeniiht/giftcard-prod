package com.giftcard.exceptiontestcases;

import static org.mockito.Mockito.*;
import static com.giftcard.utilityclasses.TestUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.giftcard.controller.GiftCardController;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.servicesImpl.GiftCardOrderServiceImpl;
import com.giftcard.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(GiftCardController.class)
public class ExceptionTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GiftCardOrderServiceImpl giftCardOrderServiceImpl;
	
	@Test
	public void testAddGiftOrderException() throws Exception {
		
		GiftCardOrderDetailsDTO badData = MasterData.getGiftCardOrderDetailsDTO();
		badData.setPhoneNumber("123");
		badData.setBuyerFirstName("ab");
		when(giftCardOrderServiceImpl.saveGiftCardOrderDetail(MasterData.getGiftCardOrderDetailsDTO()))
		.thenReturn(MasterData.getGiftCardOrderDetailsDTO());
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/gift-card/addGiftCardOrder")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);


		MockMvcRequestBuilders.get("/")
		.contentType(MediaType.APPLICATION_JSON)
		.$(0).equals("Hello I am from controller");


		
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();


		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"), 
		exceptionTestFile);
	}
	
	@Test
	public  void testDeleteGiftCardException() throws Exception{
		
		
		when(giftCardOrderServiceImpl.deleteGiftCards("1"))
		.thenReturn(MasterData.getGiftCardOrderDetailsDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteGiftCards/2")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), 
		exceptionTestFile);
	}
}
