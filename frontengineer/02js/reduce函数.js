
    // 数组累加和
    let arr = [5, 5, 5, 5, 5]
    
    let s = arr.reduce( (sum, current, index) => {
        // sum初始值为第二个参数，后面为两数之和
        // current为数组当前每一项
        return sum + current;          // 6, 5  6+5, 5  6+5+5, 5  6+5+5+5,5  6+5+5+5+5,5  6+5+5+5+5+5
    }, 6)
    
    console.log(s); // 31


    // 对象数组的累加和
    let arr = [
        {
            name: 'jack',
            count: 10
        },
        {
            name: 'rose',
            count: 20
        }
    ]
    
    let s = arr.reduce((sum, current, index) => {
        return sum + current.count
    }, 50)
    console.log(s); // 80
    
    // 对象数组分组求和
    let arr = [
        {name: 'jack', course: '语文', count: 100 },
        {name: 'jack', course: '英语', count: 100 },
        {name: 'jack', course: '数学', count: 100 },
        {name: 'rose', course: '语文', count: 50 },
        {name: 'rose', course: '英语', count: 50 },
        {name: 'rose', course: '数学', count: 50 },
    ]
    let s2 = arr.reduce((obj, current, index) => {
        let name = current.name;
        let count = current.count;
        
        let oldCount = obj[name];
        if(oldCount) {
            obj[name] = oldCount + count;
        } else {
            obj[name] = count;
        }
        return obj;
    }, {})
    console.log('s2', s2);     //{jack: 300, rose: 150}
    
    // 二维数组的处理
    let arr = [
            ['红色', '黑色', '白色'],
            ['16G', '32G'],
            ['移动版', '联通版']
        ]
    [ [ '红色', '16G', '移动版' ],
      [ '红色', '16G', '联通版' ],
      [ '红色', '32G', '移动版' ],
      [ '红色', '32G', '联通版' ],
      [ '黑色', '16G', '移动版' ],
      [ '黑色', '16G', '联通版' ],
      [ '黑色', '32G', '移动版' ],
      [ '黑色', '32G', '联通版' ],
      [ '白色', '16G', '移动版' ],
      [ '白色', '16G', '联通版' ],
      [ '白色', '32G', '移动版' ],
      [ '白色', '32G', '联通版' ] ]
      
    // =====================================  
    
    let arr = [
        ['红色', '黑色', '白色'],
        ['16G', '32G']
    ]
    let s = arr.reduce( (res, current, index) => {
        // 处理第一组
        if (index == 0) {
            current.forEach(item => {
                res.push([item])
            })
        }
        retrun res;                 // ['红色', '黑色', '白色']
    }, [])
    
    // =====================================
    
    let arr = [
        ['红色', '黑色', '白色'],
        ['16G', '32G'],
        ['移动版', '联通版']
    ]
    let s = arr.reduce( (res, current, index) => {
        // 处理第一组
        if (index == 0) {
            current.forEach(item => {
                res.push([item])
            })
        }else {
            let newArr = [];
            res.forEach(tempArr => {
                current.forEach(ele => {
                    newArr.push([...tempArr, ele])
                    console.log(newArr);
                })
            })
            res = newArr;
        }
        return res;
    }, [])
    console.log(s)
    
    
    
    // 二维数组处理结果为对象
    let arr = [
        ['红色', '黑色', '白色'],
        ['16G', '20G'],
        ['移动版', '联通版']
    ]
    [ { attr0: '红色', attr1: '16G', attr2: '移动版' },
      { attr0: '红色', attr1: '16G', attr2: '联通版' },
      { attr0: '红色', attr1: '20G', attr2: '移动版' },
      { attr0: '红色', attr1: '20G', attr2: '联通版' },
      { attr0: '黑色', attr1: '16G', attr2: '移动版' },
      { attr0: '黑色', attr1: '16G', attr2: '联通版' },
      { attr0: '黑色', attr1: '20G', attr2: '移动版' },
      { attr0: '黑色', attr1: '20G', attr2: '联通版' },
      { attr0: '白色', attr1: '16G', attr2: '移动版' },
      { attr0: '白色', attr1: '16G', attr2: '联通版' },
      { attr0: '白色', attr1: '20G', attr2: '移动版' },
      { attr0: '白色', attr1: '20G', attr2: '联通版' } ]

    
    // ==========================================
    
    let arr = [
        ['红色', '黑色', '白色'],
        ['16G', '20G'],
        ['移动版', '联通版']
    ]
    let s = arr.reduce( (res, current, index) => {
        if(index == 0) {
            current.forEach(ele => {
                res.push({[ 'attr' + index] : ele})
            })
        } else {
            let newArr = [];
            res.forEach( obj => {
                current.forEach(ele => {
                    newArr.push({...obj, ['attr，' + index] : ele})
                })
            })
            res = newArr;
        }
        return res;
    }, []);
    console.log(s)