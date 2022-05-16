import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class IterateOverArrayListExample {
    public static void main(String[] args) {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Game of Thrones");
        tvShows.add("Friends");
        tvShows.add("Prison break");

        System.out.println("=== Iterate using Java 8 forEach an lambda ====");
        tvShows.forEach(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== iterate using an iterator() ===");
        Iterator<String> tvShowIteerator = tvShows.iterator();
        while(tvShowIteerator.hasNext()){
            String tvShow = tvShowIteerator.next();
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
        ListIterator<String> tvShowListIterator = tvShows.listIterator(tvShows.size());
//        while (tvShowIteerator.hasPrevious()){
//            String tvShow = tvShowIteerator.previous();
//            System.out.println(tvShow);
//        }

        System.out.println("\n=== Iterate using simple for- each loop ===");
        for (String tvShow : tvShows){
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using dor loop with index === ");
        for (int i = 0 ; i< tvShows.size(); i++){
            System.out.println(tvShows.get(i));
        }

    }
}
