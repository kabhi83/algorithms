/**
 * 
 */
package com.home.ak.algo.exception;

/**
 * @author abhi
 *
 */
public class QueueEmptyException extends Exception {

	private static final long serialVersionUID = 2426026417779146881L;
	
	private String message;

	/**
	 * @param message
	 */
	public QueueEmptyException(String message) {
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
