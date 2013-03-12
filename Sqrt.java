/**
 *Newton iteration. <= 20 iterate times will get the answer.
 **/
public class Sqrt {
       
       //accuracy providede version
       public static double sqrt(double x,double acuracy){
             double sqrt = x;
             while(Math .abs(sqrt*sqrt-x)> acuracy){
                  sqrt=(sqrt+x/sqrt)/ 2;
             }
             return sqrt;
       }
      
       //without accuracy version. Still only several times of iteration
       public static double sqrt(double x){
             double sqrt = x;
	     double pre = 0;
	     while(sqrt!=pre){
	          pre=sqrt;
		  sqrt=(sqrt+x/sqrt)/2;
	     }
	     return sqrt;
       }
      
       public static void main(String[] args){
             System.out .println(sqrt( 1231311244.0));
       }

}
