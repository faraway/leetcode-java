package leetcode;

public class PowX {

    public double pow(double x, int n) {
        if(n==0 )
            return 1.0 ;
        if(x==1.0 )
            return x;
        if(x==-1.0 )
            return n%2 ==0 ? 1.0:-1.0;
           
        int sign = n>0 ? 1 :-1 ;
        n=sign> 0 ? n:-n;
       
        double pow = getPow(x,n);
        return sign > 0 ? pow : 1.0/pow;

    }
   
    private double getPow(double x, int n){
        if(n==1 )
            return x;
        int odd = n%2 ;
        int half = n/2 ;
        double temp = getPow(x,half);
        return odd==1 ? temp*temp*x : temp*temp;
    }
}

