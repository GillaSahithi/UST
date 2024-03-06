//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    static final int row = 6;
    static final int col = 6;
    static final int[] seatPrices = {60,80,100,120,140,160};
    static boolean[][] seatAvail = new boolean[row][col];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of seats to book: ");
        int num = sc.nextInt();
        sc.nextLine();

        String[] seatSelect = new String[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter seat(e.g., A1): ");
            seatSelect[i] = sc.nextLine().toUpperCase();

            while (!isValid(seatSelect[i]) || isSeatTaken(seatSelect[i])) {
                if (!isValid(seatSelect[i])) {
                    System.out.println("Invalid seat");
                }
                else {
                    System.out.println("Seat already taken");
                }
                System.out.print("Enter seat(e.g., A1): ");
                seatSelect[i] = sc.nextLine().toUpperCase();
            }
            markSeatAsTaken(seatSelect[i]);
        }
        int total = calculate(seatSelect);
        System.out.println("Total cost: " + total);
    }
    public static boolean isValid(String seat) {
        return seat.matches("[A-F][1-6]");
    }

    public static boolean isSeatTaken(String seat) {
        int r = seat.charAt(0) - 'A';
        int c = Integer.parseInt(seat.substring(1)) - 1;
        return seatAvail[r][c];
    }

    public static void markSeatAsTaken(String seat) {
        int r = seat.charAt(0) - 'A';
        int c = Integer.parseInt(seat.substring(1)) - 1;
        seatAvail[r][c] = true;
    }

    public static int calculate(String[] seatSelection) {
        int total = 0;
        for (String seat : seatSelection) {
            int row = seat.charAt(0) - 'A';
            total += seatPrices[row];
        }
        return total;
    }
}
