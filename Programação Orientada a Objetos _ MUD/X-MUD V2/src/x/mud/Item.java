package x.mud;
import java.util.ArrayList;

public class Item extends Absinthe
{
    private ArrayList<Item> Itens = new ArrayList<Item> ();

    public ArrayList<Item> getItens() {
        return Itens;
    }

    public void setItens(ArrayList<Item> Itens) {
        this.Itens = Itens;
    }
     
    public int getNumItem() 
    {
        return numItem;
    }

    public void setNumItem(int numItem) 
    {
        this.numItem = numItem;
    }

    public String getNomeItem() 
    {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) 
    {
        this.nomeItem = nomeItem;
    }

    public String getDescItem() 
    {
        return descItem;
    }

    public void setDescItem(String descItem) 
    {
        this.descItem = descItem;
    }

    public double getPesoItem() 
    {
        return pesoItem;
    }

    public void setPesoItem(int pesoItem) 
    {
        this.pesoItem = pesoItem;
    }

    public int getMoedas() 
    {
        return moedas;
    }

    public void setMoedas(int moedas) 
    {
        this.moedas = moedas;
    }
}
