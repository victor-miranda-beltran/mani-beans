package com.victormiranda.mani.bean.ptsb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.victormiranda.mani.bean.Credentials;
import com.victormiranda.mani.type.BankProvider;

public class PTSBCredentials implements Credentials {
	final String user;
	final String password;
	final String pin;

	@JsonCreator
	public PTSBCredentials(
			@JsonProperty("user") final String user,
			@JsonProperty("password") final String password,
			@JsonProperty("pin") final String pin) {
		this.user = user;
		this.password = password;
		this.pin = pin;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getPin() {
		return pin;
	}

	@Override
	public BankProvider getBankProvider() {
		return BankProvider.PTSB;
	}
}
