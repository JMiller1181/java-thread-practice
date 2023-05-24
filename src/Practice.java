public class Practice {
    public static void main(String[] args){
        SharedBuffer sharedBuffer = new SharedBuffer(5);
        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
