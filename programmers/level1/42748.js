// K번째수

function solution(array, commands) {
    var answer = [];
    var len = commands.length;
    var i;
    for(i=0; i<len; i++){
        answer.push(array.slice(commands[i][0]-1, commands[i][1]).sort((a,b)=> a-b)[commands[i][2]-1]);
    }
    return answer;
}
