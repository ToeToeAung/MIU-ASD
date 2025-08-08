package Counter;

public class DoubleDigitState implements ICounterState {
	Counter c;
	private int points = 0;
	private boolean incDecFlag = true;

	public DoubleDigitState(Counter c, int points, boolean f) {
		this.c = c;
	}

	@Override
	public void update() {
		if (incDecFlag) {
			this.points += 2;
		} else {
			this.points -= 2;
		}
		System.out.println("DoubleState Received points: " + this.points);

		if (this.points < 10) {
			c.changeState(new SingleDigitState(c, this.points, incDecFlag));
		} else if (this.points >= 100) {
			c.changeState(new TripleDigitState(c, this.points));
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
