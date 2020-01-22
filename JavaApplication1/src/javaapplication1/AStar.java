/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author cn1adil
 */
public class AStar {
    
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
        PriorityQueue q = new PriorityQueue();
        Graph g = new Graph(20);
        constructGraph(g);
        
        int heuristic[] = {366, 0, 160, 242, 161, 176, 77, 151, 226, 244, 241, 234, 380, 100, 193, 253, 329, 80, 199, 374};
        int source = 0; int destination = 1; int pathCost = 0;
        
        boolean[] visited = new boolean[20];
        int[] prev = new int[20];
        for (int i = 0; i < 20; i++) {
            visited[i] = false;
            prev[i] = -1;
        }
        q.add(source, 0, 0);
//        visited[destination] = true;
        while ( !q.isEmpty() ) {
            Pair p = q.remove();
            visited[p.getNode()] = true;
            if (p.getNode() == destination) {
                pathCost = p.getSum();
                break;
            }
            int temp_node = p.getNode();
//            int temp_sum = p.getSum();
            for (int i = 0; i < g.getNode(temp_node).size(); i++) {
                Edge e = g.getEdge(temp_node, i);
                if (!visited[e.getNode()])
                {
                    q.add(e.getNode(), p.getPrev() + e.getWeight() + heuristic[e.getNode()], p.getPrev() + e.getWeight());
                    prev[e.getNode()] = temp_node;
                }
            }
        }
        System.out.println("Path Obtained: ");
        int p=destination;
        while (p != -1) {
            System.out.print(city[p] + " <- ");
            p = prev[p];
        }
        System.out.println("\b\b\b");
        System.out.println("Path Cost: " + pathCost);
    }
}
