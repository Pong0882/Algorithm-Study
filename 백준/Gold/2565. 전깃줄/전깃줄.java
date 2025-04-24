import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static final int max = 501;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] paper = new int[max];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            paper[idx] = value;
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int num : paper) {
            if (num == 0) {
                continue;
            }
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) {
                idx = -1 * (idx + 1);
            }

            if (idx == lis.size()) {
                lis.add(num);
            } else {
                lis.set(idx, num);
            }
        }
        System.out.println(n - lis.size());
        // System.out.println(Arrays.toString(paper));
    }
}
