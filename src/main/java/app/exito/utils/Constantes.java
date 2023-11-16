package app.exito.utils;

import org.json.JSONObject;

public class Constantes {
    public static final String NOMBRES;
    public static final String APELLIDOS;
    public static final String NUMERO_DOCUMENTO;
    public static final String ANIO;
    public static final String MES;
    public static final String DIA;
    public static final String CELULAR;
    public static final String CORREO;
    public static final String CLAVE;
    public static final String CIUDAD;
    public static final String ALMACEN;

    static {
        LeerJson.on("data.json");
        LeerJson.getGlobalJSONObject();
        JSONObject datosRegistro = LeerJson.getGlobalJSONObject().getJSONObject("DatosRegistro");
        JSONObject datosCompra = LeerJson.getGlobalJSONObject().getJSONObject("DatosCompra");

        NOMBRES = datosRegistro.getString("Nombres");
        APELLIDOS = datosRegistro.getString("Apellidos");
        NUMERO_DOCUMENTO = datosRegistro.getString("NumeroDocumento");
        ANIO = datosRegistro.getString("Anio");
        MES = datosRegistro.getString("Mes");
        DIA = datosRegistro.getString("Dia");
        CELULAR = datosRegistro.getString("Celular");
        CORREO = datosRegistro.getString("Correo");
        CLAVE = datosRegistro.getString("Clave");
        CIUDAD = datosCompra.getString("Ciudad");
        ALMACEN = datosCompra.getString("Almacen");
    }
}