package katrenich.prometheus;


public class Player {
	private ActionFigure figure;

	public Player(ActionFigure figure) {
		this.figure = figure;
	}

		/*
		 * 1) if Якщо є рядок, колонка або діагональ зі своїми фішками та одним вільним полем ставимо фігуру в те поле.
		 * 2) else if Якщо є рядок, колонка або діагональ з фішками противника та одним вільним полем ставимо фігуру туди.
		 * 3) else ставимо фігуру на будь-яке вільне місце:
		 *     а) if якщо вільний центр - ставимо фігуру в центральну комірку
		 *     б) else if якщо центр наш - ставимо фігур в будь-яку вільну середню лінію/діагональ.
		 *     в) else ставимо фішку в будь-яке вільне поле
		 */
	public Move turn(Board board) {
		Move move = new Move();

		// Якщо є рядок, колонка або діагональ зі своїми фішками та одним вільним полем ставимо фігуру в те поле.



		return move;
	}

}
