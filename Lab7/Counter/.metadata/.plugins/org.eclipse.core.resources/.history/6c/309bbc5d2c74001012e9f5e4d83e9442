package Counter;


public class SingleDigitState implements ICounterState {

	Counter c;
	private int points = 0;
	private boolean incDecFlag = true;

	public SingleDigitState(Counter c, int points, boolean f) {
		this.c = c;
	}

	@Override
	public void update() {
		if (incDecFlag) {
			this.points++;
		} else {
			this.points--;
		}
		System.out.println("SingleState updated points: " + this.points);
		
		if (this.points <= 0) {
			this.points = 0;
		} else if (this.points >= 10) {
			c.changeState(new DoubleDigitState(c, this.points, incDecFlag));
		}
		c.setCount(this.points);
	}
	
	@Override
	public void setFlag(boolean f) {
		this.incDecFlag = f;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}
}
