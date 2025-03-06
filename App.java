import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Masukkan nama Anda: ");
        String name = input.nextLine();
        System.out.print("Masukkan usia Anda: ");
        int age = input.nextInt();
        input.nextLine(); 
        System.out.print("Masukkan jumlah uang yang dimiliki: ");
        double uang = input.nextDouble();
        System.out.print("Masukkan rata-rata pengeluaran harian: ");
        double pengeluaranHarian = input.nextDouble();

        double usiaDouble = (double) + age;
        int uangInt = (int) uang;

        double sisaUang30Hari = uang - (pengeluaranHarian * 30);
        double bulanBertahan = (pengeluaranHarian > 0) ? uang / (pengeluaranHarian * 30) : 999; 
        String statusKeuangan = bulanBertahan < 1 ? "PERINGATAN: Keuangan Anda kurang stabil!" : (bulanBertahan > 6 ? "Keuangan Anda dalam kondisi aman." : "Keuangan cukup stabil.");

        boolean lebihDari30 = age > 30;
        boolean lebihDari30DanUang10Jt = (age > 30) && (uang > 10_000_000);
        boolean kurangDari30AtauUang5Jt = (age < 30) || (uang > 5_000_000);

        System.out.print("Masukkan jumlah hutang: ");
        double hutang = input.nextDouble();
        double hutangAbsolut = Math.abs(hutang);
        double pengeluaranDibulatkan = Math.ceil(pengeluaranHarian);

        long bonusTakTerduga = (long) (Math.random() * (900_000)) + 100_000;
        double totalSetelahBonus = uang - (pengeluaranHarian * 30) + bonusTakTerduga;

        System.out.println("\n=== LAPORAN KEUANGAN PRIBADI ===");
        System.out.println("Nama: " + name);
        System.out.println("Usia: " + age + " tahun");
        System.out.println("Uang yang dimiliki: Rp" + uang);
        System.out.println("Pengeluaran harian rata-rata: Rp" + pengeluaranHarian);
        System.out.println("Sisa uang dalam 30 hari: Rp" + sisaUang30Hari);
        System.out.println("Estimasi bulan bertahan: " + bulanBertahan + " bulan");
        System.out.println("Status Keuangan: " + statusKeuangan );
        System.out.println("Nilai absolut dari hutang: Rp" + hutangAbsolut);
        System.out.println("Pengeluaran harian setelah pembulatan: Rp" + pengeluaranHarian);
        System.out.println("Total uang yang dimiliki setelah pengeluaran dan bonus: Rp" + totalSetelahBonus);
        System.out.println("Bonus tak terduga: Rp" + (int)bonusTakTerduga);
    }
}
