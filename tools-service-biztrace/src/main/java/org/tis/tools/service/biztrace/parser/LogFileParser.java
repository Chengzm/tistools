package org.tis.tools.service.biztrace.parser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tis.tools.service.biztrace.TISLogFile;
import org.tis.tools.service.biztrace.helper.RunConfig;
import org.tis.tools.service.biztrace.redis.AbstractRedisHandler;

/**
 * 解析日志文件
 * @author megapro
 * 
 */
public class LogFileParser extends AbstractRedisHandler implements Runnable {
	
	public static int fileParsedNum = 0; //本次解析的文件数
	public static int fileReadNum = 0;  //本次读取到文件数
	public static Map<String,String> fileParseRecord = new HashMap<String, String>(); //存放文件解析的状态
	//private Jedis jedis = null ; 
	private List<TISLogFile> logFiles = null ; 
	private final static Logger logger = LoggerFactory.getLogger(LogFileParser.class);
	//public static List<String> unparseredLogFiles = new ArrayList<String>(); 
	@Override
	public void run() {
		
		//jedis = jedisPool.getResource() ;
		
		for( TISLogFile logFile : logFiles ){
			try {
				doParse(logFile) ;
			} catch (IOException e) {
				System.err.println("解析文件失败："+logFile);
				e.printStackTrace();
			}finally{
			}
		}

		//jedis.close();
	}

	/**
	 * 解析biztrace并存入redis
	 * @param fileName
	 * @throws IOException 
	 */
	private void doParse(TISLogFile logFile) throws IOException {
		
		if( !isResolvedLogFile(logFile) )
		{
			fileParseRecord.put(logFile.logFile.getAbsolutePath(), "开始解析...");
			
			long start = System.currentTimeMillis() ;
			
			//result.put(logFile.logFile.getAbsolutePath(), "");
			//AjaxUtils.ajaxJson(response, JSONObject.fromObject("{}", jsonConfig).toString());
			
			logFile.logTypeEnum.resolver.resolve(logFile); //FIXME 重构不在传入jedis对象
			
			logger.info(
					new StringBuffer()
					.append(Thread.currentThread().getName() )
					.append(" 耗时 ").append( (System.currentTimeMillis() - start) ).append(" ")
					.append( logFile.logFile.getAbsolutePath() ).toString() )  ;
			
			saveResolvedLogFile(logFile) ;
			
			fileParsedNum++;
			fileParseRecord.put(logFile.logFile.getAbsolutePath(), "解析完成");
		}else{			
			fileParseRecord.put(logFile.logFile.getAbsolutePath(), "文件已经解析过");
			logger.warn("文件已经解析过！ "+logFile.toString());	
		}
		
		fileReadNum++;
	}


	public void setFiles(List<TISLogFile> files) {
		this.logFiles = files ;
	}
	
	public List<TISLogFile> getFiles() {
		return this.logFiles ;
	}
	
	/**
	 * 判断某个文件是否已经被拆分解析过
	 * @param logFile
	 * @return true 解析过 false 还未解析过
	 */
	private boolean isResolvedLogFile(TISLogFile logFile) {
		
		// 通过查询Redis确定，是否已经解析过
//		if( jedis.sismember(
//				String.format(RunConfig.KP_SET_RESOLVED_LOG_FILE, logFile.dateStr), 
//				logFile.logFile.getAbsolutePath() ) ){
//			return true ; //已解析
//		}
		if( this.redisClientTemplate.sismember(
				String.format(RunConfig.KP_SET_RESOLVED_LOG_FILE, logFile.dateStr), 
				logFile.logFile.getAbsolutePath() ) ){
			return true ; //已解析
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = sdf.parse(logFile.dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		redisClientTemplate.sadd(RunConfig.KP_SET_RESOLVED_DATE, sdf.format(date));
		redisClientTemplate.sadd(RunConfig.KP_UNANALYZED_DATE, sdf.format(date));
		return false;//未解析
	}

	/**
	 * 记录解析过的日志文件
	 * @param logFile 已经解析的文件
	 */
	private void saveResolvedLogFile(TISLogFile logFile) {
		redisClientTemplate.sadd(
				String.format(RunConfig.KP_SET_RESOLVED_LOG_FILE, logFile.dateStr), 
				logFile.logFile.getAbsolutePath()) ;
	}
}
