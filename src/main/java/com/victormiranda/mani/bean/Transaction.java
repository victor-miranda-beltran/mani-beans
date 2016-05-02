package com.victormiranda.mani.bean;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.victormiranda.mani.type.TransactionFlow;
import com.victormiranda.mani.type.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
	protected final String transactionUID;
	protected final String description;
	protected final LocalDate date;
	protected final TransactionFlow flow;
	protected final BigDecimal amount;
	protected final TransactionStatus status;

	@JsonCreator
	public Transaction(
			@JsonProperty("transactionUID") final String  transactionUID,
			@JsonProperty("description") String description,
			@JsonProperty("date")  LocalDate date,
			@JsonProperty("flow") TransactionFlow flow,
			@JsonProperty("amount") BigDecimal amount,
			@JsonProperty("status") TransactionStatus status) {
		this.transactionUID = transactionUID;
		this.description = description;
		this.date = date;
		this.flow = flow;
		this.amount = amount;
		this.status = status;
	}


	public String getTransactionUID() {
		return transactionUID;
	}

	public String getDescription() {
		return description;
	}

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
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

	@Override
	public String toString() {
		return "Transaction{" +
				", description='" + description + '\'' +
				", date=" + date +
				", flow=" + flow +
				", amount=" + amount +
				", status=" + status +
				'}';
	}
}
