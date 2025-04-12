package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rock extends ChessPiece {

    public Rock(Board board, Color color) {
        super(board, color);
    }
    
    public boolean[][] possibleMoves(){
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }

    @Override
    public String toString(){
        return "R";
    }

}
