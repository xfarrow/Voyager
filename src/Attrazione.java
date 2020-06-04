import java.time.LocalTime;

public class Attrazione {
	private LocalTime orarioApertura;
	private LocalTime orarioChiusura;
	private boolean perBambini;
	private String tipoAttrazione;
	
	public Attrazione() {};
	
	public Attrazione(Attrazione a) {
		orarioApertura = a.getOrarioApertura();
		orarioChiusura = a.getOrarioChiusura();
		perBambini = a.getPerBambini();
		tipoAttrazione = a.getTipoAttrazione();
	}
	
	public LocalTime getOrarioApertura() {
		return orarioApertura;
	}
	public void setOrarioApertura(LocalTime orarioApertura) {
		this.orarioApertura = orarioApertura;
	}
	public LocalTime getOrarioChiusura() {
		return orarioChiusura;
	}
	public void setOrarioChiusura(LocalTime orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}
	public boolean getPerBambini() {
		return perBambini;
	}
	public void setPerBambini(boolean perBambini) {
		this.perBambini = perBambini;
	}
	public String getTipoAttrazione() {
		return tipoAttrazione;
	}
	public void setTipoAttrazione(String tipoAttrazione) {
		this.tipoAttrazione = tipoAttrazione;
	} 
}
