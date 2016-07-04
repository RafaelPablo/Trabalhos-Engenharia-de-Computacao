package jogodavelha;

public class Tabuleiro 
{
char[][]tab = new char[3][3]; //Declara a matriz de 3 por 3

public void Tabuleiro() //M�todo para setar espa�o em todas as posi��es
{
    for(int i=0;i<=2;i++)
    {
        for(int j=0;j<=2;j++)
        {
          tab[i][j]= ' '; 
        }
    }
}

public void imprime() //M�todo para imprimir de forma organizada as posi��es
{
     for(int i=0;i<=2;i++)
     {
         for(int j=0;j<=2;j++)
         {
             System.out.print("|" + tab[i][j]);
         }
         System.out.println("|");
     }
}

public boolean marcarX(int i, int j) //M�todo para marcar X no tabuleiro
{
        if((i > 2) || (j > 2) || (i < 0) || (j < 0))
        { //Verifica se a posi��o digitada est� dentro da matriz
           return false;
        }
        else if(tab[i][j] != ' ')
        { //Verifica se a posi��o digitada est� dispon�vel para jogar
           return false;
        }
        else
        { //Seta para posi��o digitada o valor de X
           tab[i][j] = 'X';
           return true;
        }
}

public boolean marcarO(int i, int j) //M�todo para marcar O no tabuleiro
{
        if((i > 2) || (j > 2) || (i < 0) || (j < 0))
        { //Verifica se a posi��o digitada est� dentro da matriz
           return false;
        }
        else if(tab[i][j] != ' ')
        { //Verifica se a posi��o digitada est� dispon�vel para jogar
           return false;
        }
        else
        { //Seta para posi��o digitada o valor de X
           tab[i][j] = 'O';
           return true;
        }
}

public boolean fimDeJogo() //M�todo verifica se o jogo terminou
{
    if (tab[0][0] == tab[0][1] && tab[0][1] == tab[0][2])
    { //Verifica se a primeira linha foi preenchida com mesmo caracter
        if(tab[0][0] == 'X' && tab[0][1] == 'X' && tab[0][2] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[0][0] == 'O' && tab[0][1] == 'O' && tab[0][2] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[1][0] == tab[1][1] && tab[1][1] == tab[1][2])
    { //Verifica se a segunda linha foi preenchida com mesmo caracter
        if(tab[1][0] == 'X' && tab[1][1] == 'X' && tab[1][2] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[1][0] == 'O' && tab[1][1] == 'O' && tab[1][2] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[2][0] == tab[2][1] && tab[2][1] == tab[2][2])
    { //Verifica se a ultima linha foi preenchida com mesmo caracter
        if(tab[2][0] == 'X' && tab[2][1] == 'X' && tab[2][2] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[2][0] == 'O' && tab[2][1] == 'O' && tab[2][2] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][0] == tab[1][0] && tab[1][0] == tab[2][0])
    { //Verifica se a primeira coluna foi preenchida com mesmo caracter
        if(tab[0][0] == 'X' && tab[1][0] == 'X' && tab[2][0] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[0][0] == 'O' && tab[1][0] == 'O' && tab[2][0] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][1] == tab[1][1] && tab[1][1] == tab[2][1])
    { //Verifica se a segunda coluna foi preenchida com mesmo caracter
        if(tab[0][1] == 'X' && tab[1][1] == 'X' && tab[2][1] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[0][1] == 'O' && tab[1][1] == 'O' && tab[2][1] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][2] == tab[1][2] && tab[1][2] == tab[2][2])
    { //Verifica se a terceira coluna foi preenchida com mesmo caracter
        if(tab[0][2] == 'X' && tab[1][2] == 'X' && tab[2][2] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[0][2] == 'O' && tab[1][2] == 'O' && tab[2][2] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2])
    { //Verifica se a diagonal descendente foi preenchida com mesmo caracter
        if(tab[0][0] == 'X' && tab[1][1] == 'X' && tab[2][2] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[0][0] == 'O' && tab[1][1] == 'O' && tab[2][2] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0])
    { //Verifica se a diagonal ascendente foi preenchida com mesmo caracter
        if(tab[0][2] == 'X' && tab[1][1] == 'X' && tab[2][0] == 'X')
            {
             System.out.println("Parab�ns X voc� venceu!");
             return true;
            }
        else if(tab[0][2] == 'O' && tab[1][1] == 'O' && tab[2][0] == 'O')
            {
             System.out.println("Parab�ns O voc� venceu!");
             return true;
            }
        else
             return false;
    } //Verifica se todo o tabuleiro foi preenchido sem um vencedor
    else if (tab[0][0] != ' ' && tab[0][1] != ' ' && tab[0][2] != ' ' &&
             tab[1][0] != ' ' && tab[1][1] != ' ' && tab[1][2] != ' ' &&
             tab[2][0] != ' ' && tab[2][1] != ' ' && tab[2][2] != ' ')
             {
                   System.out.println("Empate, ningu�m venceu.");
                   return true;   
             }
    else //Sen�o o jogo continua
    return false;
}
    
public void Computador() //M�todo em que o computador jogo "aleat�riamente"
{
       boolean mark = false; //Vari�vel para testar se marcou algo
       
       for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
             {
                    if(tab[i][j] == ' ') //Verificar se tem posi��o vazia
                     {
                        marcarO(i,j); //Chama o metodo para marcar
                        mark = true; //Altera o valor da vari�vel
                        break; //Sai do segundo for
                     }
             }
            if(mark == true) //Verifica se j� foi marcada alguma posi��o
                 break; //Se foi marcado sai do primeiro for
        }
}

}
