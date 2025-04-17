package org.example.code.C_16_interface_map.B;

@Service("ENG")
public class SayHelloInEnglish implements SayHelloService {

    @Override
    public String sayHello() {
        return "hello";
    }
}
