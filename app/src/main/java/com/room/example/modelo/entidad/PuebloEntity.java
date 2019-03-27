package com.room.example.modelo.entidad;

        import androidx.annotation.NonNull;
        import androidx.room.ColumnInfo;
        import androidx.room.Entity;
        import androidx.room.PrimaryKey;


@Entity(tableName = "pueblo_tabla")
public class PuebloEntity {
    @PrimaryKey
    @ColumnInfo(name = "codigo")
    @NonNull
    private int codigo;

    @ColumnInfo(name = "idProvincia")
    private int idProvincia;

    @ColumnInfo(name = "nombre")
    private String nombre;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCodigoComunidad() { return idProvincia; }

    public void setCodigoComunidad(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
}
