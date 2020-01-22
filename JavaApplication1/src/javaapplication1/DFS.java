/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Stack;

/**
 *
 * @author cn1adil
 */
public class DFS {
    
    static String city[] = {"Arad", "Bucharest", "Craiova", "Drobeta", "Eforie", "Fagaras", "Giurgiu", "Hirsova", "Iasi", "Lugo J",
                       "Mehadia", "Neamt", "Oradea", "Pitesti", "Rimnicu Vikea", "Sibiu", "Timisoara", "Urziceni", "Vaslui", "Zerind"};
    
    public static void constructGraph(Graph g)
    {
        g.addEdge(0, 19, 75);
        g.addEdge(0, 16, 118);
        g.addEdge(0, 15, 140);
        g.addEdge(19, 12, 71);
        g.addEdge(16, 9, 111);
        g.addEdge(15, 12, 151);
        g.addEdge(15, 5, 99);
        g.addEdge(15, 14, 80);
        g.addEdge(9, 10, 70);
        g.addEdge(5, 1, 211);
        g.addEdge(14, 13, 97);
        g.addEdge(14, 2, 146);
        g.addEdge(10, 3, 75);
        g.addEdge(1, 17, 85);
        g.addEdge(1, 6, 90);
        g.addEdge(13, 2, 138);
        g.addEdge(13, 1, 101);
        g.addEdge(2, 3, 120);
        g.addEdge(17, 18, 142);
        g.addEdge(17, 7, 98);
        g.addEdge(18, 8, 92);
        g.addEdge(7, 4, 86);
        g.addEdge(8, 11, 87);
    }
    public static void main(String[] args) {
        Graph g = new Graph(20);
        constructGraph(g);
        
        int source = 0; int destination = 1;
        
        boolean[] visited = new boolean[20];
        int[] prev = new int[20];
        for (int i = 0; i < 20; i++) {
            visited[i] = false;
            prev[i] = -1;
        }
        
        Stack st = new Stack<Integer>();
        st.push(source);
        while( !st.isEmpty() ) {
            int temp = (int)st.pop();
            if (temp == destination)
                break;
            if (!visited[temp])
            {
                visited[temp] = true;
            }
            else
                continue;
            for (int i = g.getNode(temp).size() - 1; i >= 0; i--) {
                Edge e = g.getEdge(temp, i);
                if (!visited[e.getNode()])
                {
                    st.push(e.getNode());
                    prev[e.getNode()] = temp;
                }
            }
        }
        System.out.println("Path Obtained: ");
        int p1=destination;
        int p2;
        int cost=0;
        while (p1 != -1) {
            System.out.print(city[p1] + " <- ");
            p2 = prev[p1];
            for (int i = 0; i < g.getNode(p1).size(); i++) {
                if (p2 == g.getEdge(p1, i).getNode()) {
                    cost += g.getEdge(p1, i).getWeight();
                    break;
                }
            }
            p1 = p2;
        }
        System.out.println("\b\b\b");
        System.out.println("Path Cost: " + cost);
    }
}
