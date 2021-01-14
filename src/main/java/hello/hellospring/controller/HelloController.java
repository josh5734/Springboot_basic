package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // http GET 요청을 처리하는 메서드를 매핑
    public String hello(Model model){ // 모델은 HashMap 형태를 가지고 있으므로 key, value 값처럼 사용할 수 있다.
        model.addAttribute("data", "Spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 데이터를 그대로 때려박는다. ViewResolver를 사용하지 않는다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello {name}"
    }

    @GetMapping("hello-api") // json = key + value
    @ResponseBody // HttpMessageConverter가 동작한다. (Jsonconverter(객체), StringConverter(스트링))
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // java bean 표준 방식
    static class Hello{
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
