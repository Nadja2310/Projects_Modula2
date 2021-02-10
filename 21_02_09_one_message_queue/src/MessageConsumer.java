public class MessageConsumer implements Runnable{
    OneItemStringQueue queue;
    int number;

    public MessageConsumer(OneItemStringQueue queue, int number) {
        this.queue = queue;
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {

            String item = null;
            try {
                item = queue.removeLast();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer " + number + " res " + item);
        }
    }
}
