package katrenich.prometheus;

public class TheGame {

	public static void main(String[] args) {
		Referee referee = new Referee();
		Player player1 = new Player(ActionFigure.NOUGHT);
		Player player2 = new Player(ActionFigure.CROSS);
		Board board = new Board(3);

		/**
		board.setCell(1,1, ActionFigure.NOUGHT);
		board.setCell(1,0, ActionFigure.CROSS);
		board.setCell(2,0, ActionFigure.NOUGHT);

		board.print();
		board.setCell(2,1, ActionFigure.NOUGHT);
		board.print();
		board.setCell(1,1, ActionFigure.NOUGHT);
		board.print();


		Move move = player2.turn(board);
		move.setX(0);
		move.setY(2);
		move.setFigure(ActionFigure.CROSS);
		referee.put(move, board);
		board.print();
		System.out.println(referee.isWin(move,board));
		*/


		/*
		 * Клас Поле містить метод hasMoreSpace(), що повертатиме true якщо ще залишилося дві
		 * вільні клітинки, або false у випадку якщо залишилося менше двох
		 * вільних клітинок
		 */
		while (board.hasMoreSpace()) {
			/*
			 * Кожен гравець, роблячи хід, повенен перевірити чи не зайнята
			 * відповідна клітинка. Код гравця повинен неухильно за цим слідкувати.
			 *
			 * В якості додаткового завдання Ви можете переписати код таким чином,
			 * щоб Суддя слідкував за правильністю ходу.
			 * Базова ж задача не вимагає від Судді такого функціоналу з метою спрощення задачі.
			 *
			 */

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}

			// Гравець 1 робить хід
			if(playerMove(player1, referee, board)){
				System.out.println("Виграв гравець 1!!!! УРААААА");
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			// Гравець 2 робить хід
			if(playerMove(player2, referee, board)){
				System.out.println("Виграв гравець 1!!!! УРААААА");
			}


		}
	}


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
