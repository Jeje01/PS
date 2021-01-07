// 3진법 뒤집기

const toDecimal = (n) => {
    let mul = 1
    let dec = 0
    while (n!=0) {
        dec += (n%10) * mul
        n = Math.floor(n/10)
        mul *= 3
    }
    return dec
}

const toBaseThree = (n) => {
    let ret = ""
    while(n!=0) {
        ret += n%3
        n = Math.floor(n/3)
    }
    return ret
}

const solution = (n) => {
    return toDecimal(toBaseThree(n))
}
