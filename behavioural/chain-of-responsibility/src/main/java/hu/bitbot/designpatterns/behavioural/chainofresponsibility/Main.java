package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

/**
 * Created by zoltankrizsan on 2017. 01. 13..
 */
public class Main {
	static PayBackChain firstChain;

	public static void main(String[] args) {
		firstChain = new Storage100Ft(new DriverImpl());

		Storage10Ft storage10Ft = new Storage10Ft(new DriverImpl());
		firstChain.setNextChain(storage10Ft);

		Storage1Ft storage1Ft = new Storage1Ft(new DriverImpl());
		storage10Ft.setNextChain(storage1Ft);

		firstChain.dispense(new Money(123));
	}
}
