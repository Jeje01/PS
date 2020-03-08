//스킬트리(서머코딩/윈터코딩~2018)

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int pos = -1;
        int l = 0, i, j, k;
        char[] exist = new char[26];
        char[] tree = skill.toCharArray();
        for(i = 0; i<skill_trees.length; i++){ //각 스킬
            //System.out.println("i="+i);
            for(j = 0; j<skill_trees[i].length(); j++){//스킬 안 원소            
                for(k = 0; k<tree.length; k++){ //트리 각 원소랑 비교
                    if(tree[k]==skill_trees[i].charAt(j)){
                        exist[++pos]=tree[k];
                        //System.out.println(pos);
                    }
                    
                }
            }
            if(pos==-1) answer++;
            else {
                for(l = 0; l<=pos; l++){
                    if(exist[l]!=tree[l]) break;
                }
                if(l==pos+1) answer++;
            }
            l = 0;
            pos=-1; //exist 초기화
        }
        return answer;
    }
}
