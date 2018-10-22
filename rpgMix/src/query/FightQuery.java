package query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import core.GameVariableRepository;

public class FightQuery {
	
	public static boolean FightQuery(String typeQuery) throws IOException, InterruptedException {
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
        if(chaine.equals("ready to receive player id")){
            //flux_sortie.println ("player00001") ;
            flux_sortie.println (GameVariableRepository.getInstance().getPlayerId()) ;
            System.out.println("id envoyer");
            chaine = flux_entree.readLine () ;   
         }
            if(chaine.equals("sending data")){
                System.out.println("we're about to receive the data");  
                chaine = flux_entree.readLine () ;   
                System.out.println("here are the data "+chaine);  
                closeConnection(flux_sortie,flux_entree,socket);
                /**the data are organized like:
                 *name/health/attack/defense
                 *so we split the string using the separator "/"
                 *
                 **/
                String[] split=chaine.split("/");
                String name=split[0];
                String health=split[1];
                String attack=split[2];
                String defense=split[3];

                GameVariableRepository.getInstance().setPlayerName(name);
                GameVariableRepository.getInstance().setPlayerHealth(Integer.parseInt(health));
                GameVariableRepository.getInstance().setPlayerAttack(Integer.parseInt(attack));
                GameVariableRepository.getInstance().setPlayerDefense(Integer.parseInt(defense));
                return true;
            }
            else{
                System.out.println("error, no data retrieved");
                System.out.println(chaine);

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