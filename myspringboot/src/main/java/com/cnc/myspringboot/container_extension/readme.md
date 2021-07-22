## Spring 容器拓展


#### Spring BeanPostProcessor 接口拓展

Spring 允许实现 BeanPostProcessor 接口, 实现接口postProcessBeforeInitialization 与 postProcessAfterInitialization
分别在bean 创建的前后进行环绕处理; 需要注意的是,　这一操作会对所有的bean创建都起作用

##### 拓展：
可以通过自定义注解结合spring postprocessor 来进行自定义实现拦截; 拦截后进行一定的记录或者代理操作