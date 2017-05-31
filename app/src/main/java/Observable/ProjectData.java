package Observable;

public class ProjectData implements ObservableObject
{
	public ObjectObserver objectObserver;

	@Override
	public void registerObserver(ObjectObserver objectObserver) 
	{
		this.objectObserver = objectObserver;
	}

	@Override
	public void triggerAdd(int value) {
		objectObserver.Add(value);
	}

	@Override
	public void triggerSubtract(int value) {
		objectObserver.Subtract(value);
	}

	@Override
	public void triggerDivide(int value) {
		objectObserver.Divide(value);
	}

	@Override
	public void triggerMultiply(int value) {
		objectObserver.Multiply(value);
	}

	@Override
	public int DisplayData() {
		return objectObserver.DisplayData();
	}

}