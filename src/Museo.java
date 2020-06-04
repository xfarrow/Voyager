public class Museo {
	private boolean archeologico;
	private boolean artistico;
	private boolean marino;
	private boolean militare;
	private boolean scientifico;
	private boolean naturale;
	private boolean storico;
	private boolean virtuale;
	
	public Museo() {};
	
	public Museo(Museo m) {
		archeologico = m.getArcheologico();
		artistico = m.getArtistico();
		marino = m.getMarino();
		militare = m.getMilitare();
		scientifico = m.getScientifico();
		naturale = m.getNaturale();
		storico = m.getStorico();
		virtuale = m.getVirtuale();
	}
	
	public boolean getArcheologico() {
		return archeologico;
	}
	public void setArcheologico(boolean archeologico) {
		this.archeologico = archeologico;
	}
	public boolean getArtistico() {
		return artistico;
	}
	public void setArtistico(boolean artistico) {
		this.artistico = artistico;
	}
	public boolean getMarino() {
		return marino;
	}
	public void setMarino(boolean marino) {
		this.marino = marino;
	}
	public boolean getMilitare() {
		return militare;
	}
	public void setMilitare(boolean militare) {
		this.militare = militare;
	}
	public boolean getScientifico() {
		return scientifico;
	}
	public void setScientifico(boolean scientifico) {
		this.scientifico = scientifico;
	}
	public boolean getNaturale() {
		return naturale;
	}
	public void setNaturale(boolean naturale) {
		this.naturale = naturale;
	}
	public boolean getStorico() {
		return storico;
	}
	public void setStorico(boolean storico) {
		this.storico = storico;
	}
	public boolean getVirtuale() {
		return virtuale;
	}
	public void setVirtuale(boolean virtuale) {
		this.virtuale = virtuale;
	}
	
}
