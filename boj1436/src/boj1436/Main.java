// package boj1436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        // 로컬에서 테스트할 때 사용하는 입력 파일 설정
        // System.setIn(new FileInputStream("src/input.txt"));
        
        // BufferedReader를 사용하여 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받은 문자열을 정수로 변환하여 N에 저장
        int N = Integer.parseInt(br.readLine());
        
        // 입력 스트림 닫기
        br.close();

        // 666부터 시작하는 변수 v 초기화
        int v = 666;
        
        // N번째 종말의 숫자를 찾기 위한 반복문
        for (int i = 1; i < N; i++) {
            // v 값을 1씩 증가시키면서 탐색
            v++;
            
            // v의 문자열 표현에 "666"이 포함되어 있지 않으면 계속 증가
            while (!Integer.toString(v).contains("666")) {
                v++;
            }
        }

        // 출력
        // BufferedWriter를 사용하여 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // N번째 종말의 숫자를 문자열로 변환하여 출력
        bw.write(Integer.toString(v));
        
        // 출력 버퍼 비우기
        bw.flush();
        
        // 출력 스트림 닫기
        bw.close();
    }
}