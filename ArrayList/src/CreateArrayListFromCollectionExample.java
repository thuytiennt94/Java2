import java.util.ArrayList;
import java.util.List;
public class CreateArrayListFromCollectionExample {
    public static void main(String[] args) {
        List<Integer> firstFivePrimeNumber = new ArrayList<>();
        firstFivePrimeNumber.add(2);
        firstFivePrimeNumber.add(3);
        firstFivePrimeNumber.add(5);
        firstFivePrimeNumber.add(7);
        firstFivePrimeNumber.add(11);
        List<Integer> firstTenPrimeNumbers = new ArrayList<>(firstFivePrimeNumber);

        List<Integer> nextFivePrimeNumbers = new ArrayList<>();
        nextFivePrimeNumbers.add(13);
        nextFivePrimeNumbers.add(17);
        nextFivePrimeNumbers.add(19);
        nextFivePrimeNumbers.add(23);
        nextFivePrimeNumbers.add(29);
        firstTenPrimeNumbers.addAll(nextFivePrimeNumbers);
        System.out.println(firstTenPrimeNumbers);
    }
}
