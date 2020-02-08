package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception;

import java.util.List;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.responseslocals.ErrorDetailType;


public class BaseException extends Exception{

	private static final long	serialVersionUID	= 3186105543822592034L;

	private Exception			exception;
	private String				code;
	private String				message;
	private String				nombreSP;
	private String				nombreBD;
	private String				nombreWS;
	private String				nombreQueue;
	private List<ErrorDetailType> errorDetailType;
	
	private String ubicacionError;
	private String origenError;
	
	
	
	public BaseException(){
		super();
	}

	public BaseException( Exception objException ){
		this.exception = objException;
	}

	public BaseException( String msjError ){
		super( msjError );
		this.message = msjError;
	}

	public BaseException( String msjError, Exception objException ){
		super( objException );
		this.exception = objException;
		this.message = msjError;
	}

	public BaseException( String codError, String msjError, Exception objException ){
		super( msjError );
		this.code = codError;
		this.message = msjError;
		this.exception = objException;
	}

	public BaseException( String codError, String msjError, String nombreSP, String nombreBD, Exception objException ){
		super( msjError );
		this.code = codError;
		this.message = msjError;
		this.nombreSP = nombreSP;
		this.nombreBD = nombreBD;
		this.exception = objException;
	}

	public BaseException( String codError, String msjError, String nombreWS, Exception objException ){
		super( msjError );
		this.code = codError;
		this.message = msjError;
		this.nombreWS = nombreWS;
		this.exception = objException;
	}

	public BaseException( String codError, String msjError, String nombreWS){
		super( msjError );
		this.code = codError;
		this.message = msjError;
		this.nombreWS = nombreWS;
	}

	public BaseException(String code, String message, List<ErrorDetailType> errorDetailType, String ubicacionError, String origenError) {
		super(message);
		this.errorDetailType = errorDetailType;
		this.code = code;
		this.message = message;
		this.ubicacionError = ubicacionError;
		this.origenError = origenError;
	}
	
	public BaseException(String code, String message, List<ErrorDetailType> errorDetailType, String ubicacionError, String origenError, Exception exception){
		super(message);
		this.errorDetailType = errorDetailType;
		this.code = code;
		this.message = message;
		this.ubicacionError = ubicacionError;
		this.origenError = origenError;
		this.exception = exception;
	}

	public Exception getObjException(){
		return exception;
	}

	public void setObjException( Exception objException ){
		this.exception = objException;
	}

	public String getCodError(){
		return code;
	}

	public void setCodError( String codError ){
		this.code = codError;
	}

	public String getMsjError(){
		return message;
	}

	public void setMsjError( String msjError ){
		this.message = msjError;
	}
	
	

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUbicacionError() {
		return ubicacionError;
	}

	public void setUbicacionError(String ubicacionError) {
		this.ubicacionError = ubicacionError;
	}

	public String getOrigenError() {
		return origenError;
	}

	public void setOrigenError(String origenError) {
		this.origenError = origenError;
	}

	public List<ErrorDetailType> getErrorDetailType() {
		return errorDetailType;
	}

	public void setErrorDetailType(List<ErrorDetailType> errorDetailType) {
		this.errorDetailType = errorDetailType;
	}

	public String getNombreSP(){
		return nombreSP;
	}

	public void setNombreSP( String nombreSP ){
		this.nombreSP = nombreSP;
	}

	public String getNombreBD(){
		return nombreBD;
	}

	public void setNombreBD( String nombreBD ){
		this.nombreBD = nombreBD;
	}

	public static long getSerialVersionUID(){
		return serialVersionUID;
	}

	public String getNombreWS(){
		return nombreWS;
	}

	public void setNombreWS( String nombreWS ){
		this.nombreWS = nombreWS;
	}

	public String getNombreQueue(){
		return nombreQueue;
	}

	public void setNombreQueue( String nombreQueue ){
		this.nombreQueue = nombreQueue;
	}

	public static long getSerialversionuid(){
		return serialVersionUID;
	}

}
