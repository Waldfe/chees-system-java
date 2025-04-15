package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.awt.*;
import javax.swing.*;

public class ChessGUI extends JFrame {

    private final JButton[][] boardButtons = new JButton[8][8];
    private final ChessMatch chessMatch = new ChessMatch();
    private ChessPosition source = null;

    public ChessGUI() {
        setTitle("Xadrez - Wald Edition ♟️");
        setSize(640, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        // Criar botões do tabuleiro
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton();
                button.setFont(new Font("Segoe UI Symbol", Font.BOLD, 32));
                int r = row;
                int c = col;
                button.addActionListener(e -> onSquareClick(r, c));
                boardButtons[row][col] = button;
                add(button);
            }
        }

        updateBoard();
        setVisible(true);
    }

    private void onSquareClick(int row, int col) {
        ChessPosition clicked = new ChessPosition((char) ('a' + col), 8 - row);

        if (source == null) {
            ChessPiece piece = chessMatch.getPieces()[row][col];
            if (piece != null && piece.getColor() == chessMatch.getCurrentPlayer() ) {
                source = clicked;
                highlightPossibleMoves(chessMatch.possibleMoves(source));
            }
        } else {
            try {
                chessMatch.performChessMove(source, clicked);
                source = null;
                updateBoard();

                // Verifica se há promoção pendente
                if (chessMatch.getPromoted() != null) {
                    String type = showPromotionDialog(); // Diálogo gráfico
                    chessMatch.replacePromotedPiece(type);
                    updateBoard(); // Atualiza o tabuleiro após promoção
                }

                if (chessMatch.getCheckMate()) {
                    JOptionPane.showMessageDialog(this,
                            "XEQUE-MATE! Vencedor: " + chessMatch.getCurrentPlayer() );
                }
            } catch (ChessException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                source = null;
                updateBoard();
            }
        }
    }

    private void updateBoard() {
        ChessPiece[][] pieces = chessMatch.getPieces();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = boardButtons[row][col];
                ChessPiece piece = pieces[row][col];
    
                // Cores do tabuleiro
                Color light = new Color(240, 217, 181);
                Color dark = new Color(181, 136, 99);
                button.setBackground((row + col) % 2 == 0 ? light : dark);
    
                if (piece == null) {
                    button.setText("");
                } else {
                    button.setText(getPieceSymbol(piece));
                    // Cor da peça (mapear chess.Color para AWT Color)
                    button.setForeground(
                        piece.getColor() == chess.Color.WHITE 
                            ? java.awt.Color.WHITE 
                            : java.awt.Color.BLACK
                    );
                }
            }
        }
    }

    private void highlightPossibleMoves(boolean[][] moves) {
        updateBoard(); // limpa
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < moves[i].length; j++) {
                if (moves[i][j]) {
                     boardButtons[i][j].setBackground(Color.CYAN);
                }
            }
        }
    }

    // Diálogo para escolher a peça de promoção
private String showPromotionDialog() {
    Object[] options = {"Q", "R", "B", "N"}; // Rainha, Torre, Bispo, Cavalo
    String message = "Promova o peão para:\n(Q) Rainha | (R) Torre | (B) Bispo | (N) Cavalo";
    
    String input = (String) JOptionPane.showInputDialog(
        this,
        message,
        "Promoção de Peão",
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0] // Valor padrão
    );

    return input != null ? input : "Q"; // Se cancelar, padrão para Rainha
}

    private String getPieceSymbol(ChessPiece piece) {
        String symbol = piece.toString().toUpperCase(); // ex: "Q", "K", "B"
        return switch (symbol) {
            case "P" -> "♟";
            case "R" -> "♜";
            case "N" -> "♞";
            case "B" -> "♝";
            case "Q" -> "♛";
            case "K" -> "♚";
            default -> "?";
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGUI::new);
    }
}
