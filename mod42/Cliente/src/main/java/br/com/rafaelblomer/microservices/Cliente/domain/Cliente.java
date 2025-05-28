package br.com.rafaelblomer.microservices.Cliente.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
@Schema(name="Cliente", description="Cliente") 
public class Cliente {

	@Id
	private String id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nome;
	
	@NotNull
	@Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
	private String email;
	
	@NotNull
	@Schema(minLength = 10, maxLength = 11)
	private String telefone;
}
