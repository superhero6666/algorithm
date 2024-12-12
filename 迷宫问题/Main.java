package 迷宫问题;

/**
 * @author klhu03
 * @since 2024/12/12 14:51
 **/
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

class Node{
    int a;
    int b;
    Node(int a,int b){
        this.a = a;
        this.b = b;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        dfs(matrix, list, new Node(0, 0), n-1, m-1, visited);
        list.forEach( t -> {
            System.out.println("(" + t.a + "," + t.b + ")");
        });
    }
    static boolean dfs(int[][] matrix, List<Node> list, Node node, int n, int m, boolean[][] visited){
        list.add(new Node(node.a, node.b));
        visited[node.a][node.b] = true;
        if(list.size() != 0 && list.get(list.size()-1).a == n && list.get(list.size()-1).b == m){
            return true;
        }
        if(node.a -1 >= 0 && !visited[node.a-1][node.b] && matrix[node.a-1][node.b] == 0){
            if(dfs(matrix, list, new Node(node.a-1, node.b), n, m, visited)){
                return true;
            }
        }
        if(node.a + 1 <= n && !visited[node.a+1][node.b] && matrix[node.a+1][node.b] == 0){
            if(dfs(matrix, list, new Node(node.a + 1, node.b), n, m, visited)){
                return true;
            }
        }
        if(node.b - 1 >= 0 && !visited[node.a][node.b-1] && matrix[node.a][node.b - 1] == 0){
            if(dfs(matrix, list, new Node(node.a, node.b - 1), n, m, visited)){
                return true;
            }
        }
        if(node.b + 1 <= m && !visited[node.a][node.b+1] && matrix[node.a][node.b + 1] == 0){
            if(dfs(matrix, list, new Node(node.a, node.b + 1), n, m, visited)){
                return true;
            }
        }
        list.remove(list.size()-1);
        visited[node.a][node.b] = false;
        return false;
    }
}
