package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.AtchFileVo;

public interface IAtchFileDao {
	/*
	 * 첨부파일 저장
	 * @param atchFileVo
	 * @return 
	 */
	public int insertAtchFile(AtchFileVo atchFileVo);
	
	/*
	 * 첨부파일 세부정보 저장
	 * @param atchFileVo
	 * @return  
	 */
	public int inserAtchFileDetail(AtchFileVo atchFileVo);
	
	/*
	 * 첨부파일 목록 조회하기
	 * @param atchFileVo
	 * @return 
	 */
	public List<AtchFileVo> getAtchFileList(AtchFileVo atchFileVo);
	
	/*
	 * 첨부파일 세부정보 조회하기*/
	public AtchFileVo getAtchFileDetail(AtchFileVo atchFileVo);
}
