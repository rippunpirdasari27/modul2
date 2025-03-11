import java.util.Scanner;
import java.util.Random;

class Mahasiswa {
    String nama, NIM;
    int usia, jumlahMataKuliah, nomorAntrian;
    double[] nilai;
    double ipk;

    Mahasiswa(String namaMahasiswa, String nimMahasiswa, int usiaMahasiswa, int jumlahMK, double[] nilaiMK, int antrian) {
        nama = namaMahasiswa;
        NIM = nimMahasiswa;
        usia = usiaMahasiswa;
        jumlahMataKuliah = jumlahMK;
        nilai = nilaiMK;
        nomorAntrian = antrian;
        ipk = hitungIPK();
    }

    double hitungIPK() {
        double total = 0;
        for (double n : nilai) {
            total += n;
        }
        return jumlahMataKuliah > 0 ? total / jumlahMataKuliah : 0;
    }

    String evaluasiAkademik() {
        if (usia > 22) {
            return "Mahasiswa berusia lebih dari 22 tahun.";
        } else if (ipk >= 3.5 && jumlahMataKuliah > 4) {
            return "Mahasiswa memiliki IPK tinggi dan mengambil lebih dari 4 mata kuliah.";
        } else if (ipk < 2.5 || jumlahMataKuliah < 4) {
            return "Mahasiswa perlu meningkatkan performa akademik.";
        }
        return "Mahasiswa dalam kondisi akademik yang normal.";
    }

    void tampilkanLaporan() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + NIM);
        System.out.println("Usia: " + usia);
        System.out.println("Jumlah Mata Kuliah: " + jumlahMataKuliah);
        System.out.println("IPK: " + ipk);
        System.out.println("Evaluasi: " + evaluasiAkademik());
        System.out.println("Nomor Antrian Konsultasi: " + nomorAntrian + "\n");
    }
}

public class SistemPengelolaanNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine();

        Mahasiswa[] daftarMahasiswa = new Mahasiswa[jumlahMahasiswa];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan data untuk mahasiswa ke-" + (i + 1) + ":");
            System.out.print("Nama: ");
            String namaMahasiswa = scanner.nextLine();
            System.out.print("NIM: ");
            String nimMahasiswa = scanner.nextLine();
            System.out.print("Usia: ");
            int usiaMahasiswa = scanner.nextInt();
            
            int jumlahMK;
            do {
                System.out.print("Jumlah Mata Kuliah (minimal 1): ");
                jumlahMK = scanner.nextInt();
            } while (jumlahMK < 1);

            double[] nilaiMK = new double[jumlahMK];
            for (int j = 0; j < jumlahMK; j++) {
                System.out.print("Masukkan nilai untuk mata kuliah ke-" + (j + 1) + " (0 - 100): ");
                nilaiMK[j] = scanner.nextDouble();
            }
            scanner.nextLine();
            
            int antrian = random.nextInt(100) + 1;
            daftarMahasiswa[i] = new Mahasiswa(namaMahasiswa, nimMahasiswa, usiaMahasiswa, jumlahMK, nilaiMK, antrian);
        }

        System.out.println("\nLaporan Akademik Mahasiswa:");
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.tampilkanLaporan();
        }

        scanner.close();
    }
}