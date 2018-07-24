# LearnKotlin
LearnKotlin

### 基础语法

##### 函数定义
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

##### 可变长参数
##### lambda表达式
##### 变量与常量的定义

### 类
#### 类定义
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

#### 构造函数
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
如果类有主构造函数，每个次构造函数都要直接或间接代理主构造函数
```kotlin
//次级构造函数
constructor(a: Int, b: Int) : this(a){
    sum(a, b)
}
```

#### 属性

### 继承
如果一个类要被继承，可以使用 open 关键字进行修饰
```kotlin
open class Base(p: Int)           //基类

class Derived(p: Int) : Base(p)
```

