package graTekstowa;

public enum Obiekty {
	
	KOZA(-1,"koza"),
	WILK(-1,"wilk"),
	KAPUSTA(-1,"kapusta");
	
	public int polozenieObiektu;
	public String nazwaObiektu;
	
	private Obiekty(int polozenieObiektu, String nazwaObiektu) {
		this.polozenieObiektu = polozenieObiektu;
		this.nazwaObiektu = nazwaObiektu;
	}
//
//	public int getPolozenieObiektu() {
//		return polozenieObiektu;
//	}
//
//	public void setPolozenieObiektu(int polozenieObiektu) {
//		this.polozenieObiektu = polozenieObiektu;
//	}
//	
//	public int oznaczenieObiektu() {
//		return polozenieObiektu;
//	}
	
	
}
