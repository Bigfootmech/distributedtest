package org.distributedtest.core.entities;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.distributedtest.core.validators.TransactionAmount;

import com.fasterxml.jackson.annotation.JsonProperty;
import static org.distributedtest.core.constants.EventsConstants.*;

public class AttributesObject implements Serializable {

	private static final long serialVersionUID = -2031179686212167335L;
	
	@NotNull
	@Size(min=1)
	@JsonProperty(value = ACCOUNT_NUMBER)
	private String accountNumber; // I disagree with this, should be a long, not a validated string. But that wouldn't match the spec.

	@NotNull
	@Size(min=1)
	@TransactionAmount
	@JsonProperty(value = TRANSACTION_AMOUNT)
	private String transactionAmount;
	
	@NotNull
	@Size(min=1)
	@JsonProperty(value = NAME)
	private String name;
	
	@NotNull
	@Size(min=1)
	@JsonProperty(value = PRODUCT)
	private String product;

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getTransactionAmount() {
		return transactionAmount;
	}
	
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}

}
