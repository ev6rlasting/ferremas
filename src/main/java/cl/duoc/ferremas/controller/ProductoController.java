package cl.duoc.ferremas.controller;

import cl.duoc.ferremas.model.Producto;
import cl.duoc.ferremas.model.ProductoResponseDto;
import cl.duoc.ferremas.model.Sucursal;
import cl.duoc.ferremas.repository.SucursalRepository;
import cl.duoc.ferremas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    private SucursalRepository sucursalRepository;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoResponseDto producto) {
        List<Sucursal> sucursales = sucursalRepository.findAllById(producto.idsSucursal());
        Producto producto1 = new Producto();
        producto1.setNombre(producto.nombre());
        producto1.setMarca(producto.marca());
        producto1.setPrecio(producto.precio());
        producto1.setStock(producto.stock());
        producto1.setCategoria(producto.categoria());
        producto1.setSucursales(sucursales);
        productoService.save(producto1);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(producto1.getId())
                .toUri();

        return ResponseEntity.created(location).body(producto1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(producto);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Producto>> filtrarProductos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) Float precioMin,
            @RequestParam(required = false) Long stockMin
    ) {
        List<Producto> productos = productoService.filtrarProductos(nombre, categoria, marca, precioMin, stockMin);
        return ResponseEntity.ok().body(productos);
    }

    @PutMapping("/{id}") // Actualización completa
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoResponseDto productoDto) {
        Producto productoExistente = productoService.findById(id);
        if (productoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        List<Sucursal> sucursales = sucursalRepository.findAllById(productoDto.idsSucursal());

        productoExistente.setNombre(productoDto.nombre());
        productoExistente.setMarca(productoDto.marca());
        productoExistente.setPrecio(productoDto.precio());
        productoExistente.setStock(productoDto.stock());
        productoExistente.setCategoria(productoDto.categoria());
        productoExistente.setSucursales(sucursales);

        productoService.save(productoExistente);
        return ResponseEntity.ok(productoExistente);
    }

    @PatchMapping("/{id}") // Actualización parcial
    public ResponseEntity<Producto> actualizarParcialProducto(@PathVariable Long id, @RequestBody ProductoResponseDto productoDto) {
        Producto productoExistente = productoService.findById(id);
        if (productoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (productoDto.nombre() != null) productoExistente.setNombre(productoDto.nombre());
        if (productoDto.marca() != null) productoExistente.setMarca(productoDto.marca());
        if (productoDto.precio() != null) productoExistente.setPrecio(productoDto.precio());
        if (productoDto.stock() != null) productoExistente.setStock(productoDto.stock());
        if (productoDto.categoria() != null) productoExistente.setCategoria(productoDto.categoria());

        if (productoDto.idsSucursal() != null && !productoDto.idsSucursal().isEmpty()) {
            List<Sucursal> sucursales = sucursalRepository.findAllById(productoDto.idsSucursal());
            productoExistente.setSucursales(sucursales);
        }

        productoService.save(productoExistente);
        return ResponseEntity.ok(productoExistente);
    }

    @DeleteMapping("/{id}") // Eliminar producto
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        productoService.delete(id);

        System.out.println("Producto con ID " + id + " eliminado correctamente.");

        return ResponseEntity.noContent().build();
    }

}
