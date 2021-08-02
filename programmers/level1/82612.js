// 위클리 챌린지 - 1주차

const solution = (price, money, count) => {
    const total = (count * (count + 1) / 2) * price
    return total <= money ? 0 : total - money;
}

