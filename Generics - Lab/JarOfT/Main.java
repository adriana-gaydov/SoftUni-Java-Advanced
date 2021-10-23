package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(2);
        jar.add(2);

        Integer a = jar.remove();
    }
}
