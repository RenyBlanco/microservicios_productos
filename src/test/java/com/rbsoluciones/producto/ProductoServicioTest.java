package com.rbsoluciones.producto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.rbsoluciones.producto.entity.Categoria;
import com.rbsoluciones.producto.entity.Producto;
import com.rbsoluciones.producto.repositorio.IProductoRepositorio;
import com.rbsoluciones.producto.servicio.ProductoServicioImp;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductoServicioTest {

	@Mock
	IProductoRepositorio prodRepo;
	
	@InjectMocks
	ProductoServicioImp prodServ;
	
	private Producto prod01;
	
	@BeforeEach
	public void setup() {
		prod01 = Producto.builder()
				.id(1L)
				.producto("cholas")
				.categoria(Categoria.builder().id(1L).build())
				.estado("activo")
				.precio(Double.parseDouble("45000"))
				.stock(5)
				.build();
	}
	
	@DisplayName("Verifica el guardado del Producto")
	@Test
	void testSaveProd() {
		//Given
		/*given(prodRepo.findByCategoria(prod01.getCategoria()))
		.willReturn(null);*/
		given(prodRepo.save(prod01)).willReturn(prod01);
		//When
		Producto prodSaved = prodServ.crear(prod01);
		//Then
		Assertions.assertThat(prodSaved).isNotNull();
	}
	
	@DisplayName("Verifica Busqueda de Producto")
	@Test
	void testBusqueda() {
		//Given
		given(prodRepo.findById(prod01.getId()))
		.willReturn(Optional.of(prod01));
		//When
		Producto encontrado = prodServ.listaUno(1L);
		//Then
		Assertions.assertThat(encontrado.getProducto()).isEqualTo("cholas");
	}
	
	@DisplayName("Valida actualizacion de Stock")
	@Test
	void testUpdStock() {
		//Given
		given(prodRepo.findById(prod01.getId()))
		.willReturn(Optional.of(prod01));
		//When
		Producto encontrado = prodServ.listaUno(1L);
		encontrado.setStock(8);
		Producto nuevoStock = prodServ.crear(encontrado);
		//Then
		Assertions.assertThat(nuevoStock.getStock()).isEqualTo(8);
	}

	@DisplayName("Valida actualizacion Producto")
	@Test
	void testUpdProd() {
		//Given
		given(prodRepo.findById(prod01.getId()))
		.willReturn(Optional.of(prod01));
		//When
		Producto nuevo = prodServ.listaUno(1L);
		nuevo.setDescripcion("para");
		Producto prodUpd = prodServ.actualiza(nuevo);
		//Then
		Assertions.assertThat(prodUpd.getDescripcion()).isEqualTo("para");
	}
}
