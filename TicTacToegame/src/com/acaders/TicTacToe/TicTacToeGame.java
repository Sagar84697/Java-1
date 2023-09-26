package com.acaders.TicTacToe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TicTacToe
{
	static void showBoard(char board[][])
	{
		for(int i=0; i<board.length;i++)
		{
			for(int j=0; j<board[i].length;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void insert(int pos,char board[][], char sym)
	{
		switch(pos)
		{
			case 1: board[1][1]=sym;
			break;
			case 2: board[1][3]=sym;
			break;
			case 3: board[1][5]=sym;
			break;
			
			case 4: board[3][1]=sym;
			break;
			case 5: board[3][3]=sym;
			break;
			case 6: board[3][5]=sym;
			break;
			
			case 7: board[5][1]=sym;
			break;
			case 8: board[5][3]=sym;
			break;
			case 9: board[5][5]=sym;
			break;
			default: System.out.println("Invalid Position");
		}
		
		if(sym=='X')
		{
			TicTacToeGame.allP1Pos.add(pos);
		}
		else if(sym=='O')
		{
			TicTacToeGame.allP2Pos.add(pos);
		}
	}
	
	static void checkWinner(ArrayList allP1Pos,ArrayList allP2Pos)
	{
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List diag1 = Arrays.asList(1,5,9);
		List diag2 = Arrays.asList(3,5,7);
		
		if(allP1Pos.containsAll(topRow) || allP1Pos.containsAll(midRow)||allP1Pos.containsAll(botRow)||
				allP1Pos.containsAll(leftCol)||allP1Pos.containsAll(midCol)||allP1Pos.containsAll(rightCol)||
				allP1Pos.containsAll(diag1)||allP1Pos.containsAll(diag2))
		{
			System.out.println("Player 1 is the winner");
			System.exit(0);
		}
		else if(allP2Pos.containsAll(topRow) || allP2Pos.containsAll(midRow)||allP2Pos.containsAll(botRow)||
				allP2Pos.containsAll(leftCol)||allP2Pos.containsAll(midCol)||allP2Pos.containsAll(rightCol)||
				allP2Pos.containsAll(diag1)||allP2Pos.containsAll(diag2))
		{
			System.out.println("Player 2 is the winner");
			System.exit(0);
		}
		else if((allP1Pos.size()+allP2Pos.size())==9)
		{
			System.out.println("Game draw");
			System.exit(0);
		}
	}
	
}


public class TicTacToeGame {
	static ArrayList allP1Pos = new ArrayList();
	static ArrayList allP2Pos = new ArrayList();

	public static void main(String[] args) {
		int player1Pos,player2Pos;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Player Names");
		System.out.print("Player 1 : ");
		String p1 = sc.nextLine();
		System.out.print("Player 2 : ");
		String p2 = sc.nextLine();
		
		char board[][] = {{'_','_','_','_','_','_','_'},
		{'|',' ','|',' ','|',' ','|'},
		{'|','-','+','-','+','-','|'},
		{'|',' ','|',' ','|',' ','|'},
		{'|','-','+','-','+','-','|'},
		{'|',' ','|',' ','|',' ','|'},
		{'-','-','-','-','-','-','-'}};
		TicTacToe.showBoard(board);
		
		while(true)
		{
			System.out.println(p1+": Enter the Position(1-9) to place 'X' ");
			player1Pos = sc.nextInt();
			while(allP1Pos.contains(player1Pos) || allP2Pos.contains(player1Pos) || player1Pos>9)
			{
				System.out.println("Position already taken: Re-enter ");
				player1Pos = sc.nextInt();
			}
			TicTacToe.insert(player1Pos, board,'X');
			TicTacToe.showBoard(board);
			TicTacToe.checkWinner(allP1Pos, allP2Pos);
			System.out.println("All P1 Pos are : "+allP1Pos);
			
			System.out.println(p2+": Enter the Position(1-9) to place 'O' ");
			player2Pos = sc.nextInt();
			while(allP1Pos.contains(player2Pos) || allP2Pos.contains(player2Pos) || player1Pos>9)
			{
				System.out.println("Position already taken: Re-enter ");
				player2Pos = sc.nextInt();
			}
			TicTacToe.insert(player2Pos, board,'O');
			TicTacToe.showBoard(board);
			TicTacToe.checkWinner(allP1Pos, allP2Pos);
			System.out.println("All P2 Pos are : "+allP2Pos);
		}

	}

}
