// package boj1931;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];

		// 회의 정보 입력받기
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			meetings[i][0] = Integer.parseInt(input[0]);
			meetings[i][1] = Integer.parseInt(input[1]);
		}
		br.close();

		// 회의 끝나는 시간을 기준으로 오름차순 정렬
		Arrays.sort(meetings, Comparator.comparingInt(o -> o[1]));

		// 회의 끝나는 시간이 같은 경우, 시작 시간을 기준으로 오름차순 정렬
		Arrays.sort(meetings, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return 0;
		});

		int result = 0;
		int endTime = 0;

		// 회의 선택하기
		for (int i = 0; i < N; i++) {
			// 이전 회의의 끝나는 시간보다 현재 회의의 시작 시간이 같거나 늦으면 선택
			if (meetings[i][0] >= endTime) {
				endTime = meetings[i][1];
				result++;
			}
		}

		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
	}
}
