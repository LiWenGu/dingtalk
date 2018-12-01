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
5. 接收响应的时候 FastJson 需要将 Bean 的内部类设置为 static，但是使用 JSON.parse() 的时候不需要将转化为的 Bean 内部类设置为 static.
6. 默认 FastJson 不区分大小写，因此 errmsg -> errMsg
7. 继承自基础 DingTalkFail 类
8. 获取部门列表是否要做成一个树结构返回？
>部门的 key 是 deptId 还是 deptName 更适合场景？
9. 本周末前写 travis 脚本做自动上传到 maven 库。
>就快到 12 月了，马上就要开始准备面试资料了
10. 根据 `https://open-doc.dingtalk.com/microapp/serverap
i2/pgoxpy` 进行接口分类
>但是发现这个网站的接口并不全，例如没有获取审批详情和发送异步通知的接口。
11. 发送工作通知的 msgtype 做成枚举，content 与 type 使用 JSON 转换
12. 删除旧的工作通知接口，commit log:90c0cf097eb39006b1a73012c3656ef343534068
13. 保护分支 master