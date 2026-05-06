import java.util.Random;

public class task5 {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] numbers = new int[12000];
        int numThreads = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThreads];
        int[] maxValues = new int[numThreads];

        for (int i = 0; i < 12000; i++) {
            numbers[i] = random.nextInt(100000);
        }

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                maxValues[threadIndex] = numbers[0];
                for (int j = threadIndex; j < numbers.length; j += numThreads) {
                    if (numbers[j] > maxValues[threadIndex]) {
                        maxValues[threadIndex] = numbers[j];
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = maxValues[0];
        for (int i = 1; i < numThreads; i++) {
            if (maxValues[i] > result) {
                result = maxValues[i];
            }
        }

        System.out.println("Максимальный элемент: " + result);
        System.out.println("Количество потоков: " + numThreads);
    }
}
