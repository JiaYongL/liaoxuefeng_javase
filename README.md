廖雪峰java基础课程随堂代码

# java面向对象编程

## 数据封装

### 构造方法
- 实例创建时调用构造方法
- 构造方法用于初始化实例
- 没有定义构造方法时，编译器会自动创建默认构造方法
- 可以定义多个构造方法，编译器自动根据参数判断


### 方法重载
- 重载方法应该完成相同的功能，参考String的indexOf()
- 重载方法主要依靠参数类型和树龄区分
- 不要去交换参数顺序
- 重载方法返回值类型应该相同

## 继承和多态

### 继承
- 继承是面向对象变成的一种代码复用方式
- java只允许单继承
- protected允许子类访问弗雷的字段和方法
- 子类构造方法可以通过super()调用父类的构造方法
- 可以安全地向上转型为更抽象的类型
- 可以强制向下转型，最好借助instanceof判断
- 子类和父类的关系时is， has关系不能用继承


### 多态
- 子类可以覆写父类的方法（override）
- 覆写在子类中改变了父类方法的行为
- 多态：java的方法调用总是作用于对象的世纪类型
- final修饰的方法可以阻止被覆写
- final修饰的class可以阻止被继承
- final修饰的field必须在创建对象时初始化

## 抽象类和接口

### 抽象方法
- 抽象方法定义了子类必须实现的接口规范
- 定义了抽象方法的类就是抽象类
- 从抽象类继承的子类必须实现抽象方法
- 如果不实现抽象方法，则该子类仍是一个抽象类
- 抽象方法不能实例化(My add)

### 接口
- 如果一个抽象类没有字段，所有方法都是抽象方法，就可以吧该抽象类改为接口(interface)
- 接口定义的方法默认是public abstract(不需要写)
- 一个类可以实现多个interface

| interface | abstra class | interface
:---------: | :----------: | :-------: |
继承   | 只能extends一个clas | 可以implements多个interface
字段 | 可以定义实例字段 |  不能定义实例字段
抽象方法 | 可以定义抽象方法 | 可以定义抽象方法
非抽象方法 | 可以定义非抽象方法 | 可以定义default方法
- 一个interface可以继承自另一个interface
- interface继承自interface使用extends
- 接口继承接口相当于扩展了接口的方法

- 接口类定义了纯抽象方法
- 类可以实现多个接口
- 接口也是数据类型，适用于向上转型和向下转型
- 接口不能定义实例字段
- 接口可以定义default方法(JDK >= 1.8)

## 包和classpath

### 静态字段和方法
用static修饰的字段为静态字段
- 普通字段在每个实例中都有自己的一个独立空间
- 静态字段只有一个共享空间，所有实例都共享该字段

用static修饰的方法成为静态方法
- 调用实例方法必须通过实例变量
- 调用静态方法不需要实例变量
- 静态方法不能访问this变量（this变量是实例化后实例的别名，静态方法存在于实例化之前，所以不能使用this）
- 静态方法不能访问实例字段（同样的道理）
- 静态方法可以访问静态字段

静态方法通常用于工具类
- Arrays.sort()
- Math.random()

静态方法通常用于辅助方法

Java程序入口函数main()也是静态方法

- 静态字段属于所有实例"共享"的字段，实际上是属于class的字段
- 调用静态方法不需要实例，因此无法访问this（可能是相反的原因）
- 静态方法可以访问静态字段和其他静态方法
- 静态方法常用语工具类和辅助工具

### 作用域
- 如果不确定是否需要public，就不声明public，即尽可能少地暴露对外方法，从private改为public很容易，但是从public改为private很容易出错。
- 尽可能把局部变量的作用域缩小
- 尽可能延后声明局部变量
- final与访问权限不冲突
- final修饰class可以阻止被继承
- final修饰方法阻止被覆写
- final修饰field可以阻止被重新赋值
- final修饰局部变量可以阻止被重新赋值


----
- java内建访问权限有public、protected、private和package
- java在方法内部定义的变量是局部变量
- 局部变量作用域从声明开始到块结束
- final修饰符不是访问权限，可以同访问权限一起使用
- 一个java文件只能包含一个public class， 但是可以包含多个非public class


