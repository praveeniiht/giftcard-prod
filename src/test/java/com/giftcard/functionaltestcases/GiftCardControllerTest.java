package com.giftcard.functionaltestcases;

import static org.mockito.Mockito.*;
import static com.giftcard.utilityclasses.TestUtils.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class GiftCardControllerTest {

	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GiftCardOrderServiceImpl giftCardOrderServiceImpl;

	@Test
	public void testAddGiftOrder() throws Exception {
		when(giftCardOrderServiceImpl.saveGiftCardOrderDetail(MasterData.getGiftCardOrderDetailsDTO()))
		.thenReturn(MasterData.getGiftCardOrderDetailsDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/gift-card/addGiftCardOrder")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	@Test
	public void testPlaceOrder() throws Exception {
		when(giftCardOrderServiceImpl.placeOrder(100L, "1"))
		.thenReturn(MasterData.getGiftCardOrderDetailsDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/gift-card/placeOrder/1/100")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
		
	}
	
	@Test
	public void testViewAllOrders() throws Exception {
		List<GiftCardOrderDetailsDTO> list = new ArrayList<GiftCardOrderDetailsDTO>();
		list.add(MasterData.getGiftCardOrderDetailsDTO());
		when(giftCardOrderServiceImpl.getAllOrderDetails())
		.thenReturn(list);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/gift-card/viewAllOrders")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	@Test
	public  void testDeleteGiftCards() throws Exception{
		
		
		when(giftCardOrderServiceImpl.deleteGiftCards("1"))
		.thenReturn(MasterData.getGiftCardOrderDetailsDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteGiftCards/1")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}
	
	@Test
	public  void testUpdateGiftCards() throws Exception{
		
		when(giftCardOrderServiceImpl.updateGiftCards(MasterData.getGiftCardOrderDetailsDTO()))
		.thenReturn(MasterData.getGiftCardOrderDetailsDTO());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateGiftCards")
				.content(MasterData.asJsonString(MasterData.getGiftCardOrderDetailsDTO()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}

}