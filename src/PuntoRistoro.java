import java.time.LocalTime;

public class PuntoRistoro {
	private LocalTime orarioApertura;
	private LocalTime orarioChiusura;
	private boolean senzaGlutine;
	private boolean veganFriendly;
	private boolean wiFi;
	private boolean postiASedere;
	private boolean daAsporto;
	private boolean servito;
	
	private boolean pizzeria;
	private boolean braceria;
	private boolean pub;
	private boolean ristorante;
	
	public PuntoRistoro() {};
	
	public PuntoRistoro(PuntoRistoro pr) {
		orarioApertura = pr.getOrarioApertura();
		orarioChiusura = pr.getOrarioChiusura();
		senzaGlutine = pr.getSenzaGlutine();
		veganFriendly = pr.getVeganFriendly();
		wiFi = pr.getWiFi();
		postiASedere = pr.getPostiASedere();
		daAsporto = pr.getDaAsporto();
		servito = pr.getServito();
		pizzeria = pr.getPizzeria();
		braceria = pr.getBraceria();
		pub = pr.getPub();
		ristorante = pr.getRistorante();
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
	public boolean getSenzaGlutine() {
		return senzaGlutine;
	}
	public void setSenzaGlutine(boolean senzaGlutine) {
		this.senzaGlutine = senzaGlutine;
	}
	public boolean getVeganFriendly() {
		return veganFriendly;
	}
	public void setVeganFriendly(boolean veganFriendly) {
		this.veganFriendly = veganFriendly;
	}
	public boolean getWiFi() {
		return wiFi;
	}
	public void setWiFi(boolean wiFi) {
		this.wiFi = wiFi;
	}
	public boolean getPostiASedere() {
		return postiASedere;
	}
	public void setPostiASedere(boolean postiASedere) {
		this.postiASedere = postiASedere;
	}
	public boolean getDaAsporto() {
		return daAsporto;
	}
	public void setDaAsporto(boolean daAsporto) {
		this.daAsporto = daAsporto;
	}
	public boolean getServito() {
		return servito;
	}
	public void setServito(boolean servito) {
		this.servito = servito;
	}
	public boolean getPizzeria() {
		return pizzeria;
	}
	public void setPizzeria(boolean pizzeria) {
		this.pizzeria = pizzeria;
	}
	public boolean getBraceria() {
		return braceria;
	}
	public void setBraceria(boolean braceria) {
		this.braceria = braceria;
	}
	public boolean getPub() {
		return pub;
	}
	public void setPub(boolean pub) {
		this.pub = pub;
	}
	public boolean getRistorante() {
		return ristorante;
	}
	public void setRistorante(boolean ristorante) {
		this.ristorante = ristorante;
	}
}
