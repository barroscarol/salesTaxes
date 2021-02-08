package com.salestaxes.shoppingcart;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import com.salestaxes.items.ItemBasketInterface;


public class ShoppingCart implements ShoppingCartInterface {

	private List<ItemBasketInterface> itemList;

	private float salesTaxes;
	private float totalAmountOfBasket;

	private static final Format FORMATTER = new DecimalFormat("0.00");

	public ShoppingCart() {
		itemList = new ArrayList<ItemBasketInterface>();
	}

	@Override
	public void addItemToCart(ItemBasketInterface item) {
		itemList.add(item);
	}

	private void cleaningCart() {
		totalAmountOfBasket = 0.0f;
		salesTaxes = 0.0f;
	}

	@Override
	public float getTotalAmountOfBasket() {
		return totalAmountOfBasket;
	}

	@Override
	public float getSalesTax() {
		return Float.valueOf(FORMATTER.format(salesTaxes));
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (ItemBasketInterface item : itemList) {
			buffer.append("\n").append(item.toString());
		}
		return buffer.toString();
	}

	@Override
	public void PrintReceipt() {
		cleaningCart();
		StringBuilder buffer = new StringBuilder();
		for (ItemBasketInterface item : itemList) {
			buffer.append("\n").append(item.toString());
			totalAmountOfBasket += item.getpriceForItemWithTax();
			salesTaxes += item.getItemsalesTaxes();
		}
		buffer.append("\n");
		buffer.append("\n Sales Tax: $" + FORMATTER.format(salesTaxes));
		buffer.append("\n Total : $" + totalAmountOfBasket);

		System.out.println("------------------THIS IS YOUR ORDER----------------------");
		System.out.println(buffer.toString());
		System.out.println("------------------THANKS FOR CHOOSING US------------------");

	}

}
