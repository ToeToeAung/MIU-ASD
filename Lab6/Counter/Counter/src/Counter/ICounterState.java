package Counter;

public interface ICounterState {
	void update();
	void setFlag(boolean f);
	void setPoints(int points);
}
