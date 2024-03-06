import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ввод количества гостей
        System.out.println("На скольких гостей требуется разделить счет?");
        Scanner scanner = new Scanner(System.in);
        int guests;
        while (true){
            String input = scanner.nextLine();
            try{
                guests = Integer.parseInt(input);
                if (guests <= 1) System.out.println("Введите корректное число гостей!!!");
                else break;
            }
            catch (Exception e) {System.out.println("Введите корректное число гостей!!!");}
        }


        // Добавление товаров
        Calculator calc = new Calculator(guests);
        String input;
        do {
            // Печать текущих товаров
            calc.printProducts();
            System.out.println("-------------------------------");

            System.out.println("Введите название товара и его стоимость(<Товар> <рубли.копейки>): ");
            scanner.nextLine();
            input = scanner.nextLine();
            String[] splitted = input.split(" ");
            try {
                double price = Double.parseDouble(splitted[1]);
                if (price >= 0) calc.addProduct(splitted[0], price);
                else System.out.println("Некорректная стоимость товара");
            }
            catch (Exception e){
                System.out.println("Некорректная стоимость товара");
            }
            finally{
                System.out.println("Для того, чтобы прекратить добавление товаров, введите \"Завершить\".\nИначе введите любой символ.");
                input = scanner.next();
            }
        }while (!input.equalsIgnoreCase("завершить"));

         System.out.println("-------------------------------");
         calc.printResult();
    }
}