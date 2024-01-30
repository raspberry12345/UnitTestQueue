public class Queue {
    private QueueItem head;
    private int index;

    public Queue() {
        index = 0;
    }

    public QueueItem getHead() {
        return head;
    }

    // start  method
    public void enqueue(int data) {
        QueueItem element = new QueueItem();
        element.setData(data);
        element.setNext(null);
        if(head == null){
            head = element;
        }else{
            QueueItem e = head;
            while(e.getNext() != null){
                e = e.getNext();
            }
            e.setNext(element);

        }
        index++;

    }
    // end push method

    // start size() method
    public int size() {
        return index;
    }
    // end size() method


    // start dequeue() method
    public int dequeue(){
        if(size() == 0){
            throw new RuntimeException();
        }else {
            QueueItem runElement = head;

            int saveReturnValue = runElement.getData();
            if (runElement.getNext() != null) {
                runElement = runElement.getNext();
                head = runElement;
                index--;
            }

            return saveReturnValue;
        }
    }
    // end dequeue() method


    // start dequeue() method multiple elements
    public int[] dequeue(int amount){

        if (amount > size()){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            int saveElementData[] = new int[amount];
            int count = 1;
            QueueItem runElement = head;
            boolean firstAccess = true;

            do {
                if (count <= amount){
                    saveElementData[count-1]= runElement.getData();

                    index--;
                }
                count++;
                runElement = runElement.getNext();
                if (count > amount && firstAccess){

                    head = runElement;
                    firstAccess = false;
                }
            }while(runElement.getNext() != null);

            return saveElementData;
        }
    }
    // end dequeue() method multiple elements


}
