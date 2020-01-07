package Modelos.Empleados;

import Modelos.Empleados.clsCentroCosto;
import Modelos.Empleados.clsCargo;


public class clsEmpleado {
    
    public int inId;
    public clsTipoDocumento obclsTipoDocumento;
    public String stDocumento;
    public String stPrimerNombre;
    public String stSegundoNombre;
    public String stPrimerApellido;
    public String stSegundoApellido;
    public String stTelefono;
    public clsCentroCosto obclsCentroCosto;
    public clsCargo obclsCargo;
    public clsGrupoEmpl obclsGrupoEmpl;

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public clsTipoDocumento getObclsTipoDocumento() {
        return obclsTipoDocumento;
    }

    public void setObclsTipoDocumento(clsTipoDocumento obclsTipoDocumento) {
        this.obclsTipoDocumento = obclsTipoDocumento;
    }

    public String getStDocumento() {
        return stDocumento;
    }

    public void setStDocumento(String stDocumento) {
        this.stDocumento = stDocumento;
    }

    public String getStPrimerNombre() {
        return stPrimerNombre;
    }

    public void setStPrimerNombre(String stPrimerNombre) {
        this.stPrimerNombre = stPrimerNombre;
    }

    public String getStSegundoNombre() {
        return stSegundoNombre;
    }

    public void setStSegundoNombre(String stSegundoNombre) {
        this.stSegundoNombre = stSegundoNombre;
    }

    public String getStPrimerApellido() {
        return stPrimerApellido;
    }

    public void setStPrimerApellido(String stPrimerApellido) {
        this.stPrimerApellido = stPrimerApellido;
    }

    public String getStSegundoApellido() {
        return stSegundoApellido;
    }

    public void setStSegundoApellido(String stSegundoApellido) {
        this.stSegundoApellido = stSegundoApellido;
    }

    public String getStTelefono() {
        return stTelefono;
    }

    public void setStTelefono(String stTelefono) {
        this.stTelefono = stTelefono;
    }

    public clsCentroCosto getObclsCentroCosto() {
        return obclsCentroCosto;
    }

    public void setObclsCentroCosto(clsCentroCosto obclsCentroCosto) {
        this.obclsCentroCosto = obclsCentroCosto;
    }

    public clsCargo getObclsCargo() {
        return obclsCargo;
    }

    public void setObclsCargo(clsCargo obclsCargo) {
        this.obclsCargo = obclsCargo;
    }

    public clsGrupoEmpl getObclsGrupoEmpl() {
        return obclsGrupoEmpl;
    }

    public void setObclsGrupoEmpl(clsGrupoEmpl obclsGrupoEmpl) {
        this.obclsGrupoEmpl = obclsGrupoEmpl;
    }
}
