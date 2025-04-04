package chess;

import boardgame.Board;
import boardgame.Position;
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

    private void initialSetup(){
        board.placePiece( new Rock( board, Color.WHITE ) , new Position(0,2));
        board.placePiece( new King( board, Color.WHITE ) , new Position(6,2));
    }

}
