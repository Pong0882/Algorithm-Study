package ssafy.ssafyGit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GabjaTest {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int A, B, N, M, result;
    private static int[] paper;

    public static void main(String[] args) throws IOException {
        String[] a = new String[] { "경", "신", "임", "계", "갑", "을", "병", "정", "무", "기" };
        String[] b = new String[] { "신", "유", "술", "해", "자", "축", "인", "묘", "진", "사", "오", "미" };

        while (true) {
            System.out.print("60갑자를 입력하세요 : ");
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("종료"))
                break;
            String aa = s.substring(0, 1);
            String bb = s.substring(1, 2);

            int aIdx = 0;
            int bIdx = 0;
            for (int i = 0; i < a.length; i++) {
                if (aa.equals(a[i]))
                    aIdx = i;
            }
            for (int i = 0; i < b.length; i++) {
                if (bb.equals(b[i]))
                    bIdx = i;
            }
            int result = 1800;
            // System.out.println("체크 : " + aa + " : " + aIdx + " , " + bb + " : " + bIdx);
            if (aIdx == bIdx) {
                result += aIdx;
            } else {
                int tmp = Math.abs(bIdx - aIdx) / 2;
                result += tmp * 10 + aIdx;
            }
            for (int i = result; i <= 2100; i += 60) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
