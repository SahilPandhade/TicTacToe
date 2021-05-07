/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
/**
 *
 * @author HP
 */    
import java.util.*;
public class Game {
    /**
     * @param args the command line arguments
     */
    
    //Matrix to represent tic tac toe
    private static final char[][] board = new char[3][3];
    private static String player1;
    private static String player2;
    
    //Function to place - in entire matrix. 
    void  CreateGrid(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]='-';
            }
        }

    }
    
    //Print the tic tac toe matrix with appropriate formatting.
    void PrintGrid(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
    
    //Function to decide the winner and print it.
    void decideWinner(char c){
       
        String str = (c=='x') ? (player1+" wins!") : (player2+" wins!");
        System.out.println(str);

    }
    
    //A boolean function that calls decidewinner to decide the winner and returns false (if winning condition is satisfied,else it returns true)
    boolean  checkwin(){
          
        for(int i=0;i<3;i++){
            //check the horizontal combination
            if(board[i][0]!='-' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
            {
                decideWinner(board[i][0]);
                return false;
            }
            //check vertical combination
            else if(board[0][i]!='-' && board[0][i]==board[1][i] && board[1][i]==board[2][i])
                {
                    decideWinner(board[0][i]);
                    return false;
                 
                }
        }
        
        if(board[1][1]!='-'){
            //check diagonal 1
            if(board[0][0]==board[1][1] && board[1][1]==board[2][2])
            {
                decideWinner(board[0][0]);
                return false;
           
            }
            //check diagonal 2
            else if(board[0][2]==board[1][1] && board[1][1]==board[2][0])
            {
                decideWinner(board[0][2]);
                return false; 
            }
        }
         
        return true;
    }
    
    //boolean function to check if there are unmarked(-) slots in matrix,if not then print match tied and return false.
    boolean isGridEmpty(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]=='-')
                {
                    return true;
                }
            }
        }
        System.out.println("Match tied");
        return false;
    }
    public static void main(String[] args) {
     
        Game obj = new Game();
        obj.CreateGrid();
        obj.PrintGrid();
        int row,col;
       
        boolean check = true,check1=true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player 1:");
        player1 = sc.next();
        System.out.println("Enter player 2:");
        player2 = sc.next();

        //Player1 will have first turn.
        String turn=player1;
        //while there is no winner and grid has unmarked slots keep repeating the actions inside the while loop
        while(check && check1)
        {
            //break out of while loop only when a valid input has been given
            while(true)
            {
                System.out.println("enter Row and Col: "+turn);
                row = sc.nextInt();
                col = sc.nextInt();
      
                if(row<0 || col<0 || row>=3 || col>=3)
                {
                    System.out.println("Error!");
          
                }
                else if(board[row][col] != '-' )
                {
                    System.out.println("Already marked");
                }
                else
                {
                    break;   
                }
    
            }
        
        //Mark the appropriate slot entered by player according to the turn.
        board[row][col] = (turn.equals(player1)) ? 'x' : 'o';
        //Switch the turn to other player.
        turn = (turn.equals(player1)) ? player2 : player1;
            
            //After every move we are printing the matrix
            obj.PrintGrid();
            //Check if there is a winner.
            check = obj.checkwin(); 
            //Check for possible tie.
            check1 = obj.isGridEmpty(); 
    }
   //Close the scanner.
   sc.close();    
   
}
}
