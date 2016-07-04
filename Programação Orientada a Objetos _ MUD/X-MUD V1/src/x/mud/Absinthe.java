package x.mud;

public abstract class Absinthe 
{
    protected String [] inventarioPersonagem = new String [30];
    protected int numItem;
    protected String nomeItem;
    protected String descItem;
    protected int pesoItem;
    protected int moedas = 100;
    abstract public String[] getInventarioPersonagem();
    abstract public void setInventarioPersonagem(String[] inventarioPersonagem); 
    abstract public int getNumItem(); 
    abstract public void setNumItem(int numItem);
    abstract public String getNomeItem(); 
    abstract public void setNomeItem(String nomeItem); 
    abstract public String getDescItem(); 
    abstract public void setDescItem(String descItem); 
    abstract public double getPesoItem(); 
    abstract public void setPesoItem(int pesoItem); 
    abstract public int getMoedas();
    abstract public void setMoedas(int moedas);
}
