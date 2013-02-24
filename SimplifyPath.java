/**
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
  * Did you consider the case where path = "/../"?
In this case, you should return "/".
	* Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
**/

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        // I need a stack - queue like thing, so just create one my self instead of using Stack API
        String[] stack = new String[dirs.length];
        int top = 0;
        for(String s:dirs){
            if(s.length()==0||s.equals("."))
                continue;
            if(s.equals("..")){
                if(top==0)
                    continue;
                else
                    top--;
            }else
                stack[top++]=s;
        }
       
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(int i=0;i<top;i++)
            sb.append(stack[i]+"/");
        //if path has something other than single '/', get rid of last '/'
        if(sb.length()>1)
            sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
