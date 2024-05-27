import java.io.*;
import java.util.*;

public class TicketApp {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("|=======================================================|");
        System.out.println("|           WELCOME TO KAEDAHARA STATION BUS            |");
        System.out.println("|=======================================================|\n");

        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        System.out.print("\nEnter how many ticket: ");
        int q = scan.nextInt();
        Ticket[] tick = new Ticket[q];
        String[] destinations = {
                "Kedah    [Alor Setar Bus Station]",
                "Penang   [Butterworth Bus Terminal]",
                "Perak    [Tanjung Malim Bus Station]",
                "Pahang   [Terminal Sentral Kuantan]",
                "Kelantan [Kota Bharu Bus Terminal]",
                "Selangor [Kuala Lumper Sentral] ",
                "Melaka   [Melaka Sentral Bus Terminal] ",
                "Johor    [Johor Bahru Sentral Bus Station]",
        };

        for (int i = 0; i < tick.length; i++) {
            System.out.print("\nEnter name: ");
            String cn = scan1.nextLine();
            System.out.print("Enter Number Phone (if none put -): ");
            String cp = scan1.nextLine();
            System.out.print("Enter Age: ");
            int cage = scan.nextInt();

            System.out.println();
            for (String destination : destinations) {
                System.out.println(destination);
            }
            System.out.print("\nEnter destination: ");
            String d = scan1.nextLine();

            System.out.print("Pls enter seat number: ");
            int snum = scan.nextInt();

            System.out.println("\n[1-physical ticket]");
            System.out.println("[2-digital ticket ]");
            System.out.print("\nTicket type: ");
            int tt = scan.nextInt();

            System.out.print("\nEnter the date [dd]: ");
            int dy = scan.nextInt();
            System.out.print("Enter the month [mm]: ");
            int mon = scan.nextInt();
            System.out.print("Enter the year [yyyy]: ");
            int yr = scan.nextInt();

            if (tt == 1) {
                tick[i] = new PhysicalTicket(cn, cp, cage, tt, d, snum, dy, mon, yr);
            } else if (tt == 2) {
                tick[i] = new DigitalTicket(cn, cp, cage, tt, d, snum, dy, mon, yr);
            } else {
                System.out.print("\nERRORS");
                return;
            }

            if (q > 1) {
                System.out.print("\nNext Customer Information");
                System.out.print("\n--------------------------------------------");
            }

            if (i + 1 == tick.length) {
                scan.close();
                scan1.close();
            }

        }

        double totalprice = 0.0;
        int count = 0;
        double totalprice1 = 0.0;
        int count1 = 0;
        for (int i = 0; i < tick.length; i++) {
            if (tick[i] instanceof PhysicalTicket) {
                PhysicalTicket pt = (PhysicalTicket) tick[i];
                totalprice += pt.calcPrice();
                count++;

            } else if (tick[i] instanceof DigitalTicket) {
                DigitalTicket dt = (DigitalTicket) tick[i];
                totalprice1 += dt.calcPrice();
                count1++;

            }
        }

        int newtickettotal = count + count1;
        double newprice = totalprice + totalprice1;

        try {
            BufferedReader br = new BufferedReader(new FileReader("car.txt"));
            String in = null;
            StringTokenizer st = null;
            int cnt = 0;
            bus[] info = new bus[100];
            while ((in = br.readLine()) != null) {
                st = new StringTokenizer(in, ";");
                String ds = st.nextToken();
                double dur = Double.parseDouble(st.nextToken());
                String bn = st.nextToken();

                info[cnt] = new bus(ds, dur, bn);

                cnt++;
            }

            PrintWriter outPhysicalTicket = new PrintWriter(
                    new BufferedWriter(new FileWriter("PhysicalTicket.txt")));
            PrintWriter outDigitalTicket = new PrintWriter(
                    new BufferedWriter(new FileWriter("DigitalTicket.txt")));

            String receiptBanner = "\t\t|=================================|\t\t\n\t\t|             RECEIPT             |\t\t\n\t\t|=================================|\t\t";

            outPhysicalTicket.println(receiptBanner);
            outDigitalTicket.println(receiptBanner);

            for (int i = 0; i < tick.length; i++) {
                if (tick[i] instanceof PhysicalTicket) {
                    PhysicalTicket phystic = (PhysicalTicket) tick[i];
                    outPhysicalTicket.println(phystic.toString() + "\nTicket type: Physical Ticket" + "\nPrice: RM"
                            + phystic.calcPrice());
                    outPhysicalTicket.println("----------------------------------------");

                    outPhysicalTicket.println("\nTime arive: " + info[i].getDuration() + "hour" + "\nBus Plate: "
                            + info[i].getBusName());

                    outPhysicalTicket.println("\n----------------------------------------\n");
                } else if (tick[i] instanceof DigitalTicket) {
                    DigitalTicket dt = (DigitalTicket) tick[i];
                    outDigitalTicket
                            .println(dt.toString() + "\nTicket type: Digital Ticket" + "\nPrice: RM" + dt.calcPrice());
                    outDigitalTicket.println("----------------------------------------");

                    outDigitalTicket.println(
                            "\nTime arive: " + info[i].getDuration() + " hour" + "\nBus Plate: "
                                    + info[i].getBusName());

                    outDigitalTicket.println("\n----------------------------------------\n");
                }

            }

            System.out.print("\n\n----------------------------------------\n");
            System.out.print("\n|======================================|");
            System.out.print("\n|           DATA INFORMATION           |");
            System.out.print("\n|======================================|\n");
            System.out.println("\nTotal Physical ticket purchase: " + count);
            System.out.println("Total Digital ticket purchase: " + count1);
            System.out.println("\nTotal sum ticket purchase: " + newtickettotal);
            System.out.printf("\nTotal price ticket purchase by all passenger RM: %.2f%n\n", newprice);

            outPhysicalTicket.close();
            outDigitalTicket.close();
            br.close();

        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        } catch (Exception e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

}
