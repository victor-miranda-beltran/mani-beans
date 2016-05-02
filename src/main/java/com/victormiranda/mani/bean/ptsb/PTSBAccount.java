package com.victormiranda.mani.bean.ptsb;

import java.math.BigDecimal;

public final class PTSBAccount {
	private final String id;
	private final String uid;
	private final BigDecimal availableBalance;
	private final BigDecimal currentBalance;

	public PTSBAccount(String id, String uid, BigDecimal availableBalance, BigDecimal currentBalance) {
		this.id = id;
		this.uid = uid;
		this.availableBalance = availableBalance;
		this.currentBalance = currentBalance;
	}

	public String getId() {
		return id;
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

	@Override
	public String toString() {
		return "PTSBAccount{" +
				"id='" + id + '\'' +
				", uid='" + uid + '\'' +
				", availableBalance=" + availableBalance +
				", currentBalance=" + currentBalance +
				'}';
	}
}
