package com.project.camping.stuff;

import java.util.List;

import com.project.camping.account.AccountDTO;

public interface StuffMapper {

	int insertStuff(StuffDTO sDto);

	List<StuffDTO> getAllStuff(StuffDTO s);

	StuffDTO getDetailStuff(StuffDTO s);

	List<StuffDTO> getSearchStuff(StuffSearchDTO s);

	List<CartDTO> getALlCartstuff(AccountDTO a);

	int deleteCartItem(CartDTO c);

	List<CartDTO> getCartsPayment(String[] strings);

	CartDTO getCartsPayment(String s);

	int insertCart(CartDTO c);

	StuffDTO buyNow(CartDTO c);

	StuffDTO getStuff(StuffDTO s);

	CartDTO getOrderItem(CartDTO cDTO);

	int insertOrderStuff(StuffOrderDTO soDTO);

	int insertOrderList(CartDTO ctDto);

	int deleteCart(CartDTO ctDto);

	List<StuffOrderDTO> getOrderNum(AccountDTO a);

	int getCart(CartDTO c);

	int updateCart(CartDTO c);

	int getCartCount(CartDTO c);

	int insertSales(StuffSaleDTO saleDTO);

	List<StuffSaleDTO> getTopItems(StuffSaleDTO saleDTO);

	int getSalesitem(StuffSaleDTO saleDTO);

	int updateSalesitem(StuffSaleDTO saleDTO);



}
