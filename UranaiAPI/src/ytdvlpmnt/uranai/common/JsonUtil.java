package ytdvlpmnt.uranai.common;

import java.io.IOException;
import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	/** ロガーオブジェクト */
	static Logger log = Logger.getLogger(JsonUtil.class);

	/**
	 * JSON文字列をDTOクラスへ変換する
	 *
	 * @param dto
	 * @param json
	 * @return DTOobject
	 * @throws IOException
	 */
	public static <T> T parse(Class<T> dto, String json) {
		log.debug("処理開始");
		ObjectMapper mapper = new ObjectMapper();
		try {
			log.debug("処理終了");
			return (T) mapper.readValue(json, dto);
		} catch (Exception e) {
			log.error("JSON文字列の解析に失敗しました。", e);
			return null;
		}
	}

	/**
	 * JSON文字列をDTOクラスへ変換する
	 *
	 * @param dto
	 * @param json
	 * @return DTOobject
	 * @throws IOException
	 */
	public static <T> T eqParse(Class<T> dto, String json) {
		log.debug("処理開始");
		try {
			String[] input = json.split("=", -1);
			Constructor<T> constructor = dto.getConstructor(String.class);
			log.debug("処理終了");
			return (T) constructor.newInstance(input[1]);
		} catch (Exception e) {
			log.error("=連結文字列の解析に失敗しました。", e);
			return null;
		}
	}

	/**
	 * DTOクラスのインスタンスをJSON文字列に変換する
	 *
	 * @param dto
	 * @return String
	 * @throws JsonProcessingException
	 */
	public static String convert(Object dto) {
		log.debug("処理開始");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
			log.debug("処理終了");
			return json;
		} catch (Exception e) {
			log.error("JSON文字列への変換に失敗しました。", e);
			return null;
		}
	}

}
