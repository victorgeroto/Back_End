package com.ProjetoAPIcursos.entites;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity 
	@Table(name = "cursos")
	public class ApiCursos {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		 
		@Column(name = "nome")
		private String nome;
		
	
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

}
