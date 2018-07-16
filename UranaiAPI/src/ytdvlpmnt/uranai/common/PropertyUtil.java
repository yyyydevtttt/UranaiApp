package ytdvlpmnt.uranai.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {

	/** ロガーオブジェクト */
	private Logger log = Logger.getLogger(this.getClass());
	/** プロパティファイル名 */
	private String propName = "properties.xml";
	/** プロパティオブジェクト */
	private Properties prop;


	/**
	 * プロパティオブジェクトを取得する
	 *
	 * @return Properties
	 * @throws IOException
	 *
	 */
	public Properties getProperties() {

		log.debug("処理開始");

		// プロパティが null の場合に取得
		if (this.prop == null) {
			// プロパティの取得
			this.prop = new Properties();

			try (InputStream is = new FileInputStream(propName)) {
				this.prop.loadFromXML(is);
			} catch (IOException e) {
				log.error("プロパティファイルの読み込みに失敗しました。", e);
				e.printStackTrace();
			}
		}

		log.debug("処理終了");

		return this.prop;
	}

	/**
	 * プロパティオブジェクトを取得する
	 *
	 * @param	fileName String プロパティファイル名（XML）
	 * @return Properties
	 * @throws IOException
	 *
	 */
	public Properties getProperties(String fileName) {

		log.debug("処理開始");

		// プロパティが null の場合に取得
		if (this.prop == null) {
			// プロパティの取得
			this.prop = new Properties();

			try (InputStream is = new FileInputStream(fileName)) {
				this.prop.loadFromXML(is);
			} catch (IOException e) {
				log.error("プロパティファイルの読み込みに失敗しました。", e);
				e.printStackTrace();
			}
		}

		log.debug("処理終了");

		return this.prop;
	}

}
