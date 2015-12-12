import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.ResultSet;
import java.io.*;
import java.sql.Statement;
import java.io.IOException;
import java.util.*;
import java.sql.*;

//The program manages different status for any code stored in the database


//This class contains functions resembling functions.php 
class mainProgramPHP
{

       String code;
       int useStatusCode; 


      
       //returns 'usedstatus' string for a particular 'used' status 
       public String checkCode(int useStatusCode_temp)
         {

             useStatusCode = useStatusCode_temp; 
             switch(useStatusCode){
                            case 0: return "unused";
                                   
                            case 1: return "used";
                                     
                            case 2: return "refunded";
                                     
                           default: return "invalid";
                                         
              }
       
          }





       //returns 'used' status for a particular code 
       public int getCodeType(String code_temp) throws ClassNotFoundException
         {
              int useStatusCode_temp=0;
              try
                {

              code = code_temp;
              Class.forName("com.mysql.jdbc.Driver");
              String host = "jdbc:mysql://localhost:3306/demo" ;
              String uName = "root";
              String uPassword = "shikharsingh22";
              String SQLquer = "SELECT used FROM codes WHERE code ='"+code_temp+"'" ;
             Connection con1 = DriverManager.getConnection(host, uName, uPassword);
              Statement stmt1 = con1.createStatement();
              ResultSet rs1   = stmt1.executeQuery(SQLquer);
              while(rs1.next()){
            	  useStatusCode_temp = rs1.getInt("used");
            	  }
                rs1.close();
               stmt1.close();
               con1.close();
              

              
                }catch(SQLException err){
                 System.out.println(err.getMessage()); }

               return useStatusCode_temp; 


          } 




     //prints the unused codes
     void print_code()
         {
  
                  System.out.println("Unused :"+code);
          }




}




class code3
{
   public static void main(String[] args) throws ClassNotFoundException

     { 
        
        try
        {
               int count=0;
              mainProgramPHP object1 ;
              object1= new mainProgramPHP(); 
              Class.forName("com.mysql.jdbc.Driver");
              String host = "jdbc:mysql://localhost:3306/demo" ;
              String uName = "root";
              String uPassword = "shikharsingh22";

              Connection con = DriverManager.getConnection(host, uName, uPassword);
              Statement stmt = con.createStatement();
              ResultSet rs   = stmt.executeQuery("SELECT * FROM codes ");

           if (rs.next())
            {
                 while(rs.next())
                  {
             
                   String code1 = rs.getString("code");
                   int useStatusCode = object1.getCodeType(code1);
                   String useStatus1 = object1.checkCode(useStatusCode);
                     if(useStatus1 == "unused")
                       {
                           object1.print_code();
                           count++;
                        } 
                   }                    
                  
                  System.out.println("Number of enteries in the database:"+count);
             }
            else
             {
              System.out.println("No entries in the database");
              }
                
             rs.close();
             stmt.close();
             con.close();

         }catch(SQLException err){
           System.out.println(err.getMessage()); }
       }
}
