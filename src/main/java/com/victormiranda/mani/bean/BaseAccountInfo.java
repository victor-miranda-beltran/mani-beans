package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseAccountInfo {

	protected final Integer id;

	protected final String name;

	protected final String alias;

	protected final String accountNumber;

	@JsonCreator
	public BaseAccountInfo(
			@JsonProperty("id") Integer id,
			@JsonProperty("name") String name,
			@JsonProperty("alias") String alias,
			@JsonProperty("accountNumber") String accountNumber) {
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.accountNumber = accountNumber;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAlias() {
		return alias;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
}
