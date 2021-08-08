/**
 * Runtime: 68 ms, faster than 86.19% of JavaScript online submissions for Defanging an IP Address.
 * Memory Usage: 38.9 MB, less than 15.83% of JavaScript online submissions for Defanging an IP Address.
 *
 * replace('.', '[.]')의 형태로 사용하면 첫번째 문자만 바뀜
 * replaceAll처럼 사용하기 위해 정규표현식 필요
 * ?.*\ 문자는 escape(\) 필요
 **/
const defangIPaddr = (address) => {
  return address.replace(/\./gi, '[.]')
}
