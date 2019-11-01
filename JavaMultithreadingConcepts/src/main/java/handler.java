import threadInfo.ThreadDetails;

public class handler {
    public static void main(String[] args) {
        ThreadDetails.printThreadDetails(Thread.currentThread());
    }
}
