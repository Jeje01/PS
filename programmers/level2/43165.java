// 타겟 넘버_DFS

class Solution {
    public int dfs(int[] numbers, int target, int node, int sum){
        if(node==numbers.length){
            if(sum==target) return 1;
            else return 0;
        }
        else{
            return dfs(numbers, target, node+1, sum+numbers[node])+
                dfs(numbers, target, node+1, sum-numbers[node]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
}
