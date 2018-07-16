package ytdvlpmnt.uranai.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import ytdvlpmnt.uranai.common.JsonUtil;
import ytdvlpmnt.uranai.common.MySQLConnector;
import ytdvlpmnt.uranai.dao.UranaiKekkaDao;
import ytdvlpmnt.uranai.dto.UranaiKekka;

@Path("uranaikekka")
public class UranaiKekkaService {

	/** コネクション */
	private Connection con;
	/** ロガー */
	Logger log = Logger.getLogger(this.getClass());

	{
		DOMConfigurator.configure("log4j.xml");
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("select")
	public Response selectUranaiKekka(String input) throws Exception {
		log.info("処理開始");

		// 引数の解析
		UranaiKekka uranaiKekka = JsonUtil.parse(UranaiKekka.class, input);
		// 取得した引数の出力
		log.info("受け取った引数：" + uranaiKekka.getUranaiDate());

		try {
			// UranaiKekkaDaoオブジェクトをnewする
			UranaiKekkaDao ukd = new UranaiKekkaDao(this.openConnection());
			// 占い結果を取得する
			UranaiKekka result = ukd.select(uranaiKekka);
			// 占い結果をJSONにエンコードする
			String json = JsonUtil.convert(result);

			// 処理結果の返却
			log.info("処理終了");
			return Response.ok()
					.entity(json)
					.build();

		} catch (Exception e) {
			log.error("検索処理に失敗しました。", e);
			throw e;
		}
	}

	/**
	 * コネクションを開く
	 *
	 * @return Connection
	 * @throws SQLException, ClassNotFoundException
	 *
	 */
	private Connection openConnection() throws Exception {
		log.debug("処理開始");

		// コネクションが null の場合に取得
		if (this.con == null) {
			// コネクションの取得
			MySQLConnector msc = new MySQLConnector();
			this.con = msc.getCon();
		}

		log.debug("処理終了");
		return this.con;
	}
}
