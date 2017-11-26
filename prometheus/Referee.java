package katrenich.prometheus;


import katrenich.prometheus.exceptions.RefereePutException;

public class Referee {

	//метод записує до дошки фігуру, інакше повертає помилку
	public void put(Move move, Board board) {
		if(board.getCell(move.getX(), move.getY()) != null && board.getCell(move.getX(), move.getY()) == ActionFigure.NOTHING){
			board.setCell(move.getX(), move.getY(), move.getFigure());
		} else {
			throw new RefereePutException("Can't write figure: " + move.getFigure() + " on board");
		}
	}

	// метод перевіряє чи був хід виграшним
	public boolean isWin(Move move, Board board) {
		ActionFigure figure = move.getFigure();
		int line = move.getX();
		int column = move.getY();
		int count = 0;

		// Перевірка рядка на співпадіння всіх символів
		for (int i = 0; i < board.getSizeBoard() ; i++) {
			if(i != column){
				if(figure == board.getCell(line, i)){
					count++;
				}
			}
		}

		// якщо в рядку всі фігури однакові - повертається істина
		if(count == board.getSizeBoard() - 1)
			return true;

		count = 0;

		// перевірка значень в стовпці
		for (int i = 0; i < board.getSizeBoard() ; i++) {
			if(i != line){
				if(figure == board.getCell(i, column)){
					count++;
				}
			}
		}

		if(count == board.getSizeBoard() - 1)
			return true;


		// перевірка по прямій діагоналі
		if(column == line){
			count = 0;
			for (int i = 0, j = 0; i < board.getSizeBoard(); i++) {
				if(i == column && j == line ){
					j++;
					continue;
				} else {
					if(figure == board.getCell(i, j)){
						count++;
					}
				}
				j++;
			}
		}

		if(count == board.getSizeBoard() - 1)
			return true;

		// перевірка по зворотній діагоналі
		if(column + line == board.getSizeBoard() - 1){
			count = 0;
			for (int i = board.getSizeBoard() - 1, j = 0; i >= 0 ; i--) {
				if(i == column && j == line ){
					j++;
					continue;
				} else {
					if(figure == board.getCell(j, i)){
						count++;
					}
				}
				j++;
			}
		}

		if(count == board.getSizeBoard() - 1)
			return true;

		return false;
	}

}
