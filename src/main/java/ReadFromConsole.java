import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by evozon on 9/9/2016.
 */
public class ReadFromConsole {

	//Read from console class

    public int readNumber() {
        int numberFromConsole = 0;
        boolean ok;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                numberFromConsole = scanner.nextInt();
                ok = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                ok = false;
            }
        } while(!ok);
        return numberFromConsole;

    }

    public List<Integer> readList() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> myList = new ArrayList<Integer>();
        boolean repeat = true;
        while (repeat) {
            try {
                myList.add(scanner.nextInt());
            } catch (Exception e) {
                repeat = false;
            }
        }
        return myList;
    }
}
