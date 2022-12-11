import org.junit.Test;
import java.util.Set;
import java.util.HashSet;

public class GraphAlgorithmsTest {
  @Test
  public void testPrims() {
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
    edges.add(new Edge(new Vertex('B'), new Vertex<>('A'), 1));
    edges.add(new Edge(new Vertex('A'), new Vertex('C'), 5));
    edges.add(new Edge(new Vertex('C'), new Vertex('A'), 5));
    edges.add(new Edge(new Vertex('B'), new Vertex('C'), 7));
    edges.add(new Edge(new Vertex('C'), new Vertex('B'), 7));
    edges.add(new Edge(new Vertex('B'), new Vertex('D'), 9));
    edges.add(new Edge(new Vertex('D'), new Vertex('B'), 9));
    edges.add(new Edge(new Vertex('B'), new Vertex('G'), 1));
    edges.add(new Edge(new Vertex('G'), new Vertex('B'), 1));
    edges.add(new Edge(new Vertex('C'), new Vertex('G'), 13));
    edges.add(new Edge(new Vertex('G'), new Vertex('C'), 13));
    edges.add(new Edge(new Vertex('D'), new Vertex('F'), 4));
    edges.add(new Edge(new Vertex('F'), new Vertex('D'), 4));
    edges.add(new Edge(new Vertex('E'), new Vertex('G'), 10));
    edges.add(new Edge(new Vertex('G'), new Vertex('E'), 10));
    edges.add(new Edge(new Vertex('F'), new Vertex('G'), 2));
    edges.add(new Edge(new Vertex('G'), new Vertex('F'), 2));
    edges.add(new Edge(new Vertex('F'), new Vertex('H'), 0));
    edges.add(new Edge(new Vertex('H'), new Vertex('F'), 0));
    edges.add(new Edge(new Vertex('G'), new Vertex('H'), 3));
    edges.add(new Edge(new Vertex('H'), new Vertex('G'), 3));

    Graph<String> graph = new Graph<>(vertices, edges);
    Set<Edge<String>> prims = new GraphAlgorithms().prims(new Vertex('A'), graph);
    System.out.println(prims);
  }

  @Test
  public void testPrimsParallelEdge() {
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
    edges.add(new Edge(new Vertex('A'), new Vertex<>('C'), 5));
    edges.add(new Edge(new Vertex('A'), new Vertex<>('C'), 6));

    Graph<String> graph = new Graph<>(vertices, edges);
    Set<Edge<String>> prims = new GraphAlgorithms().prims(new Vertex('A'), graph);
    System.out.println(prims);
  }

  @Test
  public void testPrimsNull() {
    Set<Vertex<String>> vertices = new HashSet<>();
    vertices.add(new Vertex('A'));
    vertices.add(new Vertex('B'));
    Set<Edge<String>> edges = new HashSet<>();
    edges.add(new Edge(new Vertex('A'), new Vertex<>('B'), 1));

    Graph<String> graph = new Graph<>(vertices, edges);
    Set<Edge<String>> prims = new GraphAlgorithms().prims(new Vertex('A'), graph);
    System.out.println(prims);
  }
}