### classpath & jar
- classpath是一个环境变量
- classpath指示JVM如何搜索class
- classpath设置的搜索路径与操作系统相关

classpath设定方法：
- 直接在系统环境中设置classpath环境变量（不推荐）
- 在启动JVM时设置classpath变量（推荐）
    1. java -classpath /usr/share com.feiyangedu.Hello
    2. java -cp /usr/share com.feiyangedu.Hello
- 没有设置环境变量也没有指定-cp参数时，默认classpath为.，即当前目录
- eclipse中运行java程序默认传入的cp参数是当前工程的bin目录和引入的jar

jar包
- jar包相当于目录
- 包含若干class文件
- 使用jar包可以避免大量的目录和class文件
- META-INF/MANIFEST.MF可以提供jar包信息，如Main-Class
- 不需要在classpath中引入包含java核心类的rt.jar

## java核心类

### 字符串和编码

String特点：
- 内容不可变
- 可以直接使用"……"
- equals(Object)
- boolean contains(CharSequence)
- trim()，移除首位空字符（空格、\t、\r、\n），trim不改变字符串的内容，而是返回新的字符串
- subString()
-------
- 字符串操作不改变原来字符串内容，而是返回新的字符串
- 常用字符串操作：提取字串、查找、替换、大小写转换等
- 字符串和byte[]转换时需要注意编码，建议使用UTF-8编码

### StringBuilder
- StringBuilder可以高效拼接字符串
- StringBuilder是可变对象，会预先分配缓冲区。
- 可以进行链式操作，实现链式操作的关键是返回实例本身。

StringBuffer
- StringBuffer是StringBuilder的线程安全版本，接口与StringBuilder完全相同
- 没有必要使用StringBuffer

### 包装类型
java数据类型：
- 基本类型：int，boolean, float……
- 引用类型：所有class类型

基本类型不可以当作一个对象，要想以对象访问，就需要包装类型
JDK为每种类型都创建类对应的包装类型

| 基本类型 | 对应的引用类型 |
| :------:| :-----------:|
| boolean | Boolean |
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| char | Character |

例如：
```java
Integer n = new Integer(99);
int i = n.intValue();
```
```java
int i = 100;

Integer n1 = new Integer(i);
Integer n2 = Integer.valueOf(i);
Integer n3 = Integer.valueOf("100");

int x1 = n1.intValue();
int x2 = Integer.parseInt("100");
String s = n1.toString();

//注意这个getInteger，并不是从字符串中获取整数，而是从系统环境变量中获取相应的值
Integer prop = Integer.getInteger("cpus");

```

- 编译器可以自动在int和Integer之间转型：
    - 自动装箱(auto boxing)：int -> Integer
    - 自动拆箱(auto unboxing)：Integer -> int
- 自动装箱和自动拆箱只发生在编译阶段
- 装箱和拆箱会影响执行效率
- 编译后的class代码是严格区分基本类型和引用类型的
- Integer -> int 执行时可能会报错（如果实例对象为null，则拆箱失败：NullPointException）
- java包装类型定义了一些有用的静态变量
- java包装类型全部继承自Number这个类

![Number][1]

------

- JDK的包装类型可以把基本类型包装成class
- 自动装箱和拆箱是编译器完成的（JDK >= 1.5）
- 装箱和拆箱会影响执行效率
- 注意拆箱可能发生NullPointException

### JavaBean
- JavaBean是一种符合命名规范的class
- JavaBean通过getter/setter来定义属性
- 属性是一种通用的叫法，并非Java语法规定
- 可以利用IDE快速生成getter和setter
- 使用Introspector.getBeanInfo获取属性列表

### 枚举类
- enum可以定义常亮类型，它被编译器编译为：final class Xxx extends Enum {...}
- name()获取常量定义的字符串，注意不要使用toString()（toString方法可能被覆写）
- ordinal()返回常量定义的顺序（无实质意义）
- 可以为enum类编写构造方法、字段和方法
- 构造方法声明为private（不声明也可以JDK10）

