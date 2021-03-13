package edu.aisl08.advcomp.authentification;

/**
 * Exception générale
 * @author philippe
 *
 */
@SuppressWarnings("serial")
public class AdvcompException extends Exception {

	public AdvcompException() {
	}

	public AdvcompException(String message) {
		super(message);
	}

	public AdvcompException(Throwable cause) {
		super(cause);
	}

	public AdvcompException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdvcompException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
