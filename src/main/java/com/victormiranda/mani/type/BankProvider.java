package com.victormiranda.mani.type;

public enum BankProvider {
	PTSB(Object.class), UNKNOWN(Object.class);

	public final Class implementation;

	BankProvider(Class implementation) {
		this.implementation = implementation;
	}
}
