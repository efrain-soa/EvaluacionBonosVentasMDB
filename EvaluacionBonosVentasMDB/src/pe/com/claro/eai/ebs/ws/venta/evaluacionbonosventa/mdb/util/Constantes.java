package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;

import java.io.Serializable;


public class Constantes implements Serializable{

	private static final long serialVersionUID = 3767984029783522404L;
	
	public static final String UBICACION_EJB_SPRING_CONTEXT = "classpath*:beanRefContext.xml";
	//public static final String UBICACION_EJB_SPRING_CONTEXT = "D:\\eduardo\\PROY_EDUARDO\\amb_desa\\work_1\\EvaluacionBonosVentaMDB\\src\\beanRefContext.xml";	
	
	public static final String NOMBRE_SP ="$nombre_SP";
	public static final String NOMBRE_BD ="$nombre_BD";  
	public static final String NOMBRE_WS ="$nombre_WS";
	public static final String VALOR_PUNTO=".";
	public static final String VALOR_PARENTISIS_A="(";
	public static final String VALOR_PARENTISIS_C=")";
	public static final String VALOR_COMA=",";
	public static final String FORMATO_FECHA="yyyyMMddhhmmss";
	public static final String LOG_SOAP="pe.com.claro.eai.postventa.bonosmdb.soap";
	public static final int VALOR_INICIAL_INTENTO=0;
	public static final String EXCEPTION_TIMEOUT="TIMEOUT";
	public static final CharSequence TIMEOUT = "TIMEOUT";

	public static final String CONNECT_TIMEOUT = "CONNECT_TIMEOUT";
	public static final String REQUEST_TIMEOUT = "REQUEST_TIMEOUT";

	public final static String INICIO_METODO = " INICIO METODO: ";
	public final static String FIN_METODO = " FIN METODO: ";
	
	public static final String P_PATH = "PATH: ";
	public static final String REQUEST_HEADER = " RequestHeader: ";
	public static final String REQUEST_BODY = " RequestBody: ";
	public static final String RESPONSE_HEADER = " ResponseHeader: ";
	public static final String RESPONSE_BODY = " ResponseBody: ";
	
	public static final String STRING_CERO = "0";
	public static final String STRING_UNO = "1";
	public static final String Vacio = "";

	public static final String MSG = "$msg";
	
	public static final String PUNTO = ".";

	public static final String EX_CON_CORCHETE = "[$ex]";
	public static final String VARIABLE_DB = "$bd";
	public static final String VARIABLE_SP = "$sp";
	
	public static final String FORMATOFECHACABECERA = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String FORMATO_FECHA_DEFAULT = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_FECHA_SP = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMEOUTEXCEPTION = "Timeout";
	public static final String TIMEOUTEXCEPTION2 = "Timed out";
	public static final String PERSISTENCEEXCEPTION = "javax.persistence.PersistenceException";
	public static final String GENERICJDBCEXCEPTION = "org.hibernate.exception";
	public static final String HIBERNATEJDBCEXCEPTION = "The application must supply JDBC connections";	
	public static final String EXCEPTIONEMPTYNULL = "Parametro(s) vacio(s)/nulo(s)";
	public final static String SQL_TIMEOUTEXCEPTION = "SQLTimeoutException";
	public static final String SQLTIMEOUTWS = "java.net.SocketTimeoutException";
	public final static String TIEMPO_TOTAL = " ] Tiempo total de proceso (ms):";
	
	 /* ENCODING */
    public static final String defaulEncodingProperties = "ISO-8859-1";
    public static final String defaulEncodingApi = "UTF-8";
    public static final String FORMATOFECHADEFAULT = "dd/MM/yyyy HH:mm:ss";
    public static final String DEFAULTENCONDINGAPI = null;
    public static final String DEFAULTENCONDIGPROPERTIES = null;
    /* Caracteres */
    public static final String CHAR_PARENTESIS_IZQUIERDO = "(";
    public static final String CHAR_PARENTESIS_DERECHO = ")";
    public static final String CHAR_INTERROGACION = "?";
    public static final String CHAR_COMA = ",";
    public static final String CORCHETE = "]";
	
