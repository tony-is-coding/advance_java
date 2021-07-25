## Spring 基础知识


#### PropertySource 属性资源

 属性资源获取的优先级顺序 以下每一项相当于持有一个 PropertySource 的对象实例
1. ServletConfig 参数（如果适用 - 例如，在DispatcherServlet上下文的情况下）
2. ServletContext 参数（web.xml 上下文参数条目）
3. JNDI 环境变量（java:comp/env/条目）
4. JVM 系统属性（-D命令行参数）
5. JVM系统环境（操作系统环境变量）

Spring 还允许自定义 PropertySource 添加到整个属性查找链上;
```$java
ConfigurableApplicationContext ctx = new GenericApplicationContext();
MutablePropertySources sources = ctx.getEnvironment().getPropertySources();
sources.addFirst(new MyPropertySource());
```