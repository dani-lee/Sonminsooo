package kr.or.ddit.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import kr.or.ddit.dao.AtchFileDaoImpl;
import kr.or.ddit.dao.IAtchFileDao;
import kr.or.ddit.util.FileUploadRequestWrapper;
import kr.or.ddit.vo.AtchFileVo;

public class AtchFileServiceImpl implements IAtchFileService{

	private static Logger logger = Logger.getLogger(AtchFileServiceImpl.class);
	private static IAtchFileService fileService;
	private IAtchFileDao fileDao;
	
	
	private AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		if(fileService == null){
			fileService = new AtchFileServiceImpl();
		}
		return fileService;
	}
	
	@Override
	public AtchFileVo saveAtchFileList(Map<String, FileItem[]> fileItemMap) throws Exception {
		
		AtchFileVo atchFileVo = new AtchFileVo();
		fileDao.insertAtchFile(atchFileVo);
		
		for(FileItem[] itemArr : fileItemMap.values()) {
			
			for(FileItem item : itemArr) {
				File uploadDir = new File(FileUploadRequestWrapper.UPLOAD_DIRECTORY);
				if(!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				
				logger.info("item.getName(): " + item.getName());
				
				String orignFileName = item.getName(); //원본 파일명  -사용자가 저장한 파일명
				long fileSize = item.getSize();			//파일크기
				String saveFileName = "";				//저장파일명 -서버에 저장된 파일명
				File storeFile = null;					//저장파일객체
				String saveFilePath = ";";				//저장파일경로
				
				do{
					//저장명 생성
					saveFileName = UUID.randomUUID()  //중복되지 않는 아이디 생성 메소드 
							.toString().replace("-", "");
					
					saveFilePath = FileUploadRequestWrapper.UPLOAD_DIRECTORY
							+ File.separator + saveFileName;
					storeFile = new File(saveFilePath);
				}while(storeFile.exists());  //저장파일이 중복되지 않을 때까지
				
				//확장명 추출
				String fileExtension = orignFileName.lastIndexOf(".") < 0 ?
						"" : orignFileName.substring(orignFileName.lastIndexOf(".") +1);
				
				item.write(storeFile);  //업로드 파일 저장
				
				atchFileVo.setStreFileNm(saveFileName); //저장명 입력
				atchFileVo.setFileSize(fileSize);
				atchFileVo.setOrignlFileNm(orignFileName);
				atchFileVo.setFileExtsn(fileExtension);
				atchFileVo.setFileStreCours(saveFilePath);
				
				fileDao.inserAtchFileDetail(atchFileVo);
				
				item.delete();  //임시 업로드 지우기
			}
		}
		return atchFileVo;
	}

	@Override
	public List<AtchFileVo> getatchFileList(AtchFileVo fileVo) {
		return fileDao.getAtchFileList(fileVo);
	}

	@Override
	public AtchFileVo getAtchFileDetail(AtchFileVo fileVo) {
		return fileDao.getAtchFileDetail(fileVo);
	}

}
