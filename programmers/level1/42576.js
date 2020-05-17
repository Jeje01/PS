// 완주하지 못한 선수

function solution(participant, completion) {
    participant.sort(); completion.sort();
    for(var i in completion){
        if(completion[i]!=participant[i])
            return participant[i];
    }
    return participant[participant.length-1]
}
