package CalculationSystem;

// очередь заявок

public class Queue {
    private Element head;
    private Element tail;

    private static class Element {
        private Task content;
        private Element next;

        public Element(Task content) {
            this.content = content;
        }
    }

    public void push(Task current) {  // добавление элемента в очередь
        Element currElement = new Element(current);
        if (this.isEmpty()) {
            this.head = currElement;
            this.tail = currElement;
        } else {
            tail.next = currElement;
            tail = currElement;
        }
    }

    public Task pop() {   // извлечение элемента из очереди
        Task current = null;
        if (!this.isEmpty()){
            if (this.head == this.tail){
                current = this.head.content;
                this.head = null;
                this.tail = null;
            } else {
                current = this.head.content;
                this.head = this.head.next;
            }
        }
        return current;
    }

    public boolean isEmpty(){
        return (this.head == null);
    }

    public void printQueue(){   // вывод содержимого очереди (для отладки)
        Element curr = this.head;
        while(curr != null){
            curr.content.printGen();
            curr = curr.next;
        }
    }
}
