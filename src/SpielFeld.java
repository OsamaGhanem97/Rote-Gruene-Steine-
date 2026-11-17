package RoteGrüneSteine;

import java.util.Random;

public class SpielFeld {

	private int zeilen;
	private int spalten;
	private int anzRotGruen;
	private Stein[][] feld;
	private Zahlen[][] spielfeld;

	public SpielFeld(int zeilenAnzahl, int spaltenAnzahl, int anzahlGruenRot) {
		this.zeilen = zeilenAnzahl;
		this.spalten = spaltenAnzahl;
		this.anzRotGruen = anzahlGruenRot;
		feld = new Stein[zeilen][spalten];
		spielfeld = new Zahlen[zeilen][spalten];
	}

	public void init() {
		for (int i = 0; i < zeilen; i++) {
			for (int j = 0; j < spalten; j++) {
				feld[i][j] = new Stein();
				spielfeld[i][j] = new Zahlen();
			}
		}
	}

	public void ausfuellen() {
		int rot = anzRotGruen;
		int gruen = anzRotGruen;
		Random r = new Random();
		while (rot > 0) {
			int zeile = r.nextInt(zeilen);
			int spalte = r.nextInt(spalten);
			feld[zeile][spalte].addRoteSteine();
			
			rot--;
		}
		while (gruen > 0) {
			int zeile = r.nextInt(zeilen);
			int spalte = r.nextInt(spalten);
			feld[zeile][spalte].addGruneSteine();
			gruen--;
		}
	}

	public int getGruenFiguren(int zeile, int spalte) {
		return feld[zeile][spalte].getAnzahlGruene();
	}

	public int getRotFiguren(int zeile, int spalte) {
		return feld[zeile][spalte].getAnzahlRote();
	}

	public int getZahl(int zeile, int spalte) {
		return spielfeld[zeile][spalte].isBelegt() ? spielfeld[zeile][spalte].getZahl() : 0;
	}

	public boolean setZahl(int zeile, int spalte, int zahl) {
		if (!spielfeld[zeile][spalte].isBelegt()) {
			spielfeld[zeile][spalte].setZahl(zahl);
			spielfeld[zeile][spalte].setBelegt(true);
			return true;
		}
		return false;
	}

	public int getPunkteGrune() {
		int punkte = 0;
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (getGruenFiguren(i, j) > 0) {
					int summeHorizintal = 0;
					for (int k = 0; k < feld[i].length; k++) {
						summeHorizintal += spielfeld[i][k].getZahl();
					}
					int sumeVertikal = 0;
					for (int x = 0; x < feld.length; x++) {
						sumeVertikal += spielfeld[x][j].getZahl();
					}
					if (summeHorizintal % 2 == 0) {
						punkte++;
					}
					if (sumeVertikal % 2 != 0) {
						punkte++;
					}
					punkte *= getGruenFiguren(i, j);
				}
			}
		}
		return punkte;
	}

	public int getPunkteRote() {
		int punkte = 0;
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (getRotFiguren(i, j) > 0) {
					int summeHorizintal = 0;
					for (int k = 0; k < feld[i].length; k++) {
						summeHorizintal += spielfeld[i][k].getZahl();
					}
					int sumeVertikal = 0;
					for (int x = 0; x < feld.length; x++) {
						sumeVertikal += spielfeld[x][j].getZahl();
					}
					if (summeHorizintal % 2 != 0) {
						punkte++;
					}
					if (sumeVertikal % 2 == 0) {
						punkte++;
					}
					punkte *= getRotFiguren(i, j);
				}
			}
		}
		return punkte;
	}

	public boolean testeEnde() {
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld[i].length; j++) {
				if (!spielfeld[i][j].isBelegt()) {
					return false;
				}
			}
		}
		return true;
	}

	public int getZeilen() {
		return zeilen;
	}

	public int getSpalten() {
		return spalten;
	}

	public int getAnzRotGruen() {
		return anzRotGruen;
	}

	public Stein[][] getFeld() {
		return feld;
	}

	public Zahlen[][] getSpielfeld() {
		return spielfeld;
	}

}
