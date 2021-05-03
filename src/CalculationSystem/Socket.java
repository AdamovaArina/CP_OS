package CalculationSystem;

public class Socket {
    private Task content;

    public void setTask(Task content){
        this.content = content;
    }  // получение заявки сокетом

    public Task getTask(){
        return this.content;
    }  // выдача заявки в обработку (в очередь)

    public void printTask(){   // вывод содержимого сокета (для отладки)
        if (content == null){
            System.out.print("Empty generator / ");
        } else{
            content.printGen();
        }

    }
}

