class Pair{
    String word;
    int pos;
    Pair(String word, int pos){
        this.word = word ;
        this. pos = pos ;
    }
}
class Solution {
    public int ladderLength(String b, String e, List<String> list) {
        Set<String> set = new HashSet<>(list);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(b,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String wo = p.word;
            int po = p.pos;
            if(wo.equals(e)) return po;
            for(int i =0;i<wo.length();i++){
                char [] w = wo.toCharArray();
                for(int j =0;j<26;j++){
                    char x = (char)('a'+j);
                    w[i] = x;
                    String ns = new String(w);
                    if(set.contains(ns)) {
                        q.add(new Pair(ns,po+1));
                        set.remove(ns);
                    }
                } 
            }
        }
        return 0;

        
    }
}