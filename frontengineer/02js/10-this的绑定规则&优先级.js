/* 

new > 显示绑定 > 隐式绑定 > 默认绑定

默认绑定: 函数在全局环境下调用，this指向全局对象，使用严格模式，this绑定到undefined
隐式绑定: 对象内的函数调用，多层对象引用还是指向原对象，函数内在有一个函数，this指向window
显示绑定: apply 第二个参数是一个数组、 bind 参数列表返回值是函数没有立即执行、 call参数列表
一个一个传出去 不同之处：call、apply会调用函数，并且改变函数内部this指向，call(null,1,3,5)和
apply(null,[1,3,5])传递的参数 不一样，call传递参数使用逗号隔开，apply使用数组传递，Bind不会调用函数
可以改变函数内部this的指向
new绑定: new Animal();

*/
