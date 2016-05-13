package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SynchronizationResult {

	private final Set<AccountInfo> accounts;
	private final List<Transaction> transactions;
	private final Boolean syncDone;

	@JsonCreator
	public SynchronizationResult(
			@JsonProperty("accounts") final Set<AccountInfo> accounts,
			@JsonProperty("transactions") final List<Transaction> transactions,
			@JsonProperty("syncDone") final boolean syncDone) {
		this.accounts  = accounts;
		this.transactions = transactions;
		this.syncDone = syncDone;
	}

	public Set<AccountInfo> getAccounts() {
		return accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public Boolean getSyncDone() {
		return syncDone;
	}

	@Override
	public String toString() {
		return "SynchronizationResult{" +
				"accounts=" + accounts +
				"transactions=" + transactions +
				", syncDone=" + syncDone +
				'}';
	}
}
