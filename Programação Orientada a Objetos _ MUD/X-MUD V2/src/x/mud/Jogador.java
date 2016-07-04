package x.mud;

import java.util.ArrayList;

public class Jogador
{
    private String nomePersonagem;
    private String senhaPersonagem;
    private int sexoPersonagem;
    private int peso_total;
    private String classePersonagem;
    private String guerreiro;
    private String ladrao;
    private String cortesa;
    private String estudioso;
    private int forca;
    private int destreza;
    private int inteligencia;
    private int vitalidade;
    private int aparencia;
    private int pontosVida;
    private int pontosMana;
    private String [] habilidades = new String [10]; //10 espaços para habilidades
    private String [] grimorio = new String [10]; //10 espaços para magias
    private String [] classeArmadura = new String [4]; //4 partes da armadura: Peitoral, Ombreiras, Braceletes e Perneiras
    private int [] dano = new int [2]; //Dano formado por: Tipo de dado e valor do dado
    private int nivelPersonagem;
    private ArrayList<Item> Inv = new ArrayList<Item> ();
    private Sala SalaJ = new Sala ();
   
    public ArrayList<Item> getInvO() 
    {
        return Inv;
    }
    public String getInv(int i)
    {
        return Inv.get(i).getNomeItem();
    }
    public void setInv2(Item In)
    {
        Inv.add(In);
    }
    public Sala getLocalizacao() 
    {
        return SalaJ;
    }
    public void setLocalizacao(Sala S1) 
    {
        SalaJ = S1;
    }
    public String getNomePersonagem()
    {
        return nomePersonagem;
    }
    public void setNomePersonagem(String nome) 
    {
        this.nomePersonagem = nome;
    }
    public String getSenhaPersonagem()
    {
        return senhaPersonagem;
    }
    public void setSenhaPersonagem(String senha)
    {
        this.senhaPersonagem = senha;
    }
    public String getSexoPersonagem() 
    {
        if (sexoPersonagem == 1)
        {
           return "Masculino";
        }
        else
           return "Feminino";
    }
    public void setSexoPersonagem(int sexo) 
    {
        this.sexoPersonagem = sexo;
    }
    public String getClassePersonagem() 
    {
        if ("G".equals(classePersonagem))
        {
           return "Guerreiro";
        }
        if ("L".equals(classePersonagem))
        {
           return "Ladrão";
        }
        if ("C".equals(classePersonagem))
        {
            return "Cortesã";
        }
        else
           return "Estudioso";
    }
    public void setClassePersonagem(String classe) 
    {
        this.classePersonagem = classe;
    }
    public Jogador() //Descrição das classes
    {
        this.guerreiro = "Conhecido por sua força e capacidade de esmagar inimigos,\nseus atributo principal é força por isso pode utilizar armaduras pesadas";
        this.ladrao = "É um personagem esperto e hábil, costuma bater carteiras\ne pular de telhado em telhado, seu diferencial é a destreza, que utiliza\npara matar silenciosamente os inimigos";
        this.cortesa = "Geralmente uma clase escolhida pelas mulheres pois estão\nsempre ligadas ao meio social e a coleta de informações. Cortesãs estão\npreparadas para atrair sua presa e a abater em um beco qualquer";
        this.estudioso = "São estrategistas de batalha e desenvolvedores de armas\nsua inteligência é muito grande o que permite agir como personalidades\ndurante o dia e super heróis à noite";
    }