### 常用工具类
Math
    
    Math提供了数学计算的静态方法
- abs / min / max
- pow / sqrt / exp / log / log10
- sin / cos / tan / asin / acos ...

- 常量
    - PI = 3.14159...
    - E = 2.71828...
- Math.random()方法生成一个随机数：
    - 0 <= Math.random() < 1
    - 可用于生成某个区间的随机数
```java
long MIN = 1000;
long MAX = 9000;
double x2 = Math.random() * (MAX - MIN) + MIN;
double r = (long) x2;
```

Random
    
    Random用来创建伪随机数
- nextInt / nextLong / nextFloat...
- nextInt(N)生成不大于N的随机数
- 什么是伪随机数？
    - 给定种子后伪随机数算法会生成完全相同的序列
    - 不给定种子时Random使用系统当前时间戳作为种子

SecureRandom

    SecureRandom用于创建安全的随机数，缺点是比较慢
    
BigInteger

    BigInteger用任意多个int[]来表示非常大的整数。

BigDecimnal

    BigDecimal表示任意精度的浮点数。
    BigInteger和BigDecimnal多用于财务计算中。


# Java异常处理

## 错误处理

### Java的异常
- 计算机运行过程中错误是不可避免的

Java异常体系：

![Java异常体系][2]

- Java规定必须捕获的异常是Exception及其子类，但不包括RuntimeException及其子类
- Java使用异常来表示错误，通过try{...} catch {...}捕获异常
- Java的异常是class，并且从Throwable集成
- Error是无需捕获的严重错误
- Exception是应该捕获的可处理的错误
- RuntimeException无需强制捕获，非RuntimeException(CheckedException)需要强制捕获，或者用throws声明。

## 断言和日志
### 断言

- 断言是一种调试方式，断言失败会抛出AssertionError
- 只能在开发和测试阶段启动断言
- 对可恢复的错误不能使用断言，而应该抛出异常
- 断言很好被使用，更好的方法是编写单元测试。

### Logging

- 日志是为了替代System.out.println()，可以定义格式，重定向到文件。
- 日志可以存档，便于问题追踪
- 日志可以按级别分类，便于打开和关闭某些级别
- 可以根据配置文件调整日志，无需修改代码
- JDK提供了Logging：java.util.logging

### Commons Logging

- Commons Logging定义了6个日志级别：
    - FATAL
    - ERROR
    - WARNING
    - INFO <---------------默认级别
    - DEBUG
    - TRACE

- Commons Logging 是使用最广泛的日志模块
- Commons Logging 的API非常简单
- Commons Logging 可以自动使用其他日志模块

## Log4j

- 目前最流行的日志框架：
    - 1.x: Log4j
    - 2.x: Log4j2
- 始终使用Commons Logging接口来写入日志
- 开发阶段无需引入Log4j
- 使用Log4j只需要把正确的配置文件和相关的jar包放入classpath
- 使用配置文件可以灵活修改日志，无需修改代码
- 如果要更换Log4j，只需要移除log4j.xml和相关jar包
- 只有扩展log4j时，才需要引入Log4j的接口


# Java反射与泛型

## 反射

### Class类
- JVM为每个class创建对应的Class实例来保存class的所有信息
- 获取一个class对应的Class实例后，就可以获取该class的所有信息
- 通过class实例获取class信息的方法称为反射Reflection
- JVM总是动态加载class，可以在运行期根据条件控制加载class

### 访问字段
- Field字段封装了字段的所有信息
- 通过Class实例的方法可以获取Filed实例：getField / getFields / getDeclaredField / getDeclaredFields
- 通过Field实例可以获取字段信息：getName / getType / getModifiers
- 通过Field实例可以读取或设置某个对象的字段： get(Object name) / set(Object instance, Object fieldValue)
- 通过设置setAccessible(true)来访问非public字段，但是注意：setAccessible(true)可能会失败，如果jvm定义来SecurityManager，并且SecurityManager的规则阻止对该Field设置accessible，就会导致失败

