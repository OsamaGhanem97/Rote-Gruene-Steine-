package RoteGrüneSteine;

import java.util.Scanner;

public class Spiel_7224321 {

	static SpielFeld sf;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Janein = "";
		do {
			System.out.println("Wie Viele Runde moechten Sie spielen? ");
			int runden = sc.nextInt();
			System.out.println("Geben Sie die Anzahl der Zeilen im Spielfeld ein:");
			int zeilen = sc.nextInt();
			System.out.println("Geben Sie die Anzahl der Spalten im Spielfeld ein: ");
			int spalten = sc.nextInt();
			System.out.println("Geben Sie die Anzahl an gruenen und roten Steinen ein: ");
			int anzRotGruen = sc.nextInt();
			sf = new SpielFeld(zeilen, spalten, anzRotGruen);
			Spieler sp1=new Spieler("GRUEN");
			Spieler sp2=new Spieler("ROT");
			Spieler aktuelleSpieler=sp1;
			int runde=1;
			while(runde<=runden) {
				sf.init();
				System.out.println("Runde "+runde);
				System.out.println("Die Steine wie folgt verteilt: ");
				sf.ausfuellen();
				ausgabefeld();
				int  rundeRot;
				int rundeGruen;
				while(sf.testeEnde()) {
					  rundeRot=0;
					 rundeGruen=0;
					System.out.println("Das Feld ist zur Zeit gefüllt: ");
					ausgabeSpielfeld();
					System.out.println(aktuelleSpieler.getName()+": ");
					System.out.println("In welche zeile soll die Zahl eingetragen werden ?");
					int zeile=sc.nextInt();
					System.out.println("In welche zeile soll die Spalte eingetragen werden ?");
					int spalte=sc.nextInt();
					System.out.println("Welche Zahl soll eingetragen soll");
					int zahl=sc.nextInt();
					if(sf.setZahl(zeile, spalte, zahl)) {
						aktuelleSpieler=aktuelleSpieler==sp1?sp2:sp1;
					}
				}
				rundeRot=sf.getPunkteRote();
				rundeGruen=sf.getPunkteGrune();
				System.out.println("Die Runde ist beendet un das Feld ist mit folgenden Zahlen gefüllt");
				ausgabeSpielfeld();
				System.out.println("Spieler "+sp1.getName()+" bekommt "+rundeGruen+" Punkte");
				System.out.println("Spieler "+sp2.getName()+" bekommt "+rundeRot+" Punkte");
				sp1.setPunkte(rundeGruen);
				sp2.setPunkte(rundeRot);
				runde++;
			}
			System.out.println("Alle Runden sind gespielt ");
			if(sp1.getPunkte()>sp2.getPunkte()) {
				System.out.println(sp1.getName()+"hat mit "+sp1.getPunkte()+" Punkten gewonnen");
			}
			else if(sp2.getPunkte()>sp1.getPunkte()) {
				System.out.println(sp2.getName()+"hat mit "+sp2.getPunkte()+" Punkten gewonnen");
			}else {
				System.out.println("Das Spiel ist unentschieden beendet mit jeweils "+sp1.getPunkte()+sp2.getPunkte());
			}

			System.out.println("Wollen Sie noch einmal Spielen(J/N)");
			Janein = sc.next();
		} while (!Janein.equals("N"));

		System.out.println("Danke");
	}

	public static void ausgabeSpielfeld() {
		for (int i = 0; i < sf.getZeilen(); i++) {
			System.out.print("  " + i);
		}
		System.out.println();
		for (int i = 0; i < sf.getZeilen(); i++) {
			System.out.print(i + "  ");
			for (int j = 0; j < sf.getSpalten(); j++) {
				System.out.print(sf.getSpielfeld()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void ausgabefeld() {
		for (int i = 0; i < sf.getZeilen(); i++) {
			System.out.print("  " + i);
		}
		System.out.println();
		for (int i = 0; i < sf.getZeilen(); i++) {
			System.out.print(i + "  ");
			for (int j = 0; j < sf.getSpalten(); j++) {
				System.out.print(sf.getFeld()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
