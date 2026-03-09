package BaiTapSession03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Java_Session03_03 {
    private static String check_salary(int n) {
        if (n < 5000000) return "Thu nhập thấp";
        if (n < 15000000) return "Thu nhập trung bình";
        if (n < 50000000) return "Thu nhập khá";
        return "Thu nhập cao";
    }
    private static double check_bonus(int n) {
        if (n < 5000000) return 0.05;
        if (n < 15000000) return 0.1;
        if (n < 50000000) return 0.15;
        if (n < 100000000) return 0.2;
        return 0.25;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");
        int cnt = 0;
        int sum_salary = 0;
        int sum_bonus = 0;
        int max_salary = -1;
        int min_salary = 500000001;
        while(true) {
            System.out.println("========== MENU ==========");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int T = sc.nextInt();
            switch (T) {
                case 1:
                    System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                    while (true) {
                        System.out.print("Nhập lương: ");
                        int n = sc.nextInt();
                        if (n >= 0 && n <= 500000000) {
                            cnt++;
                            sum_salary += n;
                            sum_bonus += (int)((double)n*check_bonus(n));
                            if (n > max_salary) {
                                max_salary = n;
                            }
                            if (n < min_salary) {
                                min_salary = n;
                            }
                            System.out.println("-> Phân loại: " + check_salary(n));
                        }
                        else if (n == -1) {
                            break;
                        }
                        else {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                        }
                    }
                    break;
                case 2:
                    if (cnt == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    }
                    else {
                        System.out.println("--- Thống kê ---");
                        System.out.println("Số nhân viên: " + cnt);
                        System.out.println("Tổng lương: " + df.format(sum_salary));
                        System.out.println("Lương trung bình: " + df.format(sum_salary / cnt));
                        System.out.println("Lương cao nhất: " + df.format(max_salary));
                        System.out.println("Lương thấp nhất: " + df.format(min_salary));
                    }
                    break;
                case 3:
                    System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
                    System.out.println("Tổng tiền thưởng nhân viên: "+df.format(sum_bonus));
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Không tồn tại trong MENU. Nhập lại.");
            }
        }
    }
}
