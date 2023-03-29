package jufrin;
//dont have
import java.util.Scanner;

    public class GajianPerbudakan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama Karyawan = ");
        String nama = input.nextLine();
        System.out.print("Jabatan       = ");
        String posisi = input.nextLine();
        System.out.print("Penempatan    = ");
        String penempatan = input.nextLine();
        System.out.print("Masa Kerja    = ");
        double masakerja = input.nextDouble();

        Gajian Perusaha_Pembudakan = new Gajian (nama, posisi,penempatan, masakerja);
        Perusaha_Pembudakan.StatusKaryawan();
    }
}


