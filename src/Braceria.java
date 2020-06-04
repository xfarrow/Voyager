
public class Braceria {
	private boolean carne;
	private boolean pesce;
	
	public Braceria() {};
	
	public Braceria(Braceria b) {
		carne = b.getCarne();
		pesce = b.getPesce();
	}
	
	public boolean getCarne() {
		return carne;
	}
	public void setCarne(boolean carne) {
		this.carne = carne;
	}
	public boolean getPesce() {
		return pesce;
	}
	public void setPesce(boolean pesce) {
		this.pesce = pesce;
	}
	
}
