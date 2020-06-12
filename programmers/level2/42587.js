// 프린터 - 스택/큐

function solution(priorities, location) {
    var arr=[], print=[]
    priorities.forEach((a, i) => arr.push({"pos":i, "value":a}))
    while(arr.length!=0){
        var tmp = arr.shift();
        var check = false;
        arr.forEach(a => {
            if(tmp["value"] < a["value"]){
                check = true;
            }
        })
        if(check == true){
            arr.push(tmp)
        }else{
            print.push(tmp)
        }
    }
    return print.findIndex(a => a.pos == location)+1
}
