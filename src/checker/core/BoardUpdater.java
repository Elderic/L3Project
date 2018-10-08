package checker.core;

public class BoardUpdater {
	private BoardUpdater() {

	}
	/**
	 * The instance attribute is actually the self-scoped object/class.
	 */
	private static BoardUpdater instance = new BoardUpdater();
	
	/**
	 * A method that able us to get the singleton from anywhere if called.
	 * @return Returns the object instance, the "variables" HashMap.
	 */
	public static BoardUpdater getInstance() {
		return instance;
	}
	
}