	public static final String CLIENTE_SGA = "SGA";
	public static final String CLIENTE_BSCS = "BSCS";
	public static final String STATUS_ACTIVE = "Activo";
	public static final String STATUS_SUSPENDIDO = "Suspendido";
	public static final String STATUS_ACTIVE_SGA = "1";
	public static final String CCLDB_TELEFONIA = "002";
	public static final String CCLDB_INTERNET = "003";
	public static final String CCLDB_TV = "005";
	public static final String CLIENTE_MASIVO = "1";
	public static final String CLIENTE_CORPORATIVO = "2";
	public static final String NO_CLIENTE = "3";
	public static final String CLIENTE_MIXTO = "4";
	public static final String CUENTASCLARO_ERROR_USUARIO_BLOQUEADO = "5";
	public static final String CUENTASCLARO_ERROR_CONTRASENA = "6";
	public static final String CUENTASCLARO_ERROR_USO_INDEBIDO = "1";
	public static final String CUENTASCLARO_ERROR_TITULARIDAD = "2";
	public static final String CUENTASCLARO_ERROR_NRO_INTENTOS = "3";
	public static final String ACTIVO = "A";
	public static final String TIPO_HFC = "HFC";
	public static final String CANT_DIG_COD_CLI = "8";
	public static final String DIG_AUTOCOMPLET_CODCLI = "0";
	public static final String ESTADO_OK = "0";
	public static final int CONSTANTE_0 = 0;
	public static final int VALOR_1 = 1;
	public static final String GUION = " - ";
	public static final String CONSTANTE_LISTA_VACIA = "Lista Vacia";
	public static final String CONSTANTE_CODIGO_VACIO = "Codigo Vacio";
	public static final String CONSTANTE_SID_VACIO = "Codigo SID Vacio";
	public static final String CONSTANTE_VALOR_0 = "0";
	public static final String CONSTANTE_1 = "1";
	public static final String CONSTANTE_2 = "2";
	public static final String CONSTANTE_ERRORBD = "-1";
	public static final String CARACTER_SEPARADOR_ELEMENTOS = ";";
	public static final String KEY_FACTORY = "DESede";
	public static final String PROP_INTENTO_PERMITIDOS = ".nro.intentos.permitidos";
	public static final String PROP_ESPERA_INTENTOS = ".tiempo.espera.reintentos";
	public static final String PROP_SUFIJO = ".sufijo";
	public static final String PROP_CANT_MAX_SUFIJO = ".cant.max.sufijos";
	public static final String CODIGO_SERVICIO_BSCSC = "0";
	public static final String CODIGO_SERVICIO_ACTIVAR_BSCSC = "1";
	public static final String ARROBA_TEXT = "@";
	public static final String COMA_TEXT = ",";
	public static final boolean CONSTANTE_TRUE = true;
	public static final boolean CONSTANTE_FALSE = false;
	public static final String VACIO = "";
	public static final String TAGCLAVEINICIO = "<clave>";
	public static final String TAGCLAVEFIN = "</clave>";
	public static final String SLASH = "/";
	public static final String NOMBRE_METODO = "[evaluarCriteriosVenta]";
	public static final String CADENA_CERO = "0";
	

	public static final String COMA = ",";
    public static final String PALOTE = "|";
    public static final String DOBLESLASH = "\\";
    public static final String STRING_DOSPUNTOS = ":";
    public static final char DOSPUNTOS=':';
    public static final char GUIONBAJO='_';
    public static final String PALO="|";

	public static final String VALOR_CERO = "0";
	public static final String VALOR_UNO = "1";
	public static final String VALOR_DOS = "2";
	public static final String VALOR_TRES = "3";
	public static final int    CERO = 0;
	public static final int    UNO = 1;
	public static final int    DOSMIL = 2000;
	public static final String VALOR_BD = "BD";
	public static final String IDENTIFICADOR_BD = "$BD";
	public static final String VALOR_WS = "WS";
	public static final String IDENTIFICADOR_PLATAFORMA = "$plataforma";
	public static final String IDENTIFICADOR_ERROR = "$msgError";
	
	
	 /* Parametros de Auditoria - Header Request Transport */
    public static final String ACCEPT = "accept";
    public static final String IDTRANSACCION = "idTransaccion";
    public static final String MSGID = "msgid";
	public static final String TIMESTAMP = "timestamp";
    public static final String USERID = "userId";
    public static final String NOMBREAPLICACION = "nombreAplicacion";
    public static final String IPAPLICACION = "ipAplicacion";    
    public static final String CONTENTTYPE = "Content-Type";
    public static final String CHANNEL = "channel";
	public static final String IDAPPLICATION = "idApplication";
	public static final String USRID = "userId";
	
