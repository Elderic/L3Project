#include <netinet/in.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <libpq-fe.h>
#include <unistd.h>
#include <time.h>
#include "proto.h"

char buf [80] ;
void determineId(char *id){
	int j=0;
	//48=0 and 57=9 in ascii
	for(int i=strlen(id)-1;i>3;i--){
		if(id[i]==48){
			id[i]++;
			break;
		}
		else if(id[i]==57){
				if(id[i-1]!=57){
					id[i-1]=id[i-1]+1;
					id[i]=48;
					if(j!=0)
						id[i+j]=48;
					break;
				}
				else if(id[i-1]==57)
					j++;	
		}
		else {
			id[i]++;
			break;
		}	
	}
}
//delete the caractere \n so the tab is usable for queries
void deleteCarriageReturn(char *tab){
	int i=strlen(tab)-1;
	int size=strlen(tab)-1; 
	while(i>size-1){ 
		tab[i]='\0'; 
		i--; 
	} 
}

void do_exit(PGconn *conn, PGresult *res ) {
    PQclear(res);
    PQfinish(conn);
}
int querySignIn(char *login, char *password, char *playerId){
    PGconn *conn = PQconnectdb("user=postgres dbname=postgres password=postgres");
    if (PQstatus(conn) == CONNECTION_BAD) {        
        fprintf(stderr, "Connection to database failed: %s\n",
        PQerrorMessage(conn));
    	PQfinish(conn);
    	return 0;
    }

	//we need to delete the "\n" caracter at the end the tabs we want to use for queries
	deleteCarriageReturn(login);
	deleteCarriageReturn(password);

	const char *values[2] = {(char *)login, password};

    PGresult *res = PQexecParams(conn,
                       "SELECT id_account,account_login,account_password FROM account WHERE account_login=$1 AND account_password=$2",
                       2,       /* 2 param */
                       NULL,    /* let the backend deduce param type */
                       values,
                       NULL,
                       NULL,
                       0);    

    if (PQresultStatus(res) != PGRES_TUPLES_OK) {
        printf("No data retrieved\n");        
        do_exit(conn,res);
        return 0;        
    }    
    
    int rows = PQntuples(res);
    if(rows!=0){

      	printf("%s %s %s\n", PQgetvalue(res, 0, 0),PQgetvalue(res, 0, 1),PQgetvalue(res, 0, 2));
		char idAccount [16];
		memset (idAccount, 0, 16);
   		strcpy(idAccount,PQgetvalue(res, 0, 0));
		printf("id accout %s \n",idAccount);
		const char *values[2] = {(char *)idAccount};

    	PGresult *res2 = PQexecParams(conn,
                       "SELECT id_player FROM player WHERE id_account=$1",
                       1,       /* 2 param */
                       NULL,    /* let the backend deduce param type */
                       values,
                       NULL,
                       NULL,
                       0);    

    	if (PQresultStatus(res2) != PGRES_TUPLES_OK) {
        	printf("No data retrieved\n");        
        	do_exit(conn,res);
        	return 0;        
    	}    	
		int rows2 = PQntuples(res2);
    	if(rows2!=0){
	   		strcpy(playerId,PQgetvalue(res2, 0, 0));
			printf("id player %s \n",playerId);
			do_exit(conn,res); 
    		return 1;
		}
		else{
    		printf("No data retrieved\n");
    		do_exit(conn,res); 
    		return 0;        
   		}
    }
    else{
    		printf("No data retrieved\n");
    		do_exit(conn,res); 
    		return 0;        
    }
}

int querySignUp(char *login, char *password,char *playerId){
    PGconn *conn = PQconnectdb("user=postgres dbname=postgres password=postgres");
    if (PQstatus(conn) == CONNECTION_BAD) {        
        fprintf(stderr, "Connection to database failed: %s\n",
        PQerrorMessage(conn));
    	PQfinish(conn);
    	return 0;
    }

	//we need to delete the "\n" caracter at the end the tabs we want to use for queries
	deleteCarriageReturn(login);
	deleteCarriageReturn(password);
		
	//we check if this username is not already taken
	const char *values[1] = {(char *)login};
    	PGresult *res = PQexecParams(conn,
                       "SELECT account_login FROM account WHERE account_login=$1",
                       1,       /* 1 param */
                       NULL,    /* let the backend deduce param type */
                       values,
                       NULL,
                       NULL,
                       0);    
    
    int rows = PQntuples(res);
    if(rows!=0){
    	printf("user already exists\n");
    	do_exit(conn,res); 
    	return 0;
    }
    else{
    	printf("user doesn't exist, adding to the db\n");
    		
    	//get the highest id to increment it for the new account
    	PGresult *res2 = PQexec(conn, "SELECT max(id_account) FROM account");  
    	  		
   		printf("max avant:%s\n",PQgetvalue(res2, 0, 0));
   		char idAccount [9];
   		memset (idAccount, 0, 9);
   		strcpy(idAccount,PQgetvalue(res2, 0, 0));
   		determineId(idAccount);
   		printf("max apres:%s\n",idAccount);
    		 		   		 			
    	const char *valuesAccount[3] = {(char *)idAccount,login, password};
    	PGresult *res3 = PQexecParams(conn,
                 "INSERT INTO account(id_account,account_login,account_password,account_creation) VALUES ($1,$2,$3,CURRENT_TIMESTAMP(0)) ",
                  3,       /* 3 param */
                  NULL,    /* let the backend deduce param type */
                  valuesAccount,
                  NULL,
                  NULL,
                  0);    
     
        printf("done for account\n");
                  
    	//get the highest id to increment it for the new player
        PGresult *res4 = PQexec(conn, "SELECT max(id_player) FROM player");  
        printf("max avant:%s\n",PQgetvalue(res4, 0, 0));
       
    	strcpy(playerId,PQgetvalue(res4, 0, 0));
    	determineId(playerId);
    	printf("max apres:%s\n",playerId);
        const char *valuesPlayer[2] = {(char *)playerId,idAccount};
        //voir quelle est la position de depart sur la map pour last_position_x/y
              PGresult *res5 = PQexecParams(conn,
               "INSERT INTO player(id_player,is_connected,last_connection,id_account) VALUES ($1,'true',CURRENT_TIMESTAMP(0),$2) ",
                2,       /* 2 param */
                NULL,    /* let the backend deduce param type */ 
                valuesPlayer,
                NULL,
                NULL, 
                0);    
        printf("done for player\n"); 
		/*if (PQresultStatus(res) != PGRES_COMMAND_OK) {
    	    printf("UPDATE command failed\n");        
    	    do_exit(conn,res);	
			return 0;
    	}
		else{ */                                 
    	    PQfinish(conn);
    	    return 1;
    	//}
	}
}

