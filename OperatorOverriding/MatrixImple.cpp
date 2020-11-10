#include "Matrix.h"
#include <iostream>
#include <cstdlib>
#include <ctime>
// #include <studio.h>
// #include <stdlib.h>
// #include <time.h>
using namespace std;


Matrix::Matrix(){
    for(int x=0; x <3;x++){
      for(int y = 0; y <3;y++){
        this->array[x][y] =  rand()% 10 + 1;
      }
    }
}

void Matrix::toString(){
  for(int x=0; x <3;x++){
    for(int y = 0; y <3;y++){
      cout<<this->array[x][y]<< "  ";
    }
    cout<<endl;
  }
}

Matrix Matrix::operator*(Matrix m){
  Matrix result;
  for(int x=0; x <3;x++){
    for(int y = 0; y <3;y++){
      result.array[x][y]= this->array[x][y] * m.array[x][y];
    }
  }
  return result;
}

bool Matrix::operator==(Matrix m){
  for(int x=0; x <3;x++){
    for(int y = 0; y <3;y++){
      if(this->array[x][y] != m.array[x][y]){
        return false;
      }
    }
  }
  return true;
}
