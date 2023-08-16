import java.util.Scanner;

public class Izbor {
        private Banka banka;
        public Izbor(Banka banka) {
            this.banka = banka;
        }
    public void opcije() {
        Scanner scanner = new Scanner(System.in);
        boolean prviulaz = true;
        System.out.println("Dobro došli u Banku!");

        while (true) {
            if(prviulaz) {
                System.out.println("Zelite li otvoriti panel za odabir? (da/ne)");
                String potvrda = scanner.nextLine();

                if (potvrda.equalsIgnoreCase("ne")) {
                    break;
                }
                prviulaz = false;
            }

            System.out.println("Izaberite jednu od opcija ispod:");
            System.out.println("Unesite 'Deposit' ako zelite uplatiti novac");
            System.out.println("Unesite 'Withdraw' ako zelite podici novac");
            System.out.println("Unesite 'Status' ako zelite provjeriti stanje racuna");
            System.out.println("Unesite 'Zavrsi' ukoliko zelite napustiti meni");

            String opcija = scanner.nextLine();


            switch (opcija.toLowerCase()) {
                case "deposit":
                    banka.deposit(scanner);
                    break;
                case "withdraw":
                    banka.withdraw(scanner);
                    break;
                case "status":
                    banka.status();
                    break;
                case "zavrsi":
                    return;
                default:
                    System.out.println("Opcija koju ste unijeli ne postoji");
                    break;
            }
        }
    }


}

