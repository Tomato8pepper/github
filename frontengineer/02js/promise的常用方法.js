
/*
Promise.resolve(value)。
用于将现有对象转为 Promise 对象，如果参数是一个值，则直接返回一个处于 resolved 状态的
Promise 对象。123
Promise.reject(reason)。
用于将现有对象转为 Promise 对象，如果参数是一个值，则直接返回一个处于 rejected 状态的 Promise 对象。
Promise.then([onFulfilled, onRejected])。
用于注册异步操作成功或失败时的回调函数。如果异步操作成功，
则执行 onFulfilled 函数；如果异步操作失败，则执行 onRejected 函数。123456
Promise.catch(onRejected)。
用于注册异步操作失败时的回调函数。如果异步操作失败，则执行 onRejected 函数。
Promise.finally(onFinally)。
用于注册一个无论异步操作成功或失败都会执行的回调函数。135
Promise.all([promises])。
用于同时处理多个 Promise 对象，返回一个新的 Promise 对象，
并发
只有当所有 Promise 对象都成功才会成功、数组为空或有一个失败时，新的Promise 对象才会失败。
Promise.race([promises])。
用于处理多个 Promise 对象，返回一个新的 Promise 对象，只要其中一个 Promise 对象成功或失败，
新的 Promise 对象就会相应地成功或失败。13456
Promise.any(promises)。
用于处理多个 Promise 对象，返回一个新的 Promise 对象，只要有一个 Promise 对象成功，
新的 Promise 对象就会成功，所有的失败了，就是失败。35
Promise.allSettled(promises)。
用于同时处理多个 Promise 对象，返回一个新的 Promise 对象，每个 Promise 对象的
状态（fulfilled 或 rejected）都会被记录下来。356

Promise的三种状态：promise对象通过自身的状态，来控制异步操作，promise实例具有三种状态.
             pending：异步操作未完成
             fulfilled：异步操作成功
             rejected：异步操作失败
     实例化pending状态，异步操作成功实例就传回一个值，状态变为fulfilled
     异步操作失败，实例就抛出一个错误，状态变为rejected.
function timer () {
return new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve()
    }, 1000)
})
}
timer().then((res) => {
console.log(res)
}, (err) => {
console.log(err)
})
*/