package fa;

public abstract class State {
	/**
	 * The state label.
	 * It should be a unique name.
	 * @author elenasherman
	 */
	protected String name;
	
	/**
	 * getter for the string label
	 * @return returns the state label.
	 */
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}

	/**
	 * States inheriting from this class are not final by default,
	 * this method is intended to be overridden by final states
	 * @return boolean
	 */
	public boolean isFinalState() { return false; }

	/**
	 * States inheriting from this class are not start states by default,
	 * this method is intended to be overridden by start states
	 * @return boolean
	 */
	public boolean isStartState() { return true; }
	
}
