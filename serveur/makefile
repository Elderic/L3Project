all : main
main : checking.o query.o main.o
	gcc -o main main.o checking.o query.o -I/usr/include/postgresql -lpq
checking.o : checking.c proto.h
	gcc -c checking.c -I/usr/include/postgresql -lpq
query.o : query.c proto.h 
	gcc -c query.c -I/usr/include/postgresql -lpq
main.o : main.c proto.h
	gcc -c main.c -I/usr/include/postgresql -lpq
clean :
	rm -rf *.o main
