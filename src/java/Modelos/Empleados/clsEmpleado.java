package Modelos.Empleados;

import Modelos.Empleados.clsCentroCosto;
import Modelos.Empleados.clsCargo;


public class clsEmpleado {
    
    public int inId;
    public clsTipoDocumento obclsTipoDocumento;
    public String stDocumento;
    public String stNombre;
    public String stTelefono;
    public clsCentroCosto obclsCentroCosto;
    public clsCargo obclsCargo;

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

    public String getStNombre() {
        return stNombre;
    }

    public void setStNombre(String stNombre) {
        this.stNombre = stNombre;
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
    
    
}
