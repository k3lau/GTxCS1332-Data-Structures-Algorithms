import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

  /**
   * Performs a breadth first search (bfs) on the input graph, starting at
   * the parameterized starting vertex.
   *
   * When exploring a vertex, explore in the order of neighbors returned by
   * the adjacency list. Failure to do so may cause you to lose points.
   *
   * You may import/use java.util.Set, java.util.List, java.util.Queue, and
   * any classes that implement the aforementioned interfaces, as long as they
   * are efficient.
   *
   * The only instance of java.util.Map that you should use is the adjacency
   * list from graph. DO NOT create new instances of Map for BFS
   * (storing the adjacency list in a variable is fine).
   *
   * DO NOT modify the structure of the graph. The graph should be unmodified
   * after this method terminates.
   *
   * You may assume that the passed in start vertex and graph will not be null.
   * You may assume that the start vertex exists in the graph.
   *
   * @param <T>   The generic typing of the data.
   * @param start The vertex to begin the bfs on.
   * @param graph The graph to search through.
   * @return List of vertices in visited order.
   */
  public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    List<Vertex<T>> visitedSet = new LinkedList<>();
    Queue<Vertex<T>> queue = new LinkedList<>();
    visitedSet.add(start);
    queue.add(start);
    while (queue.size() != 0) {
      Vertex<T> u = queue.remove();
      for (VertexDistance<T> v : graph.getAdjList().get(u)) {
        if (visitedSet.contains(v.getVertex()) == false) {
          visitedSet.add(v.getVertex());
          queue.add(v.getVertex());
        }
      }
    }
    return visitedSet;
  }

  /**
   * Performs a depth first search (dfs) on the input graph, starting at
   * the parameterized starting vertex.
   *
   * When exploring a vertex, explore in the order of neighbors returned by
   * the adjacency list. Failure to do so may cause you to lose points.
   *
   * NOTE: This method should be implemented recursively. You may need to
   * create a helper method.
   *
   * You may import/use java.util.Set, java.util.List, and any classes that
   * implement the aforementioned interfaces, as long as they are efficient.
   *
   * The only instance of java.util.Map that you may use is the adjacency list
   * from graph. DO NOT create new instances of Map for DFS
   * (storing the adjacency list in a variable is fine).
   *
   * DO NOT modify the structure of the graph. The graph should be unmodified
   * after this method terminates.
   *
   * You may assume that the passed in start vertex and graph will not be null.
   * You may assume that the start vertex exists in the graph.
   *
   * @param <T>   The generic typing of the data.
   * @param start The vertex to begin the dfs on.
   * @param graph The graph to search through.
   * @return List of vertices in visited order.
   */
  public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    List<Vertex<T>> visitedSet = new LinkedList<>();
    recursiveDfs(start, graph, visitedSet);
    return visitedSet;
  }

  private static <T> void recursiveDfs(Vertex<T> vertex, Graph<T> graph,
      List<Vertex<T>> visitedSet) {
    visitedSet.add(vertex);
    for (VertexDistance<T> v : graph.getAdjList().get(vertex)) {
      if (visitedSet.contains(v.getVertex()) == false) {
        recursiveDfs(v.getVertex(), graph, visitedSet);
      }
    }
  }
}