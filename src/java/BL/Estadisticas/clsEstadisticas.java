package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clsEstadisticas {

    Connection conn = null;

    public clsEstadisticas() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String deleteEstadistica(Modelos.Estadisticas.clsEstadisticas obclsEstadistica) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEliminarEsta (?)}");
            ps.setInt(1, obclsEstadistica.getId_estadistica());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String createEstadistica(Modelos.Estadisticas.clsEstadisticas obEstadisticas) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarEstadistica(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, obEstadisticas.getObEmpleado().getId_empleado());
            ps.setInt(2, obEstadisticas.getObId_dia1().getId_dia1());
            ps.setInt(3, obEstadisticas.getObId_dia2().getId_dia2());
            ps.setInt(4, obEstadisticas.getObId_dia3().getId_dia3());
            ps.setInt(5, obEstadisticas.getObId_dia4().getId_dia4());
            ps.setInt(6, obEstadisticas.getObId_dia5().getId_dia5());
            ps.setInt(7, obEstadisticas.getObId_dia6().getId_dia6());
            ps.setInt(8, obEstadisticas.getObId_dia7().getId_dia7());
            ps.setInt(9, obEstadisticas.getObId_dia8().getId_dia8());
            ps.setInt(10, obEstadisticas.getObId_dia9().getId_dia9());
            ps.setInt(11, obEstadisticas.getObId_dia10().getId_dia10());
            ps.setInt(12, obEstadisticas.getObId_dia11().getId_dia11());
            ps.setInt(13, obEstadisticas.getObId_dia12().getId_dia12());
            ps.setInt(14, obEstadisticas.getObId_dia13().getId_dia13());
            ps.setInt(15, obEstadisticas.getObId_dia14().getId_dia14());
            ps.setInt(16, obEstadisticas.getObId_dia15().getId_dia15());
            ps.setInt(17, obEstadisticas.getObId_dia16().getId_dia16());
            ps.setInt(18, obEstadisticas.getObId_dia17().getId_dia17());
            ps.setInt(19, obEstadisticas.getObId_dia18().getId_dia18());
            ps.setInt(20, obEstadisticas.getObId_dia19().getId_dia19());
            ps.setInt(21, obEstadisticas.getObId_dia20().getId_dia20());
            ps.setInt(22, obEstadisticas.getObId_dia21().getId_dia21());
            ps.setInt(23, obEstadisticas.getObId_dia22().getId_dia22());
            ps.setInt(24, obEstadisticas.getObId_dia23().getId_dia23());
            ps.setInt(25, obEstadisticas.getObId_dia24().getId_dia24());
            ps.setInt(26, obEstadisticas.getObId_dia25().getId_dia25());
            ps.setInt(27, obEstadisticas.getObId_dia26().getId_dia26());
            ps.setInt(28, obEstadisticas.getObId_dia27().getId_dia27());
            ps.setInt(29, obEstadisticas.getObId_dia28().getId_dia28());
            ps.setInt(30, obEstadisticas.getObId_dia29().getId_dia29());
            ps.setInt(31, obEstadisticas.getObId_dia30().getId_dia30());
            ps.setInt(32, obEstadisticas.getObId_dia31().getId_dia31());

            ps.execute();

            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String commentEstadistica(Modelos.Estadisticas.clsComentarEstadisticas obclsComentarEstadisticas) {
        try {
            PreparedStatement ps = conn.prepareStatement("{call spComentarEsta(?,?)}");
            ps.setInt(1, obclsComentarEstadisticas.getId_estadisticas());
            ps.setString(2, obclsComentarEstadisticas.getComentario());

            ps.execute();

            return "Se realizó el proceso con éxito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstadistica(Modelos.Estadisticas.clsEstadisticas obEstadisticas) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spEditarEsta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, obEstadisticas.getId_estadistica());
            ps.setInt(2, obEstadisticas.getObId_dia1().getId_dia1());
            ps.setInt(3, obEstadisticas.getObId_dia2().getId_dia2());
            ps.setInt(4, obEstadisticas.getObId_dia3().getId_dia3());
            ps.setInt(5, obEstadisticas.getObId_dia4().getId_dia4());
            ps.setInt(6, obEstadisticas.getObId_dia5().getId_dia5());
            ps.setInt(7, obEstadisticas.getObId_dia6().getId_dia6());
            ps.setInt(8, obEstadisticas.getObId_dia7().getId_dia7());
            ps.setInt(9, obEstadisticas.getObId_dia8().getId_dia8());
            ps.setInt(10, obEstadisticas.getObId_dia9().getId_dia9());
            ps.setInt(11, obEstadisticas.getObId_dia10().getId_dia10());
            ps.setInt(12, obEstadisticas.getObId_dia11().getId_dia11());
            ps.setInt(13, obEstadisticas.getObId_dia12().getId_dia12());
            ps.setInt(14, obEstadisticas.getObId_dia13().getId_dia13());
            ps.setInt(15, obEstadisticas.getObId_dia14().getId_dia14());
            ps.setInt(16, obEstadisticas.getObId_dia15().getId_dia15());
            ps.setInt(17, obEstadisticas.getObId_dia16().getId_dia16());
            ps.setInt(18, obEstadisticas.getObId_dia17().getId_dia17());
            ps.setInt(19, obEstadisticas.getObId_dia18().getId_dia18());
            ps.setInt(20, obEstadisticas.getObId_dia19().getId_dia19());
            ps.setInt(21, obEstadisticas.getObId_dia20().getId_dia20());
            ps.setInt(22, obEstadisticas.getObId_dia21().getId_dia21());
            ps.setInt(23, obEstadisticas.getObId_dia22().getId_dia22());
            ps.setInt(24, obEstadisticas.getObId_dia23().getId_dia23());
            ps.setInt(25, obEstadisticas.getObId_dia24().getId_dia24());
            ps.setInt(26, obEstadisticas.getObId_dia25().getId_dia25());
            ps.setInt(27, obEstadisticas.getObId_dia26().getId_dia26());
            ps.setInt(28, obEstadisticas.getObId_dia27().getId_dia27());
            ps.setInt(29, obEstadisticas.getObId_dia28().getId_dia28());
            ps.setInt(30, obEstadisticas.getObId_dia29().getId_dia29());
            ps.setInt(31, obEstadisticas.getObId_dia30().getId_dia30());
            ps.setInt(32, obEstadisticas.getObId_dia31().getId_dia31());

            ps.execute();

            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia1(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia1(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia1().getId_dia1());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia2(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia2(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia2().getId_dia2());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia3(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia3(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia3().getId_dia3());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia4(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia4(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia4().getId_dia4());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia5(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia5(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia5().getId_dia5());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia6(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia6(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia6().getId_dia6());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia7(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia7(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia7().getId_dia7());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia8(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia8(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia8().getId_dia8());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia9(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia9(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia9().getId_dia9());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia10(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia10(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia10().getId_dia10());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia11(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia11(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia11().getId_dia11());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia12(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia12(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia12().getId_dia12());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia13(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia13(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia13().getId_dia13());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia14(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia14(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia14().getId_dia14());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia15(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia15(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia15().getId_dia15());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia16(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia16(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia16().getId_dia16());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia17(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia17(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia17().getId_dia17());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia18(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia18(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia18().getId_dia18());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia19(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia19(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia19().getId_dia19());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia20(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia20(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia20().getId_dia20());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia21(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia21(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia21().getId_dia21());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia22(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia22(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia22().getId_dia22());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia23(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia23(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia23().getId_dia23());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia24(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia24(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia24().getId_dia24());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia25(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia25(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia25().getId_dia25());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia26(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia26(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia26().getId_dia26());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia27(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia27(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia27().getId_dia27());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia28(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia28(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia28().getId_dia28());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia29(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia29(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia29().getId_dia29());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEstaDia30(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia30(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia30().getId_dia30());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public String updateEstaDia31(Modelos.Estadisticas.clsEstadisticas obclsEstadisticas) {
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEstaDia31(?,?)}");
            ps.setInt(1, obclsEstadisticas.getId_estadistica());
            ps.setInt(2, obclsEstadisticas.getObId_dia31().getId_dia31());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Modelos.Estadisticas.clsEstadisticas> getEstadisticas() {

        List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEstadistica}");

            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.Estadisticas.clsEstadisticas obEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
                obEstadisticas.setId_estadistica(rs.getInt("Id_estadistica"));

                Modelos.Estadisticas.clsEmpleado obEmpleado = new Modelos.Estadisticas.clsEmpleado();
                obEmpleado.setId_empleado(rs.getInt("Id_empleado"));
                obEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obEstadisticas.setObEmpleado(obEmpleado);

                Modelos.Estadisticas.clsId_dia1 obId_dia1 = new Modelos.Estadisticas.clsId_dia1();
                obId_dia1.setId_dia1(rs.getInt("Id_dia1"));
                obId_dia1.setDescripcionDia1(rs.getString("Descripcion1"));
                obId_dia1.setAliasDia1(rs.getString("Alias1"));
                obEstadisticas.setObId_dia1(obId_dia1);

                Modelos.Estadisticas.clsId_dia2 obId_dia2 = new Modelos.Estadisticas.clsId_dia2();
                obId_dia2.setId_dia2(rs.getInt("Id_dia2"));
                obId_dia2.setDescripcionDia2(rs.getString("Descripcion2"));
                obId_dia2.setAliasDia2(rs.getString("Alias2"));
                obEstadisticas.setObId_dia2(obId_dia2);

                Modelos.Estadisticas.clsId_dia3 obId_dia3 = new Modelos.Estadisticas.clsId_dia3();
                obId_dia3.setId_dia3(rs.getInt("Id_dia3"));
                obId_dia3.setDescripcionDia3(rs.getString("Descripcion3"));
                obId_dia3.setAliasDia3(rs.getString("Alias3"));
                obEstadisticas.setObId_dia3(obId_dia3);

                Modelos.Estadisticas.clsId_dia4 obId_dia4 = new Modelos.Estadisticas.clsId_dia4();
                obId_dia4.setId_dia4(rs.getInt("Id_dia4"));
                obId_dia4.setDescripcionDia4(rs.getString("Descripcion4"));
                obId_dia4.setAliasDia4(rs.getString("Alias4"));
                obEstadisticas.setObId_dia4(obId_dia4);

                Modelos.Estadisticas.clsId_dia5 obId_dia5 = new Modelos.Estadisticas.clsId_dia5();
                obId_dia5.setId_dia5(rs.getInt("Id_dia5"));
                obId_dia5.setDescripcionDia5(rs.getString("Descripcion5"));
                obId_dia5.setAliasDia5(rs.getString("Alias5"));
                obEstadisticas.setObId_dia5(obId_dia5);

                Modelos.Estadisticas.clsId_dia6 obId_dia6 = new Modelos.Estadisticas.clsId_dia6();
                obId_dia6.setId_dia6(rs.getInt("Id_dia6"));
                obId_dia6.setDescripcionDia6(rs.getString("Descripcion6"));
                obId_dia6.setAliasDia6(rs.getString("Alias6"));
                obEstadisticas.setObId_dia6(obId_dia6);

                Modelos.Estadisticas.clsId_dia7 obId_dia7 = new Modelos.Estadisticas.clsId_dia7();
                obId_dia7.setId_dia7(rs.getInt("Id_dia7"));
                obId_dia7.setDescripcionDia7(rs.getString("Descripcion7"));
                obId_dia7.setAliasDia7(rs.getString("Alias7"));
                obEstadisticas.setObId_dia7(obId_dia7);

                Modelos.Estadisticas.clsId_dia8 obId_dia8 = new Modelos.Estadisticas.clsId_dia8();
                obId_dia8.setId_dia8(rs.getInt("Id_dia8"));
                obId_dia8.setDescripcionDia8(rs.getString("Descripcion8"));
                obId_dia8.setAliasDia8(rs.getString("Alias8"));
                obEstadisticas.setObId_dia8(obId_dia8);

                Modelos.Estadisticas.clsId_dia9 obId_dia9 = new Modelos.Estadisticas.clsId_dia9();
                obId_dia9.setId_dia9(rs.getInt("Id_dia9"));
                obId_dia9.setDescripcionDia9(rs.getString("Descripcion9"));
                obId_dia9.setAliasDia9(rs.getString("Alias9"));
                obEstadisticas.setObId_dia9(obId_dia9);

                Modelos.Estadisticas.clsId_dia10 obId_dia10 = new Modelos.Estadisticas.clsId_dia10();
                obId_dia10.setId_dia10(rs.getInt("Id_dia10"));
                obId_dia10.setDescripcionDia10(rs.getString("Descripcion10"));
                obId_dia10.setAliasDia10(rs.getString("Alias10"));
                obEstadisticas.setObId_dia10(obId_dia10);

                Modelos.Estadisticas.clsId_dia11 obId_dia11 = new Modelos.Estadisticas.clsId_dia11();
                obId_dia11.setId_dia11(rs.getInt("Id_dia11"));
                obId_dia11.setDescripcionDia11(rs.getString("Descripcion11"));
                obId_dia11.setAliasDia11(rs.getString("Alias11"));
                obEstadisticas.setObId_dia11(obId_dia11);

                Modelos.Estadisticas.clsId_dia12 obId_dia12 = new Modelos.Estadisticas.clsId_dia12();
                obId_dia12.setId_dia12(rs.getInt("Id_dia12"));
                obId_dia12.setDescripcionDia12(rs.getString("Descripcion12"));
                obId_dia12.setAliasDia12(rs.getString("Alias12"));
                obEstadisticas.setObId_dia12(obId_dia12);

                Modelos.Estadisticas.clsId_dia13 obId_dia13 = new Modelos.Estadisticas.clsId_dia13();
                obId_dia13.setId_dia13(rs.getInt("Id_dia13"));
                obId_dia13.setDescripcionDia13(rs.getString("Descripcion13"));
                obId_dia13.setAliasDia13(rs.getString("Alias13"));
                obEstadisticas.setObId_dia13(obId_dia13);

                Modelos.Estadisticas.clsId_dia14 obId_dia14 = new Modelos.Estadisticas.clsId_dia14();
                obId_dia14.setId_dia14(rs.getInt("Id_dia14"));
                obId_dia14.setDescripcionDia14(rs.getString("Descripcion14"));
                obId_dia14.setAliasDia14(rs.getString("Alias14"));
                obEstadisticas.setObId_dia14(obId_dia14);

                Modelos.Estadisticas.clsId_dia15 obId_dia15 = new Modelos.Estadisticas.clsId_dia15();
                obId_dia15.setId_dia15(rs.getInt("Id_dia15"));
                obId_dia15.setDescripcionDia15(rs.getString("Descripcion15"));
                obId_dia15.setAliasDia15(rs.getString("Alias15"));
                obEstadisticas.setObId_dia15(obId_dia15);

                Modelos.Estadisticas.clsId_dia16 obId_dia16 = new Modelos.Estadisticas.clsId_dia16();
                obId_dia16.setId_dia16(rs.getInt("Id_dia16"));
                obId_dia16.setDescripcionDia16(rs.getString("Descripcion16"));
                obId_dia16.setAliasDia16(rs.getString("Alias16"));
                obEstadisticas.setObId_dia16(obId_dia16);

                Modelos.Estadisticas.clsId_dia17 obId_dia17 = new Modelos.Estadisticas.clsId_dia17();
                obId_dia17.setId_dia17(rs.getInt("Id_dia17"));
                obId_dia17.setDescripcionDia17(rs.getString("Descripcion17"));
                obId_dia17.setAliasDia17(rs.getString("Alias17"));
                obEstadisticas.setObId_dia17(obId_dia17);

                Modelos.Estadisticas.clsId_dia18 obId_dia18 = new Modelos.Estadisticas.clsId_dia18();
                obId_dia18.setId_dia18(rs.getInt("Id_dia18"));
                obId_dia18.setDescripcionDia18(rs.getString("Descripcion18"));
                obId_dia18.setAliasDia18(rs.getString("Alias18"));
                obEstadisticas.setObId_dia18(obId_dia18);

                Modelos.Estadisticas.clsId_dia19 obId_dia19 = new Modelos.Estadisticas.clsId_dia19();
                obId_dia19.setId_dia19(rs.getInt("Id_dia19"));
                obId_dia19.setDescripcionDia19(rs.getString("Descripcion19"));
                obId_dia19.setAliasDia19(rs.getString("Alias19"));
                obEstadisticas.setObId_dia19(obId_dia19);

                Modelos.Estadisticas.clsId_dia20 obId_dia20 = new Modelos.Estadisticas.clsId_dia20();
                obId_dia20.setId_dia20(rs.getInt("Id_dia20"));
                obId_dia20.setDescripcionDia20(rs.getString("Descripcion20"));
                obId_dia20.setAliasDia20(rs.getString("Alias20"));
                obEstadisticas.setObId_dia20(obId_dia20);

                Modelos.Estadisticas.clsId_dia21 obId_dia21 = new Modelos.Estadisticas.clsId_dia21();
                obId_dia21.setId_dia21(rs.getInt("Id_dia21"));
                obId_dia21.setDescripcionDia21(rs.getString("Descripcion21"));
                obId_dia21.setAliasDia21(rs.getString("Alias21"));
                obEstadisticas.setObId_dia21(obId_dia21);

                Modelos.Estadisticas.clsId_dia22 obId_dia22 = new Modelos.Estadisticas.clsId_dia22();
                obId_dia22.setId_dia22(rs.getInt("Id_dia22"));
                obId_dia22.setDescripcionDia22(rs.getString("Descripcion22"));
                obId_dia22.setAliasDia22(rs.getString("Alias22"));
                obEstadisticas.setObId_dia22(obId_dia22);

                Modelos.Estadisticas.clsId_dia23 obId_dia23 = new Modelos.Estadisticas.clsId_dia23();
                obId_dia23.setId_dia23(rs.getInt("Id_dia23"));
                obId_dia23.setDescripcionDia23(rs.getString("Descripcion23"));
                obId_dia23.setAliasDia23(rs.getString("Alias23"));
                obEstadisticas.setObId_dia23(obId_dia23);

                Modelos.Estadisticas.clsId_dia24 obId_dia24 = new Modelos.Estadisticas.clsId_dia24();
                obId_dia24.setId_dia24(rs.getInt("Id_dia24"));
                obId_dia24.setDescripcionDia24(rs.getString("Descripcion24"));
                obId_dia24.setAliasDia24(rs.getString("Alias24"));
                obEstadisticas.setObId_dia24(obId_dia24);

                Modelos.Estadisticas.clsId_dia25 obId_dia25 = new Modelos.Estadisticas.clsId_dia25();
                obId_dia25.setId_dia25(rs.getInt("Id_dia25"));
                obId_dia25.setDescripcionDia25(rs.getString("Descripcion25"));
                obId_dia25.setAliasDia25(rs.getString("Alias25"));
                obEstadisticas.setObId_dia25(obId_dia25);

                Modelos.Estadisticas.clsId_dia26 obId_dia26 = new Modelos.Estadisticas.clsId_dia26();
                obId_dia26.setId_dia26(rs.getInt("Id_dia26"));
                obId_dia26.setDescripcionDia26(rs.getString("Descripcion26"));
                obId_dia26.setAliasDia26(rs.getString("Alias26"));
                obEstadisticas.setObId_dia26(obId_dia26);

                Modelos.Estadisticas.clsId_dia27 obId_dia27 = new Modelos.Estadisticas.clsId_dia27();
                obId_dia27.setId_dia27(rs.getInt("Id_dia27"));
                obId_dia27.setDescripcionDia27(rs.getString("Descripcion27"));
                obId_dia27.setAliasDia27(rs.getString("Alias27"));
                obEstadisticas.setObId_dia27(obId_dia27);

                Modelos.Estadisticas.clsId_dia28 obId_dia28 = new Modelos.Estadisticas.clsId_dia28();
                obId_dia28.setId_dia28(rs.getInt("Id_dia28"));
                obId_dia28.setDescripcionDia28(rs.getString("Descripcion28"));
                obId_dia28.setAliasDia28(rs.getString("Alias28"));
                obEstadisticas.setObId_dia28(obId_dia28);

                Modelos.Estadisticas.clsId_dia29 obId_dia29 = new Modelos.Estadisticas.clsId_dia29();
                obId_dia29.setId_dia29(rs.getInt("Id_dia29"));
                obId_dia29.setDescripcionDia29(rs.getString("Descripcion29"));
                obId_dia29.setAliasDia29(rs.getString("Alias29"));
                obEstadisticas.setObId_dia29(obId_dia29);

                Modelos.Estadisticas.clsId_dia30 obId_dia30 = new Modelos.Estadisticas.clsId_dia30();
                obId_dia30.setId_dia30(rs.getInt("Id_dia30"));
                obId_dia30.setDescripcionDia30(rs.getString("Descripcion30"));
                obId_dia30.setAliasDia30(rs.getString("Alias30"));
                obEstadisticas.setObId_dia30(obId_dia30);
                
                Modelos.Estadisticas.clsId_dia31 obId_dia31 = new Modelos.Estadisticas.clsId_dia31();
                obId_dia31.setId_dia31(rs.getInt("Id_dia31"));
                obId_dia31.setDescripcionDia31(rs.getString("Descripcion31"));
                obId_dia31.setAliasDia31(rs.getString("Alias31"));
                obEstadisticas.setObId_dia31(obId_dia31);

                obEstadisticas.setComentario(rs.getString("Comentario"));

                lstclsEstadisticas.add(obEstadisticas);
            }
        } catch (Exception ex) {
        }
        return lstclsEstadisticas;
    }

    public List<Modelos.Estadisticas.clsEstadisticas> getBuscarEstadisticas(Modelos.Estadisticas.clsBuscar obclsBuscar) {

        List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spBuscarEsta(?)}");
            ps.setString(1, obclsBuscar.getStBuscar());
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.Estadisticas.clsEstadisticas obEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
                obEstadisticas.setId_estadistica(rs.getInt("Id_estadistica"));

                Modelos.Estadisticas.clsEmpleado obEmpleado = new Modelos.Estadisticas.clsEmpleado();
                obEmpleado.setId_empleado(rs.getInt("Id_empleado"));
                obEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obEstadisticas.setObEmpleado(obEmpleado);

                Modelos.Estadisticas.clsId_dia1 obId_dia1 = new Modelos.Estadisticas.clsId_dia1();
                obId_dia1.setId_dia1(rs.getInt("Id_dia1"));
                obId_dia1.setDescripcionDia1(rs.getString("Descripcion1"));
                obId_dia1.setAliasDia1(rs.getString("Alias1"));
                obEstadisticas.setObId_dia1(obId_dia1);

                Modelos.Estadisticas.clsId_dia2 obId_dia2 = new Modelos.Estadisticas.clsId_dia2();
                obId_dia2.setId_dia2(rs.getInt("Id_dia2"));
                obId_dia2.setDescripcionDia2(rs.getString("Descripcion2"));
                obId_dia2.setAliasDia2(rs.getString("Alias2"));
                obEstadisticas.setObId_dia2(obId_dia2);

                Modelos.Estadisticas.clsId_dia3 obId_dia3 = new Modelos.Estadisticas.clsId_dia3();
                obId_dia3.setId_dia3(rs.getInt("Id_dia3"));
                obId_dia3.setDescripcionDia3(rs.getString("Descripcion3"));
                obId_dia3.setAliasDia3(rs.getString("Alias3"));
                obEstadisticas.setObId_dia3(obId_dia3);

                Modelos.Estadisticas.clsId_dia4 obId_dia4 = new Modelos.Estadisticas.clsId_dia4();
                obId_dia4.setId_dia4(rs.getInt("Id_dia4"));
                obId_dia4.setDescripcionDia4(rs.getString("Descripcion4"));
                obId_dia4.setAliasDia4(rs.getString("Alias4"));
                obEstadisticas.setObId_dia4(obId_dia4);

                Modelos.Estadisticas.clsId_dia5 obId_dia5 = new Modelos.Estadisticas.clsId_dia5();
                obId_dia5.setId_dia5(rs.getInt("Id_dia5"));
                obId_dia5.setDescripcionDia5(rs.getString("Descripcion5"));
                obId_dia5.setAliasDia5(rs.getString("Alias5"));
                obEstadisticas.setObId_dia5(obId_dia5);

                Modelos.Estadisticas.clsId_dia6 obId_dia6 = new Modelos.Estadisticas.clsId_dia6();
                obId_dia6.setId_dia6(rs.getInt("Id_dia6"));
                obId_dia6.setDescripcionDia6(rs.getString("Descripcion6"));
                obId_dia6.setAliasDia6(rs.getString("Alias6"));
                obEstadisticas.setObId_dia6(obId_dia6);

                Modelos.Estadisticas.clsId_dia7 obId_dia7 = new Modelos.Estadisticas.clsId_dia7();
                obId_dia7.setId_dia7(rs.getInt("Id_dia7"));
                obId_dia7.setDescripcionDia7(rs.getString("Descripcion7"));
                obId_dia7.setAliasDia7(rs.getString("Alias7"));
                obEstadisticas.setObId_dia7(obId_dia7);

                Modelos.Estadisticas.clsId_dia8 obId_dia8 = new Modelos.Estadisticas.clsId_dia8();
                obId_dia8.setId_dia8(rs.getInt("Id_dia8"));
                obId_dia8.setDescripcionDia8(rs.getString("Descripcion8"));
                obId_dia8.setAliasDia8(rs.getString("Alias8"));
                obEstadisticas.setObId_dia8(obId_dia8);

                Modelos.Estadisticas.clsId_dia9 obId_dia9 = new Modelos.Estadisticas.clsId_dia9();
                obId_dia9.setId_dia9(rs.getInt("Id_dia9"));
                obId_dia9.setDescripcionDia9(rs.getString("Descripcion9"));
                obId_dia9.setAliasDia9(rs.getString("Alias9"));
                obEstadisticas.setObId_dia9(obId_dia9);

                Modelos.Estadisticas.clsId_dia10 obId_dia10 = new Modelos.Estadisticas.clsId_dia10();
                obId_dia10.setId_dia10(rs.getInt("Id_dia10"));
                obId_dia10.setDescripcionDia10(rs.getString("Descripcion10"));
                obId_dia10.setAliasDia10(rs.getString("Alias10"));
                obEstadisticas.setObId_dia10(obId_dia10);

                Modelos.Estadisticas.clsId_dia11 obId_dia11 = new Modelos.Estadisticas.clsId_dia11();
                obId_dia11.setId_dia11(rs.getInt("Id_dia11"));
                obId_dia11.setDescripcionDia11(rs.getString("Descripcion11"));
                obId_dia11.setAliasDia11(rs.getString("Alias11"));
                obEstadisticas.setObId_dia11(obId_dia11);

                Modelos.Estadisticas.clsId_dia12 obId_dia12 = new Modelos.Estadisticas.clsId_dia12();
                obId_dia12.setId_dia12(rs.getInt("Id_dia12"));
                obId_dia12.setDescripcionDia12(rs.getString("Descripcion12"));
                obId_dia12.setAliasDia12(rs.getString("Alias12"));
                obEstadisticas.setObId_dia12(obId_dia12);

                Modelos.Estadisticas.clsId_dia13 obId_dia13 = new Modelos.Estadisticas.clsId_dia13();
                obId_dia13.setId_dia13(rs.getInt("Id_dia13"));
                obId_dia13.setDescripcionDia13(rs.getString("Descripcion13"));
                obId_dia13.setAliasDia13(rs.getString("Alias13"));
                obEstadisticas.setObId_dia13(obId_dia13);

                Modelos.Estadisticas.clsId_dia14 obId_dia14 = new Modelos.Estadisticas.clsId_dia14();
                obId_dia14.setId_dia14(rs.getInt("Id_dia14"));
                obId_dia14.setDescripcionDia14(rs.getString("Descripcion14"));
                obId_dia14.setAliasDia14(rs.getString("Alias14"));
                obEstadisticas.setObId_dia14(obId_dia14);

                Modelos.Estadisticas.clsId_dia15 obId_dia15 = new Modelos.Estadisticas.clsId_dia15();
                obId_dia15.setId_dia15(rs.getInt("Id_dia15"));
                obId_dia15.setDescripcionDia15(rs.getString("Descripcion15"));
                obId_dia15.setAliasDia15(rs.getString("Alias15"));
                obEstadisticas.setObId_dia15(obId_dia15);

                Modelos.Estadisticas.clsId_dia16 obId_dia16 = new Modelos.Estadisticas.clsId_dia16();
                obId_dia16.setId_dia16(rs.getInt("Id_dia16"));
                obId_dia16.setDescripcionDia16(rs.getString("Descripcion16"));
                obId_dia16.setAliasDia16(rs.getString("Alias16"));
                obEstadisticas.setObId_dia16(obId_dia16);

                Modelos.Estadisticas.clsId_dia17 obId_dia17 = new Modelos.Estadisticas.clsId_dia17();
                obId_dia17.setId_dia17(rs.getInt("Id_dia17"));
                obId_dia17.setDescripcionDia17(rs.getString("Descripcion17"));
                obId_dia17.setAliasDia17(rs.getString("Alias17"));
                obEstadisticas.setObId_dia17(obId_dia17);

                Modelos.Estadisticas.clsId_dia18 obId_dia18 = new Modelos.Estadisticas.clsId_dia18();
                obId_dia18.setId_dia18(rs.getInt("Id_dia18"));
                obId_dia18.setDescripcionDia18(rs.getString("Descripcion18"));
                obId_dia18.setAliasDia18(rs.getString("Alias18"));
                obEstadisticas.setObId_dia18(obId_dia18);

                Modelos.Estadisticas.clsId_dia19 obId_dia19 = new Modelos.Estadisticas.clsId_dia19();
                obId_dia19.setId_dia19(rs.getInt("Id_dia19"));
                obId_dia19.setDescripcionDia19(rs.getString("Descripcion19"));
                obId_dia19.setAliasDia19(rs.getString("Alias19"));
                obEstadisticas.setObId_dia19(obId_dia19);

                Modelos.Estadisticas.clsId_dia20 obId_dia20 = new Modelos.Estadisticas.clsId_dia20();
                obId_dia20.setId_dia20(rs.getInt("Id_dia20"));
                obId_dia20.setDescripcionDia20(rs.getString("Descripcion20"));
                obId_dia20.setAliasDia20(rs.getString("Alias20"));
                obEstadisticas.setObId_dia20(obId_dia20);

                Modelos.Estadisticas.clsId_dia21 obId_dia21 = new Modelos.Estadisticas.clsId_dia21();
                obId_dia21.setId_dia21(rs.getInt("Id_dia21"));
                obId_dia21.setDescripcionDia21(rs.getString("Descripcion21"));
                obId_dia21.setAliasDia21(rs.getString("Alias21"));
                obEstadisticas.setObId_dia21(obId_dia21);

                Modelos.Estadisticas.clsId_dia22 obId_dia22 = new Modelos.Estadisticas.clsId_dia22();
                obId_dia22.setId_dia22(rs.getInt("Id_dia22"));
                obId_dia22.setDescripcionDia22(rs.getString("Descripcion22"));
                obId_dia22.setAliasDia22(rs.getString("Alias22"));
                obEstadisticas.setObId_dia22(obId_dia22);

                Modelos.Estadisticas.clsId_dia23 obId_dia23 = new Modelos.Estadisticas.clsId_dia23();
                obId_dia23.setId_dia23(rs.getInt("Id_dia23"));
                obId_dia23.setDescripcionDia23(rs.getString("Descripcion23"));
                obId_dia23.setAliasDia23(rs.getString("Alias23"));
                obEstadisticas.setObId_dia23(obId_dia23);

                Modelos.Estadisticas.clsId_dia24 obId_dia24 = new Modelos.Estadisticas.clsId_dia24();
                obId_dia24.setId_dia24(rs.getInt("Id_dia24"));
                obId_dia24.setDescripcionDia24(rs.getString("Descripcion24"));
                obId_dia24.setAliasDia24(rs.getString("Alias24"));
                obEstadisticas.setObId_dia24(obId_dia24);

                Modelos.Estadisticas.clsId_dia25 obId_dia25 = new Modelos.Estadisticas.clsId_dia25();
                obId_dia25.setId_dia25(rs.getInt("Id_dia25"));
                obId_dia25.setDescripcionDia25(rs.getString("Descripcion25"));
                obId_dia25.setAliasDia25(rs.getString("Alias25"));
                obEstadisticas.setObId_dia25(obId_dia25);

                Modelos.Estadisticas.clsId_dia26 obId_dia26 = new Modelos.Estadisticas.clsId_dia26();
                obId_dia26.setId_dia26(rs.getInt("Id_dia26"));
                obId_dia26.setDescripcionDia26(rs.getString("Descripcion26"));
                obId_dia26.setAliasDia26(rs.getString("Alias26"));
                obEstadisticas.setObId_dia26(obId_dia26);

                Modelos.Estadisticas.clsId_dia27 obId_dia27 = new Modelos.Estadisticas.clsId_dia27();
                obId_dia27.setId_dia27(rs.getInt("Id_dia27"));
                obId_dia27.setDescripcionDia27(rs.getString("Descripcion27"));
                obId_dia27.setAliasDia27(rs.getString("Alias27"));
                obEstadisticas.setObId_dia27(obId_dia27);

                Modelos.Estadisticas.clsId_dia28 obId_dia28 = new Modelos.Estadisticas.clsId_dia28();
                obId_dia28.setId_dia28(rs.getInt("Id_dia28"));
                obId_dia28.setDescripcionDia28(rs.getString("Descripcion28"));
                obId_dia28.setAliasDia28(rs.getString("Alias28"));
                obEstadisticas.setObId_dia28(obId_dia28);

                Modelos.Estadisticas.clsId_dia29 obId_dia29 = new Modelos.Estadisticas.clsId_dia29();
                obId_dia29.setId_dia29(rs.getInt("Id_dia29"));
                obId_dia29.setDescripcionDia29(rs.getString("Descripcion29"));
                obId_dia29.setAliasDia29(rs.getString("Alias29"));
                obEstadisticas.setObId_dia29(obId_dia29);

                Modelos.Estadisticas.clsId_dia30 obId_dia30 = new Modelos.Estadisticas.clsId_dia30();
                obId_dia30.setId_dia30(rs.getInt("Id_dia30"));
                obId_dia30.setDescripcionDia30(rs.getString("Descripcion30"));
                obId_dia30.setAliasDia30(rs.getString("Alias30"));
                obEstadisticas.setObId_dia30(obId_dia30);
                
                Modelos.Estadisticas.clsId_dia31 obId_dia31 = new Modelos.Estadisticas.clsId_dia31();
                obId_dia31.setId_dia31(rs.getInt("Id_dia31"));
                obId_dia31.setDescripcionDia31(rs.getString("Descripcion31"));
                obId_dia31.setAliasDia31(rs.getString("Alias31"));
                obEstadisticas.setObId_dia31(obId_dia31);

                lstclsEstadisticas.add(obEstadisticas);
            }

        } catch (Exception e) {

        }
        return lstclsEstadisticas;
    }

}
