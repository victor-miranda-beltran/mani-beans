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
	private final Optional<AccountInfo> account;
	private final Optional<Category> category;
	private final String description;
	private final String descriptionProcessed;
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private final LocalDate date;
	private final TransactionFlow flow;
	private final BigDecimal amount;
	private final TransactionStatus status;

	private Transaction(final Builder builder) {
		this.id = builder.id;
		this.account = builder.account;
		this.uid = builder.uid;
		this.description = builder.description;
		this.descriptionProcessed = builder.descriptionProcessed;
		this.category = builder.category;
		this.date = builder.date;
		this.flow = builder.flow;
		this.amount = builder.amount;
		this.status = builder.status;
	}

	public Optional<Integer> getId() {
		return id;
	}

	public String getUid() {
		return uid;
	}

	public Optional<AccountInfo> getAccount() {
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

	public LocalDate getDate() {
		return date;
	}

	public TransactionFlow getFlow() {
		return flow;
	}

	public BigDecimal getAmount() {
		return amount;
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
		Optional<AccountInfo> account = Optional.empty();
		LocalDate date;
		TransactionFlow flow;
		BigDecimal amount;
		TransactionStatus status;

		public Builder(final Transaction source) {
			id = source.getId();
			uid = source.getUid();
			description = source.getDescription();
			descriptionProcessed = source.getDescriptionProcessed();
			category = source.getCategory();
			account = source.getAccount();
			date = source.getDate();
			flow = source.getFlow();
			amount = source.getAmount();
			status = source.getStatus();
		}

		public Transaction build() {
			if (uid == null || description == null) {
				throw new IllegalStateException("missing fields, work in progress");
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

		public Builder withAccount(final Optional<AccountInfo> val) {
			this.account = val;
			return this;
		}

		public Builder withDate(final LocalDate val) {
			this.date = val;
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

		public Builder withStatus(final TransactionStatus val) {
			this.status = val;
			return this;
		}
	}

}
