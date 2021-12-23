package Main;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class MethodAll {
	public boolean idCheck(String findId) {
		boolean idCheck = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			StringBuffer sql = new StringBuffer();
			sql.append("select \"ID\" from \"CAFE2\" where \"ID\"=?");
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, findId);
			rs = pstmt.executeQuery();
			if(rs.next()){
					rs.getString(1);
					if(rs.getString(1).equals(findId)) {
						idCheck = true;
						return idCheck;
					}
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return idCheck;
	}
	
	public String getPassword(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String outputPassword = "";
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select \"PS\" from cafe2 where \"ID\"=?");
			
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outputPassword = rs.getString(1);
			}
			return outputPassword;
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return outputPassword;
	}
	
	
	public void DeleteId(String deleteId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("delete from \"CAFE2\" where \"ID\"=?");
			
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, deleteId);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"���� ���� �����Ǿ����ϴ�!");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void insert(String id1, String password1, String area1) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO \"CAFE2\" values(\"CAFE2_SEQ\".nextval, ?, ?, ?, sysdate, 1)");
			
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id1);
			pstmt.setString(2, password1);
			pstmt.setString(3, area1);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"���� ���� ���ԵǾ����ϴ�!");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void search(String searchId1) {
		Connection conn = null;
		PreparedStatement pstmt = null; //statement �� ��Ӱ���
		ResultSet rs = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select \"NUM\",  \"ID\" , \"PS\", \"AR\", \"DT\", \"LV\"  from \"CAFE2\"");
			sql.append(" where \"ID\"=?");//���ε� ����
			
			String searchId = searchId1; //ã�� �̸��� ������ ����
			
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, searchId); //ù��° ?�� ���� ���� �Է��ϴ� ���� (indexNum, variable)
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getLong(1)); //index��ȣ�� �˻�
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getLong(6));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void primarySearch(int searchNum) {
		Connection conn = null;
		PreparedStatement pstmt = null; //statement �� ��Ӱ���
		ResultSet rs = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select \"NUM\",  \"ID\" , \"PS\", \"AR\", \"DT\", \"LV\"  from \"CAFE2\"");
			sql.append(" where \"NUM\"=?");//���ε� ����
			
			int search = searchNum; //ã�� �̸��� ������ ����
			
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setLong(1, search); //ù��° ?�� ���� ���� �Է��ϴ� ���� (indexNum, variable)
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getLong(1)); //index��ȣ�� �˻�
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getLong(6));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void dateSearch(String date) {
		Connection conn = null;
		PreparedStatement pstmt = null; //statement �� ��Ӱ���
		ResultSet rs = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select *  from \"CAFE2\"");
			sql.append("where to_char(\"DT\",\'YYYYMMDD\')=?");//���ε� ����
			
			String search = date; //ã�� �̸��� ������ ����
			
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, search); //ù��° ?�� ���� ���� �Է��ϴ� ���� (indexNum, variable)
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getLong(1)); //index��ȣ�� �˻�
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getLong(6));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void replace(String newId, String newPs, String newAr, int newLv, String replaceId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE \"CAFE2\" SET \"NUM\"=\"CAFE2_SEQ\".nextval, \"ID\"=?, \"PS\"= ?,\"AR\"= ?,\"DT\"=sysdate ,\"LV\"= ? WHERE \"ID\"=?");
		
			//method.replace(newId, newPs, newAr, newDt, newLv);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, newId);
			pstmt.setString(2, newPs);
			pstmt.setString(3, newAr);
			pstmt.setLong(4, newLv);
			pstmt.setString(5, replaceId);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"���� ���� ���ԵǾ����ϴ�!");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void dateList() {
		Connection conn = null;
		PreparedStatement pstmt = null; //statement �� ��Ӱ���
		ResultSet rs = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select \"DT\" from \"CAFE2\"");
			
			
			
//			String search = date; //ã�� �̸��� ������ ����
			
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			pstmt = conn.prepareStatement(sql.toString());
			
//			pstmt.setString(1, search); //ù��° ?�� ���� ���� �Է��ϴ� ���� (indexNum, variable)
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void idList() {
		Connection conn = null;
		PreparedStatement pstmt = null; //statement �� ��Ӱ���
		ResultSet rs = null;
		String user = "c##tester";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Ŭ���� �ε� ����!");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select \"ID\"  from \"CAFE2\"");
			
			
//			String search = date; //ã�� �̸��� ������ ����
			
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			pstmt = conn.prepareStatement(sql.toString());
			
//			pstmt.setString(1, search); //ù��° ?�� ���� ���� �Է��ϴ� ���� (indexNum, variable)
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
