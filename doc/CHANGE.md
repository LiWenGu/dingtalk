# TODO

1. 发送通知的请求 Bean 需要优化
2. core 中含有 spring-web，主要用于获取 resttemplate
>但是 spring-cloud 不用 spring-web 就可以获取 resttemplate，得去掉
>ribbon 使用<optional>参数，但是如果我使用了这个，就报错 日志工厂的问题，因此先保留，而且
>ribbon 使用这个参数是为了有可能像 eureka 服务器不使用 spring-boot-web 的功能，但是我本身
>是给接口用的 starter，保留也没有问题。
3. 使用 fastjson 解析，将 jackson2MessageConvert 从 restemplate 去掉
>https://stackoverflow.com/questions/30041206/can-java-8-streams-operate-on-an-item-in-a-collection-and-then-remove-it
4. 通用的响应类，子类继承不同的 FailDetail 类