package com.salestaxes.items.enums;

public enum ItemCategories {

	BOOK(true, false), MEDICAL(true, false), FOOD(true, false), GENERAL_GOODIES(false, false),
	IMPORTED_BOOK(true, true), IMPORTED_MEDICAL(true, true), IMPORTED_FOOD(true, true),
	IMPORTED_GENERAL_GOODIES(false, true);

	private boolean isItemExemptFromTaxation;
	private boolean isImported;

	private ItemCategories(boolean ItemExemptFromTaxation, boolean imported) {
		isItemExemptFromTaxation = ItemExemptFromTaxation;
		isImported = imported;
	}

	public boolean isImported() {
		return isImported;
	}

	public boolean isItemExemptFromTaxation() {
		return isItemExemptFromTaxation;
	}

}