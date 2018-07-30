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

##### 1.3 lambda表达式


##### 1.4 变量与常量的定义

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

#### 2.3 属性

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


