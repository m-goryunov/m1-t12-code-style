import java.util.Scanner;

public class DepositCalculator {

    double сalculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double сalculateSimplePercent(double depositAmount, double yearlyRate, int depositPeriod) {
        return round(depositAmount + depositAmount * yearlyRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void calculateDeposit() {
        int depositPeriod;
        int depositType;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом," + " 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double out = 0;
        if (depositType == 1) {
            out = сalculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            out = сalculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
