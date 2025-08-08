package Counter;


import java.util.Stack;

public class History {
	private Stack<ICounterCommand> cmdList = new Stack<ICounterCommand>();
	private Stack<ICounterCommand> undoList = new Stack<ICounterCommand>();

	private Counter counter;

	public History(Counter counter) {
		this.counter = counter;
	}

	public void redo() {
		if (!undoList.isEmpty()) {
			ICounterCommand cmnd = getOppositeCommand(undoList.pop());
			cmnd.execute();
			cmdList.add(cmnd);	
		}
	}

	public void undo() {
		if (!cmdList.isEmpty()) {
			ICounterCommand cmnd = getOppositeCommand(cmdList.pop());
			cmnd.execute();
			undoList.add(cmnd);
		}
	}

	public void addCommand(ICounterCommand command) {
		cmdList.push(command);
	}
	
	private ICounterCommand getOppositeCommand(ICounterCommand c) {
		ICounterCommand cmnd = null;
		if (c.getClass().getSimpleName().equals("IncrementCommand")) {
			cmnd = new DecrementCommand(counter);
		} else if (c.getClass().getSimpleName().equals("DecrementCommand")) {
			cmnd = new IncrementCommand(counter);
		}
		return cmnd;
	}
}
