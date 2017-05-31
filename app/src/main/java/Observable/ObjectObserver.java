package Observable;

public interface ObjectObserver
{
    void Add(int value);
    void Subtract(int value);
    void Divide(int value);
    void Multiply(int value);
    int DisplayData();
}