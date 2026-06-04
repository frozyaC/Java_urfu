import java.util.Arrays;
import java.util.Scanner;

public class timus1642 {

    public static int StepsCounter (int startPosition, int exitCoordinate, int closestObstacleLessThanZero, int closestObstacleGreaterThanZero, boolean positiveDirection) {
        int steps = 0;
        int x = 0;
        int obstacleCounter = 0;
        int direction;
        if (positiveDirection) {
            direction = 1;
        } else {
            direction = -1;
        }
        while (obstacleCounter < 2) {
            steps++;
            x += direction;
            if (x == exitCoordinate) {
                return steps;
            } else if (x == closestObstacleGreaterThanZero || x == closestObstacleLessThanZero) {
                obstacleCounter++;
                steps = steps * 2;
                x = 0;
                direction = -direction;
            }     
        }
        return 99999;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во препятствий и координату точки выхода через пробел");
        int numberOfObstacles = in.nextInt();
        int exitCoordinate = in.nextInt();
        int[] obstacles = new int[numberOfObstacles];
        System.out.println("Введите координаты препятствий через пробел");
        for (int i = 0; i < numberOfObstacles; i++) {
            obstacles[i] = in.nextInt();
        }
        int closestObstacleLessThanZero = -1000000000;
        int closestObstacleGreaterThanZero = 1000000000;
        Arrays.sort(obstacles);
        for (int obstacle: obstacles) {
            if ((obstacle < 0) && (obstacle > closestObstacleLessThanZero)) {
                closestObstacleLessThanZero = obstacle;
            } else if ((obstacle > 0) && (obstacle < closestObstacleGreaterThanZero)) {
                closestObstacleGreaterThanZero = obstacle;
            }
        }
        int stepsPositiveDirection = StepsCounter(0, exitCoordinate, closestObstacleLessThanZero, closestObstacleGreaterThanZero, true);
        int stepsNegativeDirection = StepsCounter(0, exitCoordinate, closestObstacleLessThanZero, closestObstacleGreaterThanZero, false);
        
        if (stepsPositiveDirection == 99999) {
            System.out.println("Impossible");
        } else {
            System.out.println("При движении в положительную сторону: " + stepsPositiveDirection);
        }

        if (stepsNegativeDirection == 99999) {
            System.out.println("Impossible");
        } else {
            System.out.println("При движении в отрицательную сторону: " + stepsNegativeDirection); 
        }    
    }
    }
