package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import services.BusinessService;

@RestController
public class HelloController {
	
	@Value("${introduccion.spring.nombre}")
	private String nombre;
	
	private final BusinessService businessService;
	
	@Autowired
	private HelloController(BusinessService businessService) {
		this.businessService = businessService;
	}

    @GetMapping("/saludar/{nombre}")
    public String index(@PathVariable String nombre) {
    	String respuesta;
    	if ("Pilar".equals(nombre)) {
    		respuesta = "Hola señorita " + nombre;
    	} else {
    		respuesta = "Hola " + nombre;
    	}
    	respuesta += "<br/>" + businessService.getSaludo();
    	return respuesta;
    }

}