### 调用方法
- Method对象封装了方法的所有信息
- 通过class实例的方法可以获取Method实例：getMethod / getMethods / getDeclaredMethod / getDeclaredMehtods
- 通过Method实例可以获取方法信息：getName / getReturnType / getParameterTypes / getModifiers
- 通过Method实例可以调用某个对象的方法：Object invoke(Object instance, Object... parameters)
- 通过设置setAccessible(true)来访问非public方法

### 调用构造方法
- Constructor对象封装来构造函数的所有信息
- 通过Class实例的方法可以获取Constructor实例： getConstructor / getConstructors / getDeclaredConstructor / getDeclaredConstructors
- 通过Constructor实例可以创建一个实例对象：newInstance(Object... parameters)
- 通过设置setAccessible(true)来访问非public构造方法

### 获取继承关系
- 通过Class对象获取继承关系：
    - getSuperclass()
    - getInterfaces()
- 通过Class对象的isAssignableFrom()方法可以判断一个向上转型是否正确。

## 泛型

### 什么是泛型
- 泛型就是编写模板代码来适应任意类型
- 不必对类型进行强制转换
- 编译器将对类型进行检查
- 注意泛型的继承关系：
    - 可以把ArrayList<Integer>向上转型为list<Integer>（T不能变）
    - 不能把ArrayList<Integer>向上转型为ArrayList<Number>

### 使用泛型
- 使用泛型时，把泛型参数<T>替换为需要的class类型：List<String> list = new ArrayList<String>()
- 可以省略编译器能自动推断出的类型：List<String> list = new ArrayList<>()
- 不指定泛型参数类型时，编译器会给出警告，且只能将<T>视为Object类型

### 编写泛型
- 编写泛型事，需要定义泛型类型<T>
```java
public class Pair<T> {...}
```
- 静态方法不能引用泛型类型<T>，必须定义其他类型<K>来实现“泛型”
```java
public static <K> Pair<K> create(K first, K last) {...}
```
- 泛型可以同事定义多种类型<T, K>
```java
public class Pair<T, K> {...}
```

### 擦拭法
- Java的范型采用擦拭法实现
- 擦拭法决定来范型<T>:
    - 不能是基本类型，例如int
    - 不能获取带范型类型的Class，如：Pair<String>.class
    - 不能判断带范型类型的类型， 如：x instanceof Pair<String>
    - 不能实例化T类型，如：new T()
    - 范型方法要防止重复定义方法，例如：public boolean equals(T obj)
- 子类可以获取父类的范型类型<T>

### Java类型与反射
- 部分反射API是范型：
    - Class<T>
    - Constructor<T>
- 可以声明带泛型的数组，但是不能直接创建带泛型的数组，必须潜质转型
- 可以通过Array.newInstance(Class<T>, int)创建T[]数组，需要强制转型


# Java集合

## Java集合简介

### Java集合简介
- java集合定义在java.util包中
- 常用的集合类包括List、Set、Map等
- Java集合使用统一的Iterator遍历集合
- 尽量不要使用遗留接口

## List

### 使用List
- ArrayList VS LinkedList:

|       | ArrayList | LinkedList |
| :---: | :-------: | :--------: |
|获取指定元素| 速度很快| 需要从头开始查找元素
|添加删除元素| 速度很快| 速度很快
|在指定位置添加/删除| 需要移动元素| 不需要移动元素
|内存占用| 少 | 较大

list的特点
- 按照索引顺序访问的长度可变的链表
- 优先使用ArrayList而不是LinkedList
- 可以直接使用for……each遍历
- 可以和Array相互转换

### 编写equals方法
如果在List中查找元素：
- List的实现类通过元素的equals方法比较两个元素
- 放入的元素必须正确覆写equlals方法， JDK提供类的String，Integer等已经覆写类eauqls方法
- 编写equals方法可借助Object.equals()判断

如果不在List中查找元素：
- 不必覆写equals方法

[1]: https://www.tutorialspoint.com/java/images/number_classes.jpg
[2]: http://7xs7kk.com1.z0.glb.clouddn.com/exception-structure.jpg