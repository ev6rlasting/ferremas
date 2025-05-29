package cl.duoc.ferremas.controller;

import cl.duoc.ferremas.model.Producto;
import cl.duoc.ferremas.model.Sucursal;
import cl.duoc.ferremas.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {
    @Autowired
    private SucursalRepository sucursalRepository;

    @PostMapping
    public void crearSucursal(@RequestBody Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @GetMapping("/{id}/productos")
    public ResponseEntity<List<Producto>> listarProductosPorSucursal(@PathVariable Long id) {
        // Buscar sucursal por id
        Sucursal sucursal = sucursalRepository.findById(id).orElse(null);
        if (sucursal == null) {
            return ResponseEntity.notFound().build();
        }

        // Obtener productos asociados a la sucursal
        List<Producto> productos = sucursal.getProductos();

        return ResponseEntity.ok(productos);
    }


}
