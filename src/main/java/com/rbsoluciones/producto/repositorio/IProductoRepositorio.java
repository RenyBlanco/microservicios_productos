package com.rbsoluciones.producto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.rbsoluciones.producto.entity.*; 

public interface IProductoRepositorio extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByCategoria(Categoria categoria);

}
