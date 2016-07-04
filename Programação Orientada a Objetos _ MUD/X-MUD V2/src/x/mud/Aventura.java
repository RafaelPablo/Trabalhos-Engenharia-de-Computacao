package x.mud;
import java.util.ArrayList;
import java.util.Scanner;
public class Aventura extends Thread
{
    public static String classe = null;
    static Jogador player = new Jogador ();
    static Sala room = new Sala();
    static Item It = new Item();
    static Scanner ler = new Scanner (System.in);
    static ArrayList<Sala> Salas = new ArrayList<Sala> ();
    static ArrayList<Item> Itens = new ArrayList<Item> ();
    
    public static void init()
    {
           // Aventura Creed = new Aventura();
           // Creed.start();
            DButils sala_u = new DButils(); 
            sala_u.carregar("test.wld");
            DButils objs_u = new DButils(); 
            objs_u.carregar("test.obj");
                        
            for(int x = 0; x < sala_u.getObjVnums().length; x++)
            {
               Sala S = new Sala ();
               S.setNumSala(sala_u.getObjVnums()[x]);
               S.setDenoSala(sala_u.getItemNomes()[x]);
               S.setDescricaoSala(sala_u.getItemDesc()[x]);
               for(int y = 0; y < sala_u.getSalaSaidas()[y].length; y++)
               {
                  S.setSaidasSala(sala_u.getSalaSaidas()[x]);
               }
               for(int z = 0; z < sala_u.getSalaObjs()[z].length; z++)
               {
                  S.setObjetosSala(sala_u.getSalaObjs()[x]);
               }
               Salas.add(S);
             }
            
            for (int x = 0; x < objs_u.getObjVnums().length; x++) 
            { 
               Item I = new Item ();
               I.setNumItem(objs_u.getObjVnums()[x]); 
               I.setNomeItem(objs_u.getItemNomes()[x]); 
               I.setDescItem(objs_u.getItemDesc()[x]); 
               I.setPesoItem(objs_u.getObjPeso()[x]);
               Itens.add(I);
            }
      }  
    public static void main(String[] args) 
    {     
            init();
        
            char inicio = ' ';
            int menu = 0;
            String nome = null;
            String senha = null;
            int sexo = 0;
            String command = null;
            int x = 0;
            
            Comando cmd = new Comando (); 
                    
            System.out.println("________Bem vindo ao X-MUD * Animus 1.0_________");
            System.out.println("------Criado pelo acadêmico: Rafael Pablo-------");
            System.out.println(" Disciplina: de Programação Orientada a Objetos ");
            System.out.println("-----------Professor: Karl Phillip--------------");
            System.out.println("  Nothing is true... everything is permitted!   ");
            System.out.println("------------------------------------------------");
            System.out.println();
            //criar thread de carregamento do animus
            System.out.println("Digite o primeiro nome do personagem: ");
            player.setNomePersonagem(nome = ler.next());
            System.out.println("Seu personagem será chamado de: " + nome + " Auditore");
            System.out.println();
            System.out.println("Digite uma senha: ");
            player.setSenhaPersonagem(senha = ler.next());
            System.out.println("Senha definida!");
            System.out.println();
            System.out.println("Qual o sexo do personagem?(Digite apenas números)");
            System.out.println("Digite: 1 - Masculino e para 2 - Feminino");
            sexo = ler.nextInt();
            while ((sexo != 1) && (sexo !=2))
            {
            System.out.println("Por favor entre com um sexo válido!");
            System.out.println("Digite: 1 - Masculino e para 2 - Feminino");
            sexo = ler.nextInt();
            }
            player.setSexoPersonagem(sexo);
            System.out.println("Sexo definido como: " + player.getSexoPersonagem());
            System.out.println();
            menuClasse();
            Sala S1 = Salas.get(0);
            player.setLocalizacao(S1);
            cmd.olhar();
            
    while(menu != 1 && menu !=4)
    {    
        System.out.println();
        System.out.println("___________Escolha uma opção:___________");
        System.out.println("-----------1_Entrar no mundo------------");
        System.out.println("---2_Alterar atributos e habilidades----");
        System.out.println("--------3_Ler a história do jogo--------");
        System.out.println("-------------4_Sair do jogo-------------");
        System.out.println("----------------------------------------");
        menu = ler.nextInt();
        
        switch(menu)
        {
            case 1:
                   while(inicio != 's')
                   {
                       System.out.print(">");
                       command = ler.nextLine();
                       switch(command)
                       {
                           case "INV":
                              cmd.inventario();
                           break;
                               
                           case "LOOK":
                              cmd.olhar();
                           break;
                           case "SEE":
                              cmd.verificar();
                           break;
                            
                           case "NORTH":
                              cmd.movimento(0);
                           break;
                               
                           case "SOUTH":
                               cmd.movimento(1);
                           break;
                               
                           case "EAST":
                               cmd.movimento(2);
                           break;
                               
                           case "WEST":
                               cmd.movimento(3);
                           break;
                              
                           case "GET":
                               cmd.geting();
                           break;
                               
                           case "DROP":
                               cmd.dropring();
                           break;
                           
                           case "HELP":
                               System.out.println("_______Comandos do Animus______");
                               System.out.println("LOOK - Olha ao redor...........");
                               System.out.println("INV - Mostra o inventario......");
                               System.out.println("NORTH - Vai para o Norte.......");
                               System.out.println("SOUTH - Vai para o Sul.........");
                               System.out.println("EAST - Vai para Leste..........");
                               System.out.println("WEST - Vai para Oeste..........");
                               System.out.println("GET - Pega um item.............");
                               System.out.println("SEE - Verifica um objeto no INV");
                               System.out.println("DROP - Solta um item...........");
                               System.out.println("KILL - Ataca uma presa.........");
                               System.out.println("EXIT - Abandona o jogo.........");
                               System.out.println("STATS - Mostra dados do jogador");
                           break;
                           
                           case "KILL":
                               System.out.println("Em desenvolvimento..."); 
                           break;
                               
                           case "STATS":
                               Stats(); 
                           break;
                                                          
                           case "EXIT":
                               inicio = 's';
                               System.out.println("Animus encerrado - Obrigado por jogar o X-MUD.");
                           break;
                       }
                   }
            break;
            case 2:
                System.out.println("Opção alterar atributos e habilidades selecionada");
               Stats();
            break;
            case 3:
               System.out.println("Ler a história do jogo selecionada...");
               System.out.println("A saga de Assassin's Creed que iniciou com Altair e muitos \nanos mais tarde com Ezio, agora faz parte da sua vida. Os \nTemplários e a Igreja desejam dominar o mundo com a Maçã do \nEden e  escravizar a humanidade. A única forma de evitar isso é \nrecuperar a Maçã e matar todos os templários que conseguir \nencontrar pelo caminho.");
            break;
            case 4:
               System.out.println("Opção sair selecionada...");
               System.out.println("Animus Encerrado");
               inicio = 's';
               menu = 4; //Não está finalizando verificar
            break;
        }
    }
    }
    public static void menuClasse()
{
            System.out.println("Qual a classe do personagem?");
            System.out.println("G - para guerreiro");
            System.out.println("L - para ladrão");
            System.out.println("C - para cortesã");
            System.out.println("E - para estudioso");
            System.out.println("Digite MAIS para saber mais sobre as classes.");
            classe = ler.next();
            if ("MAIS".equals(classe))
            {
               System.out.println("Um pouco mais sobre cada classe:"); 
               System.out.println("Guerreiro: " + player.getGuerreiro());
               System.out.println("------------------------------------------------------------------------");
               System.out.println("Ladrão: " + player.getLadrao());
               System.out.println("------------------------------------------------------------------------");
               System.out.println("Cortesã: " + player.getCortesa());
               System.out.println("------------------------------------------------------------------------");
               System.out.println("Estudioso: " + player.getEstudioso());
               System.out.println("------------------------------------------------------------------------");
               System.out.println("Qual a classe do personagem?");
               System.out.println("G - para guerreiro");
               System.out.println("L - para ladrão");
               System.out.println("C - para cortesã");
               System.out.println("E - para estudioso");
               classe = ler.next();
               while ((!"G".equals(classe)) && (!"L".equals(classe)) && (!"C".equals(classe)) && (!"E".equals(classe)))
               {
                  System.out.println("Por favor entre com uma classe válida!");
                  System.out.println("Digite a classe desejada:");
                  System.out.println("G - para guerreiro");
                  System.out.println("L - para ladrão");
                  System.out.println("C - para cortesã");
                  System.out.println("E - para estudioso");
                  classe = ler.next();
               }
               player.setClassePersonagem(classe);
               player.JogadorClasse(classe);
               System.out.println("Assassino da classe: " + player.getClassePersonagem());
               
            }
            else
            {
               while ((!"G".equals(classe)) && (!"L".equals(classe)) && (!"C".equals(classe)) && (!"E".equals(classe)))
               {
               System.out.println("Por favor entre com uma classe válida!");
               System.out.println("Digite a classe desejada:");
               System.out.println("G - para guerreiro");
               System.out.println("L - para ladrão");
               System.out.println("C - para cortesã");
               System.out.println("E - para estudioso");
               classe = ler.next();
               }
               player.setClassePersonagem(classe);
               player.JogadorClasse(classe);
               System.out.println("Assassino da classe: " + player.getClassePersonagem());
            }
}
    
    public static void Stats()
       {
           player.JogadorClasse(player.getClassePersonagem());
           System.out.println("Atributos do personagem: " + player.getNomePersonagem());
           System.out.println("Classe: " + player.getClassePersonagem() + " " + player.getPeso_total());
           System.out.println("Nível: " + player.getNivelPersonagem() + "  Pontos de Vida: " + player.getPontosVida() + "  Pontos de Mana: " + player.getPontosMana());            
           System.out.println("Força:" + player.getForca()+ "\n" + "Destreza:" + player.getDestreza() + "\n" + "Inteligência:" + player.getInteligencia() + "\n" + "Vitalidade:" + player.getVitalidade()+ "\n" + "Aparência:" + player.getAparencia());
           System.out.println("Dano: "+ player.getDano()[1] + " dado de " + player.getDano()[0] + " lados.");
       }
}

