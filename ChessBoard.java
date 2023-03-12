package Chess.Game;

import java.awt.Point;

public class ChessBoard {
    private Piece[][] pieceArr;
    private final int size = 8;

    protected ChessBoard() {
        this(0);
    }

    protected ChessBoard(int choice) {
        pieceArr = new Piece[size][size];
        this.chooseBoardSetup(choice);
    }

    protected Piece get(Point piece) {
        return this.pieceArr[piece.x][piece.y];
    }

    protected void set(Point coord, Piece piece) {
        pieceArr[coord.x][coord.y] = piece;
    }
    private void chooseBoardSetup(int choice) {
        switch (choice) {
            case 0:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        pieceArr[i][j] = new EmptyPiece(i, j);
                    }
                }
            break;
            case 1:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == 1) {
                            pieceArr[i][j] = new Pawn(i, j, false);
                        } else if (i == 6) {
                            pieceArr[i][j] = new Pawn(i, j, true);
                        } else {
                            pieceArr[i][j] = new EmptyPiece(i, j);
                        }
                    }
                }
                pieceArr[7][1] = new Knight(7, 1, true);
                pieceArr[7][6] = new Knight(7, 6, true);
                pieceArr[0][1] = new Knight(0, 1, false);
                pieceArr[0][6] = new Knight(0, 6, false);
                break;
        }
    }

    protected void print() {
        for (int i = 0; i < size; i++) {
            System.out.print((i - 8) * (-1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(pieceArr[i][j].toString() + "|");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
