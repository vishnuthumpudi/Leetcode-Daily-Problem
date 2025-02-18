class Solution {
    public String smallestNumber(String pattern) {
        //created stringbuilder to store the final result
        StringBuilder result = new StringBuilder();

        //created stack to manage decrease operations
        Stack<Integer> stack = new Stack<>();

        //traverse the array till pattern.length() to handle the last sequence
        for(int ind = 0;ind<=pattern.length();ind++){

            // push the number 
            stack.push(ind+1);

            
            if(ind == pattern.length() || pattern.charAt(ind) == 'I'){

                //pattern finds I then append the character in stringbuilder in reverse manner
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
}
