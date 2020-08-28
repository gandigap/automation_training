import java.util.Scanner;

public class OptionalTask1 {
    public static void main(String[] args) {
        int [] arrayNumbers = inputNumbers();
        printArray(arrayNumbers);
        chooseAndCompleteTask(arrayNumbers);
    }

    private static void chooseAndCompleteTask(int [] arrayNumbers){
        System.out.println("Введите число соответствующее номеру задания:" + "\n" +
                "1: Найти самое короткое и самое длинное число. Вывести найденные числа и их длину." + "\n" +
                "2: Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины." + "\n" +
                "3: Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину." + "\n" +
                "6: Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number){
            case 1:
                findAndOutputMaxMinLengthNumbers(arrayNumbers);
                break;
            case 2:
                sortArrayNumbersOrderTheirLength(arrayNumbers);
                break;
            case 3:
                printNumbersWhoseLengthIsLessMoreThanTheAverage(arrayNumbers);
                break;
            case 6:
                numberInWhichTheDigitsAreInStrictAscendingOrder(arrayNumbers);
                break;
            default:
                throw new IllegalArgumentException("Не корректно введен номер задания");
        }
        scan.close();
    }

    private static void printArray(int [] arrayNumbers) {
        System.out.print("Массив чисел: ");
        for (int i = 0; i < arrayNumbers.length; i++){
            System.out.print(arrayNumbers[i] + " ");
        }
        System.out.println();
    }

    private static int [] inputNumbers() {
        Scanner scannerNumbers = new Scanner(System.in);
        System.out.print("Введите количество чисел:");
        int numberOfDigits = scannerNumbers.nextInt();
        int [] arrayNumbers = new int[numberOfDigits];
        for (int i = 0; i < numberOfDigits; i++){
            System.out.print("Введите число: ");
            arrayNumbers[i] = scannerNumbers.nextInt();
        }
        return  arrayNumbers;
    }

    private static void findAndOutputMaxMinLengthNumbers(int [] arrayNumbers){
        int max, max_i, min, min_i;
        String stringRepresentationOfANumber = String.valueOf(arrayNumbers[0]); //String.valueOf(Math.abs(arrayNumbers[0]))
        max = min = stringRepresentationOfANumber.length();
        max_i = min_i = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            stringRepresentationOfANumber = String.valueOf(arrayNumbers[i]);
            if(max < stringRepresentationOfANumber.length()){
                max = stringRepresentationOfANumber.length();
                max_i = i;
            } else if (min > stringRepresentationOfANumber.length()){
                min = stringRepresentationOfANumber.length();
                min_i = i;
            }
        }
        System.out.println("Самое длинное число: " + arrayNumbers[max_i] + ", его длина :" + max + " символов!");
        System.out.println("Самое короткое число :" + arrayNumbers[min_i] +  ", его длина :" + min + " символов!");
    }

    private static void sortArrayNumbersOrderTheirLength(int [] arrayNumbers){
        for(int i=0; i < arrayNumbers.length; i++){
            for(int j=0; j < arrayNumbers.length; j++){
                String stringRepresentationOfANumberI = String.valueOf(arrayNumbers[i]);           ////Преобразуем числа в строки
                String stringRepresentationOfANumberJ = String.valueOf(arrayNumbers[j]);           ////Преобразуем числа в строки
                if(stringRepresentationOfANumberI.length() > stringRepresentationOfANumberJ.length())                                         ////Находим и сравниваем длину чисел
                {
                    int number = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[i];
                    arrayNumbers[i] = number;
                }
            }
        }

        System.out.println("Массив в порядке убывания длины:" );
        printArray(arrayNumbers);

        for(int i=0; i<arrayNumbers.length; i++){
            for(int j=0; j<arrayNumbers.length; j++){
                String stringRepresentationOfANumberI = String.valueOf(arrayNumbers[i]);           ////Преобразуем числа в строки
                String stringRepresentationOfANumberJ = String.valueOf(arrayNumbers[j]);           ////Преобразуем числа в строки
                if(stringRepresentationOfANumberI.length() < stringRepresentationOfANumberJ.length())                                         ////Находим и сравниваем длину чисел
                {
                    int number = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[i];
                    arrayNumbers[i] = number;
                }
            }
        }

        System.out.println("Массив в порядке возростания длины:" );
        printArray(arrayNumbers);

    }

    private static void printNumbersWhoseLengthIsLessMoreThanTheAverage(int [] arrayNumbers){
        int average, sum = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            String stringRepresentationOfANumber = String.valueOf(arrayNumbers[i]);
            sum += stringRepresentationOfANumber.length();
        }
        average = sum / arrayNumbers.length;
        System.out.println("Средняя длина числа: " + average);
        System.out.println("Числа, длина которых больше средней:");
        for (int i = 0; i < arrayNumbers.length; i++) {
            String stringRepresentationOfANumber = String.valueOf(arrayNumbers[i]);
            if( stringRepresentationOfANumber.length() > average){
                System.out.println(arrayNumbers[i] + " - длина: " + stringRepresentationOfANumber.length());
            }
        }
        System.out.println();
        System.out.println("Числа длина которых меньше средней:");
        for (int i = 0; i < arrayNumbers.length; i++) {
            String stringRepresentationOfANumber = String.valueOf(arrayNumbers[i]);
            if( stringRepresentationOfANumber.length() < average){
                System.out.println(arrayNumbers[i] + " - длина: " + stringRepresentationOfANumber.length());
            }
        }
        System.out.println();
    }

    private static void numberInWhichTheDigitsAreInStrictAscendingOrder(int [] arrayNumbers){
        boolean order= false;
        int number = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            int numeral = 0;
            if(Math.abs(arrayNumbers[i]) > 9) {
                String stringRepresentationOfANumber = String.valueOf(arrayNumbers[i]);
                number = arrayNumbers[i];
                for (int k = 0; k < stringRepresentationOfANumber.length(); k++) {
                    if (numeral < Character.getNumericValue(stringRepresentationOfANumber.charAt(k))) {
                        numeral = Character.getNumericValue(stringRepresentationOfANumber.charAt(k));
                        order = true;
                    } else {
                        order = false;
                        break;
                    }
                }
            }
            if(order){
                break;
            }
        }
        System.out.println(order ?
                "Число, цифры в котором идут в строгом порядке возрастания:" + number :
                "Числа, цифры в котором идут в строгом порядке возрастания нет!");
        System.out.println();
    }
}
