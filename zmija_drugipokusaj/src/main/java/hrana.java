
public class hrana {
    int pozicijaHraneX;
    int pozicijaHraneY;
    public int[] Hrana(){
        int pozicijaX =(int) Math.floor(Math.random() * 255) ;
        int pozicijaY= (int) Math.floor(Math.random() * 255);
        int []vrijednostiHrane = {pozicijaX,pozicijaY};   
        return vrijednostiHrane;
    }
            
            
            
         
}
