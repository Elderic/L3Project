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
			//socket = new Socket ("192.168.1.30", 5000) ;
			socket = new Socket ("127.0.0.1", 5000) ;
			flux_sortie = new PrintWriter (socket.getOutputStream (), true) ;
			flux_entree = new BufferedReader (new InputStreamReader (socket.getInputStream ())) ;
		} 
		catch (UnknownHostException e) {
			System.err.println ("Hote inconnu") ;
            return false;
		} 
	
        flux_sortie.println(typeQuery);
        // on lit ce qu'a envoye le serveur
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
	
	public static void closeConnection(PrintWriter flux_sortie,BufferedReader flux_entree, Socket socket) throws IOException{
		 	flux_sortie.close () ;
	        flux_entree.close () ;
	        socket.close () ;
	}
}

