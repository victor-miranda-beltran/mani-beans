package com.victormiranda.mani.bean.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.victormiranda.mani.type.TransactionFlow;

import java.util.Optional;

public class Category {
    private final Integer id;
    private final String name;
    private final TransactionFlow flow;
    private final Optional<Category> parent;

    @JsonCreator
    public Category(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("flow") TransactionFlow flow,
            @JsonProperty("parent") Optional<Category> parent) {
        this.id = id;
        this.name = name;
        this.flow = flow;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TransactionFlow getFlow() {
        return flow;
    }

    public Optional<Category> getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flow=" + flow +
                ", parent=" + parent +
                '}';
    }
}
