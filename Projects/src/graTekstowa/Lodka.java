package graTekstowa;

public class Lodka {
	private boolean czyJestPusta;
	private int polozenieLodki;
	
	public boolean getCzyJestPusta() {
		return czyJestPusta;
	}
	public void setCzyJestPusta(boolean czyJestPusta) {
		this.czyJestPusta = czyJestPusta;
	}
	public int getPolozenieLodki() {
		return polozenieLodki;
	}
	public void setPolozenieLodki(int polozenieLodki) {
		this.polozenieLodki = polozenieLodki;
	}
	public Lodka() {
		czyJestPusta=true;
		polozenieLodki=-1;
	}
	public void plyniecieLodki() {
		if(polozenieLodki==-1) polozenieLodki=1;
		else polozenieLodki = -1;
		System.out.println("Łódka popłynęła na drugą stronę.");
	}
	public void polozenieLodki() {
		if(polozenieLodki==-1) System.out.println("Łódka znajduje się na wyspie po lewo.");
		else System.out.println("Łódka znajduje się na wyspie po prawo.");
	}
}
