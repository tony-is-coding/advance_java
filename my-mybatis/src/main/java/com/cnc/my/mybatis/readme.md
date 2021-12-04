#### SqlSession 接口 

- 只要实现基本的 CURD 方法
- 默认有一个DefaultSqlSession
  - DefaultSqlSession 持有一个 Executor 与 一个 Configuration
    - Executor 用于执行 statement, 复杂与对应的db 交互
    - Configuration 管理对应的映射sql表, 获取 MappedStatement 给到executor执行

#### SqlSessionFactory 接口
1. SqlSession 的创建工厂
2. 默认有一个 DefaultSqlSessionFactory


#### SqlSessionManager 类
1. 同时实现了