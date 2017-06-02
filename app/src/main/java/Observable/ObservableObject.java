package observable;

public interface ObservableObject
{
    void RegisterObserver(ObjectObserver objectObserver);
    void TriggerAdd(int value);
    void TriggerSubtract(int value);
    void TriggerDivide(int value);
    void TriggerMultiply(int value);
    int DisplayData();
}