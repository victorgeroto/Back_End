package com.ProjetoAPIcursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoAPIcursos.entites.ApiCursos;
import com.ProjetoAPIcursos.repository.APIcursosRepository;

@Service
public class APIcursosService {
    private final APIcursosRepository apiCursosRepository;

    //construtor que recebe a dependencia
    @Autowired
    public APIcursosService(APIcursosRepository apiCursosRepository) {
        this.apiCursosRepository = apiCursosRepository;
    }
    
    public List<ApiCursos> buscaTodosCursos(){
    	return apiCursosRepository.findAll();
    }
    
    public ApiCursos buscaApiCursosId(Long id) {
        Optional <ApiCursos> apiCursos = apiCursosRepository.findById(id);
        return apiCursos.orElse(null);
    }
    //metodo salvar os produtos
    public ApiCursos SalvaApiCursos(ApiCursos apiCursos) {
    	return apiCursosRepository.save(apiCursos);
    }
    public ApiCursos alterarApiCursos(Long id, ApiCursos alterarApiCurs) {
    	Optional <ApiCursos> existeApiCursos = apiCursosRepository.findById(id);
    	
    	if (existeApiCursos.isPresent()) {
    		alterarApiCurs.setId(id);
    		return apiCursosRepository.save(alterarApiCurs);
    	}
    	return null;
    }
    public boolean apagarApiCursos(Long id) {
    	Optional <ApiCursos> existeApiCursos = apiCursosRepository.findById(id);
    	if (existeApiCursos.isPresent()) {
    		apiCursosRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}

