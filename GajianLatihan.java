package jufrin;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
                    /*>>>>>>>>>>>>>>>>>>>> (INPUT CLASS-X-METHOD) <<<<<<<<<<<<<<<<<<< */
        class Gajian {

        String nama;
        String posisi;
        String Penempatan;
        double masakerja;
        long gaji_bulanan;
        double tunjangan_penempatannya;
        double biaya_pajak;
        double Bonus_Masa_Kerja;

   /* >>>>>>>>>>>>>>>>>>>> (Tunjangan/bonus penempatan) <<<<<<<<<<<<<<<<<<<<<<<
        a. Jakarta, maka tunjangan penempatannya sebesar Rp. 2.500.000
        b. Bandung, maka tunjangan penempatannya sebesar Rp. 1.500.000
        c. Selain dua kota tersebut tidak mendapatkan tunjangan penempatan*/
    public void setpenempatan() {
        if (Penempatan.equalsIgnoreCase("Jakarta")) {
            tunjangan_penempatannya = 2500000;
        } else if (Penempatan.equalsIgnoreCase("Bandung")) {
            tunjangan_penempatannya = 1500000;
        } else {
            tunjangan_penempatannya = 0;
        }
    }
/* >>>>> Potongan pajak :
        a. Jika karyawan yang mempunyai gaji pokok >= 15.000.000 maka, potongan pajak sebesar 15%
        b. Jika karyawan yang mempunyai gaji pokok >= 10.000.000 maka, potongan pajak sebesar 10%
        c. Jika karyawan yang mempunyai gaji pokok <= 10.000.000 maka, potongan pajak sebesar 5% */
    public void setpajak() {
        if (gaji_bulanan >= 15000000) {
            biaya_pajak = 0.15 * gaji_bulanan;
        } else if (gaji_bulanan >= 10000000) {
            biaya_pajak = 0.1 * gaji_bulanan;
        } else {
            biaya_pajak = 0.05 * gaji_bulanan;
        }
    }
    /*>>>>>. Gaji pokok perjabatan :
        a. Scrum Master, maka gaji pokoknya sebesar Rp. 12.000.000
        b. Technical Leader, maka gaji pokoknya sebesar Rp. 14.000.000
        c. Project Manager, maka gaji pokoknya sebesar Rp. 16.000.000
        d. Selain dua jabatan diatas maka gaji pokoknya sebesar Rp. 8.000.000*/
        public void setgajipokok() {
            if (posisi.equalsIgnoreCase("Scrum Master")) {
                gaji_bulanan = 12000000;
            } else if (posisi.equalsIgnoreCase("Technical Leader")) {
                gaji_bulanan = 14000000;
            } else if (posisi.equalsIgnoreCase("Project Manager")) {
                gaji_bulanan = 16000000;
            } else if(posisi.equalsIgnoreCase("Sales")) {
                gaji_bulanan = 3500000;
            } else {
                gaji_bulanan = 8000000;
            }
        }

        /*>>>>>> Bonus Masa Kerja :
   a. Jika masa kerja >= 5 tahun, maka mendapatkan bonus sebesar Rp. 1.000.000
   b. Jika masa kerja >= 3 tahun, maka mendapatkan bonus sebesar Rp. 750.000
   c. Jika masa kerja >= 1.5 tahun, maka mendapatkan bonus sebesar Rp. 500.000
   b. Jika masa kerja < 1.5 tahun makan tidak mendapatkan bonus */

    public void setBonus() {
        if (masakerja >= 5) {
            Bonus_Masa_Kerja = 1000000;
        } else if (masakerja >= 3) {
            Bonus_Masa_Kerja = 750000;
        } else if (masakerja >= 1.5) {
            Bonus_Masa_Kerja = 500000;
        } else {
            Bonus_Masa_Kerja = 0;
        }
    }


        /*Rumus menghitung take homepay => gaji pokok + tunjangan jabatan + bonus masa kerja - potongan pajak*/
    public long getTakeHomePay() {
        return (long) ((gaji_bulanan + tunjangan_penempatannya ) + (Bonus_Masa_Kerja - biaya_pajak));
    }


         /*>>>>>>>>>>>>>OUTPUT STATUS DATA DAN PEMANGGILAN MENTHOD<<<<<<<<<<<<<<<<*/
    public void StatusKaryawan() {
        Locale LokasiID = new Locale("in","ID");
        NumberFormat Formatrupiah = NumberFormat.getNumberInstance(LokasiID);
        NumberFormat Formatrp = NumberFormat.getCurrencyInstance(LokasiID);
        NumberFormat Formatrp1 = NumberFormat.getCompactNumberInstance();
        NumberFormat Formatrp2 = NumberFormat.getIntegerInstance(LokasiID);

//        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
//        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
//
//        formatRp.setCurrencySymbol("Rp. ");
//        formatRp.setMonetaryDecimalSeparator(',');
//        formatRp.setGroupingSeparator('.');

        System.out.println("=============================================");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Nama Karyawan        = " + nama);
        System.out.println("Jabatan              = " + posisi);
        System.out.println("Penempatan           = " + Penempatan);
        System.out.println("Masa Kerja           = " + masakerja + " Tahun");
        System.out.println("Gaji Pokok           = " + Formatrp.format(gaji_bulanan));
        System.out.println("Tunjangan Penempatan = " + Formatrp.format(tunjangan_penempatannya));
        System.out.println("Bonus Masa Kerja     = " + Formatrp.format(Bonus_Masa_Kerja));
        System.out.println("Potongan Pajak       = " + Formatrp.format(biaya_pajak));
        System.out.println("Take Home Pay        = " + Formatrp.format(getTakeHomePay()));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("==============================================");


        //NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in,", "ID"));
    }
        public Gajian(String nama, String posisi, String penempatan, int masakerja) {
            this.nama = nama;
            this.posisi = posisi;
            this.Penempatan = penempatan;
            this.masakerja = masakerja;
            setgajipokok();
            setpenempatan();
            setpajak();
            setBonus();
        }
}
