package algorithm.permutation;

import java.util.Arrays;

public class BitPerm {
    static int flag;
    static int[] card = { 1, 2, 3, 4, 5 };
    static int[] select = new int[3];
    static int depth;

    public static void main(String[] args) {
        perm(0);
    }

    private static void perm(int cnt) {
        if (cnt == 3) {

            System.out.printf(Integer.toBinaryString(flag));
            System.out.println(Arrays.toString(select));
            // System.out.println();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if ((flag & 1 << i) != 0) {
                continue;
            }
            select[cnt] = card[i];
            flag |= 1 << i;
            perm(cnt + 1);
            flag &= ~(1 << i);
        }
    }
}
