import java.util.Scanner;

public class Oyuncu {
    private String isim;
    private char sekil;

    public Oyuncu(String isim,char sekil) {
        this.isim = isim;
        this.sekil = sekil;
    }

    public String getIsim() {
        return isim;
    }

    public char getSekil() {
        return sekil;
    }

    public void hamle(Board board) {
        int[] result = new int[2];
        while (true) {
            System.out.println(isim + ", lütfen koordinatları girin: ");
            try {
                Scanner sc = new Scanner(System.in);
                String[] inputs = sc.nextLine().split(" ");
                result[0] = Integer.parseInt(inputs[0]);
                result[1] = Integer.parseInt(inputs[1]);

                if (result[0] > 3 || result[0] < 1 || result[1] > 3 || result[1] < 1) {
                    throw new Exception("1 ile 3 arasında bir sayı giriniz.");
                }
                if (board.getBoard()[result[0] - 1][result[1] - 1] != '-') {
                    throw new Exception("Hücre dolu. Başka koordinat giriniz.");
                }

                board.getBoard()[result[0] - 1][result[1] - 1] = sekil;
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}






