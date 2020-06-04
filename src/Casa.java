
public class Casa {
	private String tipoCasa;
	private double metriQuadri;
	private String tipoEsterno;
	private boolean vietatoFumare;
	private boolean servizioBiancheria;
	private boolean lavatrice;
	private boolean lavastoviglie;
	private String tipoLetto;
	
	public Casa() {};
	
	public Casa(Casa c) {
		tipoCasa = c.getTipoCasa();
		metriQuadri = c.getMetriQuadri();
		tipoEsterno = c.getTipoEsterno();
		vietatoFumare = c.getVietatoFumare();
		servizioBiancheria = c.getServizioBiancheria();
		lavatrice = c.getLavatrice();
		lavastoviglie = c.getLavastoviglie();
		tipoLetto = c.getTipoLetto();
	}
	
	public String getTipoCasa() {
		return tipoCasa;
	}
	public void setTipoCasa(String tipoCasa) {
		this.tipoCasa = tipoCasa;
	}
	public double getMetriQuadri() {
		return metriQuadri;
	}
	public void setMetriQuadri(double metriQuadri) {
		this.metriQuadri = metriQuadri;
	}
	public String getTipoEsterno() {
		return tipoEsterno;
	}
	public void setTipoEsterno(String tipoEsterno) {
		this.tipoEsterno = tipoEsterno;
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
