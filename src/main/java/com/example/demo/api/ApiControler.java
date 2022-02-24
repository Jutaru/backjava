package com.example.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("")
@RestController
public class ApiControler {
    private RestTemplate restTemplate;
    @Autowired
    public ApiControler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


@PostMapping("/api/search")

    /*choice[0],+choice[1],+choice[2]*/

    public ResponseEntity<?> getDataFromApi(){
    String[] choice = {"salt","pepper","flour"};
String ch="";
String number="3";
    for(int i = 1; i < choice.length; i++)
    {
        String x = choice[i];
         ch=choice[0] + ",+" + x;
        //System.out.print(x + " ");
        //System.out.print(choice[i]);
        //System.out.print(ch);
    }



    String  url  ="https://api.spoonacular.com/recipes/findByIngredients?apiKey=8a7d17fa9581449e9600bd8457c07f9a&ingredients="+ch+"&number="+number;
    var data =restTemplate.exchange(url, HttpMethod.GET, null,  String.class) ;
    return  ResponseEntity.ok(data.getBody());
}



}
