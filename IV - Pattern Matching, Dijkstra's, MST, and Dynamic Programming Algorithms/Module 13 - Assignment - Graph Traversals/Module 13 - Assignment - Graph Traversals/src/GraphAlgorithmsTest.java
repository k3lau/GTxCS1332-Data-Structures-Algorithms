import java.util.Set;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.*;

public class GraphAlgorithmsTest {
  private Graph<String> createSample() {
    Set<Vertex<String>> vertices = new HashSet<>();
    vertices.add(new Vertex('A'));
    vertices.add(new Vertex('B'));
    vertices.add(new Vertex('C'));
    vertices.add(new Vertex('D'));
    vertices.add(new Vertex('E'));
    vertices.add(new Vertex('F'));
    vertices.add(new Vertex('G'));
    vertices.add(new Vertex('H'));
    Set<Edge<String>> edges = new HashSet<>();
    edges.add(new Edge(new Vertex('A'), new Vertex<>('B'), 8));
    edges.add(new Edge(new Vertex('B'), new Vertex('A'), 8));
    edges.add(new Edge(new Vertex('A'), new Vertex('D'), 5));
    edges.add(new Edge(new Vertex('D'), new Vertex('A'), 5));
    edges.add(new Edge(new Vertex('A'), new Vertex('C'), 2));
    edges.add(new Edge(new Vertex('C'), new Vertex('A'), 2));
    edges.add(new Edge(new Vertex('B'), new Vertex('C'), 1));
    edges.add(new Edge(new Vertex('C'), new Vertex('B'), 1));
    edges.add(new Edge(new Vertex('B'), new Vertex('D'), 1));
    edges.add(new Edge(new Vertex('D'), new Vertex('B'), 1));
    edges.add(new Edge(new Vertex('B'), new Vertex('G'), 7));
    edges.add(new Edge(new Vertex('G'), new Vertex('B'), 7));
    edges.add(new Edge(new Vertex('C'), new Vertex('E'), 3));
    edges.add(new Edge(new Vertex('E'), new Vertex('C'), 3));
    edges.add(new Edge(new Vertex('D'), new Vertex('F'), 4));
    edges.add(new Edge(new Vertex('F'), new Vertex('D'), 4));
    edges.add(new Edge(new Vertex('E'), new Vertex('G'), 2));
    edges.add(new Edge(new Vertex('G'), new Vertex('E'), 2));
    edges.add(new Edge(new Vertex('F'), new Vertex('G'), 0));
    edges.add(new Edge(new Vertex('G'), new Vertex('F'), 0));
    edges.add(new Edge(new Vertex('F'), new Vertex('H'), 1));
    edges.add(new Edge(new Vertex('H'), new Vertex('F'), 1));
    edges.add(new Edge(new Vertex('G'), new Vertex('H'), 1));
    edges.add(new Edge(new Vertex('H'), new Vertex('G'), 1));
    Graph<String> graph = new Graph<>(vertices, edges);
    return graph;
  }

  @Test
  public void testBfs() {
    Graph graph = createSample();
    System.out.println(graph.getVertices().toString());
    System.out.println(graph.getEdges());
    System.out.println(graph.getAdjList());
    List bfs = new GraphAlgorithms().bfs(new Vertex('A'), graph);
    System.out.println(bfs);
  }

  @Test
  public void testBfsSingle() {
    Set<Vertex<String>> vertices = new HashSet();
    vertices.add(new Vertex('a'));
    Set<Edge<String>> edges = new HashSet();
    edges.add(new Edge(new Vertex('a'), new Vertex('a'), 1));
    Graph<String> graph = new Graph(vertices, edges);
    System.out.println(graph.getVertices().toString());
    System.out.println(graph.getEdges());
    System.out.println(graph.getAdjList());
    List bfs = new GraphAlgorithms().bfs(new Vertex('a'), graph);
    System.out.println(bfs);
  }

  @Test
  public void testDfs() {
    Graph graph = createSample();
    System.out.println(graph.getVertices().toString());
    System.out.println(graph.getEdges());
    System.out.println(graph.getAdjList());
    List dfs = new GraphAlgorithms().dfs(new Vertex('A'), graph);
    System.out.println(dfs);
  }

  @Test
  public void testDfs2() {
    Set<Vertex<String>> vertices = new HashSet<>();
    vertices.add(new Vertex('A'));
    vertices.add(new Vertex('B'));
    vertices.add(new Vertex('C'));
    vertices.add(new Vertex('D'));
    vertices.add(new Vertex('E'));
    vertices.add(new Vertex('F'));
    vertices.add(new Vertex('G'));
    vertices.add(new Vertex('H'));
    Set<Edge<String>> edges = new HashSet<>();
    edges.add(new Edge(new Vertex('A'), new Vertex<>('B'), 1));
    edges.add(new Edge(new Vertex('A'), new Vertex('C'), 1));
    edges.add(new Edge(new Vertex('A'), new Vertex('E'), 1));

    edges.add(new Edge(new Vertex('B'), new Vertex('D'), 1));

    edges.add(new Edge(new Vertex('B'), new Vertex('F'), 1));

    edges.add(new Edge(new Vertex('C'), new Vertex('E'), 1));

    edges.add(new Edge(new Vertex('C'), new Vertex('G'), 1));
    edges.add(new Edge(new Vertex('G'), new Vertex('C'), 1));
    edges.add(new Edge(new Vertex('F'), new Vertex('H'), 1));

    edges.add(new Edge(new Vertex('G'), new Vertex('H'), 1));

    Graph<String> graph = new Graph<>(vertices, edges);
    List dfs = new GraphAlgorithms().dfs(new Vertex('A'), graph);
    System.out.println(dfs);
  }
}
