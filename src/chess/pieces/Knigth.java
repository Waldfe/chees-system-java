package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knigth extends ChessPiece {

    public Knigth(Board board, Color color) {
        super(board, color);
    }

    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //acima direita
        p.setValues( position.getRow() - 2, position.getColumn() + 1 );
        if (getBoard().positionExists(p) && ( !getBoard().thereIsAPiece(p) || isThereOpponentPiece(p) ) ) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //acima esquerda
        p.setValues(position.getRow() - 2 , position.getColumn() - 1 );
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo direita
        p.setValues(position.getRow() + 2, position.getColumn() + 1 );
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo esquerda
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita acima
        p.setValues(position.getRow() - 1, position.getColumn() + 2 );
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita abaixo
        p.setValues(position.getRow() + 1 , position.getColumn() + 2 );
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //esquerda acima
        p.setValues(position.getRow() - 1 , position.getColumn() - 2 );
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //esquerda abaixo
        p.setValues(position.getRow() + 1, position.getColumn() - 2 );
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;

    }

    @Override
    public String toString() {
        return "N";
    }

}
