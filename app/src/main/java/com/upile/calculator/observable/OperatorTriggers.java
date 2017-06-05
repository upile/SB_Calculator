package com.upile.calculator.observable;

public interface OperatorTriggers
{
    void registerObserver(OperatorObservers objectObserver);
    void triggerAdd(int value);
    void triggerSubtract(int value);
    void triggerDivide(int value);
    void triggerMultiply(int value);
    int displayData();
}