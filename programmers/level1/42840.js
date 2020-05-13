// 모의고사

function solution(answers) {
    var count = [], answer = [], i, j;
    var p = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]];
    for(i=0; i<3; i++){
        var cnt=0;
        for(j =0; j<answers.length; j++){
            if(answers[j]==p[i][j%p[i].length])
                cnt++;
        }
        count.push(cnt);
    }
    var max = Math.max.apply(Math, count);
    for(var i=0; i<3; i++){
        if(max==count[i])
            answer.push((i+1));
    }
    return answer.sort();
}
