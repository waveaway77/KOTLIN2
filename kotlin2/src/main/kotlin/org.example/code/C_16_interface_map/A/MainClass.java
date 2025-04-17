package org.example.code.C_16_interface_map.A;

import java.util.HashMap;

// https://stackoverflow.com/questions/58277097/autowire-an-interface-as-mapstring-interfacename-is-possible
public class MainClass {

    @Autowired
    private HashMap<String, SomeInterface> springComponentsImplList1;

    @Autowired
    private HashMap<String, SomeInterface> springComponentsImplList2;
    // get the implementation by a "key"


    // But you may also try to get all bean instances of a particular type along with their names
    // using ListableBeanFactory: (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ListableBeanFactory.html)
    private HashMap<String, Foo> allBeansOfType;
    @Autowired
    public MyClass(ListableBeanFactory beanFactory) {
        this.allBeansOfType = beanFactory.getBeansOfType(Foo.class);
    }
}