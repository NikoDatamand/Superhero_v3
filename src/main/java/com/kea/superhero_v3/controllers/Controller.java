package com.kea.superhero_v3.controllers;

import com.kea.superhero_v3.models.Superhero;
import com.kea.superhero_v3.services.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("Superhelte")
public class Controller {

    private Service superheroService;

    public Controller(Service superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping(path="/")
    public ResponseEntity<List<Superhero>> getSuperheroDatabase() {
        List superheroList = superheroService.getSuperheroes();
        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);
    }

    @GetMapping(path="/{navn}")
    public ResponseEntity<String> getSuperhero(@PathVariable String navn){
        Superhero superhero = superheroService.getSuperhero(navn);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","text/html");

        return new ResponseEntity<String>(
                "<html><body><h1>" +
                        superhero.getName() + " " + superhero.getAge()+ " " + superhero.getSuperpower() +
                        "</h1></body></html>"
                ,responseHeaders, HttpStatus.OK);
    }


    //Doesn't work...
    @GetMapping(path="slet/{navn}")
    public ResponseEntity<String> deleteSuperhero(@PathVariable String navn){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type","text/html");

            int arraySize = superheroService.getSuperheroDatabase().getArrayList().size();
            do {
                superheroService.deleteSuperhero(navn);
                if (superheroService.getSuperheroDatabase().getArrayList().size() < arraySize) {
                    return new ResponseEntity<>(
                            "<html><body><h1>" +
                                    navn + " has been deleted" +
                                    "</h1></body></html>"
                            , responseHeaders, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(
                            "<html><body><h1>" +
                                    "couldn't find " + navn +
                                    "</h1></body></html>"
                            , responseHeaders, HttpStatus.OK);
                }
            } while (arraySize != 0);
    }

    //TODO
/*/

            /opret : opretter en superhelt

/ret : retter oplysninger om en superhelt

/slet/{navn} : sletter superhelt med navn = {navn}*/
}
