package volpini;

import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String c = "A";
        Studente s = new Studente("Tizio","caio",17,c.charAt(0));
        System.out.println(s.toString());
    }
}
