
public class BedAndBreakfast {
	private boolean reception;
	private boolean vietatoFumare;
	private boolean servizioBiancheria;
	private boolean lavatrice;
	private boolean lavastoviglie;
	private String tipoLetto;
	
	public BedAndBreakfast() {};
	
	public BedAndBreakfast(BedAndBreakfast bb) {
		reception = bb.getReception();
		vietatoFumare = bb.getVietatoFumare();
		servizioBiancheria = bb.getServizioBiancheria();
		lavatrice = bb.getLavatrice();
		lavastoviglie = bb.getLavastoviglie();
		tipoLetto = bb.getTipoLetto();
	}
	
	public boolean getReception() {
		return reception;
	}
	public void setReception(boolean reception) {
		this.reception = reception;
	}
	public boolean getVietatoFumare() {
		return vietatoFumare;
	}
	public void setVietatoFumare(boolean vietatoFumare) {
		this.vietatoFumare = vietatoFumare;
	}
	public boolean getServizioBiancheria() {
		return servizioBiancheria;
	}
	public void setServizioBiancheria(boolean servizioBiancheria) {
		this.servizioBiancheria = servizioBiancheria;
	}
	public boolean getLavatrice() {
		return lavatrice;
	}
	public void setLavatrice(boolean lavatrice) {
		this.lavatrice = lavatrice;
	}
	public boolean getLavastoviglie() {
		return lavastoviglie;
	}
	public void setLavastoviglie(boolean lavastoviglie) {
		this.lavastoviglie = lavastoviglie;
	}
	public String getTipoLetto() {
		return tipoLetto;
	}
	public void setTipoLetto(String tipoLetto) {
		this.tipoLetto = tipoLetto;
	}
	
	
}
