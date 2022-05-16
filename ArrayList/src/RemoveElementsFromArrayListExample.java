import java.util.ArrayList;
import java.util.List;
public class RemoveElementsFromArrayListExample {
    public static void main(String[] args) {
        List<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Python");
        programmingLanguages.add("Perl");
        programmingLanguages.add("Ruby");

        System.out.println("Initial List: " + programmingLanguages);
        //remove the element at index '5'
        programmingLanguages.remove(5);
        System.out.println("After remove(5) " + programmingLanguages);
        //remove the fít occurrence of the given alement from the arraylist
        boolean isRemoved = programmingLanguages.remove("Kotlin");
        System.out.println("After remove(\"Kotlin\"): " + programmingLanguages);
        //remove all the elements that exist in a given collection
        List<String> scriptingLanguages = new ArrayList<>();
        scriptingLanguages.add("Python");
        scriptingLanguages.add("Ruby");
        scriptingLanguages.add("Perl");

        programmingLanguages.removeAll(scriptingLanguages);
        System.out.println("After removeAll(scriptingLanguages): " +programmingLanguages);

        programmingLanguages.removeIf(n -> (n.charAt (0) == 'C'));
        System.out.println("After Removing all elements that start with \"c\": " + programmingLanguages);

        //remove all elements from the arraylist
        programmingLanguages.clear();
        System.out.println("After clear(): " + programmingLanguages);
    }
}
