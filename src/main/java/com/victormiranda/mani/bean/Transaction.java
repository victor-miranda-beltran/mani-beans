package com.victormiranda.mani.bean;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.victormiranda.mani.bean.category.Category;
import com.victormiranda.mani.type.TransactionFlow;
import com.victormiranda.mani.type.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@JsonDeserialize(builder = Transaction.Builder.class)
public class Transaction {

	private final Optional<Integer> id;

	private final String uid;

	private final BaseAccountInfo account;

	private final Optional<Category> category;

	private final String description;

	private final String descriptionProcessed;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private final LocalDate dateAuthorization;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private final LocalDate dateSettled;

	private final TransactionFlow flow;

	private final BigDecimal amount;

	private final BigDecimal balance;

	private final TransactionStatus status;

	private Transaction(final Builder builder) {
		this.id = builder.id;
		this.account = new BaseAccountInfo(
				builder.account.getId(),
				builder.account.getName(),
				builder.account.getAccountNumber());
		this.uid = builder.uid;
		this.description = builder.description;
		this.descriptionProcessed = builder.descriptionProcessed;
		this.category = builder.category;
		this.dateAuthorization = builder.dateAuthorization;
		this.dateSettled = builder.dateAuthorization;
		this.flow = builder.flow;
		this.amount = builder.amount;
		this.balance = builder.balance;
		this.status = builder.status;
	}

	public Optional<Integer> getId() {
		return id;
	}

	public String getUid() {
		return uid;
	}

	public BaseAccountInfo getAccount() {
		return account;
	}

	public Optional<Category> getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public String getDescriptionProcessed() {
		return descriptionProcessed;
	}

	public LocalDate getDateAuthorization() {
		return dateAuthorization;
	}

	public LocalDate getDateSettled() {
		return dateSettled;
	}

	public TransactionFlow getFlow() {
		return flow;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
	public static class Builder {
		Optional<Integer> id = Optional.empty();
		String uid;
		String description;
		String descriptionProcessed;
		Optional<Category> category = Optional.empty();
		BaseAccountInfo account;
		LocalDate dateAuthorization;
		LocalDate dateSettled;
		TransactionFlow flow;
		BigDecimal amount;
		BigDecimal balance;
		TransactionStatus status;

		public Builder(final Transaction source) {
			id = source.getId();
			uid = source.getUid();
			description = source.getDescription();
			descriptionProcessed = source.getDescriptionProcessed();
			category = source.getCategory();
			account = source.getAccount();
			dateAuthorization = source.getDateAuthorization();
			dateSettled = source.getDateSettled();
			flow = source.getFlow();
			amount = source.getAmount();
			balance = source.getBalance();
			status = source.getStatus();
		}

		public Builder() {}

		public Transaction build() {
			if ((uid == null && status == TransactionStatus.NORMAL) || description == null || account == null) {
				throw new IllegalStateException("missing fields, work in progress");
			}

			if (dateAuthorization == null) {
				dateAuthorization = dateSettled;
			}

			return new Transaction(this);
		}

		public Builder withId(final Optional<Integer> val) {
			id = val;
			return this;
		}

		public Builder withUid(final String val) {
			uid = val;
			return this;
		}

		public Builder withDescription(final String val) {
			description = val;
			return this;
		}

		public Builder withDescriptionProcessed(final String val) {
			descriptionProcessed = val;
			return this;
		}

		public Builder withCategory(final Optional<Category> val) {
			this.category = val;
			return this;
		}

		public Builder withAccount(final BaseAccountInfo val) {
			this.account = val;
			return this;
		}

		public Builder withDateAuthorization(final LocalDate val) {
			this.dateAuthorization = val;
			return this;
		}

		public Builder withDateSettled(final LocalDate val) {
			this.dateSettled = val;
			return this;
		}

		public Builder withFlow(final TransactionFlow val) {
			this.flow = val;
			return this;
		}

		public Builder withAmount(final BigDecimal val) {
			this.amount = val;
			return this;
		}

		public Builder withBalance(final BigDecimal val) {
			this.balance = val;
			return this;
		}

		public Builder withStatus(final TransactionStatus val) {
			this.status = val;
			return this;
		}
	}

}
