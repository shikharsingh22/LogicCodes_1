import java.util.Random;
import java.io.*;

//The following code creates 250 unique codes of 10 character length starting with letters 'ST'. 

class generateUnique 

{
     char x[] = new char[10] ;
    
     int i,j ; 
        public void createRandomString() //The function generates randon strings of length 10 starting with letters "ST". 
            {
                  x[0] = 'S';
                  x[1] = 'T';
               for(j=1 ; j<251; j++)
               {
         
                  for (i=2; i<=9; i++)
                   {
                     
                      Random r = new Random();
                      char c = (char)(r.nextInt(26) + 'a');
                      x[i]= c;

                
                    }
                 System.out.println(x);

               }
             }
}


public class code1
{

   public static void main(String[] args){
     
      generateUnique gU = new generateUnique();
      gU.createRandomString();
          
      }
}
