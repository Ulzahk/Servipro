
package Modelos.ResponsableGrupo;


public class ResponsableGrupo {
    
    private int id_responsable;
    private int id_grupo;
    private String id_usuario;

    public ResponsableGrupo() {
    }

    public ResponsableGrupo(int id_grupo, String id_usuario) {
        this.id_grupo = id_grupo;
        this.id_usuario = id_usuario;
    }

    public ResponsableGrupo(int id_responsable, int id_grupo, String id_usuario) {
        this.id_responsable = id_responsable;
        this.id_grupo = id_grupo;
        this.id_usuario = id_usuario;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

}
