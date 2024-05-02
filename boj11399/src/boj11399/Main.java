// package boj11339;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일로부터 데이터를 읽어오기 위해 파일 입력 스트림 설정
        // System.setIn(new FileInputStream("src/input.txt"));
        
        // BufferedReader를 사용하여 입력 데이터 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 정수 N 읽기
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄에서 공백으로 구분된 N개의 정수를 읽어 배열 P에 저장
        int[] P = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 입력 스트림 닫기
        br.close();
        
        // 배열 P 정렬 (오름차순)
        Arrays.sort(P);
        
        // 누적 합 배열 계산
        int[] prefixSum = new int[N];
        prefixSum[0] = P[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + P[i];
        }
        
        // 총 대기 시간 계산
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += prefixSum[i];
        }
        
        // 출력을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 결과 값을 문자열로 변환하여 출력
        bw.write(Integer.toString(result));
        
        // 출력 버퍼 플러시
        bw.flush();
        
        // 출력 스트림 닫기
        bw.close();
    }
}