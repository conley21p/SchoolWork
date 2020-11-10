#ifndef matrix_h
#define matrix_h

using namespace std;

#include <iostream>

class Matrix{
  public:
    int array[3][3];
    //Constructor assigns random values to array
    Matrix();
    //deconstructor
    ~Matrix(){};
    //print array to console
    void toString();
    //overload constructor for *
    Matrix operator*(Matrix m);
    //+ overload
    bool operator==(Matrix m);
};


#endif
