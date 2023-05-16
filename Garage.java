import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int Anzahl_Etagen = 0;
        int Parkplaetze_pro_Etage = 0;
        int Anzahl_Autoparkplaetze = 0;
        int Anzahl_Motorradparkplaetze = 0;
        String Nummernschild = "";
        Map<String, Integer> Autos = new HashMap<>();   // Alle Autos im Parkhaus und ihre Schilder
        Map<String, Integer> Motorraeder = new HashMap<>(); // // Alle Motorräder im Parkhaus und ihre Schilder
        Map<String, Integer> AlleSchilder = new HashMap<>(); // Etage und Einzigartigkeit des Schilds
        String bindestrich = "-".repeat(40);
        String antwort = "";
        int antwort2 = 0;
        int i = 0;
        int j = 0;

        System.out.print("Wollen Sie die Anzahl von Etagen und Parkplätzen selber eingeben? (ja/nein) ");
        antwort = scan.nextLine();

        if (antwort.equals("ja")) {
            System.out.print("Anzahl Etagen: ");
            Anzahl_Etagen = scan.nextInt();
            System.out.print("Anzahl Parkplätze pro Etage: ");
            Parkplaetze_pro_Etage = scan.nextInt();
        } else if (antwort.equals("nein")) {
            Anzahl_Etagen = rand.nextInt(19) + 1;
            Parkplaetze_pro_Etage = rand.nextInt(450) + 50; // zwischen 50 und 500
        }
        Anzahl_Autoparkplaetze = Anzahl_Etagen * Parkplaetze_pro_Etage - Anzahl_Etagen * Parkplaetze_pro_Etage / 10;
        Anzahl_Motorradparkplaetze = Anzahl_Etagen * Parkplaetze_pro_Etage / 10; // Ein Zehntel aller Parkplätze sind die Motorradparkplätze

        while (antwort2 != 4) {
            System.out.println("\n\n" + bindestrich + "\nAnzahl Etagen: " + Anzahl_Etagen + "\nAnzahl Parkplätze pro Etage: " + Parkplaetze_pro_Etage +
                    "\nAnzahl freier Autoparkplätze: " + (Anzahl_Autoparkplaetze - Autos.size()) + " von " + Anzahl_Autoparkplaetze +
                    "\nAnzahl freier Motorradplätze: " + (Anzahl_Motorradparkplaetze - Motorraeder.size()) + " von " + Anzahl_Motorradparkplaetze +
                    "\n" + bindestrich + "\nWas wollen Sie tun?\n1: Einen Autoparkplatz vergeben\n2: Einen Motorradparkplatz vergeben\n"
                    + "3: Ein Fahrzeug finden" + "\n4: Programm beenden");
            antwort2 = scan.nextInt();
            scan.nextLine();

            if (antwort2 == 1) {
                System.out.print("Nummernschild eingeben: ");
                Nummernschild = scan.nextLine();
                if (AlleSchilder.containsKey(Nummernschild)) {
                    System.out.println("Das Nummernschild gibt es schon!");
                } else {
                    Autos.put(Nummernschild, i);
                    AlleSchilder.put(Nummernschild, (i / (Anzahl_Autoparkplaetze) + 1));

                    i++;
                    System.out.println("Hinzugefügt!");
                }
            }

            if (antwort2 == 2) {
                System.out.print("Nummernschild eingeben: ");
                Nummernschild = scan.nextLine();
                if (AlleSchilder.containsValue(Nummernschild)) {
                    System.out.println("Das Nummernschild gibt es schon!");
                } else {
                    Motorraeder.put(Nummernschild, j);
                    AlleSchilder.put(Nummernschild, (j / (Anzahl_Motorradparkplaetze) + 1));
                    j++;
                    System.out.println("Hinzugefügt!");
                }
            } else if (antwort2 == 3) {
                System.out.print("Nummernschild eingeben: ");
                Nummernschild = scan.nextLine();
                if (Autos.containsKey(Nummernschild)) {
                    System.out.println("Das Auto " + Nummernschild + " hat den Parkplatz " + Autos.get(Nummernschild) + " auf der Etage " + AlleSchilder.get(Nummernschild));
                }
                else if (Motorraeder.containsKey(Nummernschild)) {
                    System.out.println("Das Motorrad " + Nummernschild + " hat den Parkplatz " + Motorraeder.get(Nummernschild) + " auf der Etage " + AlleSchilder.get(Nummernschild));
                }

                else {
                    System.out.println("Das Nummernschild gibt es nicht!");
                }
                }
            }
        }
    }
