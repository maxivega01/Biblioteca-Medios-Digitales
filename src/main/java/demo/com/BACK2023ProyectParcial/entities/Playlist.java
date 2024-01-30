package demo.com.BACK2023ProyectParcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //sera una tabla
@Table(name = "playlists") //la tabla en la bda
@Data //LOMBOK me hace getters y setters
@NoArgsConstructor //LOMBOK me hace constructor vacio
@AllArgsConstructor //LOMBOK me hace constructor no vacio
public class Playlist {

    @Id
    @GeneratedValue(generator = "playlist")
    @TableGenerator(name = "playlist", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="playlistid",
            initialValue=18, allocationSize=1)
    @Column(name = "playlistid")
    private long playlistId;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "playlistid"),
            inverseJoinColumns = @JoinColumn(name = "trackid")
    )

    private List<Track> tracks;

}
