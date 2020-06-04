
public class Alloggio {
	private int stanze;
	private int bagni;
	private boolean TV;
	private boolean parcheggio;
	private boolean wifi;
	private boolean piscina;
	private boolean condizionamento;
	private boolean animaliAmmessi;
	private String tipoAlloggio;
	
	public Alloggio() {};
	
	public Alloggio(Alloggio a) {
		stanze = a.getStanze();
		bagni = a.getBagni();
		TV = a.getTV();
		parcheggio = a.getParcheggio();
		wifi = a.getWifi();
		piscina = a.getPiscina();
		condizionamento = a.getCondizionamento();
		animaliAmmessi = a.getAnimaliAmmessi();
		tipoAlloggio = a.getTipoAlloggio();
	}
	
	public int getStanze() {
		return stanze;
	}
	public void setStanze(int stanze) {
		this.stanze = stanze;
	}
	public int getBagni() {
		return bagni;
	}
	public void setBagni(int bagni) {
		this.bagni = bagni;
	}
	public boolean getTV() {
		return TV;
	}
	public void setTV(boolean tV) {
		TV = tV;
	}
	public boolean getParcheggio() {
		return parcheggio;
	}
	public void setParcheggio(boolean parcheggio) {
		this.parcheggio = parcheggio;
	}
	public boolean getWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean getPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean getCondizionamento() {
		return condizionamento;
	}
	public void setCondizionamento(boolean condizionamento) {
		this.condizionamento = condizionamento;
	}
	public boolean getAnimaliAmmessi() {
		return animaliAmmessi;
	}
	public void setAnimaliAmmessi(boolean animaliAmmessi) {
		this.animaliAmmessi = animaliAmmessi;
	}
	public String getTipoAlloggio() {
		return tipoAlloggio;
	}
	public void setTipoAlloggio(String tipoAlloggio) {
		this.tipoAlloggio = tipoAlloggio;
	}
}
