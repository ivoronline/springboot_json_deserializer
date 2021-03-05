package com.ivoronline.springboot_json_deserializer.controllers;

import com.ivoronline.springboot_json_deserializer.DTO.PersonDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/AddPerson")
  public String addPerson(@RequestBody PersonDTO personDTO) {

    //GET DATA FROM PersonDTO
    String name   = personDTO.name;
    Float  height = personDTO.height;

    //RETURN SOMETHING
    return name + " is " + height + " meters high";

  }

}
