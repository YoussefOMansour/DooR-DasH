package game.engine;
import game.engine.cells.*;
import java.util.ArrayList;
import game.engine.monsters.Monster;
import game.engine.cards.*;
public class Board {
	private Cell[][] boardCells;
	private	static ArrayList<Monster> stationedMonsters;
	private static ArrayList<Card> originalCards;
	public static ArrayList<Card> cards;
	
	public Board(ArrayList<Card> readCards){
		boardCells = new Cell[Constants.BOARD_ROWS][Constants.BOARD_COLS];
		stationedMonsters=new ArrayList<>();
		cards=new ArrayList<>();
		originalCards=readCards;
	}
	
	public Cell[][] getBoardCells() {
		return boardCells;
	}
	
	public ArrayList<Monster> getStationedMonsters() {
		return stationedMonsters;
	}
	public void setStationedMonsters(ArrayList<Monster> stationedMonsters) {
		Board.stationedMonsters = stationedMonsters;
	}
	
	public static ArrayList<Card> getOriginalCards() {
		return originalCards;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		Board.cards = cards;
	}
	
	

}
