package com.rvsoni.ecom.mdc;

public enum MDCKeys {

	OPERATION ("Ecom.Operation"),PRODUCT("ECOM.Product");
	
	private String name;

	private MDCKeys(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
