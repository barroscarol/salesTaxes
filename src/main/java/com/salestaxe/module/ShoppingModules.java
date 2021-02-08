package com.salestaxe.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.salestaxes.items.ItemBasket;
import com.salestaxes.items.ItemBasketInterface;
import com.salestaxes.shoppingcart.ShoppingCart;
import com.salestaxes.shoppingcart.ShoppingCartInterface;
import com.salestaxes.taxes.ServiceTaxCalculator;
import com.salestaxes.taxes.TaxCalculatorInterface;

class ShoppingModules extends AbstractModule {

	@Override
	protected void configure() {
		bind(TaxCalculatorInterface.class).to(ServiceTaxCalculator.class).in(Singleton.class);
		bind(ItemBasketInterface.class).to(ItemBasket.class);
		bind(ShoppingCartInterface.class).to(ShoppingCart.class);
	}

}
