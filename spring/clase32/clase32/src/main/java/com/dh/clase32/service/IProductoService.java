package com.dh.clase32.service;

import com.dh.clase32.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> obtenerProductos();
    Optional<Producto> buscarProductoXId(Long id);
    Producto guardarProducto(Producto producto);
    void eliminarProducto(Long id);
    Producto actualizarProducto(Producto producto);
}
