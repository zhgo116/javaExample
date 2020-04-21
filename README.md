#java基础示例


##各种java功能模块区分

( )=>箭头函数
方法链:当方法的返回值是一个对象时,这个对象还可以再调用它的方法

两害相权取其轻



#RestTemplate传参


@RequestMapping("/sayhello")
public String sayHello() {
    ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={1}", String.class, "张三");
    return responseEntity.getBody();
}
@RequestMapping("/sayhello2")
public String sayHello2() {
    Map<String, String> map = new HashMap<>();
    map.put("name", "李四");
    ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/sayhello?name={name}", String.class, map);
    return responseEntity.getBody();
}


1.可以用一个数字做占位符，最后是一个可变长度的参数，来一一替换前面的占位符
2.也可以前面使用name={name}这种形式，最后一个参数是一个map，map的key即为前边占位符的名字，map的value为参数值




@RequestMapping("/sayhello3")
public String sayHello3() {
    UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/sayhello?name={name}").build().expand("王五").encode();
    URI uri = uriComponents.toUri();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
    return responseEntity.getBody();
}