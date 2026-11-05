class MyHashSet {

    boolean[] booleanArray;

    public MyHashSet() {
        booleanArray = new boolean[1000000];
    }
    
    public void add(int key) {
        if(booleanArray[key] == false) {
            booleanArray[key] = true;
        }
    }
    
    public void remove(int key) {
        booleanArray[key] = false;
    }
    
    public boolean contains(int key) {
        if(booleanArray[key] == true) return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */