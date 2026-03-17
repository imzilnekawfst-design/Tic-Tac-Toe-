import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TicTacToe {
    int boardwidth = 400 ;
    int boardheight = 450 ; // 50 px for the text panel on top 
   JFrame frame = new JFrame ("Tic-Tac-Toe game ");
   ImageIcon icon = new ImageIcon("src/image.png");
   // we write text in panel using laybriry label 
   JLabel textLabel =new JLabel();
    JPanel textpanel = new JPanel();
    JPanel boardPanel =new JPanel();
    JButton  resetButton = new JButton("Reset");
    JButton[][] board = new JButton[3][3];
    String playerx = "X";
    String playerO = "O" ;
    String currentPlayer = playerx ;
    
    boolean gameOver = false; 
    int turns = 0 ;
     TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textpanel.setLayout(new BorderLayout());
        textpanel.add(textLabel);
        frame.add(textpanel, BorderLayout.NORTH);
        frame.setIconImage(icon.getImage());
      

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);
        // row and colouns
        for(int r =0 ; r<3 ;r++){
             for(int c =0 ; c<3 ;c++){
                 JButton carreau = new JButton();
                 board[r][c]= carreau ;
                 boardPanel.add(carreau);
                 carreau.setBackground(Color.darkGray);
                 carreau.setForeground(Color.white);
                 carreau.setFont(new Font("Arial", Font.BOLD, 70));
                 carreau.setFocusable(false);
               
                carreau.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e){
                        if (gameOver) return ;
                        JButton carreau = (JButton) e.getSource();
                        if (carreau.getText().isEmpty()){
                            carreau.setText(currentPlayer);
                            turns++;
                            chekWinner();
                            if(!gameOver){
                            if (currentPlayer == playerx) {
                                currentPlayer = playerO;
                                } else {
                                 currentPlayer = playerx;
                                }
                            textLabel.setText(currentPlayer +" 's turn ");
                            }
                        }
                    }
                });





             }

        }
         // button reset to reset the game 
         resetButton.setBackground(Color.darkGray);
         resetButton.setForeground(Color.white);
         resetButton.setFont(new Font("Arial", Font.BOLD, 20));
         resetButton.setFocusable(false);
         resetButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        resetGame();
    }
});

textpanel.add(resetButton, BorderLayout.EAST);



     }
    void chekWinner(){
         //horizontal ( check each row )
         // getText Read each button text
         for(int r = 0 ; r<3 ;r++){
         if(board[r][0].getText().isEmpty() ) continue ;

         if(board[r][0].getText() == board[r][1].getText() &&
            board[r][1].getText() == board[r][2].getText()){
            for(int i = 0 ;i <3 ; i++) {
                 setWinner(board[r][i]);
            }
                gameOver = true;
                return;
            }
           }
           //Vertical ( check each colum )
            for(int c = 0 ; c<3 ;c++){
                if(board[0][c].getText().isEmpty() ) continue ;
                  if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText())
                    {
            for(int i = 0 ;i <3 ; i++) {
                 setWinner(board[i][c]);
            }
                gameOver = true;
                return;
            } 
            }
            //Diagonally right side 
            if (board[0][0].getText() !="" &&  board[0][0].getText()== board[1][1].getText()
             && board[1][1].getText()== board[2][2].getText())
             {
            for(int i = 0 ;i <3 ; i++) {
                 setWinner(board[i][i]);
            }
                gameOver = true;
                return;
            } 
           //Diagonally left side 
           if (board[0][2].getText() != "" &&  board[0][2].getText()== board[1][1].getText()
             && board[1][1].getText()== board[2][0].getText())
             {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
                gameOver = true;
                return;
            } 
            if (turns == 9){
             for(int r = 0 ; r <3 ;r++){
                for (int c = 0 ; c<3 ;c++){
                    setfinich(board[r][c]);
                }
            }
            gameOver = true;
                return;
         }
            
        }

      void setWinner (JButton carreau) {
         carreau.setForeground(Color.PINK);
         carreau.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the winner!");
    }
        
          void setfinich(JButton carreau) {
         carreau.setForeground(Color.yellow);
         carreau.setBackground(Color.gray);
        textLabel.setText( " the game is over ");
          }
      void resetGame (){
        for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
            board[r][c].setText("");
            board[r][c].setBackground(Color.darkGray);
            board[r][c].setForeground(Color.white);
        }
        }
        currentPlayer = playerx ;
        gameOver = false ;
       textLabel.setText("Tic-Tac-Toe");
          }

    
}

