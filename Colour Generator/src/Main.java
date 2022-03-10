import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many colours would you like to generate? ");
        int num = sc.nextInt();

        System.out.print(colours(num));
    }

    public static StringBuilder colours(int num) {
        String s = "0123456789ABCDEF";
        StringBuilder codes = new StringBuilder();
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < 6; j++) {
                Random random = new Random();
                int index = random.nextInt(s.length());
                codes.append(s.charAt(index));
            }
            codes.append("\n");
        }
        return codes;
    }
}
