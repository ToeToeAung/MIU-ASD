package Counter;


public class TripleDigitState implements ICounterState {
	Counter c;
	private int points = 0;
	private boolean incDecFlag = true;

	public TripleDigitState(Counter c, int points) {
		this.c = c;
	}

	@Override
	public void update() {
		if (incDecFlag) {
			this.points += 3;
		} else {
			this.points -= 3;
		}
		System.out.println("Triple Digit State Received points: " + this.points);
		
		if (this.points < 100) {
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
