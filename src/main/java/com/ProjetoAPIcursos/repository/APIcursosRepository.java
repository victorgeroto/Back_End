package com.ProjetoAPIcursos.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.ProjetoAPIcursos.entites.ApiCursos;

	public interface APIcursosRepository extends JpaRepository<ApiCursos, Long> {
		
		// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
	}
