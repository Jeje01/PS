// 소수 만들기

function solution(nums) {
    var answer = 0, notPrime=[], i
    nums.sort()
    var max = 3000
    for(i=0; i<max; i++)
        notPrime.push(0)
    for(i=2; i<max; i++){
        if(notPrime[i]==1) continue
        for(var j=i*2; j<max; j+=i){
            notPrime[j] = 1
        }
    }
    for(i=0; i<nums.length-2; i++){
        var tmp=nums[i]
        for(var j=i+1; j<nums.length-1; j++){
            var tmp2 = tmp+nums[j]
            for(var k=j+1; k<nums.length; k++){
                var tmp3 = tmp2+nums[k]
                if(notPrime[tmp3]==0) {
                    answer++
                }
            }

        }
    }
    return answer
}
