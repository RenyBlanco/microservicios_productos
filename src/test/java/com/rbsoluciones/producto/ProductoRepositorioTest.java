package com.rbsoluciones.producto;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rbsoluciones.producto.entity.Categoria;
import com.rbsoluciones.producto.entity.Producto;
import com.rbsoluciones.producto.repositorio.*;

@DataJpaTest
public class ProductoRepositorioTest {

	@Autowired
	IProductoRepositorio prodRepo;
	
	@Test
	public void cuandoBuscamosCategoria_retornaProducto() {
		Producto producto01 = Producto.builder()
				.producto("puma")
				.categoria(Categoria.builder().id(1L).build())
				.descripcion("cualquier cosa")
				.estado("activo")
				.stock(5)
				.precio(Double.parseDouble("80000"))
				.creadoEn(new Date()).build();
		prodRepo.save(producto01);
		
		List<Producto> encontrado = prodRepo.findByCategoria(producto01.getCategoria());
		
		Assertions.assertThat(encontrado.size()).isEqualTo(2);
	}
}
