public class Main {

    public static void main(String ... args) {
        Address address = new Address("Toto", "Tata", 110);
        System.out.println(address.getPostCode().get());
    }
}
