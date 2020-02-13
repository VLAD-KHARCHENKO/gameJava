import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class RandomController {
    private RandomModel randomModel;
    private RandomView randomview;
    private ResourceBundle bundle;


    public RandomController(RandomModel randomModel, RandomView randomview, String locale) {
        this.randomModel = randomModel;
        this.randomview = randomview;
        this.bundle = ResourceBundle.getBundle("resources", new Locale(locale));
    }


    void random() {
        int randNumber = (int) (Math.random() * 100);
        randomModel.setRandomNumber(randNumber);
        System.out.println(randNumber);
    }

    boolean getUserNumber(int count) throws IOException {
        int yourNumber = getNumber();
        if (yourNumber == randomModel.randomNumber) {
            randomview.printMessage(bundle.getString("win") + " " + count + " " + bundle.getString("attempts"));
            return false;
        } else {
            boolean result = compare(yourNumber);
            if (result == true)
                randomview.printMessage(bundle.getString("bigger"));
            if (result == false)
                randomview.printMessage(bundle.getString("smaller"));
        }
        return true;
    }

    private int getNumber() throws IOException {
        int yourNumber;
        int left = randomModel.getLeft();
        int right = randomModel.getRight();
        randomview.printMessage(bundle.getString("numberFrom") + " " + left + " " + bundle.getString("to")+" "+right);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        yourNumber = Integer.parseInt(bufferedReader.readLine());
        if (yourNumber <= left || yourNumber >= right) {
            randomview.printMessage(bundle.getString("error"));
        }
        return yourNumber;
    }

    public void lose() {
        randomview.printMessage(bundle.getString("lose"));
    }

    private boolean compare(int yourNumber) {
        if (yourNumber > randomModel.randomNumber) {
            randomModel.setRight(yourNumber);
            return true;
        }
        randomModel.setLeft(yourNumber);
        return false;
    }


}
