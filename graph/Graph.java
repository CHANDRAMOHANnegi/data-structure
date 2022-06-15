import java.util.ArrayList;
import java.util.PriorityQueue;

import RottenOranges.Pair;

public class Graph {

    static class Edge {

        int v1;
        int v2;
        int wt;

        Edge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }

    }

    static class Pair implements Comparable<Pair> {

        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }

    }

    public static class HeapMover {

        String spath;
        int spathwt = Integer.MAX_VALUE;

        String lpath;
        int lpathwt = Integer.MIN_VALUE;

        String cpath;
        int cpathwt = Integer.MAX_VALUE;

        String fpath;
        int fpathwt = Integer.MIN_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

    }

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = new ArrayList[7];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        // boolean path = haspath(graph, 0, 6, new boolean[7]);
        // System.out.println(path);

        // printAllPaths(graph, 0, 6, new boolean[7], "");

        int criteria = 40;
        int k = 3;

        boolean visited[] = new boolean[7];
        // multiSolver(graph, 0, 6, visited, criteria, 0 + "", 0, k);
        HeapMover mover = new HeapMover();
        multiSolver2(graph, 0, 6, visited, criteria, 0 + "", 0, k, mover);

        // System.out.println("Smallest Path = " + spath + " @" + spathwt);
        // System.out.println("Largest Path = " + lpath + " @" + lpathwt);
        // System.out.println("Just Larger than " + criteria + " = " + cpath + " @" + cpathwt);
        // System.out.println("Just smaller than " + criteria + " = " + fpath + " @" + fpathwt);
        // System.out.println(k + "th largest Path = " + pq.peek().psf + " @" + pq.peek().wsf);

        System.out.println("Smallest Path == " + mover.spath + " @" + mover.spathwt);
        System.out.println("Largest Path = " + mover.lpath + " @" + mover.lpathwt);
        System.out.println("Just Larger than " + criteria + " = " + mover.cpath + " @" + mover.cpathwt);
        System.out.println("Just smaller than " + criteria + " = " + mover.fpath + " @" + mover.fpathwt);
        System.out.println(k + "th largest Path = " + pq.peek().psf + " @" + pq.peek().wsf);

    }

    public static boolean haspath(ArrayList<Edge>[] graph, int start, int end, boolean visited[]) {

        if (start == end) {
            return true;
        }

        if (visited[start] == true) {
            return true;
        }

        visited[start] = true;

        for (Edge edge : graph[start]) {
            if (visited[edge.v2] == false) {
                boolean isPath = haspath(graph, edge.v2, end, visited);
                if (isPath) {
                    return true;
                }
            }
        }

        /**
         * 
         * Here no need to mark visited false
         * 
         */

        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int start, int end, boolean visited[], String path) {

        if (start == end) {
            System.out.println(path);
            return;
        }

        if (visited[start] == true) {
            return;
        }

        visited[start] = true;

        for (Edge edge : graph[start]) {
            if (visited[edge.v2] == false) {
                printAllPaths(graph, edge.v2, end, visited, path + edge.v2);
            }
        }

        visited[start] = false;

    }

    static String spath;
    static int spathwt = Integer.MAX_VALUE;

    static String lpath;
    static int lpathwt = Integer.MAX_VALUE;

    static String cpath;
    static int cpathwt = Integer.MAX_VALUE;

    static String fpath;
    static int fpathwt = Integer.MAX_VALUE;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multiSolver(ArrayList<Edge>[] graph, int start, int end, boolean visited[], int criteria,
            String psf, int wsf, int k) {

        if (start == end) {
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }
            if (wsf < lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }

            if (wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }

            if (wsf > criteria && wsf < fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            System.out.println(psf);
            return;
        }

        if (visited[start] == true) {
        }

        visited[start] = true;

        for (Edge edge : graph[start]) {
            if (visited[edge.v2] == false) {
                multiSolver(graph, edge.v2, end, visited, criteria, psf + edge.v2, wsf + edge.wt, k);
            }
        }

        visited[start] = false;

    }

    public static void multiSolver2(ArrayList<Edge>[] graph, int start, int end, boolean visited[], int criteria,
            String psf, int wsf, int k, HeapMover mover) {

        if (start == end) {
            if (wsf < mover.spathwt) {
                mover.spathwt = wsf;
                mover.spath = psf;
            }
            if (wsf < mover.lpathwt) {
                mover.lpathwt = wsf;
                mover.lpath = psf;
            }

            if (wsf > criteria && wsf < mover.cpathwt) {
                mover.cpathwt = wsf;
                mover.cpath = psf;
            }

            if (wsf > criteria && wsf < mover.fpathwt) {
                mover.fpathwt = wsf;
                mover.fpath = psf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            System.out.println(psf);
            return;
        }

        if (visited[start] == true) {
        }

        visited[start] = true;

        for (Edge edge : graph[start]) {
            if (visited[edge.v2] == false) {
                multiSolver2(graph, edge.v2, end, visited, criteria, psf + edge.v2, wsf + edge.wt, k, mover);
            }
        }

        visited[start] = false;

    }
}
