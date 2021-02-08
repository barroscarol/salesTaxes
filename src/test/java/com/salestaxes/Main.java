package com.salestaxes;

import java.util.Scanner;

import com.salestaxe.module.InjectorFactory;
import com.salestaxes.items.ItemBasketInterface;
import com.salestaxes.items.enums.ItemCategories;
import com.salestaxes.shoppingcart.ShoppingCartInterface;



public class Main {

	enum ItemCategoriesList {

		BOOK("Book"), CHOCOLATE_BAR("Chocolate Bar"), CHOCOLATE_BOX("Chocolate Box"), MUSIC_CD("Music CD"),
		PERFUME("Perfume"), HEAD_ACHE_PILLS("Head Ache Pills");

		private String itemName;

		private ItemCategoriesList(String name) {
			itemName = name;
		}

		public String getItemName() {
			return itemName;
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ItemCategoriesList list[] = ItemCategoriesList.values();
		StringBuilder buffer = new StringBuilder();
		int count = 1;

		for (ItemCategoriesList item : list) {
			buffer.append(count++).append(":").append(item.getItemName() + "\n");
		}

		String productList = " Creating your shopping Basket,please select the items :\n - input 0 to submit your cart when it's finished \n" + buffer.toString();

		ItemCategories[] itemCategorys = ItemCategories.values();

		buffer.delete(0, buffer.length());
		for (ItemCategories itemCategory : itemCategorys) {
			buffer.append(itemCategory.ordinal()).append(" :").append(itemCategory.name() + "\n");
		}

		String itemCategoryList = "ItemBasket category: \n " + "\n" + buffer;

		ShoppingCartInterface cart = InjectorFactory.getInjector().getInstance(ShoppingCartInterface.class);
		while (true) {
			System.out.println(productList);	
			int product = scan.nextInt();
			if (product == 0) {
				break;
			}
			ItemBasketInterface item = InjectorFactory.getInjector().getInstance(ItemBasketInterface.class);
			item.setItemDescription(list[product - 1].getItemName());

			System.out.println("Item price: ");
			item.setpriceForItem(scan.nextFloat());

			System.out.println(itemCategoryList);
			item.setItemCategories(itemCategorys[scan.nextInt()]);

			cart.addItemToCart(item);

		}

		cart.PrintReceipt();
		scan.close();

	}
}
