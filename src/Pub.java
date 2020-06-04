
public class Pub {
	private boolean birreria;
	
	public Pub() {};
	
	public Pub(Pub p) {
		birreria = p.getBirreria();
	}

	public boolean getBirreria() {
		return birreria;
	}

	public void setBirreria(boolean birreria) {
		this.birreria = birreria;
	}
	
}
