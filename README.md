# easy_call
##通过注解 @Call()的方式来调用组件的onClick()方法
##使用方法：
###1在被调用的组件上加注解：
```
@Call(type = FloatingActionButton.class, name = "fab", id = R.id.fab)
FloatingActionButton fab;
```
### 2 初始化builder
```
Builder builder = Builder().getBuilder();
builder.addPage(this, "main");
```
### 3 调用处：
```
builder.getCall("main", "fab").call();
```
