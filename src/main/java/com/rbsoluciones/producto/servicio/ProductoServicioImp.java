package com.rbsoluciones.producto.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbsoluciones.producto.entity.Categoria;
import com.rbsoluciones.producto.entity.Producto;
import com.rbsoluciones.producto.repositorio.IProductoRepositorio;

public class ProductoServicioImp implements IProductoServicio {

	@Autowired
	IProductoRepositorio prodRepo;
	
	@Override
	public List<Producto> listarTodos() {
		
		return prodRepo.findAll();
	}

	@Override
	public Producto listaUno(long id) {
		return prodRepo.findById(id).orElse(null);
	}

	@Override
	public Producto crear(Producto p) {
		p.setEstado("activo");
		p.setCreadoEn(new Date());
		return prodRepo.save(p);
	}

	@Override
	public Producto actualiza(Producto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto elimina(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto actualizaStock(long id, int quanity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findByCategoria(Categoria c) {
		// TODO Auto-generated method stub
		return null;
	}

}
