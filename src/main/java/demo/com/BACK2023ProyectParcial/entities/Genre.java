package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //sera una tabla
@Table(name = "genres") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Genre {

    @Id
    @GeneratedValue(generator = "genre")
    @TableGenerator(name = "genre", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="genreid",
            initialValue=25, allocationSize=1)
    @Column(name = "genreid")
    private long genreId;

    private String name;
}
