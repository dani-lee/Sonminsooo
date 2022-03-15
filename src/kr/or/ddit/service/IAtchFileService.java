package kr.or.ddit.service;



import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.AtchFileVo;

public interface IAtchFileService {
	
	public AtchFileVo saveAtchFileList(Map<String, FileItem[]> fileItemMap)throws Exception;
	
	public List<AtchFileVo> getatchFileList(AtchFileVo fileVo);
	
	public AtchFileVo getAtchFileDetail(AtchFileVo fileVo);
}
