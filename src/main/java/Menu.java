import java.util.ArrayList;
import java.util.List;

public class Menu {
    ReadFromConsole readFromConsole = new ReadFromConsole();
    Calculator calculator = new Calculator();

    public void options() {
        System.out.println("Please select an option:\n" +
                "1. Sum \n" +
                "2. Even number \n" +
                "3. Palindrom \n" +
                "4. Multiplication \n" +
                "5. Control Digit \n" +
                "6. Exercitiu cu numere si vectori \n" +
                "7. Maximul dintr-o lista \n" +
                "8. Perechi de numere descrescatoare din lista \n" +
                "9. Se afiseaza valorile dintr-un interval \n" +
                "0. Exit");
    }

    public void runProgram() {
        int opt, nr1, nr2, nr;
        do {
            options();
            opt = readFromConsole.readNumber();
            switch (opt) {
                case 1:
                    System.out.println("Please enter first number: ");
                    nr1 = readFromConsole.readNumber();
                    System.out.println("Please enter the second number: ");
                    nr2 = readFromConsole.readNumber();
                    System.out.println("The sum is: " + calculator.suma(nr1, nr2) + "\n");
                    break;
                case 2:
                    System.out.println("Please enter your number: ");
                    nr = readFromConsole.readNumber();
                    if (calculator.nrPar(nr)) {
                        System.out.println("Number is even.");
                    } else {
                        System.out.println("Number is odd.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter your number: ");
                    nr = readFromConsole.readNumber();
                    if (calculator.palindrom(nr)) {
                        System.out.println("Number is palindrome.");
                    } else {
                        System.out.println("Number is not palindrome.");
                    }
                    break;
                case 4:
                    System.out.println("Please enter first number: ");
                    nr1 = readFromConsole.readNumber();
                    System.out.println("Please enter the second number: ");
                    nr2 = readFromConsole.readNumber();
                    System.out.println("The result of multiplication is: " + calculator.inmultire(nr1, nr2) + "\n");
                    break;
                case 5:
                    System.out.println("Please enter the number: ");
                    nr = readFromConsole.readNumber();
                    System.out.println("The control digit is: " + calculator.controlDigit(nr) + "\n");
                    break;
                case 6:
                    System.out.println("Please enter the number: ");
                    nr = readFromConsole.readNumber();
                    int vector[];
                    vector = calculator.numereDouaValori(nr);
                    System.out.println("The even nr is: " + vector[0] + "\n");
                    System.out.println("The odd nr is: " + vector[1] + "\n");

                    break;
                case 7:
                    System.out.println("Please enter a number or enter any other character to exit ");
                    System.out.println("Nr maxim este: " + calculator.returnMaxFromArray(readFromConsole.readList()));
                    break;
                case 8:
                    System.out.println("Please enter a number or enter any other character to exit ");
                    System.out.println("Perechile de numere descrescatoare din lista sunt:" + calculator.pairsList(readFromConsole.readList()));
                    break;
                case 9:
                    System.out.println("Please enter a number or enter any other character to exit ");
                    List<Integer> listFromUser = readFromConsole.readList();
                    System.out.println("Please enter the first value: ");
                    int firstNumber = readFromConsole.readNumber();
                    System.out.println("Please enter second value: ");
                    int secondNumber = readFromConsole.readNumber();
                    List<Integer> resultList = calculator.listaIntreDouaValori(listFromUser, firstNumber, secondNumber);
                    if (resultList.isEmpty())
                        System.out.println("The list is empty!");
                    else
                        System.out.println("The final list is : " + resultList);
                    break;
                case 0:
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Please do something!");

            }
        } while (opt != 0);


    }
}
