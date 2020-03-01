import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class testing {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int N, M;
  static ArrayList<ArrayList<Integer>> pahts = new ArrayList<ArrayList<Integer>>();
  static boolean[] isPhoRestaurant;
  static boolean[] visited;
  static int[] dist;
  static int totalDist;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));

    N = readInt();
    M = readInt();

    isPhoRestaurant = new boolean[N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++)
      pahts.add(new ArrayList<Integer>());

    for (int i = 0; i < M; i++)
      isPhoRestaurant[readInt()] = true;

    for (int i = 0; i < N - 1; i++) {
      int a = readInt();
      int b = readInt();
      pahts.get(a).add(b);
      pahts.get(b).add(a);
    }

    for (int i = 0; i < N; i++)
      if (isPhoRestaurant[i]) {
        mark(i, -1);
        break;
      }

    dist = new int[N];
    for (int i = 0; i < N; i++)
      if (visited[i]) {
        computeDist(i, -1, 0);
        break;
      }

    int maxIndex = -1;
    for (int i = 0; i < N; i++)
      if (visited[i] && (maxIndex == -1 || (dist[maxIndex] < dist[i])))
        maxIndex = i;

    dist = new int[N];
    computeDist(maxIndex, -1, 0);

    int longestDist = 0;

    for (int i = 0; i < N; i++)
      longestDist = Math.max(longestDist, dist[i]);

    out.println(totalDist - longestDist);
    out.close();
  }

  static void computeDist(int u, int prev, int depth) {
    dist[u] = depth;
    for (int v : pahts.get(u)) {
      if (v != prev && visited[v]) {
        computeDist(v, u, depth + 1);
      }
    }
  }

  static void mark(int u, int prev) {
    if (isPhoRestaurant[u])
      visited[u] = true;

    for (int v : pahts.get(u)) {
      if (v == prev)
        continue;
      mark(v, u);
      if (visited[v]) {
        totalDist += 2;
        visited[u] = true;
      }
    }
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char readCharacter() throws IOException {
    return next().charAt(0);
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}