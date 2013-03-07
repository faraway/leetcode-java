/**
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
**/

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadder {
    HashSet<String> visited;
   
    ArrayList<String> current ;
   
    ArrayList<String> next ;
   
    public int ladderLength(String start, String end, HashSet<String> dict) {
        visited = new HashSet <String>();
        current = new ArrayList <String>();
        next = new ArrayList <String>();
       
        current.add(start);
        //distance count
        int count=1 ;
        //found solution or not
        boolean found=false;
        //doing BFS to find nearest word transformation
        bfs: while(!current .isEmpty()){
             for(String s:current){
                   if(s.equals(end)){
                        found= true;
                         break bfs;
                  }
                   else{
                        getNeighbours(s,dict);
                  }
             }
             current.clear();
             ArrayList<String> temp = current;
             current=next ;
             next=temp;
             count++;
        }
        return found?count:0 ; 
    }
   
    //given a word, find its neighbours
    private void getNeighbours(String node,HashSet<String> dict){
        char[] array = node.toCharArray();
        for(int i=0;i<array. length;i++){
             char original = array[i];
             for(int j='a';j<= 'z';j++){
                   if(j!=(original)){
                        array[i]=( char)j;
                         String temp = new String(array);
                         if(dict.contains(temp)&&!visited .contains(temp)){
                               next.add(temp);
                               visited.add(temp);
                        }
                  }
            }
            array[i]=original;
        }
    }
}
