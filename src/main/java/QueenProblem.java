import java.util.Scanner;

public class QueenProblem {

    int chessboard[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0}
    };
    public boolean checkPosition(int i) {
        boolean result = false;
        for (int j = 0; j < 8; ++j) {
            if (chessboard[i][j] == 0) {
                setFigure(i,j);
                if (i==7){
                    result = true;
                }
                else {
                    if (!(result = checkPosition(i+1)))
                        resetFigure(i,j);
                }
            }
            if (result)
                break;
        }
        return result;
    }

    public void resetFigure(int i, int j) {
        for (int x=0;x<8; ++x) {
            --chessboard[x][j];
            --chessboard[i][x];
            int foo;
            foo = j - i + x;
            if (foo >= 0 && foo <8)
                --chessboard[x][foo];
            foo = j + i - x;
            if (foo >= 0 && foo <8)
                --chessboard[x][foo];
        }
        chessboard[i][j] = 0;
    }

    public void setFigure(int i, int j) {
        for (int x=0;x<8; ++x) {
            ++chessboard[x][j];
            ++chessboard[i][x];
            int foo;
            foo = j - i + x;
            if (foo >= 0 && foo <8)
                ++chessboard[x][foo];
            foo = j + i - x;
            if (foo >= 0 && foo <8)
                ++chessboard[x][foo];
        }
        chessboard[i][j] = -1;
    }

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        System.out.print("Введите значение строки: ");
        int a = sc.nextInt();
        if (8 <= a) {
            System.out.println("Такой ячейки не существует!");
            return;
        }

        System.out.print("Введите значение столбца: ");
        int b = sc.nextInt();
        if (8 <= a) {
            System.out.println("Такой ячейки не существует!");
            return;
        }

        QueenProblem queenProblem = new QueenProblem();

        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                queenProblem.chessboard[i][j] = 0;
        queenProblem.checkPosition(0);
        queenProblem.setFigure(a,b);
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (queenProblem.chessboard[i][j] == -1) {
                    System.out.print(" 1 ");
                }
                else
                    System.out.print(" 0 ");
            }
            System.out.print(" \n");
    }
    }

}