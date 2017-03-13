package org.distributedtest.core.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.distributedtest.core.entities.ValidCurrency;

public class TransactionAmountValidator implements ConstraintValidator<TransactionAmount, String> {
	
	private static final String SEPARATOR = " ";

	private static final int COMPRISED_PARTS = 2;
	
	Pattern AMOUNT_REGEX = Pattern.compile("-?[\\d]+\\.[\\d]{2}");
	
	private static final String INVALID_LENGTH = "Transaction amount had an invalid number of parts, must be " 
	+ COMPRISED_PARTS + "The currency type, then the amount separated by a space. Eg: USD 15000.00, or 0.00";
	
	private static final String INVALID_CURRENCY_TYPE = "Invalid currency type ";
	
	private static final String INVALID_NUMBER_FORMAT = "Invalid amount format, must be a number to exactly two decimal places, with no comma separation. Eg: 15000.00";


	@Override
	public void initialize(TransactionAmount constraintAnnotation) {
		// nothing to do
	}

	@Override
	public boolean isValid(String transactionAmount, ConstraintValidatorContext context) {
		
		if(isNotAString(transactionAmount)){
			return false; // nice to have: better error reporting
		}
		
		String[] splitString = ((String) transactionAmount).split(SEPARATOR);
		
		if(incorrectLength(splitString)){
			return false;
		}
		
		String currencyType = getCurrencyType(splitString);
		if(isInvalidCurrencyType(currencyType)){
			return false;
		}
		
		String amount = getAmount(splitString);
		if(isIllegalAmountType(amount)){
			return false;
		}
		
		return true;
	}

	private boolean isNotAString(Object arg0) {
		return !String.class.equals(arg0.getClass());
	}

	private boolean incorrectLength(String[] splitString) {
		return splitString.length != COMPRISED_PARTS;
	}

	private String getCurrencyType(String[] splitString) {
		return splitString[0];
	}

	private String getAmount(String[] splitString) {
		return splitString[1];
	}

	private Boolean isInvalidCurrencyType(String currencyType) {
		try{
			ValidCurrency.valueOf(currencyType);
			return false;
		} catch (Exception e) {
			return true; 
		}
	}

	private boolean isIllegalAmountType(String amount) {
		return !(AMOUNT_REGEX.matcher(amount).matches());
	}
}
