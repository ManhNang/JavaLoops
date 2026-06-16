import java.util.Random;

public class SecurityScannerOptimized {
    public static void main(String[] args) {
        int size = 1_000_000;
        String[] users = new String[size];
        int[] loginAttempts = new int[size];
        boolean[] isLocked = new boolean[size];
        Random random = new Random();

        int adminIndex = 1;
        for (int i = 0; i < size; i++) {
            if (i % 150 == 0) {
                users[i] = "ADMIN_" + adminIndex;
                adminIndex++;
            }
            // Giả lập dữ liệu nhiễu (null, BANNED, bị khóa)
            else if (i % 100 == 0) {
                users[i] = null; // Cứ mỗi 100 phần tử lại có 1 null
            } else if (i % 50 == 0) {
                users[i] = "BANNED_USER";
            } else {
                users[i] = "USER_" + i;
            }
            loginAttempts[i] = random.nextInt(10);
            isLocked[i] = random.nextBoolean();
        }

        System.out.println("--- BẮT ĐẦU QUÉT HỆ THỐNG ---");
        long startTime = System.nanoTime();

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null || users[i].startsWith("BANNED") || isLocked[i]) {
                continue;
            }
            if (loginAttempts[i] > 3) {
                System.out.println("Cảnh báo: " + users[i] + " sai mật khẩu " + loginAttempts[i] + " lần.");
            }
            if (users[i].startsWith("ADMIN")) {
                System.out.println("Đã tìm thấy Admin hệ thống: " + users[i]);
                break;
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Thời gian quét: " + (endTime - startTime) + " nano giây.");
    }
}
