package Observable;

public class ProjectData implements ObservableObject
{
	public ObjectObserver objectObserver;

	@Override
	public void RegisterObserver(ObjectObserver objectObserver)
	{
		this.objectObserver = objectObserver;
	}

	@Override
	public void TriggerAdd(int value) {
		objectObserver.Add(value);
	}

	@Override
	public void TriggerSubtract(int value) {
		objectObserver.Subtract(value);
	}

	@Override
	public void TriggerDivide(int value) {
		objectObserver.Divide(value);
	}

	@Override
	public void TriggerMultiply(int value) {
		objectObserver.Multiply(value);
	}

	@Override
	public int DisplayData() {
		return objectObserver.DisplayData();
	}

}