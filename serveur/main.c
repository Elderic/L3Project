//rappel makefile: la commande make generera l'executable main. si vous modifiez un des fichiers, 
//tapez make clean, puis make pour regenerer l'executable
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

int main () {

	int s_ecoute, s_dial, cli_len ;
	struct sockaddr_in serv_addr, cli_addr ;
	serv_addr.sin_family = AF_INET ;
	serv_addr.sin_addr.s_addr = INADDR_ANY ;
	serv_addr.sin_port = htons (5000) ;
	memset (&serv_addr.sin_zero, 0, sizeof(serv_addr.sin_zero));
	s_ecoute = socket (PF_INET, SOCK_STREAM, 0) ;
	bind (s_ecoute, (struct sockaddr *)&serv_addr, sizeof serv_addr) ;
	listen (s_ecoute, 5) ;
	cli_len = sizeof (cli_addr) ;

	while(1){	
		s_dial = accept (s_ecoute, (struct sockaddr *)&cli_addr, &cli_len) ;
		printf ("Le client d'adresse IP %s s'est connecté depuis son port %d\n", \
	      inet_ntoa (cli_addr.sin_addr), ntohs (cli_addr.sin_port)) ;
	
		int p=0; 
		memset (buf, 0, 80);
		p=read (s_dial, buf, 80) ;
		if(p!=0){
			if (strcmp (buf, "signingIn\n")==0 )			//if the client wants to sign in
				signInChecking(s_dial);
			else if (strcmp (buf, "signingUp\n")==0 )			//if the client wants to sign up
				signUpChecking(s_dial);		
			else{
				printf("fail, unknown query %s \n",buf);
			}
		}
		close (s_dial) ;
	}
	close (s_ecoute) ;
	/*char timeArray [30];
		time_t rawtime;
		time (&rawtime);
		struct tm  *timeinfo = localtime (&rawtime);
		strftime(timeArray, sizeof(timeArray)-1, "%Y-%d-%m %H:%M:%S", timeinfo);
    		printf("%s\n",timeArray);*/
}
