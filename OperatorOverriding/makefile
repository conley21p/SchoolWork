CC=g++
CFlALGS=-c

all: MatrixMain.o MatrixImple.o
	$(CC) $(CFLAGS) MatrixMain.o MatrixImple.o -o out
MatrixMain.o:
	$(CC) $(CFLAGS) -c MatrixMain.cpp
MatrixImple.o:
	$(CC) $(CFLAGS) -c MatrixImple.cpp
clean:
	rm *.o out
