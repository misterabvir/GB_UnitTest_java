package HM1.Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double input) {

        if(input < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }

        double epsilon = 1e-6;
        double result = input;
        while (Math.abs(result * result - input) > epsilon) {
            result = 0.5 * (result + input / result);
        }
        return result;
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if(purchaseAmount < 0) {
            throw new ArithmeticException("Purchase amount can't be less than 0");
        }
        if(discountAmount < 0 || discountAmount > 100){
            throw new ArithmeticException("Discount must be in range from 0 to 100");
        }

        return purchaseAmount - purchaseAmount / 100.0 * discountAmount;
    }
}