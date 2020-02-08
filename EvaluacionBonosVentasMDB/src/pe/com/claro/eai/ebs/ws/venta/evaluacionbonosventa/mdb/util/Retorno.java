package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.util;



public class Retorno<T>{
    /**
	 * 
	 */
	private String errorCode;
    private String errorMsg;
    private T objecto;


    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }


    public void setObjecto(T objecto) {
        this.objecto = objecto;
    }

    public T getObjecto() {
        return objecto;
    }
    
}
