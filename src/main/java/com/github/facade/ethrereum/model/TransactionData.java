package com.github.facade.ethrereum.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.web3j.crypto.Pair;

import java.math.BigInteger;
import java.util.Objects;

public final class TransactionData {

    private static final String EMPTY = "";

    private final String hash;

    private final BigInteger nonce;

    private final String blockHash;

    private final BigInteger blockNumber;

    private final BigInteger gasPrice;

    private final BigInteger gasLimit;

    private final String contact;

    private final String from;

    private final String to;

    private final BigInteger value;

    private final BigInteger fee;

    private final String input;

    @JsonCreator
    public TransactionData(
            @JsonProperty(value = "hash") String hash,
            @JsonProperty(value = "nonce") BigInteger nonce,
            @JsonProperty(value = "blockHash") String blockHash,
            @JsonProperty(value = "blockNumber") BigInteger blockNumber,
            @JsonProperty(value = "gasPrice") BigInteger gasPrice,
            @JsonProperty(value = "gasLimit") BigInteger gasLimit,
            @JsonProperty(value = "from") String from,
            @JsonProperty(value = "to") String to,
            @JsonProperty(value = "value") BigInteger value,
            @JsonProperty(value = "fee") BigInteger fee,
            @JsonProperty(value = "input") String input) {
        this.hash = hash;
        this.nonce = nonce;
        this.blockHash = blockHash;
        this.blockNumber = blockNumber;
        this.gasPrice = gasPrice;
        this.gasLimit = gasLimit;
        this.contact = EMPTY;
        this.from = from;
        this.to = to;
        this.value = value;
        this.fee = fee;
        this.input = input;
    }

    public TransactionData(
            String hash,
            BigInteger nonce,
            String blockHash,
            BigInteger blockNumber,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String contact,
            String from,
            String to,
            BigInteger value,
            BigInteger fee,
            String input) {
        this.hash = hash;
        this.nonce = nonce;
        this.blockHash = blockHash;
        this.blockNumber = blockNumber;
        this.gasPrice = gasPrice;
        this.gasLimit = gasLimit;
        this.contact = contact;
        this.from = from;
        this.to = to;
        this.value = value;
        this.fee = fee;
        this.input = input;
    }

    public String getHash() {
        return hash;
    }

    public BigInteger getNonce() {
        return nonce;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public BigInteger getBlockNumber() {
        return blockNumber;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public String getContact() {
        return contact;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigInteger getValue() {
        return value;
    }

    public BigInteger getFee() {
        return fee;
    }

    public String getInput() {
        return input;
    }

    public TransactionData copy(Pair pair) {
        return new TransactionData(
                this.hash,
                this.nonce,
                this.blockHash,
                this.blockNumber,
                this.gasPrice,
                this.gasLimit,
                this.to,
                this.from,
                (String) pair.getFirst(),
                (BigInteger) pair.getSecond(),
                this.fee,
                this.input
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionData that = (TransactionData) o;
        return Objects.equals(hash, that.hash) &&
                Objects.equals(nonce, that.nonce) &&
                Objects.equals(blockHash, that.blockHash) &&
                Objects.equals(blockNumber, that.blockNumber) &&
                Objects.equals(gasPrice, that.gasPrice) &&
                Objects.equals(gasLimit, that.gasLimit) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(value, that.value) &&
                Objects.equals(fee, that.fee) &&
                Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                hash, nonce, blockHash, blockNumber,
                gasPrice, gasLimit, contact, from,
                to, value, fee, input
        );
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "hash='" + hash + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", contract='" + contact + '\'' +
                '}';
    }
}
