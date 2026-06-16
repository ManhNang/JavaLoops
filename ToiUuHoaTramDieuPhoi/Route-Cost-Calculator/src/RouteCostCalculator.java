import java.util.Random;

class FuelConfig {
    public double getBasePrice() {
        return 22500.0; // Giá xăng cơ bản
    }
}

public class RouteCostCalculator {
    private static double calculateHeavyTaxRate() {
        return 1.1;
    }

    public static double calculateRouteCostOptimized(double[] distances, double maxBudget) {
        double totalCost = 0;

        System.out.println("Bắt đầu tính toán lộ trình...");
        long startTime = System.currentTimeMillis();

        FuelConfig config = new FuelConfig();
        double currentTax = calculateHeavyTaxRate();
        double stepCost = 0;

        for (int i = 0; i < distances.length; i++) {
            stepCost = distances[i] * config.getBasePrice() * currentTax;
            totalCost += stepCost;

            if (totalCost > maxBudget) {
                System.out.println("Chi phí đã vượt quá ngân sách!");
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian chạy (Legacy): " + (endTime - startTime) + " ms");

        return totalCost;
    }

    public static void main(String[] args) {
        double[] testDistances = new double[1_000_000];
        Random random = new Random();

        for (int i = 0; i < testDistances.length; i++) {
            testDistances[i] = random.nextDouble(5);
        }

        double maxBudget = 100000000.5;
        double totalCost = calculateRouteCostOptimized(testDistances, maxBudget);
        System.out.println("Tổng chi phí: ");
        System.out.printf("%.2f\n", totalCost);
    }
}
