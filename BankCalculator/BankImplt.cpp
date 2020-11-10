#include "Bank.h"
using namespace std;
using namespace Bankn;

double Bank::simpleInterest(){
  return (deposit*interest*timeInYears)/100;
}
