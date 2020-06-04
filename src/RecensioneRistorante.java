
public class RecensioneRistorante extends Recensione {
	private int recensioneID;
	private int valutazioneCucina;
	private int valutazioneServizio;
	private int valutazioneConto;
	
	public int getRecensioneID() {
		return recensioneID;
	}
	public void setRecensioneID(int recensioneID) {
		this.recensioneID = recensioneID;
	}
	public int getValutazioneCucina() {
		return valutazioneCucina;
	}
	public void setValutazioneCucina(int valutazioneCucina) {
		this.valutazioneCucina = valutazioneCucina;
	}
	public int getValutazioneServizio() {
		return valutazioneServizio;
	}
	public void setValutazioneServizio(int valutazioneServizio) {
		this.valutazioneServizio = valutazioneServizio;
	}
	public int getValutazioneConto() {
		return valutazioneConto;
	}
	public void setValutazioneConto(int valutazioneConto) {
		this.valutazioneConto = valutazioneConto;
	}
}
