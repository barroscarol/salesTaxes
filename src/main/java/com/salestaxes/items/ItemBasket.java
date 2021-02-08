package com.salestaxes.items;


import com.google.inject.Inject;
import com.salestaxes.items.enums.ItemCategories;
import com.salestaxes.taxes.TaxCalculatorInterface;

public class ItemBasket implements ItemBasketInterface {

	private float priceForItem;
	private String nameOfItem;
	private ItemCategories itemCategory;

	@Inject
	private TaxCalculatorInterface TaxCalculator;

	@Override
	public String getItemDescription() {
		return nameOfItem;
	}

	@Override
	public void setItemDescription(String itemnameOfItem) {
		nameOfItem = itemnameOfItem;
	}

	@Override
	public float getpriceForItem() {
		return priceForItem;
	}

	@Override
	public void setpriceForItem(float price) {
		priceForItem = price;

	}

	@Override
	public void setItemCategories(ItemCategories category) {
		itemCategory = category;

	}

	@Override
	public boolean isItemImported() {
		return itemCategory.isImported();
	}

	@Override
	public boolean isItemExemptFromTaxation() {
		return itemCategory.isItemExemptFromTaxation();
	}

	@Override
	public float getpriceForItemWithTax() {
		return getItemsalesTaxes() + getpriceForItem();
	}

	@Override
	public float getItemsalesTaxes() {
		return (TaxCalculator.calculateTax(this));
	}

	@Override
	public String toString() {
		return "   (001)  - " + nameOfItem + ": $" + getpriceForItemWithTax();
	}

}
