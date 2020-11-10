#ifndef Bank_H
#define Bank_H
#include <iostream>
using namespace std;

namespace Bankn {
  class Bank{
  public:
    double deposit;
    double interest;
    double timeInYears;
    double simpleInterest();
  };
} /* Bank */
#endif
