package katrenich.prometheus;

import katrenich.prometheus.exceptions.RefereePutException;

import java.util.Scanner;

public class TheGame {

	public static void main(String[] args) {
		/*
		 * Створимо гру гравець - комп'ютер. Для цього зробимо можливість гравцеві з клавіатури вводити
		 * розмір ігрового поля та фігуру, якою він буде грати
		 * */
		Scanner scanner = new Scanner(System.in);
		int gameSchedule = gameSchedule(scanner);

		if(gameSchedule == 0){
			// вводимо в консоль розмір ігрового поля
			Board board = new Board(3);

			// Гравець обирає фігуру, якою буде грати
			ComputerPlayer computerPlayer1 = new ComputerPlayer(ActionFigure.CROSS);
			ComputerPlayer computerPlayer2 = new ComputerPlayer(ActionFigure.NOUGHT);

			Referee referee = new Referee();

			while (board.hasMoreSpace()) {

				// Гравець 1 робить хід
				if(playerMove(computerPlayer1, referee, board)){
					System.out.println("Переміг гравець 1!");
				}

				// Гравець 2 робить хід
				if(playerMove(computerPlayer2, referee, board)){
					System.out.println("Переміг гравець 2!");
				}
			}

		} else if (gameSchedule == 1){
			// вводимо в консоль розмір ігрового поля
			int boardSize = getBoardSize(scanner);
			Board board = new Board(boardSize);

			// Гравець обирає фігуру, якою буде грати
			ActionFigure figure = getFigure(scanner);
			ComputerPlayer computerPlayer1 = new ComputerPlayer(figure);
			ComputerPlayer computerPlayer2 = new ComputerPlayer(figure == ActionFigure.CROSS ? ActionFigure.NOUGHT : ActionFigure.CROSS);

			Referee referee = new Referee();
		} else {

		}


	}

	// метод для вибору режиму гри
	private static int gameSchedule(Scanner scanner) {
		System.out.print("Тестовий \"комп'ютер - комп'ютер\" - 0\n" +
				"\t\t\"гравець - комп'ютер\" - 1\n" +
				"\t\t\"гравець - гравець\" - 2\nЗробіть Ваш вибір: ");

		String s = " ";
		while(true){
			s = scanner.next();
			if(s.equals("0") || s.equals("1") || s.equals("2")){
				break;
			} else {
				System.out.println("Введено не коректне значення, будь-ласка введіть 0, 1 або 2");
			}
		}

		return Integer.parseInt(s);
	}

	// зчитування з консолі фігури для гри
	private static ActionFigure getFigure(Scanner scanner) {
		System.out.print("Для гри хрестиками натисніть - 1, для гри ноликами натисніть - 0." +
				"\nЗробіть Ваш вибір: ");
		String s = " ";
		while(true){
			s = scanner.next();
			if(s.equals("1") || s.equals("0")){
				break;
			} else {
				System.out.println("Введено не коректне значення, будь-ласка введіть 0 або 1");
			}
		}
		return s.equals("1") ? ActionFigure.CROSS : ActionFigure.NOUGHT;
	}

	// зчитування з консолі розміру поля
	private static int getBoardSize(Scanner scanner) {
		int boardSize = 0;
		System.out.print("Введіть розмір ігрового поля - не парне число від 3 до 15: ");
		while(true){
			try {
				String s = scanner.next();
				boardSize = Integer.parseInt(s);
			} catch (NumberFormatException e){

			}

			if(boardSize % 2 == 1 && boardSize > 2){
				if(boardSize <= 15){
					break;
				}
			}
			System.out.println("Не корректний розмір ігрового поля, введіть будь ласка не парне число від 3 до 15");
		}

		return boardSize;
	}

	/*
	 * Метод виконує хід гравця та повертає істину, якщо хід був виграшним
	 */
	private static boolean playerMove(ComputerPlayer computerPlayer, Referee referee, Board board){
		Move move = computerPlayer.turn(board);

		try {
			referee.put(move, board);
		} catch (RefereePutException e){
			System.out.println("Не корректний хід!");
			return false;
		}

		board.print();

		return referee.isWin(move, board);
	}

}
