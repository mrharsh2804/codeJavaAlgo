import java.io.*;
import java.util.*;

/*

Given list of folders, print the path of a given folder from root. If there is no path to the root folder then return an empty string. Root level folders will have 0 as id. The structure of Folder is like this:
class Folder {
   int id;
   List<int> subfolders;
   String name;
}

Ex: 
list = 
[Folder(0, [7, 3], “abc”), 
Folder(0, [], “xyz”), 
Folder(8, [9], “def”), 
Folder(7, [], “ijk), 
Folder(9, [], “lmn”)]

printPath(9) = “abc” -> “ijk” -> “lmn” printPath(8) = ""
Clarification: There can be multiple root level folders. All other folders have unique ids.
Note: printPath method may be called multiple times. Design your solution taking that into account

0: abc
0: xyz

idToFold
8: def
7: ijk
9: lmn

*/


// Main class should be named 'Solution'
class Folder {
   int id;
   int[] subfolders;
   String name;
    Folder(int id, int[] sub, String name)
    {
        this.id = id;
        subfolders = sub;
        this.name = name;
    }
    
    @Override
        public int hashCode()
        {
  
            // uses roll no to verify the uniqueness
            // of the object of Student class
  
            final int temp = 14;
            int ans = 1;
            ans = temp * ans + id;
            return ans;
        }
    
    @Override
    public boolean equals(Object o)
    {
        Folder f = (Folder) o;
        return this.id == f.id;
    }
}

class Solution {
    public static void main(String[] args) {
        List<Folder> list = new ArrayList();
        list.add(new Folder(0, new int[]{7, 3}, "abc"));
        list.add(new Folder(0, new int[]{8}, "xyz"));
        list.add(new Folder(8, new int[]{}, "def"));
        list.add(new Folder(7, new int[]{9}, "ijk"));
        list.add(new Folder(9, new int[]{7}, "lmn"));
        System.out.println(printPath(list, 9));
    }
    
    public static String printPath(List<Folder> folders, int fId)
    {
        HashMap<Integer,Folder> idToFold = new HashMap<>();
        for(Folder fold : folders)
        {
            if(fold.id != 0)
                idToFold.put(fold.id, fold);
        }
        HashMap<Folder, Folder> map = new HashMap<>();
        for(Folder root : folders)
        {
            for(int folder : root.subfolders)
            {
                if(idToFold.containsKey(folder)){
                    map.put(idToFold.get(folder), root);
                }
            }
        }
        
        StringBuilder path = new StringBuilder();
        Folder cur = idToFold.get(fId);
        if(cur == null) return "Invalid input folder";
        path.append(cur.name);
        //list = [Folder(0, [7, 3], “abc”), Folder(0, [8], “xyz”), Folder(8, [], “def”), Folder(7, [9], “ijk), Folder(9, [8], “lmn”)]
        HashSet<Folder> visited = new HashSet<>();
        while(cur.id != 0)
        {
            Folder parent = map.get(cur);

            if(parent!=null && !visited.contains(parent))
            {
                visited.add(parent);
                path.append("-->");
                path.append(parent.name);
                cur = parent;
            }
            else {
                return "No path to root!";
            }
        }
        
        return path.toString();
        
    }
}
