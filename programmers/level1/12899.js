// 124 나라의 숫자

function solution(n) {
    var answer = '';
    var num = [1, 2, 4];
    while(n!=0){
        answer = num[(n-1)%3] + answer;
        n = (n-((n-1)%3+1))/3;
    }
    return answer;
}
