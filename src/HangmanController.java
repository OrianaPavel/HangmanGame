import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HangmanController {
    private final HangmanView theView;
    private final HangmanModel theModel;

    public HangmanController(HangmanView theView, HangmanModel theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.setWord(theModel.getCurrentWordState());
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addNewGameListener(new NewGameListener());
    }

    class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(theModel.verifyPlayerGuess( theView.getGuessedLetter())) {
                if (theModel.getTriesLeft() > 0) {
                    String playerGuess = theView.getGuessedLetter();


                    theModel.testPlayerGuess(playerGuess);
                    int triesLeft = theModel.getTriesLeft();

                    theView.setCurrentState(triesLeft);
                    theView.setGuessesLeftLabel(triesLeft);
                    theView.setWord(theModel.getCurrentWordState());
                    theView.setGuessedLetter("");
                    theView.setWrongGuesses(theModel.getWrongGuesses());
                    if (theModel.checkEndGame()) {
                        theView.addGameFinished();
                        if (theModel.getTriesLeft() == 0)
                            theView.addFinishMethod("Ai ramas fara vieti!");
                        else
                            theView.addFinishMethod("Ai ghicit");
                        theView.setWord( theModel.getChosenWord());
                        theView.setGuessedLetterEditable(false);
                    }

                }
            }
        }
    }
    class NewGameListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            theModel.resetGame();
            theView.setWord( theModel.getCurrentWordState() );
            theView.setWrongGuesses( theModel.getWrongGuesses());
            theView.setGuessesLeftLabel(6);
            theView.setCurrentState(6);
            theView.setGuessedLetterEditable(true);
        }
    }
}
