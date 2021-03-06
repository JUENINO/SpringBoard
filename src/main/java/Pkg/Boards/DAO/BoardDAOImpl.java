package Pkg.Boards.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Pkg.Boards.Commons.DB.DBCon;
import Pkg.Boards.VO.BoardVO;
import Pkg.Boards.VO.MemberVO;
import oracle.jdbc.OracleTypes;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Override
	public ArrayList<BoardVO> getBoardsList(String idx){
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		Connection dbCon = DBCon.getConnection();
		
		String strSql = "{call PKG_BOARDS.PROC_SEL_BOARD(?,?)}";
		
		ArrayList<String> params = new ArrayList<>();
		params.add(idx);		
		CallableStatement csmt = DBCon.getCallableStatement(dbCon, strSql, params);
		try {
			csmt.registerOutParameter(2, OracleTypes.CURSOR);
			csmt.executeQuery();
			
			ResultSet rs = (ResultSet)csmt.getObject(2);
			
			while(rs.next()) {			
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getNString("IDX"));
				vo.setTitle(rs.getNString("TITLE"));
				vo.setUserID(rs.getNString("USERID"));
				boardList.add(vo);
			}
			rs.close();
			rs = null;
			csmt.close();
			csmt = null;
			dbCon.close();
			dbCon = null;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return boardList;
		
	}
	
	@Override
	public ArrayList<MemberVO> getMembersList(String userID){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		Connection dbCon = DBCon.getConnection();
		
		String strSql = "{call PKG_BOARDS.PROC_SEL_MEMBER(?,?)}";
		
		ArrayList<String> params = new ArrayList<>();
		params.add(userID);		
		CallableStatement csmt = DBCon.getCallableStatement(dbCon, strSql, params);
		try {
			csmt.registerOutParameter(2, OracleTypes.CURSOR);
			csmt.executeQuery();
			
			ResultSet rs = (ResultSet)csmt.getObject(2);
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setUserID(rs.getNString("USERID"));
				vo.setUserName(rs.getNString("USERNAME"));
				memberList.add(vo);
			}
			rs.close();
			rs = null;
			csmt.close();
			csmt = null;
			dbCon.close();
			dbCon = null;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	
	@Override
	public void saveBoard(String[] idx, String[] title, String[] userID, String[] status) {
		Connection dbCon = DBCon.getConnection();
		String strSql = "{call PKG_BOARDS.PROC_SAVE_BOARD(?,?,?)}";
		CallableStatement csmt = null;
		try {
		dbCon.setAutoCommit(false);
		int dbCnt = 0;
		
		//idx, title, userid??? ???????????? for??? ???????????? ?????????.
		// ???????????? ?????? idx, title, userid??? ??????????????? ???????????????, idx??? ????????? update, idx??? ????????? ????????? insert??? ??????.
		for(int i = 0 ;i<title.length;i++) {
			ArrayList<String> params = new ArrayList<>();
			params.add(idx[i]);		
			params.add(title[i]);	
			params.add(userID[i]);	
		    csmt = DBCon.getCallableStatement(dbCon, strSql, params);
		    
		    //????????? status??? ???????????? ??????X
		    if(status[i] != null) {
		    dbCnt += csmt.executeUpdate();
		    }
		}
		System.out.println(dbCnt +"?????? ?????? ?????????????????????.");
			dbCon.commit();
		
		}
		catch(Exception e) {
			try {
			dbCon.rollback();
			} catch(Exception ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
			csmt.close();
			csmt = null;
			dbCon.close();
			dbCon = null;
			} catch(Exception eee) {
				eee.printStackTrace();
			}
		}
		
		
	}
	
	
	
	 public void deleteBoard(String[] idx) {
		 Connection dbCon = DBCon.getConnection();
			String strSql = "{call PKG_BOARDS.PROC_DEL_BOARD(?)}";
			CallableStatement csmt = null;
			try {
			dbCon.setAutoCommit(false);
			int dbCnt = 0;
			
			
			for(int i = 0 ;i<idx.length;i++) {
			
				
				//????????? idx??? DB??? ?????????, ??????????????? ???????????? ???????????? ???????????? for???.
				ArrayList<String> params = new ArrayList<>();
				params.add(idx[i]);
			    csmt = DBCon.getCallableStatement(dbCon, strSql, params);
			    
			    dbCnt += csmt.executeUpdate();    
			}
			
			System.out.println(dbCnt +"?????? ?????? ?????????????????????.");
				dbCon.commit();
			
			}
			catch(Exception e) {
				try {
				dbCon.rollback();
				} catch(Exception ee) {
					ee.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
				csmt.close();
				csmt = null;
				dbCon.close();
				dbCon = null;
				} catch(Exception eee) {
					eee.printStackTrace();
				}
			}		
	 }
}
