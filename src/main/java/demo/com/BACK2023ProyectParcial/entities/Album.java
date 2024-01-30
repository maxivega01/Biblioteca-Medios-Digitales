package demo.com.BACK2023ProyectParcial.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(generator = "album")
    @TableGenerator(name = "album", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="albumid",
            initialValue=347, allocationSize=1)
    @Column(name = "albumid")
    private long albumId;

    private String title;

    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist artist;

}

