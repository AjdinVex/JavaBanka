
import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.SortedMap;

public class Banka {
    private double stanje;

    public void deposit(Scanner novac) {
        System.out.println("Unesite koliko želite uplatiti novca:");
        double suma = Double.parseDouble(novac.nextLine());
        stanje = stanje + suma;
        System.out.println("Vaše trenutno stanje je: " + stanje + " KM");
    }

    public void withdraw(Scanner novac) {
        System.out.println("Unesite koliko želite podići novca:");
        double suma = Double.parseDouble(novac.nextLine());

        if (suma > stanje) {
            System.out.println("Nemate dovoljno novca na računu.");
        } else {
            stanje = stanje - suma;
            System.out.println("Vaše trenutno stanje je: " + stanje + " KM");
        }
    }

    public void status() {
        System.out.println("Vaše stanje je: " + stanje + " KM");
    }

    public void saveState(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(String.valueOf(stanje));
            fileWriter.close();
            System.out.println("Stanje sačuvano u datoteku " + filename);
        } catch (IOException e) {
            System.out.println("GREŠKA pri čuvanju stanja.");
            e.printStackTrace();
        }
    }


    public void loadState(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine(); // Čitanje jednog reda iz datoteke

            if (line != null) {
                stanje = Double.parseDouble(line); // Pretvaranje stringa u double
                System.out.println("Stanje učitano: " + stanje + " KM");
            } else {
                System.out.println("Datoteka je prazna.");
            }

            bufferedReader.close(); // Zatvaranje BufferedReader-a
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Greška pri pretvaranju stringa u double.");
            e.printStackTrace();
        }

    }
}