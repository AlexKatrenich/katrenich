package katrenich.prometheus.interfaces;


import katrenich.prometheus.Board;
import katrenich.prometheus.Move;

public interface Player {
	/*
	 * Гравці можуть робити ходи за допомогою виклику методу turn, що отримує стан поля
	 * та повертає інформацію про свій хід
	 * */
	public Move turn(Board board);

}
