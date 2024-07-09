package com.adalbertofjr.springgradle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @GetMapping
    public String sayHello() {
        return "Hello from SpringBoot by Adalberto";
    }

    @PostMapping("/post")
    public String sayHelloPost(@RequestBody Map<String,Object> payload){
        return payload.get("name").toString();
    }


    @GetMapping("/subpath")
    public String subPath() {
        return "This is one subpath from /";
    }

    @GetMapping("/subpathbody")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public String subPathBody(@RequestParam(value = "name", required = true) String name) {
        return "This is one subpathbody from /" + name;
    }

    @GetMapping("/subpathrequestparam")
    public String subPath(@RequestParam(value = "name", required = false) String name) {
        return "This is one subpath from /" + name;
    }

    @GetMapping("/subpathparameter")
    public String subPathWithParameter(@RequestParam("name") String name) {
        return "Hello " + name + "! This is one subpath with parameter.";
    }

    @GetMapping("/subpathrequest")
    public String subPathWithRequest(final WebRequest webRequest) {
        String name = webRequest.getParameter("name");
        if (name != null) {
            return "Hello " + name + "! This is one subpath with webrequest.";
        }

        return "No query params";
    }

//    @GetMapping("/{dynamic}")
//    public String dynamicSubPath(@PathVariable("dynamic") String name) {
//        return "Hello " + name + " this is my dynamic route...";
//    }
}
