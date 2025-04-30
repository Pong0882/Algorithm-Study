package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = (br.readLine().split(":"));
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]) / 10;
        System.out.println(h / 10 + h % 10 + m % 3 + 1);
    }
}