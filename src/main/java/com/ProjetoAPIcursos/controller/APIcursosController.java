package com.ProjetoAPIcursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoAPIcursos.entites.ApiCursos;
import com.ProjetoAPIcursos.service.APIcursosService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name= "Cursos", description = "API REST DE GERENCIAMENTO  DE CURSOS")
@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")

public class APIcursosController{
    private final APIcursosService apiCursosService;

    @Autowired
    public APIcursosController(APIcursosService apiCursosService) {
        this.apiCursosService = apiCursosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiCursos> buscaAPIcursosControlId(@PathVariable Long id){
    	ApiCursos apiCursos = apiCursosService.buscaApiCursosId(id);
    	if (apiCursos != null) {
    		return ResponseEntity.ok(apiCursos);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping
    public ResponseEntity<List<ApiCursos>> buscaTodosCursosControl(){
    	List<ApiCursos> Cursos = apiCursosService.buscaTodosCursos();
    	
    	return ResponseEntity.ok(Cursos);
    }
    @PostMapping
    public ResponseEntity<ApiCursos> salvaCursosControl(@RequestBody ApiCursos apiCursos){
    	ApiCursos salvaApiCursos = apiCursosService.SalvaApiCursos(apiCursos);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaApiCursos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiCursos> alteraApiCursosControl(@PathVariable Long id, @RequestBody ApiCursos apiCursos){
    	ApiCursos alteraApiCursos = apiCursosService.alterarApiCursos(id, apiCursos);
    	if(alteraApiCursos != null) {
    		return ResponseEntity.ok(apiCursos);
    	}
    	else {
    		return ResponseEntity.notFound().build();   	
    		}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaApiCursosControl(@PathVariable Long id){
    	boolean apagar = apiCursosService.apagarApiCursos(id);
    	if (apagar) {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    
    
}

