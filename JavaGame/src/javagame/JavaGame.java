
package javagame;
 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//JFrame je klasa za upravljanje samim prozorom igre , Runnable je dodatak koji pokreće samu igru i neke metode tipa move
public class JavaGame extends JFrame implements Runnable{
     //varijable
    int x,y,smijerX,smijerY,hrana , xH , yH;
     private Image doublebufferImage;
     private Graphics doublebufferGraphics;
     Font font = new Font("Arial",Font.HANGING_BASELINE, 15 );
     Image head;
     Image food; 
    int rep = 5;
   //OVO POKUSAVAM SAD RJESIT MALO SAM U KURSLUSU SAD IMAM 5 IDEJA a nijedna nejde hehe
   /* int []yLokacija = new int [rep];
     int []xLokacija = new int[rep];
     for(int i = 0 ;i<xLokacija.length;i++){
    xLokacija[i]= x; 
}
      yLokacija[j]= y;
  
    */ 
     
//metoda za pokretanje igrice
   public void run()
        {
             try{
                 while(true)//beskonačna petlja koja ažurira kretanje
                 {
                     move();
                     Thread.sleep(7);//može se promijeniti brzina 5 npr u 1 i bit ce brze i obrnuto
                 }
                 
             }
             catch(Exception e){
                 System.out.println("Error");                 
             }
        }
   //metoda za kretanje zmije
       public void move()
       {
           x += smijerX;
           y += smijerY;
           if(x < 0)
               x = 230;
           if(x > 230)
               x = 0;                
           if(y < 0)
               y = 230;
           if(y > 230)
               y = 0;
       }
       //metoda koja očitava x smijer
        public void xSmijer(int setXSmijer)
        {
            smijerX = setXSmijer;
        }
        //metoda koja očitava y smijer
        public void ySmijer(int setYSmijer)
        {
            smijerY = setYSmijer;
        }

     public class AkcijskiGumbi extends KeyAdapter//klasa za gumbe/strelice za pokretanje zmije
    {
        //metoda koja mijenja x ili y za 1 ili -1 dok je pritisnuta tipka
        public void keyPressed(KeyEvent keyEvent)
        {
            int keyCode = keyEvent.getKeyCode();
            if(keyCode == keyEvent.VK_LEFT)
            {
               xSmijer(-1);
               ySmijer(0);
            }
            if(keyCode == keyEvent.VK_RIGHT)
            {
                xSmijer(+1);
                ySmijer(0);
            }
            if(keyCode == keyEvent.VK_UP)
            {
                ySmijer(-1);
                xSmijer(0);
            }
            if(keyCode == keyEvent.VK_DOWN)
            {
              ySmijer(+1);
              xSmijer(0);
            }
            
        }
        //metoda kad se tipka otpusti ne mijenja se vise x ili y
        public void keyReleased(KeyEvent keyEvent)
        {
            int keyCode = keyEvent.getKeyCode();
            if(keyCode == keyEvent.VK_LEFT)
            {
               xSmijer(-1);
            }
            if(keyCode == keyEvent.VK_RIGHT)
            {
                xSmijer(+1);
            }
            if(keyCode == keyEvent.VK_UP)
            {
                ySmijer(-1);
            }
            if(keyCode == keyEvent.VK_DOWN)
            {
                ySmijer(+1);
            }
        }
    }
  /* int [] randomX = new int[50];
        for(int i = 0 ; i < randomX.length; i++)
        {
                int broj = (int) Math.floor(Math.random() * 230);
                        broj = randomX[i]; 
        }
     public int hranaZaZmijuY(int y)
     {
     int randomY = (int) Math.floor(Math.random() * 230)+20; 
     y= randomY;
     return y;
     }*/
    /* public int brojPojedeneHrane(int x , int y,int){
         this.x = x;
         this.y= y;
         
     }*/
   
    //metoda za     
    public  JavaGame()
        {
            ImageIcon snakeHead = new ImageIcon("C:/Users/Luka/Desktop/java/JavaGame/src/javagame/download.gif");
            head = snakeHead.getImage();
            ImageIcon misevi = new ImageIcon("C:/Users/Luka/Desktop/java/JavaGame/src/javagame/mouse.gif");
            food = misevi.getImage();
            addKeyListener(new AkcijskiGumbi());
            setTitle("Snake");
            setSize(250,250);
            setResizable(false);
            setVisible(true);
            setBackground(Color.GREEN);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            x = 150;
            y = 150;//kad se kreira nova igra ovo su početne koordinate
        }
    //metoda za ažuriranje slike tako da se briše prethodno nactana linija
    public void paint(Graphics graphics)
        {
            doublebufferImage = createImage(getWidth(),getHeight());
            doublebufferGraphics = doublebufferImage.getGraphics();
            paintComponent(doublebufferGraphics);
            graphics.drawImage(doublebufferImage, 0, 0, this);
        }
  
  /*protected boolean paintComponent_food(Graphics graphics)
    {
       return graphics.drawImage(food , hranaZaZmijuX(randomX),hranaZaZmijuY(randomY),this);
    }*/
    //metoda za dodavanje elemenata tipa tekst,slika itd.
    public void paintComponent(Graphics graphics)
        {      
            graphics.setFont(font);
            graphics.setColor(Color.magenta);
            graphics.drawString("SNAKE GAME",80, 125);
            graphics.drawString(String.valueOf(x) +','+ String.valueOf(y),180,230);
            graphics.setColor(Color.RED);
            graphics.drawImage(head , x, y, this);
            
          /*
            do
            {   
               boolean radnja= true;
               if(radnja)
               {
                    setInterval(radnja,2000);  
                    graphics.drawImage(food , hranaZaZmijuX(randomX),hranaZaZmijuY(randomY),this);
               }
                 graphics.drawImage(food , hranaZaZmijuX(randomX),hranaZaZmijuY(randomY),this);                       
            }
            while(!(x<=randomX-5 && x>=randomX) && (y<=randomY-5 && y>=randomY));
            */
            repaint();
            
        }
  
    //glavna metoda za samo pokretanje igrice
    public static void main (String[] args)
        {
            JavaGame novaIgra = new JavaGame();
            Thread pokretac = new Thread(novaIgra);
            pokretac.start();
            
        }
}
