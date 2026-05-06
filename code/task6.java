import java.util.Random;

public class task6 {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] numbers = new int[12000];
        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        long[] sums = new long[numThreads];
        
        for (int i = 0; i < 12000; i++) {
            numbers[i] = random.nextInt(100);
        }

        int chunkSize = (numbers.length + numThreads - 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            final int start = threadIndex * chunkSize;
            final int end = Math.min(start + chunkSize, numbers.length);

            threads[threadIndex] = new Thread(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += numbers[j];
                }
                sums[threadIndex] = localSum;
            });
            threads[threadIndex].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long total = 0;
        for (int i = 0; i < numThreads; i++) {
            total += sums[i];
        }

        System.out.println("Итоговая сумма: " + total);
    }
}
