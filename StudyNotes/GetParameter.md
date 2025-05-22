SpringBoot如何获取请求URL中的查询参数

http://localhost:8080/hello?name=45类似这样的URL中?name=45的查询参数。查询参数必须以？开头这在RFC3986中进行了规范。

```java
//传统方式获取参数，通过HttpServletRequest对象的getParameter方法
@RequestMapping("/hello")
public String hello(HttpServletRequest r) {
    System.out.println("有人正在请求hello。");
    String name = r.getParameter("name");
    System.out.println("query parameter is " + name);
    return "hello world";
}
```

```java
//SpringBoot获取参数的方式，通过@RequestParam注解
//将对应形参变量与参数进行绑定，直接使用。
@RequestMapping("/hello")
public String hello(
@RequestParam(value = "name") String name,
@RequestParam(value = "age", required = false) Integer age) {
    System.out.println("有人正在请求hello。");
    StringBuilder builder = new StringBuilder();
    builder.append(name).append(" ");
    if (age != null) {
    	builder.append(age);
    }
    return builder.toString();
}
```

```java
//使用实体类接收请求参数
@RequestMapping("/info")
public String getMessage(@ModelAttribute User user) {
    return user.getName() + ' ' + user.getAge() + ' ' + user.getPhone() + ' ' + user.getAddress();
}
```

```java
//获取数组类型的请求参数
@RequestMapping("/listParameter")
public String getHobby(@RequestParam(value = "hobby") List<String> myHobby) {
    return myHobby.toString();
}
```

```java
//获取路径参数
@RequestMapping("/user/{id}")
public String getUserId(@PathVariable Integer id) {
    if (id != null) {
        return "you id is " + id;
    }
    return "404";
}
```
