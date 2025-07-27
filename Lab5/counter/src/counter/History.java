package counter;

import java.util.Stack;

public class History {
	private Stack<ICommand> cmdList = new Stack<ICommand>();
	private Stack<ICommand> undoList = new Stack<ICommand>();

	private Counter counter;

	public History(Counter counter) {
		this.counter = counter;
	}

	public void redo() {
		if (!undoList.isEmpty()) {
			ICommand cmnd = getOppositeCommand(undoList.pop());
			cmnd.execute();
			cmdList.add(cmnd);	
		}
	}

	public void undo() {
		if (!cmdList.isEmpty()) {
			ICommand cmnd = getOppositeCommand(cmdList.pop());
			cmnd.execute();
			undoList.add(cmnd);
		}
	}

	public void addCommand(ICommand command) {
		cmdList.push(command);
	}
	
	private ICommand getOppositeCommand(ICommand c) {
		ICommand cmnd = null;
		if (c.getClass().getSimpleName().equals("IncrementCounterCommand")) {
			cmnd = new DecrementCounterCommand(counter);
		} else if (c.getClass().getSimpleName().equals("DecrementCounterCommand")) {
			cmnd = new IncrementCounterCommand(counter);
		}
		return cmnd;
	}
}
