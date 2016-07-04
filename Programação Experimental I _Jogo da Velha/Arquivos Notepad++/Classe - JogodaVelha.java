/*Universidade do Oeste de Santa Catarina - Unoesc Joa�aba
 *Curso de Engenharia da Computa��o
 *Disciplina Programa��o Experimental I
 *Trabalho Jogo da Velha
 *Acad�mico Rafael Pablo Massocato
 */

package jogodavelha;

import java.util.Scanner;

public class JogodaVelha 
{
    static Scanner ler = new Scanner(System.in); //Objeto para ler do teclado
    static Tabuleiro Game = new Tabuleiro(); //Objeto para chamar a outra classe
    static boolean restart = false; //Vari�vel para reiniciar o jogo
     
    public static void main(String[] args) 
    {
    int opcao = 0; 
    Game.Tabuleiro(); //Seta para as posi��es do tabuleiro espa�o
     
    System.out.println("****Bem vindo ao jogo da velha*****");
    do{ //Imprime o menu at� que sair seja selecionado ou inicie o jogo
    System.out.println("|----------------------|");
    System.out.println("|Digite a op��o de jogo|");
    System.out.println("|----------------------|");
    System.out.println("| 1 -> 2 Jogadores     |");
    System.out.println("| 2 -> 1 Jogador x CPU |");
    System.out.println("| 3 -> Sair            |");
    System.out.println("|----------------------|");
    opcao = ler.nextInt();
       switch (opcao)
       {
           case 1:
               System.out.println("Selecionado: 2 Jogadores");
               hum_hum(); //Chama o m�todo Humano x Humano
               break;
           case 2:
               System.out.println("Selecionado: 1 Jogador x CPU");
               hum_cpu(); //Chama o m�todo Humano x CPU
               break;
           case 3:
               System.out.println("Selecionado: Sair, a velha te espera!");
               default: //Sai do programa
               break;
       }
    }while(opcao != 3);
    }
    
public static void hum_hum() //M�todo para jogar Humano x Humano
 {
   int i;
   int j;
   boolean jog = true; //Vari�vel para passar o turno de X para O 
   
  while(Game.fimDeJogo() != true || restart == true)
  { //Esse la�o verifica se o fim do jogo chegou ou se a partida reiniciou
  
      if(jog == true) //Se jog for true � a vez do X
      {
          Game.imprime(); //Imprime o tabuleiro
          System.out.println("Jogador X realize sua jogada [linha (espa�o) coluna]");
          i = ler.nextInt(); //Faz a leitura da linha
          j = ler.nextInt(); //Faz a leitura da coluna
          boolean a = Game.marcarX(i,j); //Chama o m�doto marcar X
          while(a != true) //For�a o jogador a uma posi��o v�lida
          {
          System.out.println("A posi��o escolhida � inv�lida X, tente novamente:");
          i = ler.nextInt();
          j = ler.nextInt();
          a = Game.marcarX(i,j);
          }
          boolean b = Game.fimDeJogo(); 
              if(b == true) //Testa se o jogo terminou
                 {
                  Game.imprime(); 
                  System.out.println("Game Over!");
                  restart = true; //Permite reiniciar a partida
                  Game.Tabuleiro(); //Reinicia o tabuleiro
                  break; //Sai do la�o while
                 }
               else
                 {
                  jog = false; //Altera a condi��o para o outro jogador
                 }
      }
      else //Com o jog false � a vez do O
      {   
          Game.imprime(); //Imprime o tabuleiro
          System.out.println("Jogador O realize sua jogada [linha (espa�o) coluna]");
          i = ler.nextInt(); //Faz a leitura da linha
          j = ler.nextInt(); //Faz a leitura da coluna
          boolean a = Game.marcarO(i,j); //Chama o m�todo marcar O
          while(a != true) //For�a o jogador a uma posi��o v�lida
          {
          System.out.println("A posi��o escolhida � inv�lida O, tente novamente:");
          i = ler.nextInt();
          j = ler.nextInt();
          a = Game.marcarO(i,j);
          }
          boolean b = Game.fimDeJogo(); 
              if(b == true) //Testa se o jogo terminou
                 {
                  Game.imprime();
                  System.out.println("Game Over!");
                  restart = true; //Permite reiniciar a partida
                  Game.Tabuleiro(); //Reinicia o tabuleiro
                  break; //Sai do la�o while
                 }
               else
                 {
                  jog = true; //Altera a condi��o para o outro jogador
                 }
      }
  }
 }
public static void hum_cpu() //Metodo para jogar Humano x CPU
 {
   int i;
   int j;
   boolean jog = true; //Vari�vel para passar o turno de X para O
   
  while(Game.fimDeJogo() != true || restart == true)
  { //Esse la�o verifica se o fim do jogo chegou ou se a partida reiniciou
  
      if(jog == true) //A parte do humano aqui ficou igual a do X anterior
      {
          Game.imprime();
          System.out.println("Jogador X realize sua jogada [linha (espa�o) coluna]");
          i = ler.nextInt();
          j = ler.nextInt();
          boolean a = Game.marcarX(i,j);
          while(a != true)
          {
          System.out.println("A posi��o escolhida � inv�lida X, tente novamente:");
          i = ler.nextInt();
          j = ler.nextInt();
          a = Game.marcarX(i,j);
          }
          boolean b = Game.fimDeJogo();
              if(b == true)
                 {
                  Game.imprime();
                  System.out.println("Game Over! Humano representava X e venceu.");
                  restart = true; 
                  Game.Tabuleiro();
                  break;
                 }
               else
                 {
                  jog = false;
                 }
      }
      else
      {
          Game.Computador(); //Chama o m�todo para o computador jogar aleat�rio
          boolean b = Game.fimDeJogo(); 
              if(b == true) //Verifica se o jogo acabou
                 {
                  Game.imprime(); //Imprime o tabuleiro
                  System.out.println("Game Over! CPU repesentava a O e venceu.");
                  restart = true; //Permite reiniciar a partida
                  Game.Tabuleiro(); //Reinicia o tabuleiro
                  break; //Sai do la�o while
                 }
               else
                 {
                  jog = true; //Altera a condi��o para o outro jogador
                 }
      }
  }
}

}
