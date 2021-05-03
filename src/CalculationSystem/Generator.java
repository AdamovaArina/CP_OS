package CalculationSystem;

import java.util.Random;

// генератор заявок, выдает новую заявку с некоторой вероятностью на каждом такте

public class Generator {
    public static final double DEFAULT = 0.25;  // вероятность генерации заявки по умолчанию
    public static final int MIN = 1;  // нижняя граница слагаемых
    public static final int MAX = 100;  // верхняя граница (для получения приемлемого результата)

    private static Random gen = new Random();

    private double probability;
    private Socket sock = new Socket();;

    public Generator(double probability){
        this.probability = probability;
    }

    public Socket getSocket(){
        return this.sock;
    }

    public void generate(){
        double currProbability = gen.nextDouble();  // создаем случайное число от 0 до 1
        Task currTask = null;
        if (currProbability < this.probability){    // если случайное число меньше заданной вероятности,
                                                    // генерируется заявка
            int term1 = MIN + gen.nextInt(MAX - MIN);
            int term2 = MIN + gen.nextInt(MAX - MIN);
            currTask = new Task(term1, term2);
        }
        this.sock.setTask(currTask);  // передаем созданную заявку в сокет
        this.sock.printTask();   // вывод содержимого сокета (для отладки)
    }
}
