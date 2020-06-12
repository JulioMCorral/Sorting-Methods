/* 
 * In this class the implementation was to make method which envolves
 * the Kruskal algorithm. this is related with the minimun spanning tree
 * in a set to find the shortest path in a grapth
 *
 * 
 *@author Julio Corral
 *
 *Lab 5
 *     
 *      T.A: Jaime Nava
 *      Professor: Olac Fuentes
 *      Class: Tues-Thurs: 10:30am-11:50am 
 */

import java.util.*;
import java.io.*;

public class GreedyAlgorithm
{
    /*Constructor
     * 
     * variables:  node1, node2, wight;
     */
    private static class Edge 
    {
        String node1;              // label of the first edge node
        String node2;              // label of the second edge node
        double weight;             // edge weight
        
        
        /* constructor with parameters
         * 
         * @param n1 is node in graph
         * @param n2 is node in graph
         * @param w is weight of the connecting nodes 
         * @postcondition: node1 = n1; node2 = n2; weight = w;
         */
        public Edge(String n1, String n2, double w) 
        {
            node1 = n1;               
            node2 = n2;      
            weight = w;              
        }
    }
    
    /**
     *  this class describes a graph vertext set 
     */
    private static class VertexSet
    {
        String label;              // vertex label
        VertexSet next;            // pointer to the next vertex in the set
        VertexSet head;            // pointer to the first vertex in the set
        VertexSet tail;            // pointer to the last vertex in the set
        
        /**
         * constructor with parameters
         * @param l string variable 
         * @postcondition: label = l; next = null; head = tail = this;
         */
        public VertexSet(String l) 
        {
            label = l;               // set up the node label
            next = null;             // reference to the next set node
            head = tail = this;      // references to the set tail and the head
        }
    }
    
    private static TreeMap<String, VertexSet> vertices;
    private static TreeSet<Edge> edges;    
    
    /**
     *  main method 
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        // read graph encoding (data.txt)
        readGraph(args);                      
        
        // control output of the graph edges sorted by weight
        System.out.println("Edges sorted according to the weight:");
        //loop until graph.txt has variables
        for (Iterator<Edge> it=edges.iterator(); it.hasNext(); ) 
        {
            Edge e = it.next();
            if (! vertices.containsKey(e.node2))
            {
                //if a node is undefined in input file
                System.out.println("Undefined node " + e.node2); 
                //exit the program
                System.exit(0);         
            }
            //else print connecting nodes and weight
            System.out.println(e.node1 + " - " + e.node2 + ": " + e.weight); 
        }
        
        // the set A will store the MST edges --- A = emptyset
        ArrayList<Edge> A = new ArrayList<Edge>();  
        
        System.out.println("\nRunning Kruskal's algorithm:\n");
        // main loop over all edges
        for (Iterator<Edge> it=edges.iterator(); it.hasNext(); )   
        {
            // fetch an edge from the list
            Edge e = it.next();               
            // retrieve the edge endpoints
            String c1 = e.node1;               
            String c2 = e.node2;
            System.out.print("Checking edge " + c1 + " - " + c2 + " : ");
            // check whether they are in diff.
            if (findSet(c1) != findSet(c2))   
                // vertex sets of the partition
            {                                 
                // if not - accept the edge
                A.add(e);                       
                // unite the corresp. vertex sets
                union(e.node1, e.node2);        
                System.out.println("ACCEPT");
            }
            else                               
                System.out.println("reject");    
        }
        
        // output of the MST edges with weights
        System.out.println("\nMST edges:"); 
        double w = 0;
        //loop of mst edges
        for (Iterator<Edge> it=A.iterator(); it.hasNext(); ) 
        {
            Edge e = it.next();  
            System.out.println(e.node1 + " - " + e.node2 + ": " + e.weight);
            w += e.weight;
        }
        System.out.println(); 
        System.out.println("Total MST weight: " + w);
    }
    
    /**
     * Method returns a pointer to the vertex set to which the vertex
     * with the given label 
     * 
     * @param c string value of vertex
     * @return v.head
     */
    public static VertexSet findSet(String c)
    {
        VertexSet v = vertices.get(c);
        return(v.head);
    }
    
    /**
     * union method: unites two vertex sets given by the vertex 
     *              labels of their representatives
     * 
     * @param c1 value of the first node
     * @param c2 value of the second node
     */
    public static void union(String c1, String c2)
    {
        // get the pointers to the corresponding vertexes
        VertexSet v1 = vertices.get(c1); 
        VertexSet v2 = vertices.get(c2);
        
        // append the second list to the first one
        v1.head.tail.next = v2.head;   
        // set up pointer to the end of list
        v1.head.tail = v2.head.tail;   
        for (VertexSet v=v2.head; v!=null; v=v.next)
            // set up pointers to the rep of the list
            v.head = v1.head;            
    }
    
    /**
     * method that reads the graph.txt file
     */
    public static void readGraph(String[] args) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new FileReader("data.txt"));
        
        // the comparator is necessary to compare the edges by weight
        Comparator<Edge> c = new Comparator<Edge>()
        {            
            public int compare(Edge e1, Edge e2)
            {
                //set weight1 according to e1 weight
                double weight1 = e1.weight;    
                //set weight2 according to e2 weight
                double weight2 = e2.weight;    
                //if weight1 is less than weight 2 return -1
                if (weight1 < weight2) return(-1);  
                //if its greater return 1
                else if (weight1 > weight2) return(1); 
                else          
                {
                    String s1 = e1.node1;     
                    String s2 = e2.node1;
                    return(s1.compareTo(s2));    
                }
            }
        };
        
        // storage for graph vertices
        vertices = new TreeMap<String, VertexSet>();
        // storage for the graph edges
        edges = new TreeSet<Edge>(c);      
        
        // read all file records
        while (inFile.hasNextLine())        
        {
            // read a text line from file
            String s = inFile.nextLine();    
            // ignore comments
            if (s.length() > 0 && s.charAt(0) != '#')  
            {
                StringTokenizer sTk = new StringTokenizer(s);
                
                String vertexLabel1 = sTk.nextToken();  
                
                if (vertices.containsKey(vertexLabel1))
                {
                    System.out.println("Multiple declaration of vertex " + vertexLabel1
                                           + " in the adjacency list");
                    System.exit(0);
                }
                // retrieve the node label
                VertexSet v = new VertexSet(vertexLabel1);
                // adding the vertex into the hash
                vertices.put(vertexLabel1, v); 
                
                // loop over all edges incident with
                // the current vertex
                while (sTk.hasMoreTokens())    
                {                              
                    // second endnode label   
                    String vertexLabel2 = sTk.nextToken();  
                    
                    double edgeWeight = 0;
                    try
                    {
                        //edge wgt
                        edgeWeight = Double.parseDouble(sTk.nextToken());   
                    }
                    catch(NumberFormatException nfe)
                    {
                        System.out.println("Wrong label/weight combination in the " +
                                           "adjacency list of " + vertexLabel1);
                        System.exit(0);
                    }
                    catch(NoSuchElementException nfe)
                    {
                        System.out.println("Wrong adjacency list for node " + vertexLabel1);
                        System.exit(0);
                    }
                    // endnode of edges
                    if (vertexLabel1.compareTo(vertexLabel2) < 0) 
                    {                          
                        // are stored in the alphabetic order
                        Edge e = new Edge(vertexLabel1, vertexLabel2, edgeWeight);
                        // add edge to the tree
                        edges.add(e);              
                    }
                }
            }
        }
    }
}
