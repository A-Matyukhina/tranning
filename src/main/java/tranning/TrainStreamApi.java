package tranning;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TrainStreamApi {

    public void demoStream1(){
        // Задача. Для любого набора случайно сгенерированных чисел
        // нужно определить количество парных.

        // 1. Создать поток данных из случайного массива чисел
        List<Integer> arrInt = new ArrayList<Integer>();
        Random rnd = new Random();
        int number;
        for (int i = 0; i < 10; i++) {
            number = rnd.nextInt() % 100;
            arrInt.add(number);
        }
        System.out.println("Array arrInt: ");
        System.out.println(arrInt);
        // 2. Определить количество парных чисел (числа, которые делятся на 2).Способ 1.
        // 2.1. Создать поток из массива AL - метод stream()
        Stream<Integer> stream = arrInt.stream();
        // 2.2. Объявить ссылку на стандартный
        //      функциональный интерфейс Predicate<Integer>
        Predicate<Integer> fn;
        // 2.3. Присвоить ссылке лямбда-выражение, которое определяет есть ли число четным
        fn = (n -> n % 2 == 0);
        // 2.4. Вызвать метод filter, который виберет только парные  числа из потока stream
        Stream<Integer> resStream = stream.filter(fn);
        // 2.5. Вывести количество парных чисел
        System.out.println("n = " + resStream.count() );
        // 3. Определить количество парных чисел. Способ 2 - быстрый способ
        int n2 = (int)(arrInt.stream().filter((n) -> (n % 2) ==0)).count();
        System.out.println("n = " + n2);
    }
    public void demoStream2(){
        // Задача. Задано множество фамилий сотрудников.
        // Разработать программу, которая отображает все фамилии, начинающиеся на букву 'J'

        List<String> arrStr = new ArrayList<>();
        Faker faker = new Faker();
        int count = 0;
        for (int i = 0; i <= 30; i++) {
            arrStr.add(faker.name().lastName());
        }
        System.out.println(arrStr);
        // 3. Вычислить количество фамилий, которые начинаются на 'J'
        long result = arrStr.stream()
                .filter(str -> str.charAt(0) == 'M')
                .count();

        System.out.println("count of fullname, which starts with M is: " + result );
    }
}
