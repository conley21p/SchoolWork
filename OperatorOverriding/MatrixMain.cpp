#include <iostream>
#include "Matrix.h"
using namespace std;



int main(){
  Matrix one;
  Matrix two;
  Matrix sum;


//Test the overrided * operator
  sum = one*two;

  cout<<endl<< "Matrix One: "<< endl;
  one.toString();
  cout<<endl<< "Matrix Two: "<< endl;
  two.toString();
  cout<<endl<<"Multipled together equal:"<< endl;
  sum.toString();


  //Test the overrided == operator
  bool checkFalse = one==two;
  bool cheackTrue = one==one;

  cout<<endl<<endl<<"Testing the == operator:"<<endl;
  cout<<"should be false(0): "<< checkFalse<<endl;
  cout<<"should be true(1): "<< cheackTrue<<endl<<endl;

  return 0;
}
