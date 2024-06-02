package com.vansh.ds;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShortestPathStatistics {
    public static void main(String[] args) {
        List<String> datasetPaths = Arrays.asList(
                "C:/Users/VANSH TOLANI/Downloads/hu.txt",
                "C:/Users/VANSH TOLANI/Downloads/ro.txt",
                "C:/Users/VANSH TOLANI/Downloads/hr.txt"
        );

        List<EdgeWeightedDigraph> graphs = new ArrayList<>();
        List<DijkstraSP> shortestPaths = new ArrayList<>();

        for (String datasetPath : datasetPaths) {
            In in = new In(datasetPath);
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
            DijkstraSP sp = new DijkstraSP(G, 0); // Assuming source vertex is 0
            graphs.add(G);
            shortestPaths.add(sp);
        }

        List<Double> allPathLengths = new ArrayList<>();
        double combinedSum = 0.0;
        double combinedMin = Double.POSITIVE_INFINITY;
        double combinedMax = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < graphs.size(); i++) {
            EdgeWeightedDigraph G = graphs.get(i);
            DijkstraSP sp = shortestPaths.get(i);

            for (int v = 0; v < G.V(); v++) {
                if (sp.hasPathTo(v)) {
                    double pathLength = sp.distTo(v);
                    allPathLengths.add(pathLength);
                    combinedSum += pathLength;
                    combinedMin = Math.min(combinedMin, pathLength);
                    combinedMax = Math.max(combinedMax, pathLength);
                }
            }
        }

        int totalPaths = allPathLengths.size();
        double combinedMean = combinedSum / totalPaths;

        double[] pathLengthsArray = allPathLengths.stream().mapToDouble(Double::doubleValue).toArray();
        Arrays.sort(pathLengthsArray);
        double combinedMedian;
        int totalVertices = pathLengthsArray.length;
        if (totalVertices % 2 == 0) {
            combinedMedian = (pathLengthsArray[totalVertices / 2 - 1] + pathLengthsArray[totalVertices / 2]) / 2.0;
        } else {
            combinedMedian = pathLengthsArray[totalVertices / 2];
        }

        StdOut.println("Combined Mean: " + combinedMean);
        StdOut.println("Combined Median: " + combinedMedian);
        StdOut.println("Combined Minimum: " + combinedMin);
        StdOut.println("Combined Maximum: " + combinedMax);
    }
}