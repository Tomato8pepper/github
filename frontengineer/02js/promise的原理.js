/*
Promise的原理主要基于异步编程，它是一个对象，用于处理异步操作的结果。Promise的核心在于其状态的
管理，它有三种 状态：pending（等待态）、fulfilled（成功态）、rejected（失败态）。这些状态一旦
改变，就不会再变，意味着Promise 对象的状态是单向的，且不可逆。 状态管理：Promise对象在创建时处于
pending状态，表示异步操作正在进行中。当异步操作成功完成时，状态变为fulfilled， 此时可以通过then方法
注册的回调函数来处理成功的结果。如果异步操作失败，状态变为rejected，此时可以通过then方法 注册的回调
函数来处理错误。 then方法：Promise实例的then方法用于指定Promise对象状态改变时的回调函数。它接受两个
参数：第一个是成功回调函数， 第二个是失败回调函数。当Promise对象的状态从pending变为fulfilled时，会
调用第一个回调函数；如果状态从pending 变为rejected，则调用第二个回调函数。 链式调用：Promise的then
方法返回一个新的Promise对象，这使得可以链式调用多个then方法，形成所谓的"then链"。这种链式 调用的方式
允许我们按照异步操作完成的顺序执行一系列操作。 Promise的创建：创建一个Promise实例需要传入一个执行器
函数作为参数，该函数接收两个参数：resolve和reject。这两个 参数都是函数类型，分别用于改变Promise对象
的状态为fulfilled或rejected。 不可变性：一旦Promise对象的状态被resolve或reject，它的状态就不会再
改变，这意味着一旦异步操作的结果确定（无论是 成功还是失败），这个结果就被"锁定"，不会再变。 总的来
说，Promise通过其状态的管理、then方法的回调注册以及链式调用的方式，为异步编程提供了一种解决方案，使得
异步操 作的结果可以以同步的方式被处理和传递。
*/