import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {

        printTask();
        Scanner scanner = new Scanner(System.in);
        int numberTask = scanner.nextInt();
        chooseAndCompleteTask(numberTask, args);
        scanner.close();
    }

    private static void printTask(){
        System.out.println("Введите число соответствующее номера задания:" + "\n" +
                "1: Приветствовать любого пользователя при вводе его имени через командную строку." + "\n" +
                "2: Отобразить в окне консоли аргументы командной строки в обратном порядке." + "\n" +
                "3: Вывести заданное количество случайных чисел с переходом и без перехода на новую строку" + "\n" +
                "4: Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и " +
                "вывести результат на консоль." + "\n" +
                "5: Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. " +
                "Осуществить проверку корректности ввода чисел." + "\n");
    }

    private static void chooseAndCompleteTask(int numberTask , String [] args){
        switch (numberTask){
            case 1:
                greetUser();
                break;
            case 2:
                argumentsCommandLineInReverseOrder(args);
                break;
            case 3:
                outputRandomNumbers();
                break;
            case 4:
                wholeNumbersArgumentsCommandLineSumAndMultiply(args);
                break;
            case 5:
                getMonth();
                break;
            default:
                throw new IllegalArgumentException("Не корректно введен номер задания");
        }

    }

    private static void greetUser(){
        Scanner scannerNameUser = new Scanner(System.in);
        String nameUser = scannerNameUser.next();
        System.out.println("Hello " + nameUser + "!");
        scannerNameUser.close();
    }

    private static void argumentsCommandLineInReverseOrder(String [] commandArgs){
        System.out.println("Reverse orger arguments: ");
        for(int i = commandArgs.length - 1; i >= 0; i--){
            System.out.println(commandArgs[i]);
        }
    }

    private static void outputRandomNumbers(){
        int countNumbers = 5;
        int[] array = new int[countNumbers];
        System.out.println("5 random numbers from new line");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()* 20 - 10);
            System.out.println(array[i]);
        }
        System.out.println("5 random numbers inline");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    private static void wholeNumbersArgumentsCommandLineSumAndMultiply(String [] commandArgs){
        int sum = 0, multiplication = 1;
        int [] arrayNumbers = new int[commandArgs.length];
        for (int i = 0; i < arrayNumbers.length - 1; i++) {
            arrayNumbers[i] = Integer.parseInt(commandArgs[i]);
            sum += arrayNumbers[i];
            multiplication *= arrayNumbers[i];
        }
        System.out.println("Sum numbers = " + sum + "!\n"
                + "Multiply numbers = " + multiplication + "!"
        );
    }

    private static void getMonth(){
        Scanner scannerNumberMonth = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");
        int numberMonth = scannerNumberMonth.nextInt();
        String[] month = {"январь", "феваль", "март", "апрель", "май", "июнь",
                "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        String s;
        try {
            s = month[numberMonth - 1];
            System.out.println("Месяц под этим номером - " + s + ".");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Такого месяца не существует");
        }
        scannerNumberMonth.close();
    }
}
