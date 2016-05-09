package com.victormiranda.mani.bean.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.victormiranda.mani.type.TransactionFlow;

import java.util.Optional;

public class Rule {
    private final Integer id;
    private final Optional<Integer> userId;
    private final String pattern;
    private final TransactionFlow flow;

    @JsonCreator
    public Rule(
            @JsonProperty("id") Integer id,
            @JsonProperty("userId") Optional<Integer> userId,
            @JsonProperty("pattern") String pattern,
            @JsonProperty("flow") TransactionFlow flow) {
        this.id = id;
        this.userId = userId;
        this.pattern = pattern;
        this.flow = flow;
    }

    public Integer getId() {
        return id;
    }

    public Optional<Integer> getUserId() {
        return userId;
    }

    public String getPattern() {
        return pattern;
    }

    public TransactionFlow getFlow() {
        return flow;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", userId=" + userId +
                ", pattern='" + pattern + '\'' +
                ", flow=" + flow +
                '}';
    }
}
