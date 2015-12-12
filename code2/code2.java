import java.util.Random;

import java.io.*;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStreamWriter;

import java.io.Writer;







//The following code creates 250 unique codes of 10 character length starting with letters 'ST' along with the queries to insert them in database, and puts both in respective files. 





class generateUnique 


{
     



      char codes[] = new char[10] ;
     
      String fquery ;
     
       int j =0 ; 
  
     int i ;
      
      int tentative_code_id; 
  
     String transition ; 



 

        public void createRandomString() //The function generates randon strings of length 10 starting with letters "ST" and sql queries. 
 
           {
                
                  codes[0] = 'S';

                  codes[1] = 'T';
 
                
              do
              
                                {
 
                  
                  for (i=2; i<=9; i++)
        
                                       {
  
                                          Random r = new Random();
                    
                      char c = (char)(r.nextInt(94) + '!');

                                          codes[i]= c; 
                     
                   }

 

                                    transition = new String(codes); 
                
                    tentative_code_id++; 





                              




    //Comparing if the string already exists in the file     
                   
                  try {

            
                                          BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("section1.txt")));
 
                                          String line;

                   
                   // line = br.readLine();


                                          while ((line = br.readLine()) != null) 
                                                {

 
                                                    if(codes.equals(line))
 
                                                    continue; 
                    
                                                 }

                                         br.close();

                                         } catch (IOException e) {

                                           System.out.println("ERROR: unable to read file " + "section1.txt");
               
                            e.printStackTrace();   
                      
                                                                  }








                              




   //If unique, writing the string in file 'section1.txt'
  
                                   try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("section1.txt", true))))
                                    {
                     out.println(codes);
  
                                     }catch (IOException e) {
     
                                      System.out.println("Writing operation Failed");

                                                            }








 


                                //Generating queries to be inserted into database named 'database1'

                                  fquery = "INSERT INTO database1 (code_id, code) VALUES('"+ tentative_code_id+"','"+transition+"')";







                          






     //Writing the query corresponding to the string in file 'section2.sql'
                  
               try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("section2.sql", true)))) {

                                 out.println(fquery);

                                   }catch (IOException e) {
 
                                    System.out.println("Writing operation Failed");

                                                           }







                                
                                System.out.println(codes);
               
                  j++; 

               
                             }while(j<=249);

                      }

   }





public class code2

{
   public static void main(String[] args)
                      {

                     
      generateUnique gU = new generateUnique();

                           gU.createRandomString();
  
                 
      }

}
