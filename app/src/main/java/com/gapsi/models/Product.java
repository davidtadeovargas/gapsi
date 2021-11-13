package com.gapsi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nombre")
	@NotEmpty(message = "Nombre es requerido")
	private String nombre;
	
	@Column(name = "descripcion")
	@NotEmpty(message = "Descripción es requerida")
	private String descripcion;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "modelo")
	@NotEmpty(message = "Modelo es requerido")
	private String modelo;
}
