import java.util.ArrayList;

public class LettoreCd {
	private int n;
	private ArrayList<Cd> cdStack;

	LettoreCd(int cdN) {
		this.n = cdN;
		        this.cdStack = new ArrayList<>(n);
	}

	/**
	 * Method: getCD
	 * Parameters: cdPosition (position of the CD in the stack)
	 * Return: the Cd object located at the requested postion
	 */
	public Cd getCD (int cdPosition) {
		return cdStack.get(cdPosition);
	}

	/**
	 * Method: setCd
	 * Description: Insert the Cd in the stack at stack pointer postion
	 * Parameters: Cd object to insert
	 * Return: success ? true : false
	 */
	public boolean setCd (Cd cdInsert) {
		if (cdStack.size() >= n) {
			return false;
		} else {
			cdStack.add(cdInsert);
			return true;
		}
	}

	/**
	 * Method: killCd
	 */
	public boolean killCd (int killPosition) {
		killPosition -= 1;
		if(killPosition < 0 || killPosition >= cdStack.size()) {
			return false;
		} else {
			cdStack.remove(killPosition);
			return true;
		}
	}

	public int getN () {
		return cdStack.size();
	}

	@Override
	public String toString() {
		StringBuilder cdString = new StringBuilder(String.format("Elements in the CD manager: %d\n", this.getN()));
		for (Cd currentCd : cdStack) {
			cdString.append(String.format("%d) %s\n", cdStack.indexOf(currentCd) + 1, currentCd.toString()));
		}
		return cdString.toString();
	} 

}