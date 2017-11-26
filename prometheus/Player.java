package katrenich.prometheus;


public class Player {
	private ActionFigure figure;

	public Player(ActionFigure figure) {
		this.figure = figure;
	}

		/*
		 * 1) if Якщо є рядок, стовпчик зі своїми фішками та одним вільним полем - ставимо фігуру в те поле.
		 * 2) else if Якщо є рядок, колонка або діагональ з фішками противника та одним вільним полем ставимо фігуру туди.
		 * 3) else ставимо фігуру на будь-яке вільне місце:
		 *     а) if якщо вільний центр - ставимо фігуру в центральну комірку
		 *     б) else if якщо центр наш - ставимо фігур в будь-яку вільну середню лінію/діагональ.
		 *     в) else ставимо фішку в будь-яке вільне поле
		 */
	public Move turn(Board board) {
		Move move = new Move();
		move.setFigure(figure);

		if(checkForWin(board, move)){
			return move;
		} else if (checkForWinOpponent(board, move)){
			return move;
		} else {
			double d = (float) board.getSizeBoard() / 2 + 0.4;
			int centre = (int) d;

			if(ActionFigure.NOTHING == board.getCell(centre, centre)){
				move.setX(centre);
				move.setY(centre);
				return move;
			} else if(figure == board.getCell(centre, centre) && setFigureByCentre(board, move, centre)){
				return move;
			} else{
				return setFigureAnyware(board, move);
			}

		}
	}

	// Метод встановлює фігуру гравця в першу вільну комірку
	private Move setFigureAnyware(Board board, Move move) {
		for (int i = 0; i < board.getSizeBoard(); i++) {
			for (int j = 0; j < board.getSizeBoard(); j++) {
				if(ActionFigure.NOTHING == board.getCell(i,j)){
					move.setX(i);
					move.setY(j);
					return move;
				}
			}
		}

		return move;
	}

	// Метод встановлює фігуру гравця в будь-яку вільну клітинку середнього рядка або середнього стовпця
	private boolean setFigureByCentre(Board board, Move move, int centre) {
		// перебір по середньому рядку
		for (int i = 0; i < board.getSizeBoard(); i++) {
			if(board.getCell(centre, i) == ActionFigure.NOTHING){
				move.setX(centre);
				move.setY(i);
				return true;
			}
		}

		// перебір по середньому стовпці
		for (int i = 0; i < board.getSizeBoard(); i++) {
			if(board.getCell(i, centre) == ActionFigure.NOTHING){
				move.setX(i);
				move.setY(centre);
				return true;
			}
		}

		return false;
	}


	/*
	 * Метод перевіряє, чи на полі є рядок/стовпчик з однією пустою клітинкою та рештою клітинок заповненими фігурами
	 * противника. Якщо така клітика є - в об'єкт ходу заповнюються координати клітинки та повертається істина.
	 */
	private boolean checkForWinOpponent(Board board, Move move) {
		int count = 0;

		// Визначається фігура суперника(в залежності від фігури гравця)
		ActionFigure opponentFigure = figure == ActionFigure.CROSS ? ActionFigure.NOUGHT : ActionFigure.CROSS;

		// Перевірка кожного рядка на наявність однієї вільної клітинки та решти клітинок заповнених фігурами оппонента.
		for (int i = 0; i < board.getSizeBoard() ; i++) {
			count = 0;
			for (int j = 0; j < board.getSizeBoard(); j++) {
				if(opponentFigure == board.getCell(i, j)){
					count++;
				}else{
					move.setX(i);
					move.setY(j);
				}
			}
			if(count==board.getSizeBoard() - 1 && board.getCell(move.getX(), move.getY()) == ActionFigure.NOTHING){
				return true;
			}
		}

		// Перевірка кожного стовпця на наявність однієї вільної клітинки та решти клітинок заповнених фігурами оппонента.
		for (int i = 0; i < board.getSizeBoard() ; i++) {
			count = 0;
			for (int j = 0; j < board.getSizeBoard(); j++) {
				if(opponentFigure == board.getCell(j, i)){
					count++;
				}else{
					move.setX(j);
					move.setY(i);
				}
			}
			if(count==board.getSizeBoard() - 1 && board.getCell(move.getX(), move.getY()) == ActionFigure.NOTHING){
				return true;
			}
		}

		return false;
	}


	/*
	 * Метод перевіряє, чи на полі є рядок/стовпчик з однією пустою клітинкою та рештою клітинок заповненими фігурами
	 * гравця. Якщо така клітика є - в об'єкт ходу заповнюються координати клітинки та повертається істина.
	 */
	private boolean checkForWin(Board board, Move move){
		int count = 0;
		move.setFigure(figure);

		// Перевірка кожного рядка на наявність однієї вільної клітинки та решти клітинок заповнених фігурами гравця.
		for (int i = 0; i < board.getSizeBoard() ; i++) {
			count = 0;
			for (int j = 0; j < board.getSizeBoard(); j++) {
				if(figure == board.getCell(i, j)){
					count++;
				}else{
					move.setX(i);
					move.setY(j);
				}
			}
			if(count==board.getSizeBoard() - 1 && board.getCell(move.getX(), move.getY()) == ActionFigure.NOTHING){
				return true;
			}
		}

		// Перевірка кожного стовпця на наявність однієї вільної клітинки та решти клітинок заповнених фігурами гравця.
		for (int i = 0; i < board.getSizeBoard() ; i++) {
			count = 0;
			for (int j = 0; j < board.getSizeBoard(); j++) {
				if(figure == board.getCell(j, i)){
					count++;
				}else{
					move.setX(j);
					move.setY(i);
				}
			}
			if(count==board.getSizeBoard() - 1 && board.getCell(move.getX(), move.getY()) == ActionFigure.NOTHING){
				return true;
			}
		}

		return false;
	}

}
