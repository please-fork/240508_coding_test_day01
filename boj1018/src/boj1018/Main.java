// package boj1018;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일로부터 입력을 받기 위해 FileInputStream 사용
        // System.setIn(new FileInputStream("src/input.txt"));
        
        // 입력을 읽어들이기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N과 M을 공백으로 구분하여 읽어들임
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        
        // 보드 상태를 저장할 문자열 배열 board 초기화
        String[] board = new String[N];
        
        // N개의 줄에 걸쳐 보드의 각 행을 읽어들임
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        
        // 최소 수정 횟수를 저장할 변수 result 초기화
        int result = 64;
        
        // 모든 가능한 8x8 크기의 체스판에 대해 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 첫 번째 칸이 흰색인 경우와 검은색인 경우 각각에 대한 수정 횟수 계산
                int score1 = 0;
                int score2 = 0;
                
                // 8x8 크기의 체스판에 대해 각 칸의 수정 횟수 계산
                for (int k = 0; k < 8; k++) {
                    String sub = board[i + k].substring(j, j + 8);
                    score1 += getScore(k, sub, 'W');
                    score2 += getScore(k, sub, 'B');
                }
                
                // 첫 번째 칸이 흰색인 경우와 검은색인 경우 중 최소 수정 횟수 선택
                result = Math.min(result, Math.min(score1, score2));
            }
        }
        
        // 출력을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 최소 수정 횟수를 문자열로 변환하여 출력
        bw.write(Integer.toString(result));
        
        // 출력 버퍼 플러시
        bw.flush();
        
        // 출력 스트림 닫기
        bw.close();
    }
    
    // 주어진 행과 문자열에 대해 첫 번째 칸의 색상을 기준으로 수정 횟수 계산
    public static int getScore(int idx, String s, char firstColor) {
        int score = 0;
        
        // 각 칸을 순회하며 수정 횟수 계산
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 행과 열의 합이 짝수인 경우
            if ((idx + i) % 2 == 0) {
                // 칸의 색상이 첫 번째 칸의 색상과 다르면 수정 횟수 증가
                if (c != firstColor) {
                    score += 1;
                }
            } 
            // 행과 열의 합이 홀수인 경우
            else {
                // 칸의 색상이 첫 번째 칸의 색상과 같으면 수정 횟수 증가
                if (c == firstColor) {
                    score += 1;
                }
            }
        }
        
        // 계산된 수정 횟수 반환
        return score;
    }
}