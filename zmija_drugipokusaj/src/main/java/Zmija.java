
public class Zmija {
    
    int duljina;
    int pozicijaX;
    int pozicijaY;

   
    
    public int[] Zmija(int duljina,int pozicijaX ,int pozicijaY){
    
        this.duljina = duljina;
        this.pozicijaX = pozicijaX;
        this.pozicijaY = pozicijaY;          
        int []vrijednostiZmije ={this.duljina, this.pozicijaX , this.pozicijaY};
        return vrijednostiZmije ;
    }
    
}
