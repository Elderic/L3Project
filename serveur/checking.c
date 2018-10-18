#include <netinet/in.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <stdio.h>
#include<stdlib.h>
#include<libpq-fe.h>
#include <unistd.h>
#include <time.h>
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
		int resultQuery=querySignIn(login,password);
		printf("%d\n",resultQuery);
		if(resultQuery==1){
			strcpy (buf, "signing in ok\n") ;
	      	write (s_dial, buf, strlen (buf)) ;	
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
	int resultQuery=querySignUp(login,password);
	printf("%d\n",resultQuery);
	if(resultQuery==1){
		strcpy (buf, "signing up ok\n") ;
	      write (s_dial, buf, strlen (buf)) ;	
	}
	else{
		strcpy (buf, "signing up denied\n") ;
	      write (s_dial, buf, strlen (buf)) ;	
	}		     
}
