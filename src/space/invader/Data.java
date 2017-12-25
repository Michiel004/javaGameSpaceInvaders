/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gebruiker
 */
public class Data {
    
    public void WriteFile(String firseLine , String  secondLine , String thirdLine)
    {
      //  source : https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
         PrintWriter writer;
         
                   try {
                       writer = new PrintWriter("myfile.txt", "UTF-8");
                       writer.println(firseLine);
                       writer.println(secondLine);
                       writer.println(thirdLine);
                       writer.close();
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (UnsupportedEncodingException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   }
    }
    
     public void readFile()
    {
      //  source : https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
          try(BufferedReader br = new BufferedReader(new FileReader("myfile.txt"))) {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    
   
    String everything = sb.toString();
    System.out.println("" + everything);
}                  catch (IOException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   }
    }
}
