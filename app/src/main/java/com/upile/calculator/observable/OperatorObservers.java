package com.upile.calculator.observable;

public interface OperatorObservers
{
    void add(int value);
    void subtract(int value);
    void divide(int value);
    void multiply(int value);
    int displayData();
}