    public void JogadorClasse(String classe) 
    {
        if("Guerreiro".equals(classePersonagem)) //Setando atributos da classe Guerreiro
        {
           this.forca = 14;
           this.destreza = 12;
           this.inteligencia = 8;
           this.vitalidade = 14;
           this.aparencia = 6;
           this.pontosVida = 140;
           this.pontosMana = 80;
           this.dano[0] = 10;
           this.dano[1] = 1;
           this.nivelPersonagem = 1;
           this.peso_total = 70;
        }
        if("Ladrão".equals(classePersonagem)) //Setando atributos da classe Ladrão
        {
           this.forca = 10;
           this.destreza = 15;
           this.inteligencia = 13;
           this.vitalidade = 8;
           this.aparencia = 8;
           this.pontosVida = 80;
           this.pontosMana = 130;
           this.dano[0] = 6;
           this.dano[1] = 1;
           this.nivelPersonagem = 1;
           this.peso_total = 50;
        }
        if("Cortesã".equals(classePersonagem)) //Setando atributos da classe Cortesã
        {
           this.forca = 12;
           this.destreza = 11;
           this.inteligencia = 15;
           this.vitalidade = 8;
           this.aparencia = 8;
           this.pontosVida = 80;
           this.pontosMana = 150;
           this.dano[0] = 8;
           this.dano[1] = 1;
           this.nivelPersonagem = 1;
           this.peso_total = 60;
        }
        else //Setando atributos da classe Estudioso
        {
           this.forca = 8;
           this.destreza = 13;
           this.inteligencia = 11;
           this.vitalidade = 7;
           this.aparencia = 15;
           this.pontosVida = 70;
           this.pontosMana = 110;
           this.dano[0] = 4;
           this.dano[1] = 1;
           this.nivelPersonagem = 1;
           this.peso_total = 40;
        }
        
    }
    public int getPeso_total() 
    {
        return peso_total;
    }

    public void setPeso_total(int peso_total) 
    {
        this.peso_total = peso_total;
    }

    public String getGuerreiro() 
    {
        return guerreiro;
    }

    public void setGuerreiro(String guerreiro) 
    {
        this.guerreiro = guerreiro;
    }

    public String getLadrao()
    {
        return ladrao;
    }

    public void setLadrao(String ladrao) 
    {
        this.ladrao = ladrao;
    }

    public String getCortesa() 
    {
        return cortesa;
    }

    public void setCortesa(String cortesa) 
    {
        this.cortesa = cortesa;
    }

    public String getEstudioso() 
    {
        return estudioso;
    }

    public void setEstudioso(String estudioso) 
    {
        this.estudioso = estudioso;
    }

    public int getForca() 
    {
        return forca;
    }

    public void setForca(int forca) 
    {
        this.forca = forca;
    }

    public int getDestreza() 
    {
        return destreza;
    }

    public void setDestreza(int destreza) 
    {
        this.destreza = destreza;
    }

    public int getInteligencia() 
    {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) 
    {
        this.inteligencia = inteligencia;
    }

    public int getVitalidade() 
    {
        return vitalidade;
    }

    public void setVitalidade(int vitalidade) 
    {
        this.vitalidade = vitalidade;
    }

    public int getAparencia() 
    {
        return aparencia;
    }

    public void setAparencia(int aparencia) 
    {
        this.aparencia = aparencia;
    }

    public int getPontosVida() 
    {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) 
    {
        this.pontosVida = pontosVida;
    }

    public int getPontosMana() 
    {
        return pontosMana;
    }

    public void setPontosMana(int pontosMana) 
    {
        this.pontosMana = pontosMana;
    }

    public String[] getHabilidades() 
    {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) 
    {
        this.habilidades = habilidades;
    }

    public String[] getGrimorio() 
    {
        return grimorio;
    }

    public void setGrimorio(String[] grimorio) 
    {
        this.grimorio = grimorio;
    }

    public String[] getClasseArmadura() 
    {
        return classeArmadura;
    }

    public void setClasseArmadura(String[] classeArmadura) 
    {
        this.classeArmadura = classeArmadura;
    }

    public int[] getDano() 
    {
        return dano;
    }

    public void setDano(int[] dano) 
    {
        this.dano = dano;
    }

    public int getNivelPersonagem() 
    {
        return nivelPersonagem;
    }

    public void setNivelPersonagem(int nivelPersonagem) 
    {
        this.nivelPersonagem = nivelPersonagem;
    }
    
}
