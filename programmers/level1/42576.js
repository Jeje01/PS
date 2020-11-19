// 완주하지 못한 선수

function solution(participant, completion) {
    participant.sort(); completion.sort();
    for(var i in completion){
        if(completion[i]!=participant[i])
            return participant[i];
    }
    return participant[participant.length-1]
}

// 20201119

const solution = (participant, completion) => {
    participant.sort()
    completion.sort()
    let idx = 0
    while(idx < completion.length){
        if(participant[idx] === completion[idx]){
            idx ++
        }else {
            return participant[idx]
        }
    }
    return participant[idx]
}
