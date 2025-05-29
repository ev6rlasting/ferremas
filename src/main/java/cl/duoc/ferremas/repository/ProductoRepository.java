package cl.duoc.ferremas.repository;

import cl.duoc.ferremas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE " +
            "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
            "(:categoria IS NULL OR LOWER(p.categoria) = LOWER(:categoria)) AND " +
            "(:marca IS NULL OR LOWER(p.marca) LIKE LOWER(CONCAT('%', :marca, '%'))) AND " +
            "(:precioMin IS NULL OR p.precio >= :precioMin) AND " +
            "(:stockMin IS NULL OR p.stock >= :stockMin)")
    List<Producto> filtrarProductos(
            @Param("nombre") String nombre,
            @Param("categoria") String categoria,
            @Param("marca") String marca,
            @Param("precioMin") Float precioMin,
            @Param("stockMin") Long stockMin
    );

    // Puedes conservar los métodos individuales si los sigues usando
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByCategoriaIgnoreCase(String categoria);
    List<Producto> findByMarcaContainingIgnoreCase(String marca);
    List<Producto> findByPrecio(Float precio);
    List<Producto> findByStockGreaterThanEqual(Long stock);
}
