package borsa;

public class Period {

	private int [] changes;

	public Period(int [] changes) {
		
		this.changes = changes; 
	}
	
	public int [] getChanges(){
		return changes;
	}
	
}
