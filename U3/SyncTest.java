package U3;

import java.util.ArrayList;
import java.util.List;

public class SyncTest {
    public static void main(String[] args) {
         SyncStack stack = new SyncStack();
         Producer p1 = new Producer(stack);
         Thread prodT1 = new Thread (p1);
         prodT1.start();
         Producer p2 = new Producer(stack);
         Thread prodT2 = new Thread (p2);
         prodT2.start();

         Consumer c1 = new Consumer(stack);
         Thread consT1 = new Thread (c1);
         consT1.start();
         Consumer c2 = new Consumer(stack);
         Thread consT2 = new Thread (c2);
         consT2.start();
         }
}

class Producer implements Runnable {
private SyncStack theStack;
private int num;
private static int counter = 1;

 public Producer (SyncStack s) {
 theStack = s;
 num = counter++;
 }
    public void run() {
         char c;

         for (int i = 0; i < 200; i++) {
         c = (char)(Math.random() * 26 +'A');
             theStack.push(c);
             System.out.println("Producer" + num + ":" + c);
             try {
                 Thread.sleep((int)(Math.random() * 300));
                 } catch (InterruptedException e) {
                 // ignore it
                 }
             }
         } // END run method

       } // END Producer class

class Consumer implements Runnable {
 private SyncStack theStack;
 private int num;
 private static int counter = 1;

         public Consumer (SyncStack s) {
         theStack = s;
         num = counter++;
         }

    public void run() {
         char c;
         for (int i = 0; i < 200; i++) {
             c = theStack.pop();
             System.out.println("Consumer" + num + ": " + c);

             try {
                 Thread.sleep((int)(Math.random() * 300));
                 } catch (InterruptedException e) {
                 // ignore it
                 }
             }
         }
}


class SyncStack {
    private List<Character> buffer = new ArrayList<Character>(400);

    public synchronized char pop() {
        char c;
        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        c = buffer.remove(buffer.size()-1);
        return c;
    }

    public synchronized void push(char c) {
        this.notify();
        buffer.add(c);
    }
}