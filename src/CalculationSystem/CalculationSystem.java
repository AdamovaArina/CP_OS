package CalculationSystem;

// вся система включает в себя массив генераторов заявок и сервер, который их обрабатывает

public class CalculationSystem {
    public static final int SZ = 5;

    private Server serv;
    private Generator[] generators;

    public CalculationSystem(int size, double prob){
        this.serv = new Server();
        this.generators = new Generator[size];
        for (int i = 0; i < size; i++){
            this.generators[i] = new Generator(prob);
        }
    }

    public CalculationSystem(){
        this(SZ, Generator.DEFAULT);
    }

    public void run(int it){  // it - количество итераций (тактов машинного времени), на которое мы хотим
        for (int i = 0; i < it; i++){  // запустить систему
            System.out.println("Generators on step " + i + ":");
            for (int j = 0; j < generators.length; j++){
                generators[j].generate();
            }
            System.out.println();
            serv.nextStep(i, this.generators);
        }
    }
}
