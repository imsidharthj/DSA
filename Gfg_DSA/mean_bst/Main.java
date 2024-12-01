import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
	    	Node root = buildTree(s);
    	    Solution ob = new Solution();
    	    int key = Integer.parseInt(br.readLine());
            t--;
            int res = ob.mean(root, key);
            out.println(res);
        }
        out.flush();
    }
  
}

class Solution{
    int mean(Node root, int key){
        // code here
        Node temp = root;
        double smaller = -1;
        double greater = -1;
        while(temp != null){
            if(temp.data < key){
                smaller = temp.data;
                temp = temp.right;
            } else if(temp.data > key) {
                greater = temp.data;
                temp = temp.left;
            } else {
                smaller = temp.data;
                greater = temp.data;
                break;
            }
        }
        // while(temp != null){
        //     if(temp < key){
        //         greater = temp;
        //         temp = temp.right;
        //     } else {
        //         temp = temp.left;
        //     }
        // }
        // System.out.println("smaller" + smaller);
        // System.out.println("greater" + greater);
        double average = Math.ceil((smaller + greater)/2);
        // System.out.println("average: " + average);
        return (int)average;
    }
}