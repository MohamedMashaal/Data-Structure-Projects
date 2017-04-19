package eg.edu.alexu.csd.datastructure.calculator.cs60;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class MyCalculator implements ICalculator {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public float divide(int x, int y) {
		// TODO Auto-generated method stub
		return (float) x / y;
	}

	public void fail(String string, Throwable e) {
		// TODO Auto-generated method stub

	}

}
