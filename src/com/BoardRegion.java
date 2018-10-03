package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BoardRegion {

	public static void main(String[] args) {
		BoardRegion boardRegion = new BoardRegion();

		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		boardRegion.solve(board);
	}

	public void solve(char[][] board) {
		char[][] solvedBoard = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; i < board[j].length; i++) {
				if (board[i][j] == 'O' && solvedBoard[i][j] != 'O' && solvedBoard[i][j] != 'X') {
					ArrayList<Point> currentList = new ArrayList<Point>();
					Queue<Point> queueList = new LinkedList<Point>();
					queueList.add(new Point(i, j));
					boolean isAttachedToEdge = false;
					while (!queueList.isEmpty()) {
						Point currentPoint = queueList.peek();
						if (currentPoint.x != 0) {

						}
					}
				}
			}
		}
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
