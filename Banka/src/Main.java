import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        Banka banka = new Banka();
        Izbor izbor = new Izbor(banka);


        banka.loadState("C:/Users/ajdin/Desktop/Java/Banka/src/stanje.txt");
        izbor.opcije();
        banka.saveState("C:/Users/ajdin/Desktop/Java/Banka/src/stanje.txt");




    }




}