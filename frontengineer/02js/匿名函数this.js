var name = 'window'
var person = {
    name :'Alan',
    sayName:function () {
        // let that = this
        return function () {
            // console.log(that.name)
            console.log(this.name)
        }
    }
}
person.sayName()() //window
    
var name = 'window'
var person = {
    name :'Alan',
    sayName:function () {
        return () => {
            console.log(this.name)
        }
    }
}
person.sayName()() // Alan