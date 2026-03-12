package game.engine;
import game.engine.dataloader.DataLoader;
import game.engine.monsters.*;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	private Board board;
	private ArrayList<Monster> allMonsters;
	private Monster player;
	private Monster opponent;
	private Monster current;

	public Game(Role playerRole)throws IOException{
		board =new Board(DataLoader.readCards());
		allMonsters=(DataLoader.readMonsters());
		player=selectRandomMonsterByRole(playerRole);
		if(playerRole==Role.LAUGHER)
			opponent=selectRandomMonsterByRole(Role.SCARER);
		else
			opponent=selectRandomMonsterByRole(Role.LAUGHER);
		current=player;
	}
	private Monster selectRandomMonsterByRole(Role role) {
	    Monster r = null;
	    
	    r=allMonsters.get((int)(Math.random() * allMonsters.size()));
	    		while(r.getRole()!=role){
	    			int x=(int)(Math.random() * allMonsters.size());
	    			r = allMonsters.get(x);
	    		}
	  
	    return r;
	}
	
	public Board getBoard() {
		return board;
	}
	public ArrayList<Monster> getAllMonsters() {
		return allMonsters;
	}
	public Monster getPlayer() {
		return player;
	}
	public Monster getOpponent() {
		return opponent;
	}
	public Monster getCurrent() {
		return current;
	}
	public void setCurrent(Monster current) {
		this.current = current;
	}
	
	
	
	

}
