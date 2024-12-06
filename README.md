# DSA Project: Graph Algorithms and Analysis

This project explores the application of classical graph algorithms such as Prim's, Kruskal's, Dijkstra's, and Bellman-Ford on datasets from the [Gemsec Deezer Dataset](https://snap.stanford.edu/data/deezer.html). The goal is to analyze the behavior and performance of these algorithms and compute statistical metrics such as mean, median, maximum, and minimum for various graph characteristics.

---

## Datasets Used
The project integrates three datasets from the Gemsec Deezer dataset:
- **HR Sub-Network (`hr.txt`)**
- **HU Sub-Network (`hu.txt`)**
- **RO Sub-Network (`ro.txt`)**

### About the Gemsec Deezer Dataset
The Gemsec Deezer dataset represents friendship networks of users from the music streaming service Deezer. Each dataset corresponds to a specific country and consists of undirected graphs where:
- Nodes represent users.
- Edges represent mutual friendships between users.

#### Key Properties:
- **Nodes**: Users from the respective country.
- **Edges**: Friendships between the users.
- **Node Features**: Associated with anonymized user interests (e.g., music genres).

The dataset is sourced from the following [website](https://snap.stanford.edu/data/gemsec-Deezer.html), which provides detailed information about the networks, their structure, and applications in graph-based research.

#### Dataset Overview

| Country | #Nodes | #Edges   |
|---------|--------|----------|
| RO      | 41,773 | 125,826  |
| HR      | 54,573 | 498,202  |
| HU      | 47,538 | 222,887  |

---

## Algorithms Implemented
The following graph algorithms are implemented to solve problems related to shortest paths and minimum spanning trees:

1. **Prim's Algorithm**  
   - Constructs a minimum spanning tree (MST) by adding edges with the smallest weight while avoiding cycles.
   - File: `PrimMST.java`

2. **Kruskal's Algorithm**  
   - Forms an MST by sorting edges by weight and selecting edges sequentially while avoiding cycles.
   - File: `KruskalMSTStatistics.java`

3. **Dijkstra's Algorithm**  
   - Finds the shortest paths from a source node to all other nodes in a graph with non-negative weights.
   - File: `DijkstraSP.java`

4. **Bellman-Ford Algorithm**  
   - Computes shortest paths from a source node in graphs that may have negative weight edges.
   - File: `BellmanFordSPStatistics.java`

---

## Results and Statistical Analysis
The project analyzes the results of the algorithms on the combined dataset. Metrics such as mean, median, maximum, and minimum are calculated for:
- Edge weights.
- Path lengths.
- Execution times.

The insights derived from the analysis highlight the performance trade-offs and practical applications of each algorithm.

---

## File Structure
Here is an overview of the project files:
- **`BellmanFordSPStatistics.java`**: Implementation and statistical analysis of Bellman-Ford Algorithm.
- **`DijkstraSP.java`**: Implementation of Dijkstra's Algorithm.
- **`KruskalMSTStatistics.java`**: Implementation and statistical analysis of Kruskal's Algorithm.
- **`PrimMST.java`**: Implementation of Prim's Algorithm.
- **Datasets (`hr.txt`, `hu.txt`, `ro.txt`)**: Graph data used for the project.
- **Report_Project.pdf**: Detailed report containing methodology, results, and interpretations.
- **DSA Project.pptx**: Presentation slides summarizing the project.
- **README.md**: Project overview and usage guide.

---

## How to Run
1. Clone this repository:
   ```bash
   git clone <https://github.com/Vansh-1007/Datastructures-and-Algorithms-Project>
   cd <Datastructures-and-Algorithms-Project>
javac PrimMST.java DijkstraSP.java KruskalMSTStatistics.java BellmanFordSPStatistics.java
2.Run the algorithms on the datasets:
bash
Copy code
java <AlgorithmFile> <DatasetFile>
Replace <AlgorithmFile> and <DatasetFile> with the respective file names.

## Key Insights
- The performance of Prim's and Kruskal's algorithms varies based on the graph's density.
- Dijkstra's Algorithm is optimal for non-negative edge weights but struggles with graphs having negative weights.
- Bellman-Ford, while slower, is versatile for graphs with negative weight edges.

## Future Work
Potential areas for further exploration include:
- Optimization of algorithm implementations.
- Comparison with modern graph algorithms like A*.
- Integration with visualization tools to display graph structures.


