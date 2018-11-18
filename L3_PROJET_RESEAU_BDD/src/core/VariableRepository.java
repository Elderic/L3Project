package core;

import java.util.HashMap;
import java.util.Map;

public class VariableRepository {
	private Map<String, Object> variables = new HashMap<String, Object>();

	private VariableRepository() {

	}

	private static VariableRepository instance = new VariableRepository();

	public static VariableRepository getInstance() {
		return instance;
	}

	public void register(String name, Object initialValue) {
		variables.put(name, initialValue);
	}
	
	public void modify(String name, Object initialValue) {
		this.variables.computeIfPresent(name, (k, v) -> initialValue);
	}
	/*
	public int search(Object variable) {
		return variables.get(variable.getName());
	}
	*/
	
	public Object searchByName(String name) {
		return variables.get(name);
	} 
	
	public void removeByName(String name) {
		variables.remove(name);
	}
}
