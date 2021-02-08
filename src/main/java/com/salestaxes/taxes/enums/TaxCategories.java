package com.salestaxes.taxes.enums;

public enum TaxCategories {
	BASIC_TAX(10.0f / 100), IMPORTED_TAX(5.0f / 100), EXEMPT_FROM_TAX(0),
	BOTH_TAXES(BASIC_TAX.getApplicableTax() + IMPORTED_TAX.getApplicableTax());

	private float applicableTax;

	private TaxCategories(float tax) {
		applicableTax = tax;
	}

	public float getApplicableTax() {
		return applicableTax;
	}
}
