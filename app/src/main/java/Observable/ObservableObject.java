package Observable;

public interface ObservableObject
{
    void registerObserver(ObjectObserver objectObserver);
    void triggerAdd(int value);
    void triggerSubtract(int value);
    void triggerDivide(int value);
    void triggerMultiply(int value);
    int DisplayData();
}