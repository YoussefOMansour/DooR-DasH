package game.engine.monsters;
import game.engine.Role;

public abstract class Monster implements Comparable<Monster> {
	    private final String name;             
	    private final String description;      
	    private Role role;
	    private final Role originalRole;       
	    private int energy;                    
	    private int position;                 
	    private boolean frozen;
	    private boolean shielded;
	    private int confusionTurns;
	    
		public Monster(String name, String description, Role originalRole,int energy) {
			this.name = name;
			this.description = description;
			this.originalRole = originalRole;
			this.role=originalRole;
			if(energy>=0){
				this.energy = energy;	
			}
			
		}
		

		public String getName() {
	        return name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public Role getRole() {
	        return role;
	    }

	    public Role getOriginalRole() {
	        return originalRole;
	    }

	    public int getEnergy() {
	        return energy;
	    }

	    public int getPosition() {
	        return position;
	    }

	    public boolean isFrozen() {
	        return frozen;
	    }

	    public boolean isShielded() {
	        return shielded;
	    }

	    public int getConfusionTurns() {
	        return confusionTurns;
	    }

	    public void setRole(Role role) {
	        this.role = role;
	    }

	    public void setEnergy(int energy) {
	        this.energy=Math.max(0,energy);
	    }
	    
	    public void setPosition(int position) {
	        if (position < 0) {  
	            this.position = 0;
	        } else if (position > 99) {
	            this.position = position%100;
	        } else {
	            this.position = position;
	        }
	    }

	    public void setFrozen(boolean frozen) {
	        this.frozen = frozen;
	    }

	    public void setShielded(boolean shielded) {
	        this.shielded = shielded;
	    }

	    public void setConfusionTurns(int confusionTurns) {
	        this.confusionTurns = confusionTurns;
	    }
	    public int compareTo(Monster o){
	    	if (this.getPosition() < o.getPosition()) {
	            return -1;
	        } else if (this.getPosition() > o.getPosition()) {
	            return 1;
	        } else {
	            return 0;
	        }
	    }
}
