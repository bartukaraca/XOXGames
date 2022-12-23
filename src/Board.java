public class Board {
    private char[][] board;
    private boolean oyunBitti;
    private Oyuncu kazanan;

    public Board() {
        board = new char[3][3];
        oyunBitti = false;
        kazanan = null;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean oyunbitti() {
        return oyunBitti;
    }

    public char[][] getBoard() {
        return board;
    }

    public Oyuncu getKazanan() {
        return kazanan;
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public boolean oynanabilirlik() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    return true;
                }
            }
        }
        oyunBitti = true;
        return false;
    }

    public boolean kazanan(Oyuncu oyuncu) {
       for(int i = 0; i< board[0].length;i++){
        if (satirKazanan(i, oyuncu.getSekil())
                || sütunKazanan(i, oyuncu.getSekil())) {
            oyunBitti = true;
            kazanan= oyuncu;
            return true;
        }
    }

        if (altEksen(oyuncu.getSekil()) || üstEksen(oyuncu.getSekil())) {
        oyunBitti = true;
        kazanan = oyuncu;
        return true;
    }

        return false;
}

    private boolean satirKazanan(int index, char sekil) {
        for (int j = 0; j < board[0].length; j++) {
            if (sekil != board[index][j]) {
                return false;
            }
        }
        return true;
    }

    private boolean sütunKazanan(int index, char sekil) {
        for (int i = 0; i < board[0].length; i++) {
            if (sekil != board[i][index]) {
                return false;
            }
        }
        return true;
    }

    private boolean üstEksen(char sekil) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == j && sekil != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean altEksen(char sekil) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == board[0].length - j - 1 && sekil != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

