package ytdvlpmnt.uranai.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MySQLConnector {

	/** コネクションオブジェクト */
	private Connection con = null;
	/** プロパティオブジェクト */
	private Properties prop;
	/** ロガーオブジェクト */
	private Logger log;

	public MySQLConnector() {
		PropertyUtil pu = new PropertyUtil();
		this.prop = pu.getProperties();
		this.log = Logger.getLogger(this.getClass());
	}

	/**
	 * コネクションを取得
	 *
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection getCon() throws SQLException, ClassNotFoundException {

		log.debug("処理開始");

		try {
			Class.forName(this.prop.getProperty("MySQLConnector.driverName"));
			con = DriverManager.getConnection(
					this.prop.getProperty("MySQLConnector.url"),
					this.prop.getProperty("MySQLConnector.userId"),
					this.prop.getProperty("MySQLConnector.password"));

			log.debug("処理終了");

			// MySQLコネクションを返す
			return con;
		} catch (SQLException e) {
			log.error("コネクションの取得に失敗しました。", e);
			throw e;
		} catch (ClassNotFoundException e) {
			log.error("com.mysql.jdbc.Driver が見つかりません。", e);
			throw e;
		}

	}

}
