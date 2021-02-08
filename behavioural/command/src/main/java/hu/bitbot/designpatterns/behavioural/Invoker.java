package hu.bitbot.designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoltankrizsan on 2017. 02. 02..
 */
public class Invoker {
	private final Calculator calculator;
	private final List<Command> commands = new ArrayList<>();
	private int current = 0;

	public Invoker(Calculator calculator) {
		this.calculator = calculator;
	}

	public double getActualValue() {
		return calculator.getCurrentValue();
	}

	public void redo(int levels)
	{
		for (int i = 0; i < levels; i++)
		{
			if (current < commands.size() - 1)
			{
				Command command = commands.get(current++);
				command.execute();
			}
		}
	}

	public void undo(int levels)
	{
		for (int i = 0; i < levels; i++)
		{
			if (current > 0)
			{
				Command command = commands.get(--current);
				command.unExecute();
			}
		}
	}

	public void compute(char operator, int operand)
	{
		// Create command operation and execute it
		Command command = new CalculatorCommand(
				operator, operand, calculator);
		command.execute();

		// Add command to undo list
		commands.add(command);
		current++;
	}
}
