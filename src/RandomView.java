import java.util.ResourceBundle;

public class RandomView {

    private ResourceBundle bundle;

    public static final String LANGUAGE_CHOICE = "Please,choose a language. Press 1 for English, 2 - Ukrainian. ";


    public void printMessage(String message) {
        System.out.println(message);
    }

      /*
    void inputNumber(int left, int right) {
        System.out.println("Enter a number from " + left + " to " + right);
    }

    void moreLess(boolean result) {
        if (result == true)
            System.out.println("Your number is bigger");
        if (result == false)
            System.out.println("Your number is smaller");
    }

    void win(int counter) {
        System.out.println("You have won in "+counter+ " attempts");
    }
    void lose(){
        System.out.println("You lose");
    }

    public void mistake() {
        System.out.println("error: not the correct number");
    }
 */
}
