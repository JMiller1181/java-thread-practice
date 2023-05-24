import java.util.Random;

public class Producer extends Thread {
    private SharedBuffer buffer;
    public Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            buffer.addToBuffer(random.nextInt(1,100));
        }
    }
}
