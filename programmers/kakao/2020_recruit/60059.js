// 자물쇠와 열쇠

const solution = (key, lock) => {
  const n = lock.length,
    m = key.length;
  const start = m - 1,
    end = m + n - 1,
    expandSize = n + (m - 1) * 2;
  // 열쇠를 90도 회전
  const rotate = (key) => {
    let nextKey = Array(m);
    for (let i = 0; i < m; i++) {
      nextKey[i] = Array(m);
    }
    for (let i = 0; i < m; i++) {
      for (let j = 0; j < m; j++) {
        nextKey[j][m - i - 1] = key[i][j];
      }
    }
    return nextKey;
  };
  // 확장 배열 만들어 확인
  const func = (keyR, keyC, key) => {
    const row = new Array(expandSize).fill(0);
    const expanded = new Array(expandSize);
    for (let i = 0; i < expandSize; i++) {
      expanded[i] = Array.from(row);
    }
    for (let i = 0; i < m; i++) {
      for (let j = 0; j < m; j++) {
        expanded[i + keyR][j + keyC] += key[i][j];
      }
    }
    for (let i = start; i < end; i++) {
      for (let j = start; j < end; j++) {
        expanded[i][j] += lock[i - start][j - start];
        if (expanded[i][j] != 1) {
          return false;
        }
      }
    }
    return true;
  };
  let answer = true,
    i,
    j;
  // 90도 돌리며 확인
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < m - 1 + n; j++) {
      for (let k = 0; k < m - 1 + n; k++) {
        answer = func(j, k, key);
        if (answer) return true;
      }
    }
    key = rotate(key);
  }
  return false;
};
