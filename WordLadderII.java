/**
Word Ladder IIFeb 11

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:

    All words have the same length.
    All words contain only lowercase alphabetic characters.
**/

import java.util.ArrayList;
import java.util.HashSet;

/**
  * @NOTE: dind't pass large data set
  *        another possible approach: 1.using Word Ladder to get the shortest length by BFS 
  *                                   2.using DFS to find all shortest paths
  *        But I heard this approach won't pass large data set either.
  */
public class WordLadderII {
  HashSet<String> visited;
    
    ArrayList<SNode> current;
    
    ArrayList<SNode> next;
    
    ArrayList<ArrayList<String>> result;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	result = new ArrayList<ArrayList<String>>();
        visited = new HashSet<String>();
        current = new ArrayList<SNode>();
        next = new ArrayList<SNode>();
        
        current.add(new SNode(start,null));
        //found solution or not
        boolean found=false;
        //doing BFS to find all nearest word transformation
        while(!current.isEmpty()){
        	for(SNode node:current){
        		if(node.val.equals(end)){
        			found=true;
        			addResult(node);
        		}
        		else
        			getNeighbours(node,dict);
        	}
        	
        	if(found) break;
        	//swap current and next list
        	current.clear();
        	ArrayList<SNode> temp = current;
        	current=next;
        	next=temp;
        }
        return result;  
    }
    
    //given a word, find its neighbours
    private void getNeighbours(SNode node,HashSet<String> dict){
        char[] array = node.val.toCharArray();
        for(int i=0;i<array.length;i++){
        	char original = array[i];
        	for(int j='a';j<='z';j++){
        		if(j!=(original)){
        			array[i]=(char)j;
        			String temp = new String(array);
        			if(dict.contains(temp)&&!visited.contains(temp)){
        				next.add(new SNode(temp,node));
        				/**
        				 * add parent node as visited.
        				 * Here we can't label the current node as visited like we do in classic BFS 
        				 * Since we're going to find all shortest path, label current node as visited will 
        				 * prevent us finding multiple possible shortest paths.
        				 */
        				visited.add(node.val);
        			}
        		}
        	}
        	array[i]=original;
        }
    }
    
    //for a result node, find the back trace path to the start node, add it to result
    private void addResult(SNode s){
    	ArrayList<String> list = new ArrayList<String>();
    	while(s.parent!=null){
    		list.add(s.val);
    		s=s.parent;
    	}
    	list.add(s.val);
    	//reverse the list, because the back trace path is reversed
    	java.util.Collections.reverse(list);
    	result.add(list);
    }
}

//assistance class, wrap the string and its parent node
class SNode{
	String val;
	SNode parent;
	
	SNode(String v,SNode p){
		val = v;
		parent = p;
	}
}
