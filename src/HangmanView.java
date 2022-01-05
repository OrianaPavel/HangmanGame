import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

class HangmanView extends JFrame {
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JLabel insertLetterLabel = new JLabel("Introduceti o litera");
    private JLabel wrongGuessesLabel = new JLabel("Incercari gresite");
    private JLabel guessesLeftLabel = new JLabel();
    private JLabel gameFinished = new JLabel("Jocul s-a terminat!");
    private JLabel finishMethod = new JLabel();


    private JTextField guessedLetter = new JTextField(3);
    private JTextField wrongGuesses = new JTextField(10);
    private Box rightBox;
    private Box leftBox;
    private JLabel word = new JLabel("");
    JButton submit = new JButton("Submit");
    JButton newGame = new JButton("Joc nou");

    private JLabel currentState ;
    private ImageIcon image;

    HangmanView() {

        rightBox = Box.createVerticalBox();
        leftBox = Box.createVerticalBox();
        rightPanel.add(rightBox);
        leftPanel.add(leftBox);
        word.setBorder(new EmptyBorder(20, 60, 0, 0));
        JPanel hangmanPanel = new JPanel( new BorderLayout());
        rightPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        leftPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        hangmanPanel.add( leftPanel, BorderLayout.WEST );
        hangmanPanel.add( rightPanel, BorderLayout.EAST );

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setResizable(false);
        image = new ImageIcon("resources/nr6.PNG");
        currentState = new JLabel(image);
        currentState.setIcon(image);
        wrongGuesses.setEditable(false);

        rightBox.add(insertLetterLabel);
        rightBox.add(guessedLetter);
        rightBox.add(submit);

        rightBox.add(wrongGuessesLabel);
        rightBox.add(wrongGuesses);

        guessesLeftLabel.setBorder(new EmptyBorder(20, 0, 0, 0));
        guessesLeftLabel.setText("Vieti ramase: 6");
        rightBox.add(guessesLeftLabel);

        rightBox.add(newGame);

        leftBox.add(currentState);
        leftBox.add(word);
        this.add(hangmanPanel);
    }
    protected void setWord(String chosenWord){
        word.setText(chosenWord);
    }
    protected String getGuessedLetter(){
        return guessedLetter.getText();
    }

    protected void setWrongGuesses(String wrong){
        wrongGuesses.setText(wrong);
    }
    protected void setCurrentState(int nr) {
        String URL = "resources/nr" + nr + ".PNG";
        currentState.setIcon( new ImageIcon(URL));
    }
    protected void setGuessedLetter(String s){
        guessedLetter.setText(s);
    }
    protected void addGameFinished(){
        rightBox.add(gameFinished);
    }
    protected void addFinishMethod(String s){
        finishMethod.setText(s);
        rightBox.add(finishMethod);
    }
    protected void setGuessedLetterEditable(boolean x){
        guessedLetter.setEditable(x);
    }

    protected void setGuessesLeftLabel(int nr){
        guessesLeftLabel.setText("Vieti ramase:" + nr);
    }
    void addSubmitListener(ActionListener listenForSubmitButton){
        submit.addActionListener(listenForSubmitButton);
    }
    void addNewGameListener(ActionListener listenForNewGameButton){
        newGame.addActionListener(listenForNewGameButton);
    }

}
