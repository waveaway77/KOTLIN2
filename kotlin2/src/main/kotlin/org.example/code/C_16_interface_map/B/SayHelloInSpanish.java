package org.example.code.C_16_interface_map.B;

@Service("SPN")
public class SayHelloInSpanish implements SayHelloService {

    @Override
    public String sayHello() {
        return "hola";
    }
}
