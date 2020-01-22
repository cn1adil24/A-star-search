/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.LinkedList;
/**
 *
 * @author cn1adil
 */
public class Graph {
    private LinkedList<Edge> graph[];
    private int nodes;
    String city[] = {"Arad", "Bucharest", "Craiova", "Drobeta", "Eforie", "Fagaras", "Giurgiu", "Hirsova", "Iasi", "Lugo J",
                       "Mehadia", "Neamt", "Oradea", "Pitesti", "Rimnicu Vikea", "Sibiu", "Timisoara", "Urziceni", "Vaslui", "Zerind"};
    
    public Graph(int n)
    {
        nodes = n;
        graph = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            graph[i] = new LinkedList<Edge>();
        }
    }
    public LinkedList getNode(int n)
    {
        return graph[n];
    }
    public Edge getEdge(int n, int i)
    {
        return graph[n].get(i);
    }
    
    public void addEdge(int vertex1, int vertex2, int weight)
    {
        Edge e1 = new Edge(vertex2, weight);
        graph[vertex1].add(e1);
        // for undirected graph
        Edge e2 = new Edge(vertex1, weight);
        graph[vertex2].add(e2);
    }
    public void print()
    {
        for (int i = 0; i < nodes; i++) {            
            System.out.print(city[i] + " -> ");
            for( int j = 0; j < graph[i].size(); j++ ) {
                System.out.print("{" + city[graph[i].get(j).getNode()] + ", " + graph[i].get(j).getWeight() + "} -> ");
            }
            System.out.println("\b\b\b");
        }
    }
}
