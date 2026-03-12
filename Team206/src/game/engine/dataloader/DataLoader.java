package game.engine.dataloader;
import java.util.ArrayList;

import game.engine.cards.*;
import game.engine.cells.*;
import game.engine.monsters.*;
import game.engine.monsters.Monster;

import java.io.*;

import game.engine.Role;

public class DataLoader {
	private static final String CARDS_FILE_NAME="cards.csv";
	private static final String CELLS_FILE_NAME="cells.csv";
	private static final String MONSTERS_FILE_NAME="monsters.csv";
	
	
	public static ArrayList<Card> readCards() throws IOException{
		ArrayList<Card> c=new ArrayList<Card>();
		BufferedReader br=new BufferedReader(new FileReader(CARDS_FILE_NAME));
		
		 String s;

	        while ((s = br.readLine()) != null) {
	            String[] x = s.split(",");

            if (x[0].equals("SWAPPER")) {
                c.add(new SwapperCard(x[1], x[2], Integer.parseInt(x[3])));
            } else if (x[0].equals("SHIELD")) {
                c.add(new ShieldCard(x[1], x[2], Integer.parseInt(x[3])));
            }
            else if (x[0].equals("ENERGYSTEAL")) {
                c.add(new EnergyStealCard(x[1], x[2], Integer.parseInt(x[3]), Integer.parseInt(x[4])));
            } else if (x[0].equals("STARTOVER")) {
                c.add(new StartOverCard(x[1], x[2], Integer.parseInt(x[3]), Boolean.parseBoolean(x[4])));
            } else if (x[0].equals("CONFUSION")) {
                c.add(new ConfusionCard(x[1], x[2], Integer.parseInt(x[3]), Integer.parseInt(x[4])));
	                }
            }
	        br.close();
	            return c;
	            
	            
	}
	public static ArrayList<Cell> readCells() throws IOException{
		ArrayList<Cell> c = new ArrayList<Cell>();
        BufferedReader br = new BufferedReader(new FileReader(CELLS_FILE_NAME));

        String s;
        while ((s = br.readLine()) != null) {
            String[] x = s.split(",");

            if (x.length == 3) {
                c.add(new DoorCell(x[0], Role.valueOf(x[1]), Integer.parseInt(x[2])));
            } 
            else {
                int effect = Integer.parseInt(x[1]);
                if (effect > 0) {
                    c.add(new ConveyorBelt(x[0], effect));
                } else {
                    c.add(new ContaminationSock(x[0], effect));
                }
            }
        }
        br.close();
        return c;
		
	}
	public static ArrayList<Monster> readMonsters() throws IOException{
		ArrayList<Monster> c = new ArrayList<Monster>();
        BufferedReader br = new BufferedReader(new FileReader(MONSTERS_FILE_NAME));
        
        String s;
        while ((s = br.readLine()) != null) {
            String[] x = s.split(",");

            if (x[0].equals("DYNAMO")) {
                c.add(new Dynamo(x[1], x[2], Role.valueOf(x[3]), Integer.parseInt(x[4])));
            } else if (x[0].equals("DASHER")) {
                c.add(new Dasher(x[1], x[2], Role.valueOf(x[3]), Integer.parseInt(x[4])));
            } else if (x[0].equals("SCHEMER")) {
                c.add(new Schemer(x[1], x[2], Role.valueOf(x[3]), Integer.parseInt(x[4])));
            } else if (x[0].equals("MULTITASKER")) {
                c.add(new MultiTasker(x[1], x[2], Role.valueOf(x[3]), Integer.parseInt(x[4])));
            }
        }
        br.close();
        return c;
	}
	
}
