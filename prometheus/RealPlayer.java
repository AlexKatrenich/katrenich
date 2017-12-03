package katrenich.prometheus;

import katrenich.prometheus.interfaces.Player;

public class RealPlayer implements Player {
	private ActionFigure figure;
	private Move move;

	public RealPlayer(ActionFigure figure) {
		this.figure = figure;
		move = new Move();
		move.setFigure(figure);
	}

	public void setX(int x){
		move.setX(x);
	}

	public void setY(int y){
		move.setY(y);
	}



	@Override
	public Move turn(Board board) {
		return move;
	}
}
