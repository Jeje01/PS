// H-Index

// 20.05.28
function solution(citations) {
    var n = citations.length
    for(var i=n; i>0; i--){
        var paper=0, num=0
        citations.forEach(a => {if(a>=i) paper++})
        if(paper>=i) return i
    }
    return 0
}

/*
  24.03.23 (토)

  처음에 예시를 보고 착각했던 게 h가 citations의 요소 중 하나의 값이어야한다고 생각했다.
  하지만 그런 내용은 문제에 없기 때문에 일반화하면 안 된다. 
  4년 전 코드랑 비교해봤을 때 더 깔끔해진 것 같지만
  다른 블로그 글을 보니 배열을 정렬하면 특정 값보다 작은 수가 몇개인지 배열의 길이와 인덱스 계산만으로도 가능해보인다.
  하지만 효율성이 중요하지 않은 문제라면 그냥 이렇게 빠르게 풀어도 좋을 것 같다.
*/
const solution = (citations) => {
    citations.sort().reverse()
    for (i = citations.length; i >=0; i--) {
        const total = citations.filter((a) => a >= i).length
        if (total >= i) {
           return i    
        }
    }
}
