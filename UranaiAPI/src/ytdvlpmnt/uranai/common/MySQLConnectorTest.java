package ytdvlpmnt.uranai.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectorTest {

	public static void main(String[] args) {

		MySQLConnector msc = new MySQLConnector();

		try (Connection con = msc.getCon()){
			// MySQLに接続
			System.out.println("MySQLに接続できました。");

			// 実行する
			Statement stm = con.createStatement();
			String sql = "select * from test_counter";
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				String count = rs.getString("count");
				System.out.println("取得結果 -> count: " + count);
			}

		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("MySQLConnector クラスが見つかりません。" + e.getMessage());
			e.printStackTrace();
		}

	}

}
