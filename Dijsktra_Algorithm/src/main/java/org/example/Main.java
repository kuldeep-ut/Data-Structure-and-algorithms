package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<List<int[]>> edgeList;
    static void initialize(int n){
        edgeList = new ArrayList<>(n);
        for(int i = 0; i<n; i++){
            edgeList.add(new ArrayList<>());
        }
        edgeList.get(0).add(new int[]{1, 2});
        edgeList.get(0).add(new int[]{2, 3});
        edgeList.get(1).add(new int[]{3, 5});
        edgeList.get(1).add(new int[]{2, 7});
        edgeList.get(2).add(new int[]{4, 6});
    }
    static void main() {
        initialize(5);
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[5];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{0, 0});
        dijkstra_algo(dist, pq);
        for(int z: dist){
            System.out.println(z);
        }
    }

    private static void dijkstra_algo(
            int[] dist,
            PriorityQueue<int[]> pq) {

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int u = current[0];
            int weight = current[1];

            // Ignore stale entry
            if (weight > dist[u]) {
                continue;
            }

            for (int[] edge : edgeList.get(u)) {

                int v = edge[0];
                int distance = edge[1];

                int newDistance = dist[u] + distance;

                // Relaxation
                if (newDistance < dist[v]) {

                    dist[v] = newDistance;

                    pq.add(new int[]{v, newDistance});
                }
            }
        }
    }
}
