package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9466 {
    static int n;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] choice = new int[n];
            boolean[] already = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                choice[j] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int j = 0; j < n; j++) {
//                if (!already[j]) dfs(choice, already, j, j);
            }

            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (!already[j]) ++sum;
            }
            System.out.println(sum);
        }
        br.close();
    }

    private static void dfs (int idx) {

    }
}


/*
#include <cstdio>
#include <cstring>

int t, n, arr[100001], pnt[100001], result;
bool is_visit[100001];

void dfs(int idx){
   is_visit[idx] = true;
   pnt[arr[idx]]--;
   result++;
   if (!is_visit[arr[idx]] && !pnt[arr[idx]]) dfs(arr[idx]);
}

int main(){
   for (scanf("%d", &t); t; t--){
      memset(pnt, 0, sizeof(pnt));
      memset(is_visit, 0, sizeof(is_visit));
      result = 0;
      scanf("%d", &n);
      for (int i = 1; i <= n; i++){
         scanf("%d", &arr[i]);
         pnt[arr[i]]++;
      }
      for (int i = 1; i <= n; i++){
         if (!pnt[i] && !is_visit[i])
            dfs(i);
      }
      printf("%d\n", result);
   }
}
*/