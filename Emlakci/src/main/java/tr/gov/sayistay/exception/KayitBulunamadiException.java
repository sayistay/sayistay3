package tr.gov.sayistay.exception;

public class KayitBulunamadiException extends RuntimeException {
	private static final long serialVersionUID = 2788097926133815977L;

	public KayitBulunamadiException() {
		super();
	}

	public KayitBulunamadiException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public KayitBulunamadiException(String message, Throwable cause) {
		super(message, cause);
	}

	public KayitBulunamadiException(String message) {
		super(message);
	}

	public KayitBulunamadiException(Throwable cause) {
		super(cause);
	}

}
