// "static void main" must be defined in a public class.


//Given a directed graph, find total number of routes to reach the destination from given source that have exacty m edges.

class Edge
{
    int src, dest;
    Edge(int source, int destination)
    {
        this.src = source;
        this.dest = destination;
    }
}

class Graph
{
    List<List<Integer>> adjList = new ArrayList<>();
    
    Graph(List<Edge> edges, int N)
    {
        for(int i=0; i<N; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(Edge e : edges)
        {
            adjList.get(e.src).add(e.dest);
        }
    }
}

class Node
{
    int v, depth;
    
    Node(int v, int depth)
    {
        this.v = v;
        this.depth = depth;
    }
}

public class Main {
    
    private static int numberOfPaths(Graph g, int src, int dest, int m)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0));
        int count = 0;
        while(!q.isEmpty())
        {
            Node n = q.poll();
            if(n.depth == m && n.v==dest)
                count++;
            if(n.depth > m)
                break;
            
            for(int u : g.adjList.get(n.v))
            {
                q.add(new Node(u, n.depth+1));
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        // List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				new Edge(0, 6), new Edge(0, 1), new Edge(1, 6),
				new Edge(1, 5), new Edge(1, 2), new Edge(2, 3),
				new Edge(3, 4), new Edge(5, 2), new Edge(5, 3),
				new Edge(5, 4), new Edge(6, 5), new Edge(7, 6),
				new Edge(7, 1)
		);

		// Number of vertices in the graph
		final int N = 8;

		// construct graph
		Graph g = new Graph(edges, N);

		int src = 0, dest = 3, m = 4;

		// Do modified BFS traversal from source vertex src
		System.out.println(numberOfPaths(g, src, dest, m));
    }
    
}
