package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_수학문제3 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static int N;

	private static String s;
	private static List<String> list = new ArrayList<>();

	private static List<Integer> num = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern.compile("\\d+");

		for (int i = 0; i < N; i++) {
			s = br.readLine();
			Matcher matcher = pattern.matcher(s);
			while (matcher.find()) {
				String tmp = matcher.group();

				for (int j = 0; j < tmp.length(); j++) {
					if (tmp.charAt(j) != '0') {
						tmp = tmp.substring(j);
						break;
					}
					if (j == tmp.length() - 1) {
						tmp = "0";
					}
				}
				list.add(tmp);
			}
		}

		list.sort((s1, s2) -> {
			if (s1.length() != s2.length()) {
				return s1.length() - s2.length();
			}
			return s1.compareTo(s2);
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
