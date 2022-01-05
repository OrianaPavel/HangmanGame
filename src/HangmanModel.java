import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class HangmanModel {
    private  List<String> words = new ArrayList<>();
    private int triesLeft;
    private Random rand;
    private String chosenWord, wrongGuesses = "";
    private String currentWordState;

    protected HangmanModel(){
        triesLeft = 6;
        rand = new Random();
        try {
            File myFile = new File("resources/words.txt");
            Scanner scanner = new Scanner(myFile);
            while( scanner.hasNext()){
                words.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        chosenWord = words.get(rand.nextInt(words.size()));
        chosenWord = chosenWord.trim();
        chosenWord = chosenWord.toUpperCase();
        System.out.println(chosenWord);
        currentWordState = "";
        for(int i = 0; i < chosenWord.length(); i++)
            currentWordState += "_";
    }
    protected void resetGame(){
        triesLeft = 6;
        chosenWord = words.get(rand.nextInt(words.size()));
        chosenWord = chosenWord.trim();
        chosenWord = chosenWord.toUpperCase();
        System.out.println(chosenWord);
        currentWordState = "";
        for(int i = 0; i < chosenWord.length(); i++)
            currentWordState += "_";
        wrongGuesses = "";;
    }

    protected boolean verifyPlayerGuess(String guess){
            return ((guess != null)  && (!guess.equals(""))  && (guess.matches("[a-zA-Z]")));
    }
    protected boolean checkEndGame(){
        if(triesLeft == 0)
            return true;
        return !currentWordState.contains("_");
    }
    protected void testPlayerGuess(String guess){
        boolean ok = false;
        Character charGuess = Character.toUpperCase(guess.charAt(0));
        for(int i = 0; i < chosenWord.length(); i++){
            if(charGuess.equals(chosenWord.charAt(i))) {
                ok = true;
                if (i > 0)
                    currentWordState = currentWordState.substring(0, i) + charGuess + currentWordState.substring(i + 1);
                else
                    currentWordState = charGuess + currentWordState.substring(i + 1);
            }
        }
        if(!ok) {
            triesLeft--;
            if( wrongGuesses.length() == 0)
                wrongGuesses += charGuess;
            else
                wrongGuesses += ","+ charGuess;
        }
    }
    protected String getChosenWord(){
        return chosenWord;
    }
    protected  String getWrongGuesses(){
        return wrongGuesses;
    }
    protected String getCurrentWordState() {
        return currentWordState;
    }
    protected int getTriesLeft(){
        return triesLeft;
    }


}
