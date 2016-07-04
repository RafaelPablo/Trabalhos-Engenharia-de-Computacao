package jogodavelha;

public class Tabuleiro 
{
char[][]tab = new char[3][3]; //Declara a matriz de 3 por 3

public void Tabuleiro() //Método para setar espaço em todas as posições
{
    for(int i=0;i<=2;i++)
    {
        for(int j=0;j<=2;j++)
        {
          tab[i][j]= ' '; 
        }
    }
}

public void imprime() //Método para imprimir de forma organizada as posições
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

public boolean marcarX(int i, int j) //Método para marcar X no tabuleiro
{
        if((i > 2) || (j > 2) || (i < 0) || (j < 0))
        { //Verifica se a posição digitada está dentro da matriz
           return false;
        }
        else if(tab[i][j] != ' ')
        { //Verifica se a posição digitada está disponível para jogar
           return false;
        }
        else
        { //Seta para posição digitada o valor de X
           tab[i][j] = 'X';
           return true;
        }
}

public boolean marcarO(int i, int j) //Método para marcar O no tabuleiro
{
        if((i > 2) || (j > 2) || (i < 0) || (j < 0))
        { //Verifica se a posição digitada está dentro da matriz
           return false;
        }
        else if(tab[i][j] != ' ')
        { //Verifica se a posição digitada está disponível para jogar
           return false;
        }
        else
        { //Seta para posição digitada o valor de X
           tab[i][j] = 'O';
           return true;
        }
}

public boolean fimDeJogo() //Método verifica se o jogo terminou
{
    if (tab[0][0] == tab[0][1] && tab[0][1] == tab[0][2])
    { //Como testa se todas as posições da primeira linha são iguais
        if(tab[0][0] == 'X') //Por sugestão do professor otimizei a verificação para apenas 1 posição neste if
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[0][0] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[1][0] == tab[1][1] && tab[1][1] == tab[1][2])
    { //Verifica se a segunda linha foi preenchida com mesmo caracter
        if(tab[1][0] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[1][0] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[2][0] == tab[2][1] && tab[2][1] == tab[2][2])
    { //Verifica se a ultima linha foi preenchida com mesmo caracter
        if(tab[2][0] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[2][0] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][0] == tab[1][0] && tab[1][0] == tab[2][0])
    { //Verifica se a primeira coluna foi preenchida com mesmo caracter
        if(tab[0][0] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[0][0] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][1] == tab[1][1] && tab[1][1] == tab[2][1])
    { //Verifica se a segunda coluna foi preenchida com mesmo caracter
        if(tab[0][1] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[0][1] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][2] == tab[1][2] && tab[1][2] == tab[2][2])
    { //Verifica se a terceira coluna foi preenchida com mesmo caracter
        if(tab[0][2] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[0][2] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2])
    { //Verifica se a diagonal descendente foi preenchida com mesmo caracter
        if(tab[0][0] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[0][0] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    }
    else if (tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0])
    { //Verifica se a diagonal ascendente foi preenchida com mesmo caracter
        if(tab[0][2] == 'X')
            {
             System.out.println("Parabéns X você venceu!");
             return true;
            }
        else if(tab[0][2] == 'O')
            {
             System.out.println("Parabéns O você venceu!");
             return true;
            }
        else
             return false;
    } //Verifica se todo o tabuleiro foi preenchido sem um vencedor
    else if (tab[0][0] != ' ' && tab[0][1] != ' ' && tab[0][2] != ' ' &&
             tab[1][0] != ' ' && tab[1][1] != ' ' && tab[1][2] != ' ' &&
             tab[2][0] != ' ' && tab[2][1] != ' ' && tab[2][2] != ' ')
             {
                   System.out.println("Empate, ninguém venceu.");
                   return true;   
             }
    else //Senão o jogo continua
    return false;
}
    
public void Computador() //Método em que o computador jogo "aleatóriamente"
{
       boolean mark = false; //Variável para testar se marcou algo
       
       for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
             {
                    if(tab[i][j] == ' ') //Verificar se tem posição vazia
                     {
                        marcarO(i,j); //Chama o metodo para marcar
                        mark = true; //Altera o valor da variável
                        break; //Sai do segundo for
                     }
             }
            if(mark == true) //Verifica se já foi marcada alguma posição
                 break; //Se foi marcado sai do primeiro for
        }
}

}
