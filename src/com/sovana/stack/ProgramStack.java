
package com.sovana.stack;

//Made with love by Sovana S


//Berikut adalah package yang diperlukan untuk program ini:
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;


public class ProgramStack {
    
    /*
    Method ini akan menambahkan buku baru ke koleksi buku menggunakan fungsi push().
    Namun sebelumnya, user harus memasukkan dulu judul bukunya.
    Method ini mempunyai parameter stack<string> yang akan di-push.
    */
    static void pushToStack(Stack<String> stack){
        try {
            System.out.print("Masukkan buku baru: ");
            String book = new Scanner(System.in).nextLine();
            stack.push(book);
            System.out.println("Buku \"" + book + "\" berhasil ditambahkan ke koleksi");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    /*
    Method showStack akan menampilkan isi koleksi buku menggunakan for-each-loop,
    dimana urutan teratas adalah buku yang pertama ditambahkan.
    Nomor urut buku dibuat menggunakan auto-increment.
    Method ini mempunyai parameter stack<string> yang akan ditampilkan isinya.
    */
    static void showStack(Stack<String> stack){
        int a = 0;
        System.out.println("Daftar koleksi buku:");
        for (Object o: stack){
            a++;
            System.out.println(a +". "+ o);
        }
    }
    
    /*
    Method searchStack akan mencari buku di koleksi. User harus memasukkan judul buku
    secara lengkap dan memperhatikan besar kecilnya huruf, karena input
    pencarian ini bersifat case-sensitive. Jika variable result bernilai -1,
    artinya buku yang dicari tidak ditemukan. Jika ditemukan, maka result
    akan mengembalikan nilai posisi dari buku. Namun result ini akan menampilkan posisi
    buku dalam urutan terbalik dari angka urutan di output showStack(), sehingga angka result
    perlu dibalik urutannya agar sesuai dengan angka urutan di output showStack() (Lihat di else statement).
    Method ini mempunyai parameter stack<string> yang akan di-push.
    */
    static void searchStack(Stack<String> stack){
        System.out.print("Cari buku: ");
        String searchKey = new Scanner(System.in).nextLine();
        int result = (Integer)stack.search(searchKey);
        if(result == -1) {
            System.out.println("Buku \""+ searchKey + "\" tidak ditemukan");
        } else {
            System.out.println("Buku \"" + searchKey + "\" berada pada posisi ke-" + (stack.size() - result + 1));
        }
    }
    
    /*
    Method popStack akan menghapus/mengeluarkan buku yang terakhir dimasukkan dari koleksi.
    Fungsi pop() diletakkan dalam try-catch untuk menghandle error jika koleksi buku kosong,
    maka akan menampilkan pesan bahwa koleksi buku kosong.
    Method ini mempunyai parameter stack<string> yang akan di-push.
    */
    static void popStack(Stack<String> stack){
        try {
            stack.pop();
            System.out.println("Buku terbawah di koleksi berhasil dikeluarkan.");
        } catch (EmptyStackException e) {
            System.out.println("Koleksi buku kosong. Tidak ada yang dikeluarkan.");
        }
        
    }
    
    /*
    Method showMenu akan menampilkan menu utama program yang berisi fungsi-fungsi yang telah
    dibuat di atas. Setiap menu diberi nomor urut. Untuk mengakses setiap menu, user harus
    memasukkan nomor urut salah satu menu. Jika nomor yang dimasukkan tidak ada dalam daftar,
    maka akan muncul pesan bahwa pilihan tidak valid.
    Method ini mempunyai parameter stack<string> yang akan di-push.
    */
    static void showMenu(Stack<String> stack){
        System.out.println("----KOLEKSI BUKU------");
        System.out.println(""
                + "1. Tampilkan koleksi buku"
                + "\n2. Cari buku"
                + "\n3. Tambahkan buku baru"
                + "\n4. Keluarkan buku terbawah dari koleksi"
                + "\n5. Keluar");
        System.out.print("Pilih menu: ");
        int pilihan = new Scanner(System.in).nextInt();
        switch (pilihan){
            case 1:
                showStack(stack);
                break;
            case 2:
                searchStack(stack);
                break;
            case 3:
                pushToStack(stack);
                break;
            case 4:
                popStack(stack);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }
    
    public static void main(String[] args) {
        
        /*
        Di method main, kita buat objek Stack baru yang akan dimanipulasi dengan method-method di atas.
        Kemudian, panggil method showMenu() ke dalam while true, yang artinya method showMenu()
        akan dijalankan terus-menerus sampai user menghentikan program.
        */
        Stack<String> book = new Stack();
        while (true) {
            showMenu(book);
        }
    }
}
