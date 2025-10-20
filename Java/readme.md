# 返回值类型
    方法可以返回多种类型的值: 基本数据类型（如int、double、boolean等），
    也可以是对象类型（如String、自定义的类实例等），甚至是数组类型。

# @Configuration
    

# 泛型
    创建泛型类：Box<T>表示Box类可持有任意类型T的数据 ‌
    声明泛型方法：processList(List<T> list)表示该方法可处理任何类型的列表 ‌
    实例化泛型类：Box<String> stringBox = new Box<>();创建指定String类型的Box实例 ‌
    List<String> list = new ArrayList<>();替代了传统的List<String> list = new ArrayList<String>();写法 ‌
    

    在Java中，尖括号<>主要有以下两种含义：
    泛型类型参数
    <>是泛型（Generics）的类型参数占位符，用于定义可变类型。例如：
    <>作为菱形操作符，用于简化泛型实例化代码。菱形操作符（Java 7引入）
    ‌注意‌：当编译器无法推断类型时，需显式指定类型参数（如List<String> list = new ArrayList<>();）


# List
 
    ‌创建List对象‌。
        动态数组实现：List<String> arrayList = new ArrayList<>();‌‌
        链表实现：List<String> linkedList = new LinkedList<>();‌‌
        快速创建不可变集合（JDK9+）：List<Integer> list = List.of(1, 2, 3);‌‌
 

    添加元素：
        add(E e) 末尾追加元素。‌‌    
        add(int index, E e) 指定位置插入。‌‌

    删除元素：
        remove(int index) 按索引删除。‌‌
        remove(Object o) 按元素值删除。‌‌

    访问元素：
        get(int index) 获取索引位置的元素。‌‌
        size() 获取集合元素数量。‌‌
 
    ‌遍历方式‌
        ‌传统for循环‌：通过索引遍历。‌‌‌‌
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        ‌增强for循环‌：简化遍历写法。‌‌‌‌
            for (String item : list) {
                System.out.println(item);
            }
        ‌迭代器遍历‌：支持并发修改检测。‌‌‌‌
            Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                System.out.println(it.next());
            }