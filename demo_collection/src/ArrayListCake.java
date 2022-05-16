import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
class Cake {
    private String CakeName;
    private int price;
    private String Country;

    public Cake(String cakeName, String Country, int price) {
        CakeName = cakeName;
        this.price = price;
        this.Country = Country;
    }

    public String getCakeName() {
        return CakeName;
    }

    public void setCakeName(String cakeName) {
        CakeName = cakeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "CakeName='" + CakeName + '\'' +
                ", price=" + price +
                ", Country='" + Country + '\'' +
                '}';
    }
}
    public class ArrayListCake{
        public static void main(String[] args) {
            List<Cake> cakes = new ArrayList<>();
            cakes.add(new Cake("Mochi", "Japan", 5000));
            cakes.add(new Cake("Tiramisu", "Italia", 3000));
            cakes.add(new Cake("Macaron", "France", 3500));

            cakes.forEach(cake -> {
                System.out.println("Name: " + cake.getCakeName() + ", Country: " + cake.getCountry() + ", Price: " + cake.getPrice());
            });
            System.out.println("-------------------------");
            List<Cake> cakes2 = new ArrayList<>(cakes);

            List<Cake> Nextcake = new ArrayList<>();
            Nextcake.add(new Cake("Pavlova", "Australia", 4000));
            Nextcake.add(new Cake("Black Forest", "Gremany", 3500));

            cakes2.addAll(Nextcake);
            System.out.println(cakes2);
            cakes2.sort((cake1, cake2) -> {
                return cake1.getPrice() - cake2.getPrice();
            });
            cakes2.sort(Comparator.comparing(Cake::getPrice));
            System.out.println("List cake by price : " + cakes2);
        }
    }

