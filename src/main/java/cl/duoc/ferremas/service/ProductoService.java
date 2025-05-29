package cl.duoc.ferremas.service;

import cl.duoc.ferremas.model.Producto;
import cl.duoc.ferremas.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Transactional
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }


    public List<Producto> filtrarProductos(String nombre, String categoria, String marca, Float precioMin, Long stockMin) {
        return productoRepository.filtrarProductos(nombre, categoria, marca, precioMin, stockMin);
    }
}
