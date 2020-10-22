package com.giftcard.services;

import java.util.List;


import com.giftcard.dtos.GiftCardOrderDetailsDTO;





public interface GiftCardOrderService {
    
	public List<GiftCardOrderDetailsDTO> getAllOrderDetails();

	public GiftCardOrderDetailsDTO saveGiftCardOrderDetail(GiftCardOrderDetailsDTO giftCardOrderDetails);
	
	public GiftCardOrderDetailsDTO deleteGiftCards(String giftCardId);
	
	public GiftCardOrderDetailsDTO updateGiftCards(GiftCardOrderDetailsDTO giftCardOrderDetails);
	
	public GiftCardOrderDetailsDTO placeOrder(Long giftAmount, String giftCardId);
	
}
