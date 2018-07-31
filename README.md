# LearnKotlin
LearnKotlin

### 1 基础语法

##### 1.1 函数定义
函数定义使用关键字 fun，参数格式为：参数 : 类型
```kotlin
fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}
```
表达式作为函数体，返回类型自动推断：

```kotlin
fun sum(a: Int, b: Int) = a + b

public fun sum(a: Int, b: Int): Int = a + b
```
无返回值的函数：
```kotlin
fun printSum(a: Int, b: Int): Unit { 
    print(a + b)
}


public fun printSum(a: Int, b: Int) { 
    print(a + b)
}
```

##### 1.2 可变长参数
```kotlin
fun vars(vararg v: Int){
    for(vt in v){
        print(vt)
    }
}
```

##### 1.3 高阶函数与lambda表达式
以一个函数作为参数，或者返回值是函数的函数称为 高阶函数
```kotlin
1、无参数的函数作为函数入参
定义函数
fun action(body:()->Unit){
        body()
}
调用方法1
var l : ()->Unit = {
    println("hello")
}
action(l)

调用方法2
action({
    println("hello")
})

调用方法3
action{
   println("hello")
}

2、带参数和返回值得函数 作为形参
定义函数
fun action(a: Int, body:(Int, Int)->Int){
    body(3, 3)
}

调用方法1
var n : (Int, Int)->Int = {
    i, j ->
    i + j
}
action1(1, n)

调用方法2
action1(1, {
    i, j ->
    i + j
})

调用方法3
action1(1){
    i, j ->
    i + j
}
```

##### 1.5 默认参数
```kotlin
函数定义
fun defaultParam(a: Int, b: Int = 1, c: Int = 1){
    println("defaultParam:" + (a+b+c))
}

调用方法
defaultParam(1)
defaultParam(1, c=2)
defaultParam(1, b=2)
defaultParam(1, a=2, b=2)
```

##### 1.6 包级函数
定义在包级别的函数，不属于某个具体的类
同一个包中可直接调用
不同的包需要import导入

##### 1.7 局部函数
```kotlin
fun actionLocal(a: Int) {
    var x = 3
    fun localFun(a: Int) {
        println("localFun:$a")
    }

    localFun(a+x)
}
```

##### 1.8 变量与常量的定义
```kotlin
可变变量定义：var 关键字
不可变变量定义：val 关键字，只能赋值一次的变量

变量在定义时必须被初始化

延迟初始化：lateinit
```

##### 1.9 null检查机制
```kotlin
1、变量检查
//类型后面加?表示可为空
var age: String? = "3" 
//抛出空指针异常
val ages = age!!.toInt()
//不做处理返回 null
val ages1 = age?.toInt()
//age为空返回-1
val ages2 = age?.toInt() ?: -1

2、方法检查
fun parseInt(str: String?): Int? {
  // ...
}
```

##### 1.10 区间
in 运算符来检测某个数字是否在指定区间内，区间格式为 x..y
```kotlin
in 用于判断语句
fun rangeTest(){
    val x = 5
    val y = 9
    if (x in 1..8) {
        println("x 在区间内")
    }

    if (y  !in 1..8) {
        println("y 不在区间内")
    }
}

in 用于循环语句
fun rangeLoop(){
    for (x in 1..8) {
        println("$x")
    }
}

step 增长步长
downTo 递减
```

### 2 类
#### 2.1 类定义
```kotlin
class KotlinClass{

}
```
类属性修饰词：
```kotlin
abstract    // 抽象类  
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
```

访问权限修饰词：
```kotlin
private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
```

#### 2.2 构造函数
构造函数有主次之分
主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀
```kotlin
open class KotlinClass(a: Int){

    //初始化代码段
    //可直接使用主构造器参数
    init {
        //code
    }
}
```
主构造器的参数可以在初始化代码段中使用
次级构造函数，需要加前缀constructor

```kotlin
//次级构造函数
constructor(a: Int, b: Int) : this(a){
    sum(a, b)
}
```
如果类有主构造函数，每个次构造函数都要直接或间接代理主构造函数

### 3 继承
#### 3.1 类继承
如果一个类要被继承，必须使用 open 关键字进行修饰
```kotlin
open class Base(a: Int)         //基类

class Child(a: Int) : Base(a)   //子类
```

子类有主构造函数
```kotlin
open class KotlinClass(a: Int){  //基类

}

class KotlinChildClass(a: Int) : KotlinClass(a) {   //子类有主构造函数

}
```

子类没有主构造函数
```kotlin
open class KotlinClass(a: Int){  //基类

}

class KotlinChildClass1 : KotlinClass {   //子类没有主构造函数

    //子类没有主构造函数，则在每一个次级构造函数中用 super 关键字初始化基类，或者代理另一个构造函数
    constructor(a: Int): super(a){

    }
    
    constructor(a: Int, b: Int): this(a){
    
    }
}
```

#### 3.2 方法重写
父类使用fun声明的函数默认为final，不能被子类重写。
如果子类要重写该函数，必须使用open修饰, 子类重写必须使用 override
```kotlin
//默认所有方法都是final
//如要重写必须使用open修饰
open fun sum(a: Int, b: Int): Int {
    return a + b
}
    
//子类重写必须使用 override
override fun sum(a: Int, b: Int): Int {
    return 2
}    
```

### 4 接口
1、接口可以有已实现的方法

2、多接口重复函数重写

### 5 扩展
```kotlin
对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式

若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
```

### 6 伴生

伴生对象类似于static



