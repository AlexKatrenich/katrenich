package katrenich.prometheus;

public class Board {
	private int sizeBoard;
	private ActionFigure[][] board;

	public Board(int size){
		sizeBoard = size;
		board = createBoard(sizeBoard);
	}

	// дошка заповнюється чистими клітинками
	private ActionFigure[][] createBoard(int size) {
		ActionFigure[][] board = new ActionFigure[size][size];
		for (int i = 0; i < size ; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = ActionFigure.NOTHING;
			}
		}
		return board;
	}

	public int getSizeBoard(){
		return sizeBoard;
	}

	// метод перераховує повертає істину, якщо на полі більше 2 не заповнених клітинок
	public boolean hasMoreSpace() {
		int count = 0;
		int size = sizeBoard*sizeBoard;
		for (int i = 0; i < sizeBoard ; i++) {
			for (int j = 0; j < sizeBoard; j++) {
				if(board[i][j] != null){
					count++;
				}
			}
		}
		System.out.println(count);
		return (count + 2) <= size;
	}

	// Метод виводить гральну дошку в консоль
	public void print() {
		System.out.println("-------------");
		System.out.print("  ");
		for (int i = 0; i < sizeBoard; i++) {
			System.out.print(" " + (i+1));
		}
		System.out.println();
		for (int i = 0; i < sizeBoard; i++) {
			System.out.print((i+1) + " |");
			for (int j = 0; j < sizeBoard ; j++) {
				switch (board[i][j]){
					case CROSS:
						System.out.print("X");
						break;
					case NOUGHT:
						System.out.print("O");
						break;
					case NOTHING:
						System.out.print(" ");
						break;
				}
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}

}
