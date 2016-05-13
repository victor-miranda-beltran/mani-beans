package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SynchronizationResult {

	private final Set<AccountInfo> accounts;
	private final Boolean syncDone;

	@JsonCreator
	public SynchronizationResult(
			@JsonProperty("accounts") final Set<AccountInfo> accounts,
			@JsonProperty("syncDone") final boolean syncDone) {
		this.accounts  = accounts;
		this.syncDone = syncDone;
	}

	public Set<AccountInfo> getAccounts() {
		return accounts;
	}


	public Boolean getSyncDone() {
		return syncDone;
	}

	@Override
	public String toString() {
		return "SynchronizationResult{" +
				"accounts=" + accounts +
				", syncDone=" + syncDone +
				'}';
	}
}
