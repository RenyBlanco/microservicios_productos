package com.rbsoluciones.producto.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbsoluciones.producto.entity.Categoria;
import com.rbsoluciones.producto.entity.Producto;
import com.rbsoluciones.producto.repositorio.IProductoRepositorio;

@Service
public class ProductoServicioImp implements IProductoServicio {

	@Autowired
	IProductoRepositorio prodRepo;
	
	@Override
	public List<Producto> listarTodos() {
		return prodRepo.findAll();
	}

	@Override
	public Producto listaUno(Long id) {
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
		Producto nuevo = this.listaUno(p.getId());
		if(nuevo==null) {
			return null;
		}
		return prodRepo.save(p);
	}

	@Override
	public Producto elimina(Long id) {
		Producto borrar = this.listaUno(id);
		if(borrar==null) {
			return null;
		}
		borrar.setEstado("borrado");
		return prodRepo.save(borrar);
	}

	@Override
	public Producto actualizaStock(Long id, int quantity) {
		Producto act = this.listaUno(id);
		if(act==null) {
			return null;
		}
		
		int nuevoStock = act.getStock() + quantity;
		act.setStock(nuevoStock);
		return prodRepo.save(act);
	}

	@Override
	public List<Producto> findByCategoria(Categoria c) {
		return prodRepo.findByCategoria(c);
	}

}
