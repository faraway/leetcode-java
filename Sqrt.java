
/**
 *Newton iteration. <= 20 iterate times will get the answer.
 **/
public class Sqrt {
      
       public static double sqrt(double x){
             double sqrt = x;
             while(Math .abs(sqrt*sqrt-x)> 0.01){
                  sqrt=(sqrt+x/sqrt)/ 2;
             }
             return sqrt;
      }
      
       public static void main(String[] args){
             System.out .println(sqrt( 1231311244.0));
      }

}
