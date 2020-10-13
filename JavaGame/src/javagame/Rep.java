
package javagame;

import java.awt.Graphics;


public class Rep {
   int rep = 1;
   int []xLokacija = new int[rep];
   int []yLokacija = new int [rep];
   int xR ;
   int yR;
   Rep(int rep , int []xLokacija, int []yLokacija , Graphics repic){
       int j = 0;
      
       for(j = 0 ; j < rep ; j++){
           xR= xLokacija[j]; 
           yR = yLokacija[j];      
       }
       repic.drawPolygon (xLokacija , yLokacija , 30);
      
        
       
    
   }
    
}
