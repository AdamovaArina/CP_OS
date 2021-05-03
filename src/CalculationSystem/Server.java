package CalculationSystem;

// сервер содержит в себе очередь и массив обработчиков заявок

public class Server {
    public static final int SIZE = 5;

    private Computer[] computers;
    private Queue queueOfTasks = new Queue();

    public Server(int numOfComp){
        this.computers = new Computer[numOfComp];
        for (int i = 0; i < numOfComp; i++){
            this.computers[i] = new Computer();
        }
    }

    public Server(){
        this(SIZE);
    }

    public void nextStep(int currTime, Generator[] gens){  // функция, выполняемая сервером на каждом такте
        this.pushQueue(gens);                              // см. функции ниже (все выводы на экран только
        System.out.println("Result on step " + currTime + ":"); // для отладки)
        this.result(currTime);

        this.computerCheck(currTime);

        System.out.println("Queue on step " + currTime + ":");
        this.queueOfTasks.printQueue();
        System.out.println();

        System.out.println("Computers on step " + currTime + ":");
        for (int i = 0; i < computers.length; i++){
            computers[i].printComp();
        }
        System.out.println();

        System.out.println();
    }

    public void pushQueue(Generator[] gens){   // проверяем содержимое сокетов, если там что-то есть,
        for (int i = 0; i < gens.length; i++){ // добавляем в очередь
            Task currentTask = gens[i].getSocket().getTask();
            if (currentTask != null){
                this.queueOfTasks.push(currentTask);
            }
        }

    }

    public void result(int currTime){    // если есть обработанные заявки, выводим результат на экран
        for (int i = 0; i < this.computers.length; i++){
            Task curr = computers[i].calculate(currTime);
            if (curr != null) {
                curr.printResult();
            }
        }
        System.out.println();
    }

    public void computerCheck(int currTime){   // если есть освободившиеся компьютеры, передаем в них заявки
        for (int i = 0; i < this.computers.length; i++){  // из очереди
            if (this.computers[i].isEmpty()){
                if (!this.queueOfTasks.isEmpty()){
                    this.computers[i].setTask(this.queueOfTasks.pop(), currTime);
                }
            }
        }
    }
}
