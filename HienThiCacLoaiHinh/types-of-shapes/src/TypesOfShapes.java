import java.util.Scanner;

public class TypesOfShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 4) {
            System.out.println("---MENU---");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("----------");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("----------");

            int l, w, side;
            switch (choice) {
                case 1:
                    System.out.println("Rectangle length: ");
                    l = scanner.nextInt();
                    System.out.println("Rectangle width: ");
                    w = scanner.nextInt();
                    System.out.println("----------");
                    for (int i = 0; i < l; i++) {
                        for (int j = 0; j < w; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Triangle side: ");
                    side = scanner.nextInt();
                    System.out.println("----------");
                    for (int i = 1; i <= side; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("----------");
                    for (int i = 0; i < side; i++) {
                        for (int j = side; j > i; j--) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("----------");
                    for (int i = 0; i < side; i++) {
                        for (int j = 0; j < side; j++) {
                            if (j < i) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.println("----------");
                    for (int i = 1; i <= side; i++) {
                        for (int j = 0; j < side; j++) {
                            if (j + i < side) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Triangle height: ");
                    side = scanner.nextInt();
                    System.out.println("----------");
                    for (int i = 1; i <= side; i++) {
                        for (int j = 1; j <= (side - i) * 2; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("No choice!");
                    break;
            }
        }
    }
}
