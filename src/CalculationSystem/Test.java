package CalculationSystem;

// Тестовая функция, создает систему с 3 генераторами, вероятность генерации на каждом = 0.6
// Запускает эту систему на 10 тактов

public class Test {
    public static void main(String[] args) {
        CalculationSystem cs = new CalculationSystem(3, 0.6);
        cs.run(10);
    }
}
