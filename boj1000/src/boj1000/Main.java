// package boj1000;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력
		// System.setIn(new FileInputStream("src/input.txt"));
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		scanner.close();
		// 풀이
		int result = A + B;
		// 출력
		System.out.println(result);
	}

}
