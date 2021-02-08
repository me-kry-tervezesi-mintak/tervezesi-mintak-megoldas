package hu.bitbot.designpatterns.behavioural;

/**
 * Created by zoltankrizsan on 2017. 02. 02..
 */
public class CalculatorCommand implements Command {
	private final char operator;
	private final int operand;
	private final Calculator calculator;

	public CalculatorCommand(char operator, int operand, Calculator calculator) {
		this.operator = operator;
		this.operand = operand;
		this.calculator = calculator;
	}

	public void execute() {
		calculator.operation(operator, operand);
	}

	public void unExecute() {
		calculator.operation(reverseOperator(operator), operand);
	}

	private char reverseOperator(char operator)
	{
		switch (operator)
		{
			case '+': return '-';
			case '-': return '+';
			case '*': return '/';
			case '/': return '*';
			default: throw new RuntimeException("wrong operator");
		}
	}
}
