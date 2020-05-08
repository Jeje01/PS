function solution(board, moves) {
    var answer = 0, pos = [], n = board.length, bag = [];
    var i, j;
    for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            if(board[j][i]!=0){
                pos.push(j);
                break;
            }
        }
    }
    for(i=0; i<moves.length; i++){
        var next = moves[i]-1;
        if(pos[next]>=n) continue;
        bag.push(board[pos[next]][next])
        pos[next]++;
    }
    i=1;
    while(i!=bag.length){
        if(bag[i]===bag[i-1]){
            bag.splice(i, 1); bag.splice(i-1, 1);
            answer+=2;
            i--;
        }else{
            i++;
        }
    }
    return answer;
}