package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<List<Integer>> adj;
    static void intialize(int n) {
        adj = new ArrayList<>(n);
        for(int i = 0; i< n; i++) {
            adj.add(new ArrayList<>());
        }
    }
    static void main(){
        int n = 5;
        intialize(n);
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        boolean[] vis = new boolean[n];
        dfs(0, vis);
    }

    private static void dfs(int u, boolean[] vis) {
        vis[u] = true;
        System.out.println(u);
        for(int x : adj.get(u)){
            if(!vis[x]){
                dfs(x, vis);
            }
        }
    }

}
