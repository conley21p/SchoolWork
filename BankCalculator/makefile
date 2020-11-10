CC=g++
CFlALGS=-c

all: BankMain.o BankImplt.0
	$(CC) $(CFLAGS) BankMain.o BankImplt.o -o out
BankMain.o:
	$(CC) $(CFLAGS) -c BankMain.cpp
BankImplt.0:
	$(CC) $(CFLAGS) -c BankImplt.cpp
clean:
	rm *.o out
