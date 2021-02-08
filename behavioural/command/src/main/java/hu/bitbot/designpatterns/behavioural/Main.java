package hu.bitbot.designpatterns.behavioural;

/**
 * Created by zoltankrizsan on 2017. 02. 02..
 */
public class Main {
	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		Invoker invoker = new Invoker(calculator);
		// User presses calculator buttons
		invoker.compute('+', 100);
		invoker.compute('-', 50);
		invoker.compute('*', 10);
		invoker.compute('/', 2);

		// undo 4 commands
		invoker.undo(4);

		// redo 3 commands
		invoker.redo(3);

		System.out.println(invoker.getActualValue());
	}
}
