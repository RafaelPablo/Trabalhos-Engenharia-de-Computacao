package x.mud;

public class Comando extends Aventura
{
    private int [] Walk =  new int [4];
    private char [] Saidas = {'N','S','E','W'};
    private int [] ObjN = new int [11];
    private String [] ObjD = new String [11];
    private int [] Rooms = new int [4];
    private String [] Desc = new String [4];
    private String Select = "";

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
    public void olhar ()
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
        
        for (int y = 0; y < player.getLocalizacao().getObjetosSala().length; y++)
        {
            ObjN[y] = player.getLocalizacao().getObjetosSala()[y];
            ObjD[y] = Itens.get(ObjN[y]).getNomeItem();
            System.out.println(ObjD[y]);   
        }
        System.out.println("");
    }
    public void inventario ()
    {
             if (player.getInvO().isEmpty())
             {
                 System.out.println("Não existem itens no inventário.");
             }
             else
             {
                 System.out.println("Invetário de: " + player.getNomePersonagem());
                 for (int i = 0; i <= (player.getInvO().size()-1); i++)
                 {
                     System.out.println(i + "- " + player.getInv(i));
                 }
             }

    }
    public void geting ()
    {
        System.out.println("Indique o item que deseja pegar: ");
        System.out.print(">");
        Select = ler.next();
        for (int w = 0; w < Itens.size(); w++)
        {
            if (Select.equals(Itens.get(w).getNomeItem()))
            {
                player.setInv2(Itens.get(ObjN[w]));
                System.out.println("Item " + Itens.get(w).getNomeItem() + " foi pego");
                //Salas.get(player.getLocalizacao().getNumSala()-1).setObjetosSala(?);
            }
        }
    }
    public void dropring ()
    {
        System.out.println("Indique o item que deseja largar: ");
        Select = ler.next();
    }
    public void verificar ()
    {
        System.out.println("Indique o item que deseja examinar: ");
        System.out.print(">");
        Select = ler.next();
        for (int w = 0; w < player.getInvO().size(); w++)
        {
            if (Select.equals(player.getInvO().get(w).getDescItem()))
            {
                System.out.println("Item: " + player.getInv(w));
                System.out.println("Descrição: " + player.getInvO().get(w).getDescItem());
                System.out.println("Peso: " + player.getInvO().get(w).getPesoItem() + " Kg");
            }
        }
    }
}
