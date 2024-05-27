import java.io.*;
import java.util.*;

public class TicketApp {

    public static void main(String[] args) {
        System.out.print("\t\t|=======================================================|\t\t");
        System.out.print("\n\t\t|           WELCOME TO KAEDAHARA STATION BUS            |\t\t");
        System.out.print("\n\t\t|=======================================================|\t\t\n");

        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);

        System.out.print("\nEnter how many ticket: ");
        int q = scan.nextInt();
        Ticket[] tick = new Ticket[q];

        for (int i = 0; i < tick.length; i++) {
            System.out.print("\nEnter name: ");
            String cn = scan1.nextLine();
            System.out.print("\nEnter Number Phone(if none put -): ");
            String cp = scan1.nextLine();
            System.out.print("\nEnter Age: ");
            int cage = scan.nextInt();
            System.out.print("\nKedah   [Alor Setar Bus Station] ");
            System.out.print("\nPenang  [Butterworth Bus Terminal]");
            System.out.print("\nPerak   [Tanjung Malim Bus Station]");
            System.out.print("\nPahang  [Terminal Sentral Kuantan] ");
            System.out.print("\nKelantan[Kota Bharu Bus Terminal] ");
            System.out.print("\nSelangor[Kuala Lumper Sentral] ");
            System.out.print("\nMelaka  [Melaka Sentral Bus Terminal] ");
            System.out.print("\nJohor   [Johor Bahru Sentral Bus Station] ");
            System.out.print("\nEnter destination: ");
            String d = scan1.nextLine();
            System.out.print("\nPls enter seat number: ");
            int snum = scan.nextInt();
            System.out.print("\nticket type[1-physical ticket | 2-digital ticket]:");
            int tt = scan.nextInt();
            if (tt == 1) {
                System.out.print("\nEnter the date: ");
                int dy = scan.nextInt();
                System.out.print("\nEnter the month: ");
                int mon = scan.nextInt();
                System.out.print("\nEnter the year: ");
                int yr = scan.nextInt();

                tick[i] = new PhysicalTicket(cn, cp, cage, tt, d, snum, dy, mon, yr);

            } else if (tt == 2) {
                System.out.print("\nEnter the date: ");
                int dy = scan.nextInt();
                System.out.print("\nEnter the month: ");
                int mon = scan.nextInt();
                System.out.print("\nEnter the year: ");
                int yr = scan.nextInt();

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
            outPhysicalTicket.println("\t\t|=================================|\t\t");
            outPhysicalTicket.println("\t\t|=============RECEIPT=============|\t\t");
            outPhysicalTicket.println("\t\t|=================================|\t\t");

            PrintWriter outDigitalTicket = new PrintWriter(
                    new BufferedWriter(new FileWriter("DigitalTicket.txt")));
            outDigitalTicket.println("\t\t|=================================|\t\t");
            outDigitalTicket.println("\t\t|=============RECEIPT=============|\t\t");
            outDigitalTicket.println("\t\t|=================================|\t\t");
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
                            "\nTime arive:" + info[i].getDuration() + " hour" + "\nBus Plate: " + info[i].getBusName());

                    outDigitalTicket.println("\n----------------------------------------\n");
                }

            }

            System.out.print("\n\t\t|======================================|\t\t");
            System.out.print("\n\t\t|           DATA INFORMATION           |\t\t");
            System.out.print("\n\t\t|======================================|\t\t\n");
            System.out.println("\nTotal ticket purchase by Physical: " + count);
            System.out.println("\nTotal ticket purchase by Digital: " + count1);
            System.out.println("\nTotal ticket purchase by both(Physical/Digital): " + newtickettotal);
            System.out.println("\nTotal price ticket purchase by all passenger RM: " + newprice);

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
