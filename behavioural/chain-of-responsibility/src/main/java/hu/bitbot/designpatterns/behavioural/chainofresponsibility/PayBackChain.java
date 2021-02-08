package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

public abstract class PayBackChain {
	protected PayBackChain nextChain;
	public void setNextChain(PayBackChain nextChain) {
		this.nextChain = nextChain;
	}

	public abstract void dispense(Money money);
}
