package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception;

import java.util.List;

import pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.responseslocals.ErrorDetailType;

public class ErrorFuncionalException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ErrorFuncionalException(String code, String message, List<ErrorDetailType> errorDetailType, String ubicacionError, String origenError){
		super(code, message, errorDetailType, ubicacionError, origenError);
	}
	
	public ErrorFuncionalException(String code, String message, List<ErrorDetailType> errorDetailType, String ubicacionError, String origenError, Exception exception){
		super(code, message, errorDetailType, ubicacionError, origenError);
	}

}
