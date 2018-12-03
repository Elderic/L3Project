package query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author TOULAIN Timothe
 *
 */
public class SigningInUpQuery {
	/**
	 * 
	 * this method permits to sign in or sign up
	 * @param typeQuery
	 * @param login
	 * @param password
	 * 
	 * @return true or false
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static boolean signingInUpQuery(String typeQuery,String login,String password) throws IOException, InterruptedException {
		Socket socket = null ;
		PrintWriter outputFlux = null ;
		BufferedReader inputFlux = null ;
		String chain ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			outputFlux = new PrintWriter (socket.getOutputStream (), true) ;
			inputFlux = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Unknown host") ;
            return false;
		} 
	
        outputFlux.println(typeQuery);
        chain = inputFlux.readLine () ;
        System.out.println ("Server says: " + chain) ;
        if(chain.equals("ready to sign in")){
            outputFlux.println (login) ;
            System.out.println("login sent");
            chain = inputFlux.readLine () ;
            if(chain.equals("login received")){
            	outputFlux.println (password) ;
                System.out.println("password sent");
                chain = inputFlux.readLine () ;
            }
            else{
            	System.out.println("login not received");
            }
            if(chain.equals("signing in ok")){
                System.out.println("signing in ok");    
                chain = inputFlux.readLine () ;
                System.out.println(chain);   
                GameVariableRepository.getInstance().setPlayerId(chain);
                closeConnection(outputFlux,inputFlux,socket);
                return true;
            }
            else{
                System.out.println("impossible to sign in");
                closeConnection(outputFlux,inputFlux,socket);
                return false;
            }
        }
        
        else if(chain.equals("ready to sign up")){
        	 outputFlux.println (login) ;
             System.out.println("login sent");
             chain = inputFlux.readLine () ;
             if(chain.equals("login received")){
             	outputFlux.println (password) ;
                 System.out.println("password sent");
                 chain = inputFlux.readLine () ;
             }
             else{
             	System.out.println("login not received");
             }
             if(chain.equals("signing up ok")){
                 System.out.println("signing up ok");   
                 chain = inputFlux.readLine () ;
                 System.out.println(chain);   
                 GameVariableRepository.getInstance().setPlayerId(chain);
                 closeConnection(outputFlux,inputFlux,socket);
                 return true;
             }
             else{
                 System.out.println("impossible to sign up");
                 closeConnection(outputFlux,inputFlux,socket);
                 return false;
             }
         }
        else{
        	closeConnection(outputFlux,inputFlux,socket);
            return false;
        }
	}
	
	/**
	 * 
	 * create a character for the player
	 * @param playerId
	 * @param gender
	 * @param name
	 * 
	 * @return true or false
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static boolean characterCreation(String playerId,String gender,String name) throws IOException, InterruptedException{
		Socket socket = null ;
		PrintWriter outputFlux = null ;
		BufferedReader inputFlux = null ;
		String chain ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			outputFlux = new PrintWriter (socket.getOutputStream (), true) ;
			inputFlux = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Unknown host") ;
            return false;
		} 
	
        outputFlux.println("characterCreation");
        chain = inputFlux.readLine () ;
        if(chain.equals("ready to create")){
        	System.out.println("ready to create");
            outputFlux.println(playerId);
            Thread.sleep(1000);
            outputFlux.println(name);
            Thread.sleep(1000);
            outputFlux.println(gender);
            chain = inputFlux.readLine () ;
        }
        else{
        	System.out.println("fail to create");
        	closeConnection(outputFlux,inputFlux,socket);
            return false;
        }
        if(chain.equals("creation completed")){
        	System.out.println("creation completed");
        	closeConnection(outputFlux,inputFlux,socket);
            return true;
        }
        else{
        	closeConnection(outputFlux,inputFlux,socket);
        	return false;
        }
	}
	
	/**
	 * 
	 * close the connection with the server
	 * @param outputFlux
	 * @param inputFlux
	 * @param socket
	 * 
	 * @throws IOException
	 */
	public static void closeConnection(PrintWriter outputFlux,BufferedReader inputFlux, Socket socket) throws IOException{
		outputFlux.close () ;
		inputFlux.close () ;
		socket.close () ;
	}
}