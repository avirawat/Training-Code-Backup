package com.acheron.training;

import com.acheron.training.exceptions.InsufficientBalanceException;
import com.acheron.training.exceptions.LimitExceededException;
import com.acheron.training.exceptions.NegativeAmountException;
import com.acheron.training.exceptions.PanNotFoundException;
import com.acheron.training.exceptions.ZeroAmountException;

public class Bank {
	
	int balance;
	
	public Bank(int balance) {
		super();
		this.balance = balance;
	}
	public int deposit(int amount) throws ZeroAmountException,NegativeAmountException {
		balance+=amount;
		if(amount<0) {
			throw new NegativeAmountException("Amount is negative");
		}
		if(amount==0) {
			throw new ZeroAmountException("Amount is zero");
		}
		return balance;
	}
	public int withdraw(int amount) throws LimitExceededException,InsufficientBalanceException,PanNotFoundException{
		if(amount>balance) {
			throw new InsufficientBalanceException("Balance is low");
		}
		else if(amount>5000 && amount<50000){
			throw new LimitExceededException("Enter less amount (limit EXceeded)");
		}
		else if(amount>50000) {
			throw new PanNotFoundException("Pan not available for this amount");
		}
		else {
			System.out.println("-----Enjoy Party------");
			balance-=amount;
			return balance;
		}
	}
	public int getBalance() throws ZeroAmountException{
		if(balance==0) {
			throw new ZeroAmountException("You have zero balance");
		}
		return balance;
	}
	public int penality() throws InsufficientBalanceException{
		if(balance<100) {
			balance-=50;
			throw new InsufficientBalanceException("Balance is low");
		}
		return balance;
	}
}
