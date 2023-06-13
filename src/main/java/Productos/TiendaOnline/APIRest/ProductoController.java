package Productos.TiendaOnline.APIRest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private List<Producto> productos = new ArrayList<>();

    // Listar Productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productos;
    }

    // Buscar Producto por id
    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    // Crear Producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

    // Actualizar Producto
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto productoActualizado) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setMarca(productoActualizado.getMarca());
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setPrecio(productoActualizado.getPrecio());
                return producto;
            }
        }
        return null;
    }

    // Borrar Producto
    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                return "Producto eliminado";
            }
        }
        return "Producto no encontrado";
    }
}
