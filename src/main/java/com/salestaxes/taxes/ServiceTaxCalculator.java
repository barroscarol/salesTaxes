package com.salestaxes.taxes;

import com.salestaxes.items.ItemBasketInterface;
import com.salestaxes.taxes.enums.TaxCategories;

public class ServiceTaxCalculator implements TaxCalculatorInterface {
	private static final float ROUNDOFF = 0.05f;

	private TaxCategories getItemTaxCategory(ItemBasketInterface item) {
		if (item.isItemImported() && !item.isItemExemptFromTaxation()) {
			return TaxCategories.BOTH_TAXES;
		} else if (item.isItemImported() && item.isItemExemptFromTaxation()) {
			return TaxCategories.IMPORTED_TAX;
		} else if (!item.isItemImported() && !item.isItemExemptFromTaxation()) {
			return TaxCategories.BASIC_TAX;
		}
		return TaxCategories.EXEMPT_FROM_TAX;
	}

	public float calculateTax(ItemBasketInterface item) {
		return roundOffTax(getItemTaxCategory(item).getApplicableTax() * item.getpriceForItem());
	}

	private float roundOffTax(float tax) {
		return (float) Math.ceil(tax / ROUNDOFF) * ROUNDOFF;
	}
}
