package com.rbsoluciones.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbsoluciones.producto.entity.Producto;
import com.rbsoluciones.producto.servicio.ProductoServicioImp;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
	
	@Autowired
	private ProductoServicioImp prodService;
	
	/*
	ProductoController(ProductoServicioImp prodService){
		this.prodService = prodService;
	}
	*/
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> listarProductos() {
		List<Producto> productos = prodService.listarTodos() ;
		if(productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productos);
	}

}
