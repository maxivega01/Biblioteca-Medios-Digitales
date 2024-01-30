package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //sera una tabla
@Table(name = "artists") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Artist {

    @Id
    @GeneratedValue(generator = "artist")
    @TableGenerator(name = "artist", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="artistid",
            initialValue=276, allocationSize=1)
    @Column(name = "artistid")
    private long artistId;

    private String name;

    //esto lo creo aunque no este en la bda, porque un album tiene una FK de su artista
    //y lo mapeo con EL ATRUBUTO del album
  //  @OneToMany(mappedBy = "artistId", fetch = FetchType.LAZY)
   // public List<Album> albums;


}
