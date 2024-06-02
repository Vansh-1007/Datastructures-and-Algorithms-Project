package com.vansh.ds;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimMSTStatistics {
    private static final double FLOATING_POINT_EPSILON = 1.0E-12;

    public static class PrimMST {
        private Edge[] edgeTo;
        private double[] distTo;
        private boolean[] marked;
        private IndexMinPQ<Double> pq;

        public PrimMST(EdgeWeightedGraph G) {
            edgeTo = new Edge[G.V()];
            distTo = new double[G.V()];
            marked = new boolean[G.V()];
            pq = new IndexMinPQ<>(G.V());

            for (int v = 0; v < G.V(); v++)
                distTo[v] = Double.POSITIVE_INFINITY;

            for (int v = 0; v < G.V(); v++)
                if (!marked[v]) prim(G, v);
        }

        private void prim(EdgeWeightedGraph G, int s) {
            distTo[s] = 0.0;
            pq.insert(s, distTo[s]);
            while (!pq.isEmpty()) {
                int v = pq.delMin();
                scan(G, v);
            }
        }

        private void scan(EdgeWeightedGraph G, int v) {
            marked[v] = true;
            for (Edge e : G.adj(v)) {
                int w = e.other(v);
                if (marked[w]) continue;
                if (e.weight() < distTo[w]) {
                    distTo[w] = e.weight();
                    edgeTo[w] = e;
                    if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                    else pq.insert(w, distTo[w]);
                }
            }
        }

        public Iterable<Edge> edges() {
            Queue<Edge> mst = new Queue<>();
            for (int v = 0; v < edgeTo.length; v++) {
                Edge e = edgeTo[v];
                if (e != null) {
                    mst.enqueue(e);
                }
            }
            return mst;
        }

        public double weight() {
            double weight = 0.0;
            for (Edge e : edges())
                weight += e.weight();
            return weight;
        }
    }

    public static void main(String[] args) {
        List<String> datasetPaths = Arrays.asList(
                "C:/Users/VANSH TOLANI/Downloads/hu.txt",
                "C:/Users/VANSH TOLANI/Downloads/ro.txt",
                "C:/Users/VANSH TOLANI/Downloads/hr.txt"
        );

        double combinedMean = 0.0;
        double combinedMin = Double.POSITIVE_INFINITY;
        double combinedMax = Double.NEGATIVE_INFINITY;
        List<Double> allWeights = new ArrayList<>();

        for (String datasetPath : datasetPaths) {
            In in = new In(datasetPath);
            EdgeWeightedGraph G = new EdgeWeightedGraph(in);
            PrimMST mst = new PrimMST(G);

            double weight = mst.weight();
            combinedMean += weight;
            combinedMin = Math.min(combinedMin, weight);
            combinedMax = Math.max(combinedMax, weight);
            allWeights.add(weight);

            for (Edge e : mst.edges()) {
                StdOut.println(e);
            }
        }

        int totalTrees = datasetPaths.size();
        combinedMean /= totalTrees;

        double[] weightsArray = allWeights.stream().mapToDouble(Double::doubleValue).toArray();
        Arrays.sort(weightsArray);
        double combinedMedian;
        int totalVertices = weightsArray.length;
        if (totalVertices % 2 == 0) {
            combinedMedian = (weightsArray[totalVertices / 2 - 1] + weightsArray[totalVertices / 2]) / 2.0;
        } else {
            combinedMedian = weightsArray[totalVertices / 2];
        }

        StdOut.println("Combined Mean: " + combinedMean);
        StdOut.println("Combined Median: " + combinedMedian);
        StdOut.println("Combined Minimum: " + combinedMin);
        StdOut.println("Combined Maximum: " + combinedMax);
    }
}