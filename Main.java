package org.example;

import javax.naming.NameAlreadyBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            int n=5;
            Tree tree = new Tree(n);
            tree.addEdges(1,2);
            tree.addEdges(3,4);
            tree.addEdges(1,3);
            tree.addEdges(4,5);
            System.out.println("Adding line here");
            /*
                      1
                     /  \
                    2     3
                           \
                            4
                              \
                               5
             */
            tree.dfs(1, -1);
            tree.preCalculateNthParent(n);
            System.out.println(tree.lca(2,5));
    }

    static class Tree{
        List<Integer>[] tree;
        int[][] parent;
        int[] lvl;
        int lg;
        Tree(int n){
            this.tree = new ArrayList[n+1];
            for(int i=0;i<n+1;i++){
                tree[i] = new ArrayList<>();
                System.out.println("Adding line here");
            }
            this.lg = (int)(Math.log(n)/Math.log(2))+1;
            System.out.println("Adding line here2");
            this.parent = new int[n+1][lg+1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(parent[i], -1);
            }
            lvl = new int[n+1];
            Arrays.fill(lvl, 0);
        }
        void addEdges(int u, int v){
            tree[u].add(v);
            tree[v].add(u);
        }
        public void dfs(int node, int par){
            parent[node][0] = par;
            for(int v : tree[node]){
                if(v != par){
                    lvl[v] = lvl[node] + 1;
                    dfs(v, node);
                }
            }
        }

        public void preCalculateNthParent(int n){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<=lg;j++){
                    if(parent[i][j-1] != -1)
                        parent[i][j] = parent[parent[i][j - 1]][j - 1];
                }
            }
        }

        public int lca(int u, int v){
            if(lvl[v] > lvl[u]){
                int a = u;
                u=v;
                v=a;
                int d = lvl[u] - lvl[v];
                d = (int) Math.log(d);
                for(int i=lg;i>=0;i--){
                    if(parent[u][i] != -1 && lvl[parent[u][i]] >= lvl[v]){
                        u = parent[u][i];
                    }
                }
            }
            if(u==v) return u;

            for(int i=lg;i>=0;i--){
                if(parent[u][i] != -1 && parent[v][i] != -1 && parent[u][i] != parent[v][i]){
                    u = parent[u][i];
                    v = parent[v][i];
                }
            }
            u = parent[u][0];
        return u;
        }

    }
}





