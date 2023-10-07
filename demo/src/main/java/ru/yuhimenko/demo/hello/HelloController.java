package ru.yuhimenko.demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    private final List<String> strings = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArray(@RequestParam(value = "param") String param){
        strings.add(param);
        return "success";
    }
    @GetMapping("/show-array")
    public String showArray(){
        return strings.toString();
    }
    @GetMapping("/update-hashmap")
    public String updateHashMap(@RequestParam(value = "key") String key){
        if (hashMap.isEmpty()) {
            hashMap = new HashMap<>();
        }
        hashMap.put(hashMap.size() + 1, key);
        return "success";
    }
    @GetMapping("/show-hashmap")
    public String showHashMap(){
        return hashMap.toString();
    }
    @GetMapping("/show-all-length")
    public String showAllLength(){
        int arrayListLength = strings.size();
        int hashMapLength = hashMap.size();
        return "ArrayList length: " + arrayListLength + ", HashMap length: " + hashMapLength;
    }
}
