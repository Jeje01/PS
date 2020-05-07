// 문자열 내 마음대로 정렬하기

function solution(strings, n) {
    strings.forEach((a, index) => strings[index] = a[n]+a);
    strings.sort();
    strings.forEach((a, index) => strings[index] = a.substring(1));
    return strings;
}
