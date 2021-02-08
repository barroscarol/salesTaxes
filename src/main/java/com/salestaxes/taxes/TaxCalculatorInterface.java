package com.salestaxes.taxes;

import com.salestaxes.items.ItemBasketInterface;

public interface TaxCalculatorInterface{
	float calculateTax(ItemBasketInterface item);
}
