package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rock;


public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece promoted;

    private Board board;

    public ChessMatch(){
        board = new Board( 8, 8 );
        initialSetup();
    }

    public ChessPiece[][] getpieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for( int i=0; i<board.getRows(); i++ ){
            for( int j=0; j<board.getColumns(); j++ ){
                mat[i][j] = (ChessPiece) board.piece( i, j );
            }
        }
        return mat;
    }   

    private void placeNewPiece( char column, int row, ChessPiece piece ){
        board.placePiece( piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {

        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('c', 1, new Rock(board, Color.WHITE));
        placeNewPiece('c', 2, new Rock(board, Color.WHITE));
        placeNewPiece('d', 2, new Rock(board, Color.WHITE));
        placeNewPiece('e', 2, new Rock(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rock(board, Color.BLACK));
        placeNewPiece('c', 8, new Rock(board, Color.BLACK));
        placeNewPiece('d', 7, new Rock(board, Color.BLACK));
        placeNewPiece('e', 7, new Rock(board, Color.BLACK));
        placeNewPiece('d', 8, new Rock(board, Color.BLACK));
        
    }

}
