#include <iostream>
#include <stdlib.h>
#include "Bank.h"
using namespace std;
using namespace Bankn;

int main(){
//prompt user to enter number of banks
  int numBanks;
  cout<<"Number of Banks: ";cin>>numBanks;
  Bank *bankList = new Bank[numBanks];

  //run for loop to fill info for all banks in bankList
  for(int i = 0; i<numBanks; i++){
    bankList[i].deposit = rand()  % 200000 + 10; //number 10-200,000
    bankList[i].interest = rand() % 10 + 1; //number 1-10
    bankList[i].timeInYears = rand() % 15 + 1; //number 1-15
  }

  for(int i = 0; i<numBanks; i++){
    //print interest of banks from bankList
    cout<<"Bank "<< i+1 << " interest is : "<< bankList[i].simpleInterest()<<endl;
  }

delete[] bankList;
return 0;
}
