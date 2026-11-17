package RoteGrüneSteine;

public class Stein {

	private int anzahlRote = 0;
	private int anzahlGruene = 0;

	public int getAnzahlRote() {
		return anzahlRote;
	}

	public int getAnzahlGruene() {
		return anzahlGruene;
	}

	public void addRoteSteine() {
		this.anzahlRote++;
	}

	public void addGruneSteine() {
		this.anzahlGruene++;
	}

	public String toString() {
		if (anzahlRote == 0 && anzahlGruene == 0) {
			return "-";
		} else if (anzahlRote > 0 && anzahlGruene > 0) {
			return "g:" + anzahlGruene + ",r:" + anzahlRote;
		} else if (anzahlRote > 0) {
			return "r:" + anzahlRote;
		} else {
			return "g:" + anzahlGruene;
		}
	}

}
