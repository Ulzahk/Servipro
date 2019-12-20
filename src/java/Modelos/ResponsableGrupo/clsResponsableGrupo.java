
package Modelos.ResponsableGrupo;

public class clsResponsableGrupo {
    
    public int Id_responsable;
    public clsGrupo obclsGrupo;
    public clsUsuario obclsUsuario;

    public int getId_responsable() {
        return Id_responsable;
    }

    public void setId_responsable(int Id_responsable) {
        this.Id_responsable = Id_responsable;
    }

    public clsGrupo getObclsGrupo() {
        return obclsGrupo;
    }

    public void setObclsGrupo(clsGrupo obclsGrupo) {
        this.obclsGrupo = obclsGrupo;
    }

    public clsUsuario getObclsUsuario() {
        return obclsUsuario;
    }

    public void setObclsUsuario(clsUsuario obclsUsuario) {
        this.obclsUsuario = obclsUsuario;
    }
    
    
    
    
}
