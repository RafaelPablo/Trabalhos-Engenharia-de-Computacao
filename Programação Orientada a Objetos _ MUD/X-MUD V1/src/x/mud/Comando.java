package x.mud;

public class Comando extends Aventura
{
    private int [] Walk =  new int [4];
    private char [] Saidas = {'N','S','E','W'};
    private int [] ItE = new int [10];
    private int [] Rooms = new int [4];
    private String [] Desc = new String [4];

    public void movimento (int mov)
    {
        switch(mov)
        {
        case 0:
        {
           Walk = player.getLocalizacao().getSaidasSala();
           
           if (Walk[0] != 0)
           {
              player.setLocalizacao(Salas.get(Walk[0]-1));
              olhar();
           }
           else
           {
               System.out.println("Local não sincronizado - Impossível ir até ele.");   
           }
        }
        break;
        case 1:
        {
           Walk = player.getLocalizacao().getSaidasSala();
           
           if (Walk[1] != 0)
           {
              player.setLocalizacao(Salas.get(Walk[1]-1));
              olhar();
           }
           else
           {
               System.out.println("Local não sincronizado - Impossível ir até ele.");   
           }
        }
        break;
        case 2:
        {
           Walk = player.getLocalizacao().getSaidasSala();
           
           if (Walk[2] != 0)
           {
              player.setLocalizacao(Salas.get(Walk[2]-1));
              olhar();
           }
           else
           {
               System.out.println("Local não sincronizado - Impossível ir até ele.");   
           }
        }
        case 3:
        {
           Walk = player.getLocalizacao().getSaidasSala();
           
           if (Walk[3] != 0)
           {
              player.setLocalizacao(Salas.get(Walk[3]-1));
              olhar();
           }
           else
           {
               System.out.println("Local não sincronizado - Impossível ir até ele.");   
           }
        }
        break;
        }
    }
    public void olhar()
    {
        System.out.println(player.getLocalizacao().getNumSala());
        System.out.println(player.getLocalizacao().getDenoSala());
        System.out.println(player.getLocalizacao().getDescricaoSala());
        for(int x = 0; x <=3; x++)
        {
            Rooms[x] = player.getLocalizacao().getSaidasSala()[x];
            
            if(Rooms[x] != 0)
            {
                Desc[x] = Salas.get(Rooms[x]-1).getDenoSala();
                System.out.print(Saidas[x] + ":" + Desc[x] + " ");
            }
            
            else
                System.out.print(Saidas[x] + ":  ");
        }
        System.out.println();
        
        System.out.println(player.getLocalizacao().getObjetosSala());
        
    }
    public void inventario ()
    {
        System.out.println(player.getInv());
        System.out.println("Quantidade de moedas");
    }
}
