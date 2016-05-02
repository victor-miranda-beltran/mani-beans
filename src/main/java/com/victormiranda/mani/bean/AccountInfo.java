package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class AccountInfo {
	private final String name;
	private final String accountNumber;
	private final String alias;
	private final String uid;
	private final BigDecimal availableBalance;
	private final BigDecimal currentBalance;
	private final LocalDate lastSynced;
	@JsonManagedReference
	private final List<Transaction> transactions;

	@JsonCreator
	public AccountInfo(
			@JsonProperty("name") String name,
			@JsonProperty("accountNumber") String accountNumber,
			@JsonProperty("uid") String uid,
			@JsonProperty("availableBalance") BigDecimal availableBalance,
			@JsonProperty("currentBalance") BigDecimal currentBalance,
			@JsonProperty("lastSynced") LocalDate lastSynced,
			@JsonProperty("transactions") Set<Transaction> transactionSet) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.alias = name;
		this.uid = uid;
		this.availableBalance = availableBalance;
		this.currentBalance = currentBalance;
		this.lastSynced = lastSynced;
		this.transactions = new ArrayList<>(transactionSet);
	}

	public AccountInfo(String name, String accountNumber, String alias, String uid, BigDecimal availableBalance, BigDecimal currentBalance, LocalDate lastSynced, Set<Transaction> transactions) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.alias = alias;
		this.uid = uid;
		this.availableBalance = availableBalance;
		this.currentBalance = currentBalance;
		this.lastSynced = lastSynced;
		this.transactions = new ArrayList<>(transactions);
	}

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAlias() {
		return alias;
	}

	public String getUid() {
		return uid;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	public LocalDate getLastSynced() {
		return lastSynced;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return "AccountInfo{" +
				"name='" + name + '\'' +
				", accountNumber='" + accountNumber + '\'' +
				", uid='" + uid + '\'' +
				", availableBalance=" + availableBalance +
				", currentBalance=" + currentBalance +
				", lastSynced=" + lastSynced +
				", transactions=" + transactions +
				'}';
	}
}
