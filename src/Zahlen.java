package RoteGrüneSteine;

public class Zahlen {

	private int zahl;
	private boolean belegt;

	public int getZahl() {
		return zahl;
	}

	public void setZahl(int zahl) {
		this.zahl = zahl;
	}

	public boolean isBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}
	
	public String toString() {
		if(!belegt) return "-";
		return ""+zahl;
	}

}
