package Chess.Game;

import java.awt.Point;
import java.util.ArrayList;

public class ChessBoard {
    private Piece[][] pieceArray;
    private final int size;
    protected ArrayList<Piece> blackPieces;
    protected ArrayList<Piece> whitePieces;

    protected ChessBoard() {
        this(1);
    }

    protected ChessBoard(int choice) {
        size = 8;
        pieceArray = new Piece[size][size];
        blackPieces = new ArrayList<Piece>();
        whitePieces = new ArrayList<Piece>();
        this.chooseBoardSetup(choice);
    }

    protected Piece get(Point piece) {
        return this.pieceArray[piece.x][piece.y];
    }

    protected void set(Point coord, Piece piece) {
        pieceArray[coord.x][coord.y] = piece;
    }
    private void chooseBoardSetup(int choice) {
        switch (choice) {
            case 0:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        pieceArray[i][j] = new EmptyPiece(i, j);
                    }
                }
            break;
            case 1:
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == 1) {
                            pieceArray[i][j] = addPiece(new Pawn(i, j, false));
                        } else if (i == 6) {
                            pieceArray[i][j] = addPiece(new Pawn(i, j, true));
                        } else {
                            pieceArray[i][j] = new EmptyPiece(i, j);
                        }
                    }
                }
                pieceArray[7][1] = addPiece(new Knight(7, 1, true));
                pieceArray[7][6] = addPiece(new Knight(7, 6, true));
                pieceArray[0][1] = addPiece(new Knight(0, 1, false));
                pieceArray[0][6] = addPiece(new Knight(0, 6, false));
                pieceArray[0][3] = addPiece(new King(0, 3, false));
                pieceArray[7][3] = addPiece(new King(7, 3, true));
                pieceArray[7][0] = addPiece(new Rook(7, 0, true));
                pieceArray[7][7] = addPiece(new Rook(7, 7, true));
                pieceArray[0][0] = addPiece(new Rook(0, 0, false));
                pieceArray[0][7] = addPiece(new Rook(0, 7, false));
                break;
        }
    }

    protected void print() {
        for (int i = 0; i < size; i++) {
            System.out.print((i - 8) * (-1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(pieceArray[i][j].pieceToChar() + "|");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private Piece addPiece(Piece piece) {
        if (piece.getIsWhite()) {
            whitePieces.add(piece);
        } else {
            blackPieces.add(piece);
        }
        return piece;
    }
}
