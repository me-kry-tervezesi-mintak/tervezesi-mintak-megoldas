package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

/**
 * Created by zoltankrizsan on 2017. 02. 17..
 */
public abstract class Storage extends PayBackChain {
	public final int CAPACITY;
	private final Driver driver;

	protected Storage(int capacity, Driver driver) {
		CAPACITY = capacity;
		this.driver = driver;
	}

	public void dispense(Money money) {
		if(money.getAmount() >= CAPACITY){
			int num = money.getAmount() / CAPACITY;
			int remainder = money.getAmount() % CAPACITY;
			driver.giveItBack(num);
			if(remainder != 0) this.nextChain.dispense(new Money(remainder));
		}else{
			this.nextChain.dispense(money);
		}
	}
}
