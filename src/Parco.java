
public class Parco {
	private boolean tematico;
	private boolean divertimenti;
	
	public Parco() {};
	
	public Parco(Parco p) {
		tematico = p.getTematico();
		divertimenti = p.getDivertimenti();
	}
	
	public boolean getTematico() {
		return tematico;
	}
	public void setTematico(boolean tematico) {
		this.tematico = tematico;
	}
	public boolean getDivertimenti() {
		return divertimenti;
	}
	public void setDivertimenti(boolean divertimenti) {
		this.divertimenti = divertimenti;
	}
	
}
