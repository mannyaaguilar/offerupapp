package com.manny.offerupapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class OfferUpController {
    @RequestMapping("/offerup")
    public @ResponseBody
    String offerupRoute(){
        final String uri = "https://www.offerup.com/#offers";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }
}
