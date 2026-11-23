class ProductOfNumbers {
    private List<Integer> stream;
    private int n;
    public ProductOfNumbers() {
        stream = new ArrayList<>();
        n = 0;
    }
    
    public void add(int num) {
        stream.add(num);
        n += 1;
    }
    
    public int getProduct(int k) {
        if(n == 0) return -1;

        int result = 1;

        for(int i = 0; i < k; i++) {
            result = result * stream.get(n - i - 1);
        }

        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */