package hu.bitbot.designpatterns.behavioural;

/**
 * Created by zoltankrizsan on 2017. 02. 02..
 */
public class Calculator {
	private double currentValue = 0;

	public double getCurrentValue() {
		return currentValue;
	}

	public double operation(char operator, int operand) {
		switch (operator)
		{
			case '+': currentValue += operand; break;
			case '-': currentValue -= operand; break;
			case '*': currentValue *= operand; break;
			case '/': currentValue /= operand; break;
		}

		return currentValue;
	}
}
