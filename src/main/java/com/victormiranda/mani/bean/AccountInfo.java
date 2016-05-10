package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(builder = AccountInfo.Builder.class)
public final class AccountInfo {
	private final String name;
	private final String accountNumber;
	private final String alias;
	private final String uid;
	private final BigDecimal availableBalance;
	private final BigDecimal currentBalance;
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private final LocalDate lastSynced;
	@JsonManagedReference
	private final List<Transaction> transactions;

	private AccountInfo(final Builder builder) {
		this.name = builder.name;
		this.accountNumber = builder.accountNumber;
		this.alias = builder.alias;
		this.uid = builder.uid;
		this.availableBalance = builder.availableBalance;
		this.currentBalance = builder.currentBalance;
		this.lastSynced = builder.lastSynced;
		this.transactions = new ArrayList<>();
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

	public LocalDate getLastSynced() {
		return lastSynced;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
	public static class Builder {
		String name;
		String accountNumber;
		String alias;
		String uid;
		BigDecimal availableBalance;
		BigDecimal currentBalance;
		LocalDate lastSynced;

		public Builder withName(final String val) {
			this.name = val;
			return this;
		}

		public Builder withAccountNumber(final String val) {
			this.accountNumber = val;
			return this;
		}

		public Builder withAlias(final String val) {
			this.alias = val;
			return this;
		}

		public Builder withUid(final String val) {
			this.uid = val;
			return this;
		}

		public Builder withAvailableBalance(final BigDecimal val) {
			this.availableBalance = val;
			return this;
		}

		public Builder withCurrentBalance(final BigDecimal val) {
			this.currentBalance = val;
			return this;
		}
		public Builder withLastSynced(final LocalDate val) {
			this.lastSynced = val;
			return this;
		}

		public AccountInfo build() {
			return new AccountInfo(this);
		}
	}


}
