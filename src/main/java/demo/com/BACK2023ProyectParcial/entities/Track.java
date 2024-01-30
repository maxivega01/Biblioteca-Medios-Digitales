package demo.com.BACK2023ProyectParcial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //sera una tabla
@Table(name = "tracks") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Track {
    @Id
    @GeneratedValue(generator = "track")
    @TableGenerator(name = "track", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="trackid", //no se que onda si la ponia minuscula no andaba
            initialValue=3503, allocationSize=1)
    @Column(name = "trackid")
    private long trackId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "albumid")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "mediatypeid")
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "genreid")
    private Genre genre;

    private String composer;

    private int milliseconds;

    private int bytes;

    @Column(name = "unitprice")
    private int unitPrice;

    @ManyToMany(mappedBy = "tracks", fetch = FetchType.EAGER)
    private List<Playlist> playlists;
}
