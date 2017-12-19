package katrenich.prometheus;

import katrenich.prometheus.exceptions.RefereePutException;
import katrenich.prometheus.interfaces.Player;

import java.util.Scanner;

public class TheGame {

	public static void main(String[] args) {
		/*
		 * Створимо гру 3-х видів:
		 * 1) Комп'ютер - комп'ютер
		 * 2) Гравець - комп'ютер
		 * 3) Гравець - гравець
		 * */
		Scanner scanner = new Scanner(System.in);
		int gameSchedule = gameSchedule(scanner);

		if(gameSchedule == 0){
			// вводимо в консоль розмір ігрового поля
			Board board = new Board(3);

			// Гравець обирає фігуру, якою буде грати
			Player player1 = new ComputerPlayer(ActionFigure.CROSS);
			Player player2 = new ComputerPlayer(ActionFigure.NOUGHT);

			Referee referee = new Referee();

			while (board.hasMoreSpace()) {
				System.out.println("-----------");
				// Гравець 1 робить хід
				if(playerMove(player1, referee, board)){
					System.out.println("Переміг гравець 1!");
				}
				System.out.println("-----------");
				// Гравець 2 робить хід
				if(playerMove(player2, referee, board)){
					System.out.println("Переміг гравець 2!");
				}
			}

		} else if (gameSchedule == 1){
			// вводимо в консоль розмір ігрового поля
			int boardSize = getBoardSize(scanner);
			Board board = new Board(boardSize);

			// Гравець обирає фігуру, якою буде грати
			ActionFigure figure = getFigure(scanner);
			Player player1 = new RealPlayer(figure);
			// створюється комп'ютерний гравець, що буде грати фігурою протилежною до обраної реальним гравцем
			Player player2 = new ComputerPlayer(figure == ActionFigure.CROSS ? ActionFigure.NOUGHT : ActionFigure.CROSS);

			Referee referee = new Referee();

			System.out.println("-------------");
			board.print();

			while (board.hasMoreSpace()) {

				// Зчитуємо з консолі координати ходу реального гравця
				setMovePlayer((RealPlayer)player1, scanner, board);
				System.out.println("-------------");

				// хід та перверка ходу першого гравця
				if(playerMove(player1, referee, board)){
					System.out.println("Переміг гравець 1!");
					break;
				}
				System.out.println("-------------");

				// хід та перевірка ходу другого гравця
				if(playerMove(player2, referee, board)){
					System.out.println("Переміг гравець 2!");
					break;
				}
			}

			System.out.println("Вітаю, Ви зіграли в нічию!");

		} else {
			// вводимо в консоль розмір ігрового поля
			int boardSize = getBoardSize(scanner);
			Board board = new Board(boardSize);


			ActionFigure figure = getFigure(scanner);

			Player player1 = new RealPlayer(figure);
			// створюється комп'ютерний гравець, що буде грати фігурою протилежною до обраної реальним гравцем
			Player player2 = new RealPlayer(figure == ActionFigure.CROSS ? ActionFigure.NOUGHT : ActionFigure.CROSS);

			Referee referee = new Referee();

			System.out.println("-------------");
			board.print();

			while (board.hasMoreSpace()) {

				System.out.println("Хід гравця 1");
				// Зчитуємо з консолі координати ходу реального гравця1
				setMovePlayer((RealPlayer)player1, scanner, board);
				System.out.println("-------------");

				// хід та перверка ходу першого гравця
				if(playerMove(player1, referee, board)){
					System.out.println("Переміг гравець 1!");
					break;
				}

				System.out.println("Хід гравця 2");
				System.out.println("-------------");
				// Зчитуємо з консолі координати ходу реального гравця2
				setMovePlayer((RealPlayer)player2, scanner, board);

				// хід та перевірка ходу другого гравця
				if(playerMove(player2, referee, board)){
					System.out.println("Переміг гравець 2!");
					break;
				}
			}

			System.out.println("Вітаю, Ви зіграли в нічию!");
		}


	}

	private static void setMovePlayer(RealPlayer player, Scanner scanner, Board board) {
		System.out.println("Введіть координати для ходу гравця: 'X' - рядок, 'Y' - стовпчик ");

		while (true){
			try	{
				int x = Integer.parseInt(scanner.next());
				int y = Integer.parseInt(scanner.next());
				if(y < board.getSizeBoard() && x < board.getSizeBoard()){
					player.setX(x);
					player.setY(y);
 				} else {
					throw new IllegalArgumentException();
				}
				return;
			} catch (NumberFormatException e){
				System.out.println("Невірний формат даних, введіть 2 числа через пробіл");
			} catch (IllegalArgumentException e){
				System.out.println("Вказані координати за межами грального поля, введіть 2 числа, що не перевищують " +
						"розмір поля");
			}

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
	private static boolean playerMove(Player player, Referee referee, Board board){
		Move move = player.turn(board);

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
