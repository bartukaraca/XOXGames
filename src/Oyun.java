import java.util.ArrayList;
import java.util.Scanner;

public class Oyun {
    static Board board;
    static ArrayList<Oyuncu> oyuncular;

    public static void main(String[] args) {
        secim();
        while (!board.oyunbitti()){
            play();
        }
        oyunBitti();
    }

    public static void secim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lütfen ilk oyuncunun adını giriniz.");
        String oyuncu1 = sc.nextLine();
        System.out.println("Lütfen ikinci oyuncunun adını giriniz.");
        String oyuncu2 = sc.nextLine();
        oyuncular = new ArrayList<>();
        oyuncular.add(new Oyuncu(oyuncu1, 'x'));
        oyuncular.add(new Oyuncu(oyuncu2, 'o'));

        board = new Board();
        board.print();
    }

    public static void play() {
        for (Oyuncu oyuncu : oyuncular) {
            oyuncu.hamle(board);

            board.print();
            if (board.kazanan(oyuncu) || !board.oynanabilirlik()) {
                return;
            }
        }
    }

    private static void oyunBitti() {
        if (board.getKazanan() != null) {
            System.out.println("Kazanan: " + board.getKazanan().getIsim()+ " Tebrikler...");
        } else {
            System.out.println("Oyun berabere, oynadığınız için teşekkürler...");
        }
    }
}
