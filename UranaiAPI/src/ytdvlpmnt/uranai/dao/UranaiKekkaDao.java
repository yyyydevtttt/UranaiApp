package ytdvlpmnt.uranai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ytdvlpmnt.uranai.dto.UranaiKekka;

public class UranaiKekkaDao {

	/** コネクションオブジェクト */
	private Connection con;
	/** ロガーオブジェクト */
	private Logger log;

	/**
	 * コンストラクタ
	 */
	public UranaiKekkaDao(Connection con) {
		this.con = con;
		this.log = Logger.getLogger(this.getClass());
	}

	public UranaiKekka select(UranaiKekka uranaiKekka) throws SQLException {
		log.debug("処理開始");

		// 検索結果の格納用オブジェクトを用意する
		UranaiKekka result = new UranaiKekka();
		// 実行するSQLを設定する
		String sql = "select uranai_date, "
				+ "   capricorn, "
				+ "   aquarius, "
				+ "   pisces, "
				+ "   aries, "
				+ "   taurus, "
				+ "   gemini, "
				+ "   cancer, "
				+ "   leo, "
				+ "   virgo, "
				+ "   libra, "
				+ "   scorpio, "
				+ "   sagittarius "
				+ "  from tdb.uranai_kekka "
				+ " where uranai_date = ? ";

		try (Connection con = this.con) {
			// MySQL接続完了のログ
			log.debug("MySQLに接続できました。");

			// 検索実行オブジェクト
			PreparedStatement stm = con.prepareStatement(sql);
			// 引数を設定する（日付）
			stm.setString(1, uranaiKekka.getUranaiDate());
			// 検索の実行
			ResultSet rs = stm.executeQuery();

			// 検索結果の格納
			while (rs.next()) {
				// 日付
				result.setUranaiDate(rs.getString("uranai_date"));
				// やぎ座順位
				result.setCapricorn(Integer.parseInt(rs.getString("capricorn")));
				// みずがめ座順位
				result.setAquarius(Integer.parseInt(rs.getString("aquarius")));
				// うお座順位
				result.setPisces(Integer.parseInt(rs.getString("pisces")));
				// おひつじ座順位
				result.setAries(Integer.parseInt(rs.getString("aries")));
				// おうし座順位
				result.setTaurus(Integer.parseInt(rs.getString("taurus")));
				// ふたご座順位
				result.setGemini(Integer.parseInt(rs.getString("gemini")));
				// かに座順位
				result.setCancer(Integer.parseInt(rs.getString("cancer")));
				// しし座順位
				result.setLeo(Integer.parseInt(rs.getString("leo")));
				// おとめ座順位
				result.setVirgo(Integer.parseInt(rs.getString("virgo")));
				// てんびん座順位
				result.setLibra(Integer.parseInt(rs.getString("libra")));
				// さそり座順位
				result.setScorpio(Integer.parseInt(rs.getString("scorpio")));
				// いて座順位
				result.setSagittarius(Integer.parseInt(rs.getString("sagittarius")));
			}

			// 処理結果の返却
			log.debug("処理終了");
			return result;

		} catch (SQLException e) {
			log.error("DB検索中にエラーが発生しました。");
			log.error("sql = " + sql + ", ? = " + uranaiKekka.getUranaiDate());
			throw e;
		}
	}
}
