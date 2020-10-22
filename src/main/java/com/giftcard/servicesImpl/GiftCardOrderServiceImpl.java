package com.giftcard.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giftcard.daos.GiftCardOrderDetailsDAO;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.services.GiftCardOrderService;

@Service
public class GiftCardOrderServiceImpl implements GiftCardOrderService {

	@Autowired
	private GiftCardOrderDetailsDAO giftCardOrderDetailsDAO;
	
	
	@Override
	public List<GiftCardOrderDetailsDTO> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GiftCardOrderDetailsDTO saveGiftCardOrderDetail(GiftCardOrderDetailsDTO giftCardOrderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public GiftCardOrderDetailsDTO deleteGiftCards(String giftCardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GiftCardOrderDetailsDTO updateGiftCards(GiftCardOrderDetailsDTO giftCardOrderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GiftCardOrderDetailsDTO placeOrder(Long giftAmount, String giftCardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
