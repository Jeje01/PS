// 문자열 압축

function solution(s) {
    function getLength(n){
        var array = [];
        var compressed="", count=1, temp="";
        for(var i=0; i<s.length; i+=n){
            array.push(s.substring(i, i+n))
        }
        for(var i=1; i<array.length; i++){
            if(array[i]==array[i-1]){
                count++;
                temp=array[i];
            }else{
                if(count!=1){
                    compressed+=count+temp;
                    count=1;
                }else{
                    compressed+=array[i-1];
                }
            }
        }
        if(count!=1){
            compressed+=count+temp;
        }else{
            compressed+=array[i-1];
        }
        return compressed.length;
    }
    
    var answer = 0;
    var outputs = [];
    for(var i=1; i<s.length/2+1; i++){
        outputs.push(getLength(i))
    }
    answer = Math.min.apply(Math, outputs)
    return answer;
}
