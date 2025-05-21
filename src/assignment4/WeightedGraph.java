package assignment4;

import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<V, Vertex<V>> vertices = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        if (hasVertex(v))
            return;

        vertices.put(v, new Vertex<>(v));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        sourceVertex.addNeighbor(destVertex, weight);

        if (undirected)
            destVertex.addNeighbor(sourceVertex, weight);
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : vertices.keySet()) {
            count += vertices.get(v).getNeighbors().size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(V v) {
        return vertices.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source) || !hasVertex(dest))
            return false;

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        return sourceVertex.getNeighbors().contains(destVertex);
    }

    public List<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;

        List<V> adjacentVertices = new LinkedList<>();
        Vertex<V> vertex = vertices.get(v);

        for (Vertex<V> neighbor : vertex.getNeighbors()) {
            adjacentVertices.add(neighbor.getData());
        }

        return adjacentVertices;
    }

    public Iterable<Vertex<V>> getNeighbors(V v) {
        if (!hasVertex(v)) return null;

        return vertices.get(v).getNeighbors();
    }

    public double getWeight(V source, V dest) {
        if (!hasVertex(source) || !hasVertex(dest)) {
            return Double.POSITIVE_INFINITY;
        }

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        return sourceVertex.getWeight(destVertex);
    }
}