	// ------------------------------------------//
	// --------- CONTROL DE EXCEPCIONES ---------//
	// ------------------------------------------//
	public final static String	SALTOLINEA	= "\n";
	// ------ BD ------//
	public static final String EXCEPTION_BD_TIMEOUT_01 = "Timeout";
	public static final String EXCEPTION_BD_NO_DISPONIBLE_01 = "DataAccessResourceFailureException"; // Exception
	public static final int STATUS_ERROR = 1;																					// [SPRING]
																										// [JNDI
																										// DETENIDO]
	public static final String EXCEPTION_BD_NO_DISPONIBLE_02 = "PoolDisabledSQLException"; // Exception
																							// [NATIVO]
																							// [JNDI
																							// DETENIDO]
	public static final String EXCEPTION_BD_NO_DISPONIBLE_03 = "CannotGetJdbcConnectionException"; // Exception
																									// [SPRING]
																									// [JNDI
																									// ELIMINADO]
	public static final String EXCEPTION_BD_NO_DISPONIBLE_04 = "NameNotFoundException"; // Exception
																						// [SPRING]
																						// [JNDI
																						// NO
																						// CLUSTER]
	public static final String EXCEPTION_BD_EJECUCION_01 = "UncategorizedSQLException"; // Exception
																						// [SPRING]
																						// [SP-RAISE
																						// EXCEPTION]
	public static final String EXCEPTION_BD_EJECUCION_02 = "ORA-06510"; // Exception
																		// [NATIVO]
																		// [SP-RAISE
																		// EXCEPTION]
	public static final String EXCEPTION_BD_EJECUCION_03 = "Cursor is closed"; // Exception
																				// [NATIVO]
																				// [SP-RAISE
																				// EXCEPTION]
	public static final String EXCEPTION_BD_EJECUCION_04 = "ORA-06550"; // Exception
																		// [SPRING,
																		// NATIVO]
																		// [SP-RENOMBRADO,
																		// ELIMINADO]
	public static final String EXCEPTION_BD_EJECUCION_05 = "ORA-06508"; // Exception
																		// [NATIVO]
																		// [SP-RENOMBRADO,
																		// ELIMINADO]
	public static final String EXCEPTION_BD_EJECUCION_06 = "BadSqlGrammarException"; // Exception
																						// [SPRING]
																						// [SP-RENOMBRADO,
																						// ELIMINADO]

	// ----- Generales -------//
	public static final String constanteCero = "0";
	public static final String constanteUno = "1";
	public static final String constanteMenosDos = "-2";
	public static final String CUSTOMER_ID = "ID";
	public static final String LINEA_INTERNACIONAL = "51";
	public static final String PLATAFORMA_0 = "0";


	// ----- WS -------//
	public static final String EXCEPTION_WS_TIMEOUT_CODIGO = "408";
	public static final String EXCEPTION_WS_DISPONIBILIDAD_CODIGO = "-4";
	public static final String IDENTIFICADOR_MSG_ERROR = "$msgError";
	public static final String IDENTIDICADOR_WEB_SERVICES = "$WS_NAME";
	public static final String PARAMETRO_DELIMITADOR_BARRA = "\\|";
	public static final String VALOR_IGUAL = "=";
	//

	public static final String EXCEPCION_REST = " Excepcion ocurrida en la WS - REST ";
	public static final String EXCEPTION_WS_TIMEOUT_01 = "timed out";
	public static final String EXCEPTION_WS_TIMEOUT_02 = "SocketTimeoutException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_01 = "RemoteAccessException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_02 = "404";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_03 = "WebServiceException";
	public static final String EXCEPTION_WS_NO_DISPONIBLE_04 = "ConnectException";

	public static final Object SEGMENTO_PREPAGOCONSUMER = "Prepago Consumer";

	public static final String SEGMENTO_POS = "POS";

	public static final String MENSAJE_ERROR = "";

	public static final String EMAILPLATFORMNO0= "En la Plataforma ;platfom; se obtubo el idf ;idf;  : ;idfmensaje;";

	public static final String EMAILCAMPOSOBLIGATORIOSVACIOS= "En la Plataforma ;platfom; estan vacios:  ;campo;  ";

	public static final String INTERFACE_VENTA_1 = "INTERFACE_VENTA_1";
	public static final String INTERFACE_VENTA_2 = "INTERFACE_VENTA_2";
	public static final String INTERFACE_VENTA_3 = "INTERFACE_VENTA_3";
	public static final String INTERFACE_VENTA1 = "INTERFACE_VENTA1";
	public static final String GWP = "GWP";
	public static final String OAC = "OAC";



}
