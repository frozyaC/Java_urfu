import java.util.Arrays;
import java.util.Scanner;

public class timus1025 {
    public static int MoreThanHalf(int K) {
        double moreThanHalf = Math.ceil(K / 2.0f);
        if (moreThanHalf/K == 0.5) {
            return (int)moreThanHalf + 1;
        } else if (moreThanHalf/K > 0.5) {
            return (int)moreThanHalf;
        } else {
            return 1000; //заглушка, не должно выполняться, так как K всегда > 0
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество групп: ");
        int groups = in.nextInt();
        int[] groupSize = new int[groups];
        System.out.println("Введите количество человек в группе через пробел: ");
        for (int i = 0; i < groups; i++) {
            groupSize[i] = in.nextInt();
        }
        Arrays.sort(groupSize);
        int partyMembersSum = 0;
        int enoughGroups = MoreThanHalf(groupSize.length);
        for (int i = 0; i < enoughGroups; i++) {
            partyMembersSum+= MoreThanHalf(groupSize[i]);
        }
        System.out.println("Минимальное количество для победы в голосовании : " + partyMembersSum);
    }
}
