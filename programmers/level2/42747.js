// H-Index

function solution(citations) {
    var n = citations.length
    for(var i=n; i>0; i--){
        var paper=0, num=0
        citations.forEach(a => {if(a>=i) paper++})
        if(paper>=i) return i
    }
    return 0
}
