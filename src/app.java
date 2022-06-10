import javax.swing.*;

public class app {
    private int randomNumber = getRandomNumber();
    private int playerNumber;
    private int counter = 0;
    private int bs = 100;


    private JPanel panel1;
    private JTextField numberGuess;
    private JLabel bestScore;
    private JLabel attempts;
    private JButton guessButton;
    private JButton tryAgainButton;
    private JLabel Hint;


    public app() {
        guessButton.addActionListener(e -> {
            counter++;
            playerNumber = Integer.parseInt(numberGuess.getText());
             if(randomNumber == playerNumber) {
                 bestScore.setText(String.valueOf(bs));
                 Hint.setText("Congrats");
             }
             else {
                 bs--;

                 if(playerNumber > randomNumber) {
                     Hint.setText("Lower");
                 }
                 else {
                     Hint.setText("Higher");
                 }

             }
             attempts.setText(String.valueOf(counter));
        });


        tryAgainButton.addActionListener(e -> {
            randomNumber = getRandomNumber();
            counter = 0;
            bs = 100;
            Hint.setText("");
            attempts.setText("");
            bestScore.setText("");
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new app().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public int getRandomNumber() {
        return (int) ((Math.random() * (99)) + 1);
    }
}
