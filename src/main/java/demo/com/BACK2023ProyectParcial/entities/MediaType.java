package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //sera una tabla
@Table(name = "media_types") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class MediaType {

    @Id
    @GeneratedValue(generator = "media_type")
    @TableGenerator(name = "media_type", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="mediatypeid",
            initialValue=5, allocationSize=1)
    @Column(name = "mediatypeid")
    private long mediatypeId;

    private String name;

}
