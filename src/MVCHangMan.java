public class MVCHangMan {
    public static void main(String[] args) {

        HangmanView theView = new HangmanView();
        HangmanModel theModel = new HangmanModel();
        new HangmanController(theView,theModel);

        theView.setVisible(true);
    }
}
