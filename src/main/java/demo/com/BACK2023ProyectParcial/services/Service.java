package demo.com.BACK2023ProyectParcial.services;

import java.util.List;

//interfaz base de todos mis servicios
public interface Service <T, C, ID>{
    C add(T entity);
    C update(T entity);
    C delete(ID id);
    C getById(ID id);
    List<C> getAll();


}
