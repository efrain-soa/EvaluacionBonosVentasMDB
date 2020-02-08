package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception;

public class WSClientException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7801524313780965527L;

	public WSClientException(String codError, String msjError, String origen,
			Exception objException) {
		super(codError, msjError, origen, objException);
		// TODO Auto-generated constructor stub
	}

	public WSClientException(String code, String msjError, String origen) {
		super(code, msjError, origen);
		// TODO Auto-generated constructor stub
	}

	public WSClientException(String msjError) {
		super(msjError);
		// TODO Auto-generated constructor stub
	}

}
