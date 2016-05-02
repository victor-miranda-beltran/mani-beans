package com.victormiranda.mani.bean;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.victormiranda.mani.bean.ptsb.PTSBCredentials;
import com.victormiranda.mani.type.BankProvider;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "bankProvider")
@JsonSubTypes({
		@JsonSubTypes.Type(value = PTSBCredentials.class, name = "PTSB")
})
public interface Credentials {
	BankProvider getBankProvider();
}
