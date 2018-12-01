package query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SigningInUpQuery {
	
	public static boolean signingInUpQuery(String typeQuery,String login,String password) throws IOException, InterruptedException {
		Socket socket = null ;
		PrintWriter flux_sortie = null ;
		BufferedReader flux_entree = null ;
		String chaine ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			flux_sortie = new PrintWriter (socket.getOutputStream (), true) ;
			flux_entree = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Hote inconnu") ;
            return false;
		} 
	
        flux_sortie.println(typeQuery);
        chaine = flux_entree.readLine () ;
        System.out.println ("Le serveur m'a repondu : " + chaine) ;
        if(chaine.equals("ready to sign in")){
            flux_sortie.println (login) ;
            System.out.println("login envoyer");
            chaine = flux_entree.readLine () ;
            if(chaine.equals("login received")){
            	flux_sortie.println (password) ;
                System.out.println("password envoyer");
                chaine = flux_entree.readLine () ;
            }
            else{
            	System.out.println("login not received");
            }
            if(chaine.equals("signing in ok")){
                System.out.println("signing in ok");    
                chaine = flux_entree.readLine () ;
                System.out.println(chaine);   
                GameVariableRepository.getInstance().setPlayerId(chaine);
                closeConnection(flux_sortie,flux_entree,socket);
                return true;
            }
            else{
                System.out.println("impossible to sign in");
                closeConnection(flux_sortie,flux_entree,socket);
                return false;
            }
        }
        
        else if(chaine.equals("ready to sign up")){
        	 flux_sortie.println (login) ;
             System.out.println("login envoyer");
             chaine = flux_entree.readLine () ;
             if(chaine.equals("login received")){
             	flux_sortie.println (password) ;
                 System.out.println("password envoyer");
                 chaine = flux_entree.readLine () ;
             }
             else{
             	System.out.println("login not received");
             }
             if(chaine.equals("signing up ok")){
                 System.out.println("signing up ok");   
                 chaine = flux_entree.readLine () ;
                 System.out.println(chaine);   
                 GameVariableRepository.getInstance().setPlayerId(chaine);
                 closeConnection(flux_sortie,flux_entree,socket);
                 return true;
             }
             else{
                 System.out.println("impossible to sign up");
                 closeConnection(flux_sortie,flux_entree,socket);
                 return false;
             }
         }
        else{
        	closeConnection(flux_sortie,flux_entree,socket);
            return false;
        }
	}
	public static boolean characterCreation(String playerId,String gender,String name) throws IOException, InterruptedException{
		Socket socket = null ;
		PrintWriter flux_sortie = null ;
		BufferedReader flux_entree = null ;
		String chaine ;
		
		try {
			// deuxieme argument : le numero de port que l'on contacte
			socket = new Socket ("127.0.0.1", 5000) ;
			flux_sortie = new PrintWriter (socket.getOutputStream (), true) ;
			flux_entree = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Hote inconnu") ;
            return false;
		} 
	
        flux_sortie.println("characterCreation");
        chaine = flux_entree.readLine () ;
        if(chaine.equals("ready to create")){
        	System.out.println("ready to create");
            flux_sortie.println(playerId);
            Thread.sleep(1000);
            flux_sortie.println(name);
            Thread.sleep(1000);
            flux_sortie.println(gender);
            chaine = flux_entree.readLine () ;
        }
        else{
        	System.out.println("fail to create");
        	closeConnection(flux_sortie,flux_entree,socket);
            return false;
        }
        if(chaine.equals("creation completed")){
        	System.out.println("creation completed");
        	closeConnection(flux_sortie,flux_entree,socket);
            return true;
        }
        else{
        	closeConnection(flux_sortie,flux_entree,socket);
        	return false;
        }
	}
	
	public static void closeConnection(PrintWriter flux_sortie,BufferedReader flux_entree, Socket socket) throws IOException{
		 	flux_sortie.close () ;
	        flux_entree.close () ;
	        socket.close () ;
	}
}

