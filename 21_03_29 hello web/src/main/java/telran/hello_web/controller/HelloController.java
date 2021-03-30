package telran.hello_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import telran.hello_web.dto.Auto;
import telran.hello_web.dto.Greetings;

@Controller
public class HelloController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model){
        String capitalName=name.toUpperCase();
        model.addAttribute("nameBigLetters",name);
        return "hello";
    }
    @RequestMapping(value="/hello-string/{name}",method = RequestMethod.GET)
    // oder @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloString(@PathVariable String name){
        String capitalName=name.toUpperCase();
        return "hello "+capitalName+"!";
    }
    @RequestMapping(value="/hello-json/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Greetings helloJson(@PathVariable String name){
        String capitalName=name.toUpperCase();
        Greetings response=new Greetings(capitalName,"YO");
        return response;
    }

    @PostMapping("/auto")
    @ResponseBody
    public String acceptAuto(@RequestBody Auto auto,Model model) {
        System.out.println(auto);
       // return "recieved-auto";
        return "The following auto was received: " + "make: " + auto.make + ", color: " + auto.color;
    }

    //TODO write endpoints with the types PUT, PATCH and DELETE. And check them with TalendAPI
    @PutMapping("/auto-put")
    @ResponseBody
    public String putAuto(@RequestBody Auto auto) {
        return "The following auto was received: " + "make: " + auto.make + ", color: " + auto.color;
    }

    @PatchMapping("/auto-patch")
    @ResponseBody
    public String patchAuto(@RequestBody Auto auto) {
        return "The following auto was received: " + "make: " + auto.make + ", color: " + auto.color;
    }

    @DeleteMapping("/auto-delete/{make}")
    @ResponseBody
    public String deleteAuto(@PathVariable String make) {
        return "The following auto was deleted, make: " + make;
    }
}
