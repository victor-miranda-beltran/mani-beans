package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseAccountInfo {

	protected final Integer id;

	protected final String name;

	protected final String accountNumber;

	@JsonCreator
	public BaseAccountInfo(
			@JsonProperty("id") Integer id,
			@JsonProperty("name") String name,
			@JsonProperty("accountNumber") String accountNumber) {
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
}
