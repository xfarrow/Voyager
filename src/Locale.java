public class Locale {
	private boolean discoteca;
	private boolean notturno;
	private boolean salaBallo;
	private boolean salaEventi;
	
	public Locale() {};
	
	public Locale(Locale l) {
		discoteca = l.getDiscoteca();
		notturno = l.getNotturno();
		salaBallo = l.getSalaBallo();
		salaEventi = l.getSalaEventi();
	}
	public boolean getDiscoteca() {
		return discoteca;
	}
	public void setDiscoteca(boolean discoteca) {
		this.discoteca = discoteca;
	}
	public boolean getNotturno() {
		return notturno;
	}
	public void setNotturno(boolean notturno) {
		this.notturno = notturno;
	}
	public boolean getSalaBallo() {
		return salaBallo;
	}
	public void setSalaBallo(boolean salaBallo) {
		this.salaBallo = salaBallo;
	}
	public boolean getSalaEventi() {
		return salaEventi;
	}
	public void setSalaEventi(boolean salaEventi) {
		this.salaEventi = salaEventi;
	}
	
	
}
