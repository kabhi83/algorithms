/**
 * 
 */
package com.home.ak.algo.exception;

/**
 * @author abhi
 *
 */
public class QueueOverflowException extends Exception{

	private static final long serialVersionUID = -1149479220543640444L;
	
	private String message;

	/**
	 * @param message
	 */
	public QueueOverflowException(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
