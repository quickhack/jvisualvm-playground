jvisualvm playground
==========================

本工程演示`jvisualvm`的使用。

`sample` `CPU`操作的特点
-------------------------------

`sample` `CPU`的实时数据有`CPU Sample`和`Thread CPU Time`2个Tab。

### `CPU Sample` Tab

信息显示有4列：

- Hot Spots - Method
- Self time\[%]
- Self time
- Self time(CPU)

可以看到实时数据只能看到方法的Self time（自用时间），不能直接看到包含调用子方法的执行时间（这对业务流程分析往往更有直接意义）。

点包含调用子方法的方法执行时间可以

只有线程处于处理时，才能`sample`到数据。关于这一点见演示示例[com.oldratlee.jvisualvm.Testee](src/main/java/com/oldratlee/jvisualvm/Testee.java)。

### `Thread CPU Time` Tab

相关资料
-----------------------

- [visualvm](http://visualvm.java.net/)
    - [Features](http://visualvm.java.net/features.html)
    - [VisualVM Documentation and Resources](http://visualvm.java.net/docindex.html)
- [Difference between sampling and profiling in jVisualvm](http://stackoverflow.com/questions/12130107/difference-between-sampling-and-profiling-in-jvisualvm)
- [Profiling Vs. Sampling in Java’s VisualVM](https://blog.idrsolutions.com/2014/04/profiling-vs-sampling-java-visualvm/)
- [Sampling in visual vm](http://stackoverflow.com/questions/1831349/sampling-in-visual-vm)
- [VisualVM 1.2 Adds Powerful New Performance and Memory Profiler](http://java.dzone.com/announcements/visualvm-12-great-java)
