import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomController {
    private RandomModel randomModel;
    private RandomView randomview;

    public RandomController(RandomModel randomModel, RandomView randomview) {
        this.randomModel = randomModel;
        this.randomview = randomview;
    }


    void random() {
        int randNumber = (int) (Math.random() * 100);
        randomModel.setRandomNumber(randNumber);
        System.out.println(randNumber);
    }

    boolean getUserNumber(int count) throws IOException {
        int yourNumber = getNumber();
        if (yourNumber == randomModel.randomNumber) {
            randomview.win(count);
            return false;
        } else {
            boolean result = compare(yourNumber);
            randomview.moreLess(result);
        }
        return true;
    }

    private int getNumber() throws IOException {
        int yourNumber;
        int left = randomModel.getLeft();
        int right = randomModel.getRight();
        randomview.inputNumber(left, right);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        yourNumber = Integer.parseInt(bufferedReader.readLine());
        if (yourNumber<=left||yourNumber>=right){
            randomview.mistake();
        }
        return yourNumber;
    }

    public void lose(){
        randomview.lose();
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
