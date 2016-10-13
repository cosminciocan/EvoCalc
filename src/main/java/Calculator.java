import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evozon on 9/6/2016.
 */
public class Calculator {
    public int suma(int a, int b) {
        return a + b;
    }

    public int inmultire(int x, int y) {
        return x * y;
    }

    public int impartire(int a, int b) {
        if (b != 0)
            return a / b;
        else
            return -1;
    }

    public boolean nrPar(int a) {
        if (a % 2 == 0)
            return true;
        else
            return false;
    }

    public boolean nrPrim(int a) {
        for (int i = 2; i < a - 1; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    public int nrCifre(int nr) {
        int rez = 0;

        if (nr == 0) {
            return 1;
        }
        while (nr != 0) {
            nr = nr / 10;
            rez++;
        }
        return rez;
    }

    public int sumaCifre(int nr) {
        int suma = 0;

        while (nr != 0) {
            suma = suma + (nr % 10);
            nr = nr / 10;
        }
        if (suma < 0) {
            return -suma;
        }
        return suma;
    }

    public int ceaMaiMareCifra(int nr) {
        int max = 0;

        while (nr != 0) {
            if (max < nr % 10) {
                max = nr % 10;
            }
            nr = nr / 10;

        }
        return max;
    }

    public int inversulNumarului(int nr) {
        int invers = 0;

        while (nr != 0) {
            invers = (invers * 10) + (nr % 10);
            nr = nr / 10;

        }

        return invers;
    }

    public boolean palindrom(int nr) {
        int invers = inversulNumarului(nr);
        //       if (invers == nr) {
        //            return true;
        //        } else
        //
        //            return false;
        return invers == nr;
    }

    public int controlDigit(int nr) {
        while (nr > 9) {
            nr = sumaCifre(nr);
        }
        return nr;
    }

    public int[] numereDouaValori(int nr) {
        int nr1 = 0;
        int nr2 = 0;
        int aux = 0;
        while (nr > 0) {
            if ((nr % 10) % 2 == 0) {
                nr1 = nr1 * 10 + nr % 10;
                nr = nr / 10;

            } else {
                aux = nr % 10;
                if (aux < 4) {
                    aux = aux * aux;
                    nr2 = aux + (nr2 * 10);
                    nr = nr / 10;
                } else {
                    aux = aux * aux;
                    nr2 = aux + (nr2 * 100);
                    nr = nr / 10;
                }
            }

        }
        nr1 = inversulNumarului(nr1);
        int[] results = {nr1, nr2};
        return results;

    }

    public int returnMaxFromArray(List<Integer> valuesFromUser) {
//        int max = valuesFromUser.get(0);
//        for (int i = 1; i < valuesFromUser.size(); i++) {
//            if (valuesFromUser.get(i) > max)
//                max = valuesFromUser.get(i);
//        }
        int max = valuesFromUser.get(0);
        valuesFromUser.remove(0);
        for (Integer value : valuesFromUser) {
            if (value > max)
                max = value;
        }
        return max;
    }

    public List<Integer> pairsList(List<Integer> valuesFromUser) {
        List<Integer> pairsList = new ArrayList<Integer>();
        for (int i = 0; i < valuesFromUser.size() - 1; i++) {
            if (valuesFromUser.get(i) > valuesFromUser.get(i + 1)) {
                pairsList.add(valuesFromUser.get(i));
                pairsList.add(valuesFromUser.get(i + 1));
            }
        }
        return pairsList;
    }

    public List<Integer> listaIntreDouaValori(List<Integer> listFromUser, int a, int b) {
        int min = verificareMinimMaxim(a, b).get(0);
        int max = verificareMinimMaxim(a, b).get(1);
        List<Integer> finalList = new ArrayList<Integer>();
//        for (int i = 0; i < listFromUser.size(); i++) {
//           if (listFromUser.get(i) >= min && listFromUser.get(i) <= max) {
//                finalList.add(listFromUser.get(i));
//
//            }
//
//        }
        for (int number : listFromUser) {
            if (number >= min && number <= max)
                finalList.add(number);
        }
        return finalList;

    }

    public List<Integer> verificareMinimMaxim(int a, int b) {

        int max;
        if (a > b) {
            max = a;
            a = b;
            b = max;

        }
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(a);
        newList.add(b);
        return newList;
    }

}

