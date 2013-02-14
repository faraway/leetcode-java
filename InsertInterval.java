package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

	You may assume that the intervals were initially sorted according to their start times.

	Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

	Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 * @author patrick
 *
 */
public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Iterator<Interval> it = intervals.iterator();
    	Interval start=null;
    	boolean finish=false;
    	int i=0;
    	int index=0;
    	
    	while(it.hasNext()){
    		Interval next = it.next();
    		if(start==null){
    			//the beginning of new interval is either in an interval or not
    			if(newInterval.start>=next.start && newInterval.start<=next.end){ //(1)
    				start = next;
    			}else if(next.start>newInterval.start){ //(2)
    				start = newInterval;
    				index=i;
    			}
    		}
    		if(start!=null){
    			if(next.start>newInterval.end){
    				start.end = newInterval.end;
    				finish=true;
    				break;
    			}else if(newInterval.end>=next.start && newInterval.end<=next.end){
    				start.end = next.end;
    				if(start!=next){//if start is assigned "next" this iteration, then don't delete it.
    					it.remove();
    				}
    				finish=true;
    				break;
    			}else{
    				if(start!=next){
        				it.remove();//if start is assigned "next" this iteration, then don't delete it.
    				}
    			}
    		}
    		i++;
    	}
    	if(start==newInterval){//refer to (2), we need to insert this new interval
    		intervals.add(index, start);
    	}
    	if(!finish){//if not finished
            if(start==null){//new interval must be the last interval of the list
                intervals.add(newInterval);
                return intervals;
            }
    		start.end=newInterval.end;//set the end as new interval's end any way
    	}
    	return intervals;
    }
}


/**
 * Definition for an interval.
 * */
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
 