// 두 개 뽑아서 더하기

const solution = (numbers) => {
    const list = []
    for(let i=0; i<numbers.length; i++){
        for(let j=0; j<numbers.length; j++){
            if(i==j) continue;
            let tmp = numbers[i]+numbers[j];
            if(!list.includes(tmp))
                list.push(tmp)
        }
    }
    list.sort((a, b) => a-b)
    return list
}
