import java.util.Scanner;

public class CharacterCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter characters: ");
        String s = sc.nextLine();
        int n = s.length();

        // There are 2^n possible combinations
        int total = 1 << n;

        System.out.println("All combinations:");
        for (int i = 0; i < total; i++) {
            StringBuilder current = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // If the j-th bit of i is set, include the j-th character
                if ((i & (1 << j)) != 0) {
                    current.append(s.charAt(j));
                }
            }
            if (current.length() == 0) {
                System.out.println("{}"); // Empty set
            } else {
                System.out.println(current);
            }
        }
        sc.close();
    }
}
