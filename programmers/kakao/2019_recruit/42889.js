// 실패율

function solution(N, stages) {
  var answer = [],
    count = [],
    users = stages.length,
    sum = 0;
  for (var i = 0; i < N + 1; i++) count.push(0);
  stages.forEach((a) => count[a]++);
  for (var i = 1; i < N + 1; i++) {
    var fail = users - sum == 0 ? 0 : count[i] / (users - sum);
    answer.push({ stage: i, fail: fail });
    sum += count[i];
  }
  answer.sort((a, b) => {
    if (a.fail == b.fail) return a.stage - b.stage;
    else return b.fail - a.fail;
  });
  return answer.map((a) => a.stage);
}
