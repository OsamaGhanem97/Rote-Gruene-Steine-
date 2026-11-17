package RoteGrüneSteine;

public class Spieler {

	private String name;
	private int punkte;

	public Spieler(String name) {

		this.name = name;
		punkte =0;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte += punkte;
	}

	public String getName() {
		return name;
	}

}
