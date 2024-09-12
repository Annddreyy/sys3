import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Константы для минимального и максимального номера команды
        final int MIN_COMMAND_NUMBER = 1;
        final int MAX_COMMAND_NUMBER = 16;

        Scanner in = new Scanner(System.in);

        // Ввод числа N
        System.out.println("Введите N: ");
        int N = in.nextInt();

        if (N > 100) {
            System.out.println("Слишком большое количество голосов. При голосовании будут учитаны первые 100.");
            N = 100;
        }

        // Создание и первичная инициализация словаря
        HashMap<Integer, Integer> numbersCount = new HashMap<>();
        for (int i = MIN_COMMAND_NUMBER; i <= MAX_COMMAND_NUMBER; i++) numbersCount.put(i, 0);

        // Ввод чисел и добавление новых чисел в словарь
        System.out.println("Введите числа: ");
        for (int i = 0; i < N; i++) {
            int number = in.nextInt();
            while (!(number <= MAX_COMMAND_NUMBER && number >= MIN_COMMAND_NUMBER)) {
                System.out.println("Вы ввели некорректное число! Введите заново: ");
                number = in.nextInt();
            }
            numbersCount.put(number, numbersCount.get(number) + 1);
        }

        numbersCount
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(item -> System.out.printf(item.getKey() + " " + item.getValue() + "\n"));
    }
}