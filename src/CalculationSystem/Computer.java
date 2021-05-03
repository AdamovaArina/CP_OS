package CalculationSystem;

import java.util.Random;

// обработчик заявок

public class Computer {
    private static final int LOW = 3;  // нижняя граница времени обработки заявки
    private static final int HIGH = 5;  // верхняя граница (выбраны для получения приемлемого результата)

    private static Random gen = new Random();

    private int time;   // время обработки текущей заявки (генерируется случайно)
    private int finishTime;  // время окончания обработки текущей заявки
    private Task currTask;

    public void setTask(Task currTask, int currTime){  // подача заявки в обработку, передаем текущее время системы
        this.time = LOW + gen.nextInt(HIGH - LOW);
        this.currTask = currTask;
        this.finishTime = currTime + this.time;
    }

    public Task calculate(int currTime){   // обработка заявки и удаление ее из компьютера (если прошло заданное время)
        if (this.currTask != null){
            if (currTime == this.finishTime){
                this.currTask.run();
                Task result = this.currTask;
                this.currTask = null;
                this.time = 0;
                this.finishTime = 0;
                return result;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return (this.currTask == null);
    }

    public void printComp(){   // вывод заявки, обрабатываемой компьютером (для отладки)
        if (this.currTask != null){
            this.currTask.printGen();
        } else {
            System.out.print("Empty computer / ");
        }

    }
}
