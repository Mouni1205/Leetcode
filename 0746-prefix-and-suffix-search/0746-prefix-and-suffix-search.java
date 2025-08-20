class WordFilter {

    class Node{
        Map<Character,Node> children = new HashMap<>();
        int index;
    }

    Node root = new Node();

    //store suffix#word into the trie
    public WordFilter(String[] words) {
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int n = word.length();
            //for app - we will insert app#app, pp#app, p#app, #app
            for(int j=0;j<=n;j++){
                String newWord = word.substring(j)+"#"+word;
                insert(newWord,i);
            }
        }
    }
    void insert(String word,int i){
        Node curr = root;
        for(char c:word.toCharArray()){
            curr.children.putIfAbsent(c,new Node());
            curr = curr.children.get(c);
            curr.index = i;
        }
    }
    public int f(String pref, String suff) {
        String query = suff+"#"+pref;
        Node curr = root;
        for(char c:query.toCharArray()){
            if(!curr.children.containsKey(c)) return -1;
            curr = curr.children.get(c);
        }
        return curr.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */