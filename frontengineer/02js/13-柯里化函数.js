// 在函数式编程当中，我们其实希望一个函数处理的问题尽可能单一，柯里化函数可以将每次传入的参数在一个函数中
// 处理， 再讲处理的结果传递到下一个函数当中去
function sum (x) {
    x = x + 2;
    return function (y) {
        y = y + 2;
        return function (z) {
            return x + y + z;
        }
    }
}
console.log(sum(10)(20)(30));
// 应用场景：打印日志