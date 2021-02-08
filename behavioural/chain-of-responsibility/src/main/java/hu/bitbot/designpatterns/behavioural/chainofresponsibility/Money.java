package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

public class Money {
	private final int amount;

	public Money(int amt){
		this.amount=amt;
	}

	public int getAmount() {
		return amount;
	}
}
