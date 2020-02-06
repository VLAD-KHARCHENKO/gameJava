public class RandomView {
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
}
