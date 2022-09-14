import java.util.Scanner;
public class Calc {
    static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        int inp1, inp2;
        char oper;
        oper = '0';
        int countOper = 0;
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
        String inpUser = scanner.nextLine();
        char[] inUserChar = inpUser.toCharArray();


        for(int i =0; i < inpUser.length();i++){
            if (inUserChar[i] == '+'){
                oper = '+';
                countOper += 1;
            }
            if (inUserChar[i] == '-'){
                oper = '-';
                countOper += 1;
            }
            if (inUserChar[i] == '*'){
                oper = '*';
                countOper += 1;
            }
            if (inUserChar[i] == '/'){
                oper = '/';
                countOper += 1;
            }

        }
        // Исключение если есть два операнда
        if (countOper > 1){
            throw new Exception();
        }

        //System.out.println(countOper);
        //System.out.println(oper);
        //находим два числа
        String[] razdelInpUser = inpUser.split("[+-/*]");

        String num1 = razdelInpUser[0];
        String num2 = razdelInpUser[1];

        if (isNumeric(num1) && isNumeric(num2)){
            inp1 = Integer.parseInt(num1);
            inp2 = Integer.parseInt(num2);
            System.out.println(calculate(inp1, inp2, oper));
        } else if (!isNumeric(num1) && !isNumeric(num2)) {
            inp1 = convertRomeNum(num1.toUpperCase());
            if (inp1 < 0){
                throw new Exception();
            }
            inp2 = convertRomeNum(num2.toUpperCase());
            if (inp2 < 0){
                throw new Exception();
            }
            int res = calculate(inp1, inp2, oper);
            if (res > 0){
                System.out.println(roman[res]);
            }
            else{
                throw new Exception();
            }
        }
        else {
            throw new Exception();
        }
    }
    public static int calculate(int n1, int n2, char op) throws Exception {
        int res = 0;
        switch (op) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '/':
                if (n1 != 0 || n2 != 0) {
                    res = n1 / n2;
                    break;
                } else {
                    throw new Exception();
                }

        }
        return res;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    
    private static int convertRomeNum(String inpRome){

        for(int i = 0; i < roman.length; i++){
            if (inpRome.equals(roman[i])){
                return i;
            }
        }
        return -1;
    }

}
