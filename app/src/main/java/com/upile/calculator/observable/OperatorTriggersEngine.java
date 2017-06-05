package com.upile.calculator.observable;

public class OperatorTriggersEngine implements OperatorTriggers
{
	public OperatorObservers objectObserver;

	@Override
	public void registerObserver(OperatorObservers objectObserver)
	{
		this.objectObserver = objectObserver;
	}

	@Override
	public void triggerAdd(int value) {
		objectObserver.add(value);
	}

	@Override
	public void triggerSubtract(int value) {
		objectObserver.subtract(value);
	}

	@Override
	public void triggerDivide(int value) {
		objectObserver.divide(value);
	}

	@Override
	public void triggerMultiply(int value) {
		objectObserver.multiply(value);
	}

	@Override
	public int displayData() {
		return objectObserver.displayData();
	}

}