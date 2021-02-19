// 정수 제곱근 판별

const solution = (n) => (Math.sqrt(n) % 1 === 0 ? Math.pow(Math.sqrt(n)+1, 2) : -1)

// 2021.02.19

const solution = (n) => {
    return Math.sqrt(n)%1 === 0 ? Math.pow(Math.sqrt(n)+1, 2) : -1;
}
