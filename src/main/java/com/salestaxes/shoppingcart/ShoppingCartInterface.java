package com.salestaxes.shoppingcart;

import com.salestaxes.items.ItemBasketInterface;

public interface ShoppingCartInterface {

	public void addItemToCart(ItemBasketInterface item);

	public float getTotalAmountOfBasket();

	public float getSalesTax();

	public void PrintReceipt();


}