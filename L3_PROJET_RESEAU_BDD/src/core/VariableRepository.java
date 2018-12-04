package core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 *
 */
public class VariableRepository {
	private Map<String, Object> variables = new HashMap<String, Object>();
	private static VariableRepository instance = new VariableRepository();
	
	
	/**
	 * 
	 */
	private VariableRepository() {

	}
	
	
	/**
	 * 
	 * 
	 * @return instance
	 */
	public static VariableRepository getInstance() {
		return instance;
	}

	/**
	 * 
	 * 
	 * @param name
	 * @param initialValue
	 */
	public void register(String name, Object initialValue) {
		variables.put(name, initialValue);
	}
	
	
	/*
	public void modify(String name, Object initialValue) {
		this.variables.computeIfPresent(name, (k, v) -> initialValue);
	}
	
	public int search(Object variable) {
		return variables.get(variable.getName());
	}
	*/
	
	/**
	 * 
	 * 
	 * @param name
	 * @return 
	 */
	public Object searchByName(String name) {
		return variables.get(name);
	} 
	
	/**
	 * 
	 * 
	 * @param name
	 */
	public void removeByName(String name) {
		variables.remove(name);
	}
	
	public void printHashMap() {
		for (String name: variables.keySet()){

            String key =name.toString();
            String value = variables.get(name).toString();  
            System.out.println(key + " " + value);  
		}	 
	}
}
