
public class Pizzeria {
	private boolean pizzaFritta;
	private boolean soloCena;
	private boolean fornoElettrico;
	private boolean fornoLegna;
	
	public Pizzeria() {};
	
	public Pizzeria(Pizzeria p) {
		pizzaFritta = p.getPizzaFritta();
		soloCena = p.getSoloCena();
		fornoElettrico = p.getFornoElettrico();
		fornoLegna = p.getFornoLegna();
	}
	
	public boolean getPizzaFritta() {
		return pizzaFritta;
	}
	public void setPizzaFritta(boolean pizzaFritta) {
		this.pizzaFritta = pizzaFritta;
	}
	public boolean getSoloCena() {
		return soloCena;
	}
	public void setSoloCena(boolean soloCena) {
		this.soloCena = soloCena;
	}
	public boolean getFornoElettrico() {
		return fornoElettrico;
	}
	public void setFornoElettrico(boolean fornoElettrico) {
		this.fornoElettrico = fornoElettrico;
	}
	public boolean getFornoLegna() {
		return fornoLegna;
	}
	public void setFornoLegna(boolean fornoLegna) {
		this.fornoLegna = fornoLegna;
	}
	
}
