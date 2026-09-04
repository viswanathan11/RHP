import java.io.*;
import java.util.*;

public class BomberSquad {

    static int H, W, K;
    static char[][] grid;
    static boolean[] bombRow;
    static boolean[] bombCol;
    static int[][] dist;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new char[H][W];

        bombRow = new boolean[H];
        bombCol = new boolean[W];

        // Read grid and find rows/columns containing bombs
        for (int i = 0; i < H; i++) {

            grid[i] = br.readLine().toCharArray();

            for (int j = 0; j < W; j++) {

                if (grid[i][j] == '#') {
                    bombRow[i] = true;
                    bombCol[j] = true;
                }
            }
        }

        // Distance array
        dist = new int[H][W];

        for (int i = 0; i < H; i++) {
            Arrays.fill(dist[i], -1);
        }

        // Multi-source BFS
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                // Safe empty cell
                if (grid[i][j] == '.'
                        && !bombRow[i]
                        && !bombCol[j]) {

                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];

            // No need to go beyond K
            if (dist[r][c] == K) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= H ||
                    nc < 0 || nc >= W) {
                    continue;
                }

                // Cannot move onto a bomb
                if (grid[nr][nc] == '#') {
                    continue;
                }

                // Already visited
                if (dist[nr][nc] != -1) {
                    continue;
                }

                dist[nr][nc] = dist[r][c] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }

        // Count cells reachable within K moves
        int answer = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                if (grid[i][j] == '.'
                        && dist[i][j] != -1
                        && dist[i][j] <= K) {

                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}