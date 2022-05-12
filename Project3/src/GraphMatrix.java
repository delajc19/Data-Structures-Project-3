/**
 * Joseph de la Viesca
 * CSC 201
 * Project 3, Questions 1-3
 * 4/25/22
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix implements Graph{
     int[][] matrix;
    private boolean[] visited;

    //No args constructor
    public GraphMatrix(){}

    // Initialize the graph with some number of vertices
    // Time Complexity: Theta(n^2)
    public void init(int n) {
        this.matrix = new int[n][n];
        this.visited = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                this.matrix[i][j] = 0;
            }
            visited[i] = false;
        }
    }

    //counts the number of vertices
    // Time Complexity: Theta(1)
    public int nodeCount() {
        if(this.matrix != null){return this.matrix.length;}
        return -1;
    }

    //counts the number of edges
    // Time Complexity: Theta(n^2)
    public int edgeCount() {
        if(this.matrix != null){
            int ctr = 0;
            for(int i = 0; i < this.matrix.length; i++){
                for(int j = 0; j < this.matrix.length; j++){
                    if(matrix[i][j] > 0){
                        ctr++;
                    }
                }
            }
            return ctr;
        }
        return -1;
    }

    // Adds a new edge from node v to node w with weight wgt
    // Time Complexity: Theta(1)
    public void addEdge(int v, int w, int wgt) {
        if(v < this.matrix.length && w < this.matrix.length){
            this.matrix[v][w] = wgt;
        }
    }

    // Get the weight value for an edge
    // Time Complexity: Theta(1)
    public int getWeight(int v, int w) {
        if(this.matrix != null){return this.matrix[v][w];}
        return -1;
    }

    // Set the weight of the edge from v to w
    // Time Complexity: Theta(1)
    public void setWeight(int v, int w, int wgt) {
        if(v < this.matrix.length && w < this.matrix.length){
            this.matrix[v][w] = wgt;
        }

    }

    // Remove the edge from v to w
    // Time Complexity: Theta(1)
    public void removeEdge(int v, int w) {
        if(v < this.matrix.length && w < this.matrix.length){this.matrix[v][w] = 0;}
        
    }

    // Returns true if there is an edge from v to w
    // Time Complexity: Theta(1)
    public boolean hasEdge(int v, int w) {
        if(v < this.matrix.length && w < this.matrix.length && this.matrix[v][w] > 0){return true;}
        return false;
    }

    // Returns the neighbors of node v
    // Time Complexity: Theta(n)
    public int[] neighbors(int v) {
        if(v < this.matrix.length){
            int[] temp = new int[this.matrix.length];
            int n = 0;
            for(int i = 0; i < this.matrix.length; i++){
                if(hasEdge(v,i)){
                    temp[n] = i;
                    n++; 
                }
            }
            int[] neighbors = new int[n];
            for(int i = 0; i < n; i++){
                neighbors[i] = temp[i];
            }
            return neighbors;
        }
        return null;
    }

    // Resets all elements of visited array to false
    // Time complexity: Theta(n)
    public void resetVisited() {
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        
    }

    // Returns an Integer ArrayList of the graph in BFS order
    // Time Complexity: Theta(n)
    public ArrayList<Integer> BFS(int v) {
        if(v < this.matrix.length){
            ArrayList<Integer> bfsArrayList  = new ArrayList<Integer>();
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(v);
            this.visited[v] = true;
            while(queue.peek() != null){
                bfsArrayList.add(queue.peek());
                v = queue.remove();
                int[] nList = neighbors(v);
                for(int i = 0; i < nList.length; i++){
                    if(visited[nList[i]] == false){
                        queue.add(nList[i]);
                        this.visited[nList[i]] = true;
                    }
                }
            }
            return bfsArrayList;
        }
        return null;
    }

    // Returns true if there is a path between v and w. Otherwise returns false. You may use the BFS method (above) for this method.
    // Time Complexity: Theta(n)
    public boolean hasPath(int v, int w) {
        ArrayList<Integer> pathList = BFS(v);
        for(int i = 0; i < pathList.size(); i++){
            if(pathList.get(i) == w){
                return true;
            }
        }
        return false;
    }

    // Performs a topologicalSort if the graph and returns an ArrayList that contains the vertex labels/id in topologically sorted order. You must use BFS 
    // Time Complexity: Theta(n^2)
    public ArrayList<Integer> topologicalSort() {
        int v = -1;
        int indegree = -1;
        while(indegree > 0){
            for(int i = 0; i < nodeCount(); i++){
                for(int j = 0; j < nodeCount(); i++){
                    if(this.matrix[i][j] > 0) {v = matrix[i][j];}
                }
            }
            indegree = 0;
            for(int i = 0; i < nodeCount(); i++){
                if(matrix[i][v] > 0){indegree++;}
            }
        }
        return BFS(v);
    }
}
