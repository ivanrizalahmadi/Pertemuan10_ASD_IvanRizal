import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kapasitas maksimal antrian: ");
        int kapasitas = scanner.nextInt();
        Queue antrian = new Queue(kapasitas);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Hapus Pasien Terdepan");
            System.out.println("3. Lihat Pasien Terdepan");
            System.out.println("4. Lihat Pasien Terbelakang");
            System.out.println("5. Cari Posisi Pasien");
            System.out.println("6. Daftar Semua Pasien");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (antrian.isFull()) {
                        System.out.println("Antrian sudah penuh!");
                    } else {
                        System.out.print("Nama Pasien: ");
                        String nama = scanner.nextLine();
                        System.out.print("Nomor Identitas: ");
                        int noID = scanner.nextInt();
                        System.out.print("Jenis Kelamin (L/P): ");
                        char jenisKelamin = scanner.next().charAt(0);
                        System.out.print("Umur: ");
                        int umur = scanner.nextInt();
                        scanner.nextLine();
                        Pasien baru = new Pasien(nama, noID, jenisKelamin, umur);
                        antrian.enqueue(baru);
                    }
                    break;
                case 2:
                    Pasien dihapus = antrian.dequeue();
                    if (dihapus != null) {
                        System.out.println("Pasien yang dihapus: " + dihapus);
                    }
                    break;
                case 3:
                    antrian.peek();
                    break;
                case 4:
                    antrian.peekRear();
                    break;
                case 5:
                    System.out.print("Masukkan nama pasien yang dicari: ");
                    String namaDicari = scanner.nextLine();
                    antrian.peekPosition(namaDicari);
                    break;
                case 6:
                    antrian.print();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
