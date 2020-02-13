import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GameJava {

    private static RandomView  view= new RandomView();
    public static String locale;

    public static void main(String[] args) throws IOException {
       // ResourceBundle bundleUa =ResourceBundle.getBundle("resources_ua", new Locale("uk","Ua"));
       // ResourceBundle bundleEn =ResourceBundle.getBundle("resources_en", new Locale("en","USA"));

      //  System.out.println(new String(bundleUa.getString("someValue").getBytes("ISO-8859-1"),"Windows-1251"));
       // System.out.println(bundleEn.getString("someValue"));

        view.printMessage(view.LANGUAGE_CHOICE);
        locale = chooseLanguage();


        RandomModel randomModel = setModelStartParametr();
        RandomView randomView = new RandomView();
        RandomController randomController = new RandomController(randomModel, randomView,locale);

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


    public static String chooseLanguage() {
        Scanner sc = new Scanner(System.in);
        int buff = sc.nextInt();
        if (buff == 1)
            return "en";
        else
            return "ua";

    }

    private static RandomModel setModelStartParametr() {
        RandomModel model = new RandomModel();
        model.setLeft(0);
        model.setRight(100);
        return model;
    }
}
