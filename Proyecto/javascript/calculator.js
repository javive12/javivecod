

 function sum(a,b){
 return a+b;
 }
 function sustract(a,b){
 return a-b;
 }
 function multiply(a,b){
 return a*b;
 }
 function divide(a,b){
 return a/b;
 }

 function factorial(n){
     if(i<1) return 1;
     r=1;

    for(i=n;i>0;i--){
          r*=i;
    }
    return r;
 }

 function factorialRecursivo(n){
     
    if(n<2) return 1;

   
        return n*factorialRecursivo(n-1);
    }

 

    