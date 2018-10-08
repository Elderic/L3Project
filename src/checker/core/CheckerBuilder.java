package checker.core;
import checker.data.ClassFactory;

public class CheckerBuilder {
	private static CheckerBuilder instance = new CheckerBuilder();

	public CheckerBuilder() {
	}
	
	public static CheckerBuilder getInstance() {
		return instance;
	}
	
}