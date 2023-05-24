import java.util.ArrayList;

public class SharedBuffer {
    private ArrayList<Integer> bufferStorage;
    private int sizeLimit;

    public SharedBuffer(int sizeLimit) {
        this.sizeLimit = sizeLimit;
        this.bufferStorage = new ArrayList<>();
    }
    public synchronized void addToBuffer(int randomNum) {
        while(bufferStorage.size() >= sizeLimit){
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
            bufferStorage.add(randomNum);
            System.out.println(bufferStorage);
            notifyAll();
    }
    public synchronized int getNumberFromBuffer(){
        int num;
        while (bufferStorage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
            num = bufferStorage.remove(0);
            System.out.println(bufferStorage);
            notifyAll();
            return num;
    }
}
