package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public final class SynchronizationRequest {

	private final Credentials credentials;
	private final Set<AccountInfo> accounts;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@JsonCreator
	public SynchronizationRequest(
			@JsonProperty("credentials") final Credentials credentials,
			@JsonProperty("accounts") final Set<AccountInfo> accounts) {
		this.credentials = credentials;
		this.accounts = accounts;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public Set<AccountInfo> getAccounts() {
		return accounts;
	}
}
