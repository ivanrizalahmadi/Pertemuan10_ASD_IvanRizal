public class Queue {
    private Pasien[] antrian;
    private int front, rear, size, max;

    public Queue(int max) {
        this.max = max;
        this.antrian = new Pasien[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Pasien pasien) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            antrian[rear] = pasien;
            size++;
            System.out.println("Pasien berhasil ditambahkan ke antrian.");
        } else {
            System.out.println("Antrian penuh!");
        }
    }

    public Pasien dequeue() {
        if (!isEmpty()) {
            Pasien temp = antrian[front];
            front = (front + 1) % max;
            size--;
            return temp;
        } else {
            System.out.println("Antrian kosong!");
            return null;
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Pasien terdepan: " + antrian[front]);
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Pasien terbelakang: " + antrian[rear]);
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void peekPosition(String nama) {
        int current = front;
        for (int i = 0; i < size; i++) {
            if (antrian[current].nama.equals(nama)) {
                System.out.println(nama + " berada di posisi " + (i + 1) + " dari depan.");
                return;
            }
            current = (current + 1) % max;
        }
        System.out.println("Pasien tidak ditemukan dalam antrian.");
    }

    public void print() {
        if (!isEmpty()) {
            System.out.println("Daftar Pasien:");
            int current = front;
            for (int i = 0; i < size; i++) {
                System.out.println(antrian[current]);
                current = (current + 1) % max;
            }
        } else {
            System.out.println("Antrian kosong!");
        }
    }
}
