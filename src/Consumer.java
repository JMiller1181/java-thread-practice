public class Consumer extends Thread{
    private SharedBuffer buffer;
    private int sum;
    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            sum += buffer.getNumberFromBuffer();
            System.out.println("Running sum: " + sum);
        }
        System.out.println("The sum is: " + sum);
    }
}
