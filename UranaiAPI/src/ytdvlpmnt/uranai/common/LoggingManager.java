package ytdvlpmnt.uranai.common;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggingManager {

	/** ロガーオブジェクト */
	private Logger log;

	/**
	 * コンストラクタ
	 */
	public LoggingManager(Logger log) {
		this.log = log;
		DOMConfigurator.configure("log4j.xml");
	}

	/**
	 * コンストラクタ
	 */
	public LoggingManager() {
	}

	/**
	 * ロガーを取得する
	 *
	 * @return log
	 */
	public Logger get() {
		return this.log;
	}

}
