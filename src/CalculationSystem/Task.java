package CalculationSystem;

//Определяет заявку, хранит два слагаемых, номер заявки и поле для результата
//(инициализируется после вычисления в Computer)

public class Task {
    private static int globalNumber;  // номер последней заявки
    private final int number;
    private final int term1;
    private final int term2;
    private Integer result = null;

    public Task(int term1, int term2){
        this.number = globalNumber++;
        this.term1 = term1;
        this.term2 = term2;
    }
    
    public void run(){
        this.result = this.term1 + this.term2;   // "выполнение" заявки, инициализация результата
    }

    public void printGen(){   // вывод номера заявки (для отладки)
        System.out.print("Task № " + this.number + " / ");
    }

    public void printResult(){  // вывод всей заявки с результатом (для отладки)
        System.out.print("№ " + this.number + ": " + this.term1 + " + " + this.term2 + " = " + this.result + " / ");
    }
}
