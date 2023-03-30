package jufrin;

import java.util.Scanner;
import java.util.InputMismatchException;
public class TugasStrukturdata1 {
    private static String[] queue = new String[20];
    private static int counters = 0;

    private static boolean queueStorage() {
        if (counters < queue.length) {
            return true;
        } else {
            return false;
        }
    }

    private static void createQueue() {
        int loopX = 0;
        String alpha = "";
        while (loopX == 0) {
            System.out.print("Masukkan Nama Antrian = ");
            Scanner alphaX = new Scanner(System.in);
            try {
                alpha = alphaX.nextLine();
                loopX = 1;
            } catch (InputMismatchException e) {
                System.out.println("Masukan Antrian harus berupa nama");
                loopX = 0;
            }
        }
        queue[counters] = alpha;
        counters++;
    }

    private static void removeQueue() {
        counters--;
        for (int i = 0; i < counters; i++) {
            queue[i] = queue[i + 1];
        }
        System.out.println("antrian sudah di panggil dan menjalakan proses adminitrasi!!");
    }

    private static void displayDataQueue() {
        System.out.print("Data dalam andrian: ");
        for (int i = 0; i < counters; i++) {
            System.out.print("\n[" + (i + 1) + " => " + queue[i] + "] saat ini anda berada di urutan " + (i + 1));
            System.out.println("\nwaktu tunggu sekitar " + (i + 1) * 15 + " menit sampai giliran Anda");
        }
        System.out.println("");

    }

    private static void cleanQueue() {
        counters = 0;
    }

    private static void menuProgram() {
        int loopX = 0;
        int choosenMenu = 0;
        while (loopX == 0) {
            System.out.println("\t\tPROGRAM ANTRIAN PASIEN");
            System.out.println("\t\t======================");
            System.out.println("MENU");
            System.out.println("1. Ambil Antrian");
            System.out.println("2. panggil dari Antrian");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. perkirann Waktu Antrian");
          //  System.out.println("5. Mengkosongkan Antrian ");
            System.out.println("5. Keluar dari Program");
            System.out.print("Silahkan Masukan Pilihan (1 - 5)");
            System.out.println("                       ");
            System.out.println("\t\tPROGRAM ANTRIAN PASIEN");
            System.out.println("\t\t======================");
            System.out.print("Silahkan Pilihan Menu =");
            Scanner menuOption = new Scanner(System.in);
            try {
                choosenMenu = menuOption.nextInt();
                loopX = 1;
            } catch (InputMismatchException e) {
                System.out.println("Masukan harus Angka!");
            }
        }
        System.out.println("");
        menuChooser(choosenMenu);
    }

    private static void menuChooser(int choosenMenu) {
        switch (choosenMenu) {
            case 1:
                boolean check = queueStorage();
                if (check) {
                    createQueue();
                } else {
                    System.out.println("Antrian Penuh!, kosongkan data satu terlebih dahulu!");
                }
                break;
            case 2:
                removeQueue();
                break;
            case 3:
                System.out.println("Status Terisi: ");
                System.out.println("Kapasitas: " + queue.length);
                System.out.println("Terisi   : " + counters);
                break;
            case 4:
                displayDataQueue();
                break;
            case 5:
                cleanQueue();
                break;
            case 6:
                quitApp();
                break;
        }
        menuProgram();
    }

    private static void quitApp() {
        String quitss = "y";
        System.out.print("Keluar dari Program? (Y/T): ");
        quitss = new Scanner(System.in).nextLine();
        if (quitss.equalsIgnoreCase("y")) {
            System.exit(0);
        } else {
            menuProgram();
        }
    }

    public static void main(String[] args) {
        menuProgram();
    }
}