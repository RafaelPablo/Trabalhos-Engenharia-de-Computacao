package x.mud;

public class Sala 
{
 private int numSala;
 private String DenoSala;
 private String descricaoSala;
 private int [] saidasSala = new int [4];
 private int [] objetosSala = new int [10];

 public void setNumSala (int localização)
 {
     this.numSala = localização;
 }
 public int getNumSala()
 {
     return numSala;
 }
 public void setDenoSala (String Denominacao)
 {
     this.DenoSala = Denominacao;
 }
 public String getDenoSala()
 {
     return DenoSala;
 }
    public void setDescricaoSala(String Descricao) 
    {
        this.descricaoSala = Descricao;
    }
    public String getDescricaoSala() 
    {
        return descricaoSala;
    }
    public void setObjetosSala(int[] objetosSala)
    {
        this.objetosSala = objetosSala;
    }
    public int[] getObjetosSala() 
    {
        return objetosSala;
    }
    public void setSaidasSala(int[] saidasSala) 
    {
        this.saidasSala = saidasSala;
    }
    public int[] getSaidasSala() 
    {
        return saidasSala;
    }
   
}
