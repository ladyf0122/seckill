package org.seckill.exception;

/**
 * 秒杀相关异常
 * @author Lady_F
 *
 */
public class SeckillException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}

}
