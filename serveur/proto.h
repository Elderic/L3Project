void signInChecking(int s_dial);
void signUpChecking(int s_dial);
int querySignIn(char *login, char *password);
int querySignUp(char *login, char *password);
void determineId(char *id);
void deleteCarriageReturn(char *tab);
void do_exit(PGconn *conn, PGresult *res );
