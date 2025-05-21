package assignment4;

import java.util.*;

class Vertex<V> {
    private V data;
    private List<Vertex<V>> neighbors;
    private Map<Vertex<V>, Double> weights;

    public Vertex(V data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
        this.weights = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public List<Vertex<V>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex<V> neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
            weights.put(neighbor, 1.0); // Default weight
        }
    }

    public void addNeighbor(Vertex<V> neighbor, double weight) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
            weights.put(neighbor, weight);
        } else {
            weights.put(neighbor, weight); // Update weight if neighbor already exists
        }
    }

    public double getWeight(Vertex<V> neighbor) {
        return weights.getOrDefault(neighbor, Double.POSITIVE_INFINITY);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}