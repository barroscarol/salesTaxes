package com.salestaxe.module;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorFactory {
	private InjectorFactory() {
	}

	private static Injector injector;

	static {
		injector = Guice.createInjector(new ShoppingModules());
	}

	public static Injector getInjector() {
		return injector;
	}
}
