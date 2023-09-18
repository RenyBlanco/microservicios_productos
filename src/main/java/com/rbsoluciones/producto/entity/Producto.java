package com.rbsoluciones.producto.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String producto;
	private String descripcion;
	
	private int stock;
	private double precio;
	private String estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadoEn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Categoria categoria;
	

}
