package com.rbsoluciones.producto.servicio;

import java.util.List;

import com.rbsoluciones.producto.entity.Categoria;
import com.rbsoluciones.producto.entity.Producto;

public interface IProductoServicio {
	public List<Producto> listarTodos();
	public Producto listaUno(Long id);
	public Producto crear(Producto p);
	public Producto actualiza(Producto p);
	public Producto elimina(Long id);
	public Producto actualizaStock(Long id, int quanity);
	public List<Producto> findByCategoria(Categoria c);

}
