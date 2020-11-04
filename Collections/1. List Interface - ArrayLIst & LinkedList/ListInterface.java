import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListInterface {
    long startTime, endTime, startTime2, endTime2;

    public void findComparison() {
        

        List<Integer> intArrayList = new ArrayList<>();
        List<Integer> intLinkedList = new LinkedList<>();

        for(int i=0; i<50000; i++) {
            int temp = random.nextInt(1000000);

            intArrayList.add(temp);

            intLinkedList.add(temp);

        }

         // insert xperiment
        for(int i=0; i<30; i++) {
            int temp = random.nextInt(1000000);

            startTime = System.nanoTime();
            intArrayList.add(25000, temp);
            endTime = System.nanoTime();
            System.out.print((endTime-startTime)+"\t");

            startTime2 = System.nanoTime();
            intLinkedList.add(25000, temp);
            endTime2 = System.nanoTime();
            System.out.println((endTime2-startTime2));
        }

        for(int i=0; i<30; i++) {
            int temp = random.nextInt(1000000);

            startTime = System.nanoTime();
            intArrayList.add(temp);
            endTime = System.nanoTime();
            System.out.print((endTime-startTime)+"\t");

            startTime2 = System.nanoTime();
            intLinkedList.add(temp);
            endTime2 = System.nanoTime();
            System.out.println((endTime2-startTime2));
        }

        //remove experiment
//        int rindex = 49999;  // 0, 25000, 49000, 49999
//        for(int i=0; i<30; i++) {
//
//            startTime = System.nanoTime();
//            intArrayList.remove(rindex);
//            endTime = System.nanoTime();
//            System.out.print((endTime-startTime)+"\t");
//
//            startTime2 = System.nanoTime();
//            intLinkedList.remove(rindex);
//            endTime2 = System.nanoTime();
//            System.out.println((endTime2-startTime2));
//            rindex--;
//        }

        // Get element by index
//        int sindex = 45000; // 10000, 45000
//        for(int i=0; i<30; i++) {
//
//            startTime = System.nanoTime();
//            intArrayList.get(sindex);
//            endTime = System.nanoTime();
//            System.out.print((endTime-startTime)+"\t");
//
//            startTime2 = System.nanoTime();
//            intLinkedList.remove(sindex);
//            endTime2 = System.nanoTime();
//            System.out.println((endTime2-startTime2));
//            sindex++;
//        }

        // search by value
//        int index = 5000;
//        for(int i=0; i<30; i++) {
//            intArrayList.add(index, 999);
//            intLinkedList.add(index, 999);
//
//            startTime = System.nanoTime();
//            intArrayList.indexOf(999);
//            endTime = System.nanoTime();
//            System.out.print((endTime-startTime)+"\t");
//
//            startTime2 = System.nanoTime();
//            intLinkedList.indexOf(999);
//            endTime2 = System.nanoTime();
//            System.out.println((endTime2-startTime2));
//        }

    }
}
