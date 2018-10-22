void signInChecking(int s_dial);
void signUpChecking(int s_dial);
void fightSoloChecking(int s_dial);
void characterCreationChecking(int s_dial);

int queryCharacterCreation(char *playerId,char *name, char *gender);
int querySignIn(char *login, char *password,char *playerId);
int querySignUp(char *login, char *password,char *playerId);
int queryFightSolo(char *playerId,char *playerData);

void determineId(char *id);
void deleteCarriageReturn(char *tab);
void do_exit(PGconn *conn, PGresult *res );
