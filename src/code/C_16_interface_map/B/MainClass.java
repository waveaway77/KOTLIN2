package code.C_16_interface_map.B;

import java.util.Map;

/*
path variable을 사용하여 원하는 인터페이스의 메소드를 출력 가능하다
 */
// https://stackoverflow.com/questions/58277097/autowire-an-interface-as-mapstring-interfacename-is-possible
public class MainClass {

    private Map<String, SayHelloService> sayHelloService; // Map에 인터페이스를 타입으로 지정할 수 있다.

    @Autowired
    public void HelloController(Map<String, SayHelloService> sayHelloService) {
        this.sayHelloService = sayHelloService;
    }

    @GetMapping("/hello/{lang}")
    public String sayHello(@PathVariable String lang) {
        String msg = this.sayHelloService.get(lang).sayHello(); // path variable을 키값으로 하여 원하는 인터페이스의 메서드를 가져온다.
        return msg;
        /*
        ENG 일 경우 hello
        SPN 일 경우 hola
         */
    }
}
