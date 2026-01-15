// 相同输入具有相同的输出
let str = (str, name) => `${str} ${name}`
console.log(f('K', 'J'))
// 无副作用 副作用是改变了函数之外的内容，函数外部validate为false