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

void signInChecking(int s_dial){

        printf("the client wants to sign in %s\n",buf);
		memset (buf, 0, 80);
	    strcpy (buf, "ready to sign in\n") ;
	    write (s_dial, buf, strlen (buf)) ;		
	    memset (buf, 0, 80);
	    //we create a tab to receive the client's login
		char login[30];
		memset (login, 0, 30);
	    read (s_dial, login, 30) ;				//the client sends login 
	    printf ("J'ai recu login %s \n", login) ;
	    //inform the client that we received the login
	    strcpy (buf, "login received\n") ;
	    write (s_dial, buf, strlen (buf)) ;		
	    memset (buf, 0, 80);
	    //we create a tab to receive the client's password
	    char password[30];
		memset (password, 0, 30);
	    read (s_dial, password, 30) ;
	    printf ("J'ai recu password %s \n", password) ;
		char playerId[16];
		memset (playerId, 0, 16);

		int resultQuery=querySignIn(login,password,playerId);
		printf("%d\n",resultQuery);
		if(resultQuery==1){
			strcpy (buf, "signing in ok\n") ;
	      	write (s_dial, buf, strlen (buf)) ;	
	    	write (s_dial, playerId, strlen (buf)) ;	
		}
		else{
			strcpy (buf, "signing in denied\n") ;
	      	write (s_dial, buf, strlen (buf)) ;	
		}	
}

void signUpChecking(int s_dial){

	printf("the client wants to sign up %s\n",buf);
	memset (buf, 0, 80);
	strcpy (buf, "ready to sign up\n") ;
	write (s_dial, buf, strlen (buf)) ;
	memset (buf, 0, 80);
	//we create a tab to receive the client's login
	char login[16];
	memset (login, 0, 16);
	read (s_dial, login, 16) ;				//the client sends login 
	printf ("J'ai recu login %s \n", login) ; 
	//inform the client that we received the login
	strcpy (buf, "login received\n") ;
	write (s_dial, buf, strlen (buf)) ;		
	memset (buf, 0, 80);
	//we create a tab to receive the client's password
	char password[10];
	memset (password, 0, 10);
	read (s_dial, password, 10) ;
	printf ("J'ai recu password %s \n", password) ;
	memset (buf, 0, 80);
	char playerId[16];
	memset (playerId, 0, 16);
	int resultQuery=querySignUp(login,password,playerId);
	printf("%d\n",resultQuery);
	if(resultQuery==1){
		strcpy (buf, "signing up ok\n") ;
	    write (s_dial, buf, strlen (buf)) ;	
	    write (s_dial, playerId, strlen (buf)) ;	
	}
	else{
		strcpy (buf, "signing up denied\n") ;
	    write (s_dial, buf, strlen (buf)) ;	
	}		    
}
void fightSoloChecking(int s_dial){
	printf("the client is gonna fight in solo %s\n",buf);
	memset (buf, 0, 80);
	strcpy (buf, "ready to receive player id\n") ;
	write (s_dial, buf, strlen (buf)) ;
	memset (buf, 0, 80);
	char playerId[16];
	memset (playerId, 0, 16);
	read (s_dial, playerId, 16) ;				//the client sends player id
	printf ("J'ai recu id %s \n", playerId) ; 
	char playerData[30];
	memset (playerData, 0, 30);

	int resultQuery=queryFightSolo(playerId,playerData);
	if(resultQuery==1){
		strcpy (buf, "sending data\n") ;
	    write (s_dial, buf, strlen (buf)) ;	
		printf("data du tabl: %s\n",playerData);
	    write (s_dial, playerData, strlen (playerData)) ;	
	}
	else{
		strcpy (buf, "error, no data retrieved\n") ;
	      write (s_dial, buf, strlen (buf)) ;	
	}	 
}
void characterCreationChecking(int s_dial){
	printf("the client wants to create char %s\n",buf);
	memset (buf, 0, 80);
	strcpy (buf, "ready to create\n") ;
	write (s_dial, buf, strlen (buf)) ;
	memset (buf, 0, 80);
	char playerId[16];
	memset (playerId, 0, 16);
	read (s_dial, playerId, 16) ;				//the client sends player id
	printf ("J'ai recu id %s \n", playerId) ;
	char name[16];
	memset (name, 0, 16);
	read (s_dial, name, 16) ;				//the client sends character name
	printf ("J'ai recu name %s \n", name) ;
	char gender[16];
	memset (gender, 0, 16);
	read (s_dial, gender, 16) ;				//the client sends player id
	printf ("J'ai recu gender %s \n", gender) ;

	int resultQuery=queryCharacterCreation(playerId,name,gender);
	if(resultQuery==1){
		strcpy (buf, "creation completed\n") ;
	    write (s_dial, buf, strlen (buf)) ;	
		printf("creation completed\n");
	}
	else{
		strcpy (buf, "impossible to create character\n") ;
	    write (s_dial, buf, strlen (buf)) ;	
	}	 
}














