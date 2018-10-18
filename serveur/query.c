#include <netinet/in.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <stdio.h>
#include<stdlib.h>
#include<libpq-fe.h>
#include <unistd.h>
#include <time.h>
#include"proto.h"

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
int querySignIn(char *login, char *password){
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
                       "SELECT account_login,account_password FROM account WHERE account_login=$1 AND account_password=$2",
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
    	printf("row=%d\n",rows);
    	for(int i=0; i<rows; i++) {
        
      	  printf("%s %s \n", PQgetvalue(res, i, 0), 
      	  PQgetvalue(res, i, 1));
    	}
    	do_exit(conn,res); 
    	return 1;
    }
    else{
    		printf("No data retrieved\n");
    		do_exit(conn,res); 
    		return 0;        
    }
}

int querySignUp(char *login, char *password){
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
                  char idPlayer [9];
    			memset (idPlayer, 0, 9);
    			strcpy(idPlayer,PQgetvalue(res4, 0, 0));
    			determineId(idPlayer);
    			printf("max apres:%s\n",idPlayer);
                  const char *valuesPlayer[2] = {(char *)idPlayer,idAccount};
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
                                     
                   PQfinish(conn);
                   return 1;
    }
}
    
