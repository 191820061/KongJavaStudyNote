默认情况下，Spring MVC会将Controller方法的返回值视为视图名，用于渲染页面。如果使用@ResponseBody注解，会将其返回值直接视为HTTP响应内容返回。

一般情况下@ResponseBody并不会单独使用，而是使用@RestController。@RestController是@Controller和@ResponseBody的组合注解。当然如果只是想Controller类的部分方法的返回值直接作为相应内容返回，则可以单独使用，在方法上添加该注解。

@ResponseBody注解的方法，会将返回的对象自动转换为JSON格式，然后作为响应内容返回给客户端。

```java
//测试返回一个对象
@RequestMapping("/objectResponse")
public User getUser(){
    return new User("郝文乾", 23,"安徽","13965358064");
}
```

```json
//返回值
{
    "name": "郝文乾",
    "age": 23,
    "address": "安徽",
    "phone": "13965358064"
}
```

