package com.salestaxes.items;

import com.salestaxes.items.enums.ItemCategories;

public interface ItemBasketInterface {

	String getItemDescription();

	void setItemDescription(String description);

	float getpriceForItem();

	void setpriceForItem(float price);

	void setItemCategories(ItemCategories itemCategory);

	boolean isItemImported();

	boolean isItemExemptFromTaxation();

	float getpriceForItemWithTax();

	float getItemsalesTaxes();

}
