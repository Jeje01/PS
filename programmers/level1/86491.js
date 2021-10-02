// 최소직사각형

const solution = (sizes) => {
    sizes = sizes.map((size) => size.sort((a, b) => a - b))
    return Math.max(...sizes.map((size) => size[0])) * Math.max(...sizes.map((size) => size[1]))
}
