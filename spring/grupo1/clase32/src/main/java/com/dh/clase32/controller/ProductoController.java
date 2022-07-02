package com.dh.clase32.controller;

import com.dh.clase32.entities.Producto;
import com.dh.clase32.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarTodosLosProductos(){
        return ResponseEntity.ok(productoService.obtenerProductos());
    }



    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> obtenerProducto(@PathVariable Long id){
        return ResponseEntity.ok(productoService.buscarProductoXId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Se elimino el producto con id "+id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> restarCantidadProducto(@PathVariable Long id){
        Producto productoViejo = productoService.buscarProductoXId(id).get();
        if(productoViejo.getCantidad()>0){
            productoViejo.setCantidad(productoViejo.getCantidad()-1);
            return ResponseEntity.ok(productoService.actualizarProducto(productoViejo));
        }
        return ResponseEntity.ok(productoViejo);
    }

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }






}
