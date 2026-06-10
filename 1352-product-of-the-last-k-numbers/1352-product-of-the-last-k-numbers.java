class ProductOfNumbers {
    ArrayList<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        //if num is not 0 just get the prefix product and multiply with num
        if(num!=0){
            list.add(list.get(list.size()-1)*num);
        }else{
        //if its 0 we initialize new arraylist just like kadane's algo
        list = new ArrayList<>();
        list.add(1); 
        }
    }
    
    public int getProduct(int k) {
        //if k<list size that means we have 0 so entire product is 0
        //if not we just have to divide it by the total product till now with the product outside of k range
        int n = list.size();
        if(k>=n) return 0;
        return list.get(n-1)/list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */