package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.exception;


public class TimeOutException extends BaseException{

	private static final long	serialVersionUID	= -4938556712560828963L;

	public TimeOutException(){
		super();
	}

	public TimeOutException( Exception objException ){
		super( objException );
	}

	public TimeOutException( String msjError ){
		super( msjError );
	}

	public TimeOutException( String codError, String msjError, Exception objException ){
		super( codError, msjError, objException );
	}

	public TimeOutException( String codError, String msjError, String nombreWS, Exception objException ){
		super( codError, msjError, nombreWS, objException );
	}
	


}
