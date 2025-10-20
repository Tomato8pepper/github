// 检测数组
console.log([] instanceof Array) 
console.log(Array.isArray(1))

// 转换方法
// toLocaleString() toString() valueOf()

// 栈方法
let ar = [1, 2, 3, 4]
console.log(ar.push(5, 5), ar)
console.log(ar.pop(8), ar)

// 队列方法
let arr = [1, 2, 3, 4]
console.log(arr.shift(5), arr)
console.log(arr.unshift(8), arr)

// 排序方法
let arrr = [1, 2, 3, 4]
let arrb = [{id: 2}, {id: 3}, {id: 1}, {id: 8}, {id: 5}];
console.log(arrr.sort((a, b) => a - b))
console.log(arrr.sort((a, b) => b - a))
console.log(arrb.sort((a, b) => a.id - b.id))
console.log(arrb.sort((a, b) => b.id - a.id))

// 操作方法
let arrra = [1, 2, 3, 4]
let arrrb = [5, 6]
console.log(arrra.concat(arrrb))
console.log(arrra.concat(arrrb).slice(2,4))
console.log(arrra.concat(arrrb).splice(2,4))   // 删除下标，元素个数， 新补充元素