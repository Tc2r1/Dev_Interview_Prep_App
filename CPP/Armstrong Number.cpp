#include <iostream>  
using namespace std;  
//An Armstrong number is a number that is equal to the sum of the cubes of its own digits-->370=27+343+0
void Armstrong(int n)  
{  
   int r,sum=0,temp;    
   temp=n;    
   while(n>0)    
  {    
      r=n%10;//extracting the last digit
      sum=sum+(r*r*r);    
      n=n/10;    
 }    
if(temp==sum)    
cout<<"Yes,the number is an Armstrong Number."<<endl;    
else    
cout<<"No,the number is not an Armstrong Number."<<endl;   
}  

int main(){
      
      int num;
      cout << "Enter a number : ";
      cin >> num;
      Armstrong(num);
      return 0;
}