int queryFightSolo(char *playerId,char *playerData){
    PGconn *conn = PQconnectdb("user=postgres dbname=postgres password=postgres");
    if (PQstatus(conn) == CONNECTION_BAD) {        
        fprintf(stderr, "Connection to database failed: %s\n",
        PQerrorMessage(conn));
     	PQfinish(conn);
    	return 0;
    }

	
	const char *values[1] = {(char *)playerId};

    PGresult *res = PQexecParams(conn,
                       "SELECT character_name,character_health,character_attack,character_defense FROM players_character WHERE id_player=$1 ",
                       1,       /* 1 param */
                       NULL,    /* let the backend deduce param type */
                       values,
                       NULL,
                       NULL,
                       0);    

    if (PQresultStatus(res) != PGRES_TUPLES_OK) {
        printf("No data retrieved\n");        
        do_exit(conn,res);
        return 0;        
    }    
    
    int rows = PQntuples(res);
    if(rows!=0){
		
      	printf("%s %s %s %s\n", PQgetvalue(res, 0, 0), 
        PQgetvalue(res, 0, 1), PQgetvalue(res, 0, 2),PQgetvalue(res, 0, 3));
		
		strcat (playerData,PQgetvalue(res, 0, 0));
		strcat (playerData,"/");
		strcat (playerData,PQgetvalue(res, 0, 1));
		strcat (playerData,"/");
		strcat (playerData,PQgetvalue(res, 0, 2));
		strcat (playerData,"/");
		strcat (playerData,PQgetvalue(res, 0, 3));

    	do_exit(conn,res); 
    	return 1;
    }
    else{
    	printf("No data retrieved 2\n");
    	do_exit(conn,res); 
    	return 0;        
    }

}
int queryCharacterCreation(char *playerId,char *name, char *gender){

	PGconn *conn = PQconnectdb("user=postgres dbname=postgres password=postgres");
    if (PQstatus(conn) == CONNECTION_BAD) {        
        fprintf(stderr, "Connection to database failed: %s\n",
        PQerrorMessage(conn));
     	PQfinish(conn);
    	return 0;
    }

	//we need to delete the "\n" caracter at the end the tabs we want to use for queries
	//deleteCarriageReturn(playerId);
	deleteCarriageReturn(name);
	deleteCarriageReturn(gender);

	PGresult *res2 = PQexec(conn, "SELECT max(id_character) FROM players_character");  
    	  		
   		printf("max avant:%s\n",PQgetvalue(res2, 0, 0));
   		char idCharacter [9];
   		memset (idCharacter, 0, 9);
   		strcpy(idCharacter,PQgetvalue(res2, 0, 0));
   		determineId(idCharacter);
   		printf("max apres:%s\n",idCharacter);
		const char *values[4] = {(char *)idCharacter,name,gender,playerId};

    PGresult *res = PQexecParams(conn,
                       "INSERT INTO players_character(id_character,character_name,character_experience,character_gender,character_health,character_attack,character_defense,character_nb_fights,character_nb_victories,character_nb_defeats,id_player) VALUES ($1,$2,0,$3,5,5,5,0,0,0,$4) ",
                       4,       /* 4 param */
                       NULL,    /* let the backend deduce param type */
                       values,
                       NULL,
                       NULL,
                       0);    
   		printf("charid:%s\n",idCharacter);
   		printf("name:%s\n",name);
   		printf("gender:%s\n",gender);
   		printf("playerid:%s\n",playerId);
 	/*if (PQresultStatus(res) != PGRES_COMMAND_OK) {
        printf("UPDATE command failed\n");        
        do_exit(conn,res);	
		return 0;
    }
	else{*/
	    do_exit(conn,res); 
		return 1;
	//}


}










