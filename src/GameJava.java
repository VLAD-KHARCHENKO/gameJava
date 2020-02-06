import java.io.IOException;

public class GameJava {
    public static void main(String[] args) throws IOException {
        RandomModel randomModel = setModelStartParametr();
        RandomView randomView = new RandomView();
        RandomController randomController = new RandomController(randomModel, randomView);

        randomController.random();
        int count = 1;
        boolean resalt = true;
        while (resalt && count < 10) {
            resalt = randomController.getUserNumber(count);

            count++;

        }
        if (count==10 && resalt) {
        randomController.lose();
        }
    }


    private static RandomModel setModelStartParametr() {
        RandomModel model = new RandomModel();
        model.setLeft(0);
        model.setRight(100);
        return model;
    }
}
