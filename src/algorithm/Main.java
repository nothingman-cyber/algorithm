package algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("题目");
        AtomicInteger i = new AtomicInteger(12);
        i.addAndGet(12);
    }

}
