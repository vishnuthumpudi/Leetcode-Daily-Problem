class Solution {
    class Node{
        String name;
        HashMap<String, Node> children;
        Node(){
            this.name = "*";
            children = new HashMap();
        }
        Node(String name){
            children = new HashMap();
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    HashMap<String, List<Node>> hashNodeMap;
    HashSet<Node> nodeWithDuplicateHashes;
    List<List<String>> ans;
    
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        //construct tree of folders
        Node root = new Node();
        for(List<String> path : paths){
            Node node = root;
            for(String folder : path){
                if(node.children.containsKey(folder) == false){
                    node.children.put(folder, new Node(folder));
                }
                node = node.children.get(folder);
            }
        }

        hashNodeMap = new HashMap<String, List<Node>>();
        nodeWithDuplicateHashes = new HashSet<Node>();
        // constuct hashes in post order traversal and store them in hashNodeMap
        countHashes(root);
        for(String key : hashNodeMap.keySet()){
            if(hashNodeMap.get(key).size() > 1){
                for(Node curr : hashNodeMap.get(key)){
                    nodeWithDuplicateHashes.add(curr);
                }
            }
        }

        ans = new LinkedList<List<String>>();
        //nodeWithDuplicateHashes stores nodes with duplicate hashes. Use this in deleteDuplicateFolders() to delete children of the nodes recursively.
        deleteDuplicateFolders(root, new LinkedList<String>());

        //First entry contains empty folder. We have to remove it.
        ans.remove(0);
        return ans;
    }

    void deleteDuplicateFolders(Node node, List<String> path){
        if(nodeWithDuplicateHashes.contains(node)){
            return;
        }
        List<String> newPath = new LinkedList<>(path);
        ans.add(newPath);
        for(String folder : node.children.keySet()){
            path.add(folder);
            deleteDuplicateFolders(node.children.get(folder), path);
            path.remove(path.size()-1);
        }

    }

    String countHashes(Node node){

        if(node.children.size() == 0){
            return node.name;
        }

        List<String> childHashes = new LinkedList();
        for(String folder : node.children.keySet()){
            String childHash = countHashes(node.children.get(folder));
            childHashes.add(childHash);
        }

        String nodeHash = "";
        //in case of multiple subfolders, getNodeHash() calculates hash by arranging children in alphabetical order
        if(childHashes.size()>1){
            nodeHash = "#" + getNodeHash(childHashes);
        }
        else{
            nodeHash = childHashes.get(0);
        }
        
        if(hashNodeMap.containsKey(nodeHash)){
            hashNodeMap.get(nodeHash).add(node);
        }
        else{
            List<Node> list = new LinkedList();
            list.add(node);
            hashNodeMap.put(nodeHash, list);
        }
        return node.name + "/" + nodeHash;
    }

    String getNodeHash(List<String> childHashes){
        Collections.sort(childHashes, (a,b)->a.compareTo(b));
        String hash = "";
        for(String childHash : childHashes){
            hash = hash + childHash + "#";
        }
        return hash.substring(0, hash.length()-1);
    }
}
