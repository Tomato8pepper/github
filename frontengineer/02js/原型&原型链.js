/* 
    显示原型：每个构造函数都有一个显示原型prototype
    隐式原型: 每一个实例都有一个隐式原型__proto__ var arr = []; arr.proto === Array.prototype

    原型链
    查找实例对象的方法和属性时，先在自身找，找不到沿着__proto__向上找，把__proto__形成的链条关系
    称为原型链
*/