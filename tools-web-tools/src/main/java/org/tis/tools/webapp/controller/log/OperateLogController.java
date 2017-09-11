package org.tis.tools.webapp.controller.log;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tis.tools.rservice.log.capable.IOperateLogRService;
import org.tis.tools.webapp.controller.BaseController;

import java.util.HashMap;
import java.util.Map;




/**
 * 操作日志管理
 * @author zhaoch
 */
@Controller
@RequestMapping("OperateLogController")
public class OperateLogController extends BaseController {

	
	@Autowired
	IOperateLogRService operateLogRService;
	private Map<String, Object> responseMsg = getResponseMessage();



    /**
     * 查询操作日志列表
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryOperateLogList",produces ="application/json;charset=UTF-8", method= RequestMethod.POST)
    public Map<String, Object>  queryOperateLogList(@RequestBody String content) {
        return getReturnMap(operateLogRService.queryOperateLogList());
    }

    /**
     * 查询操作日志详情
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryOperateDetail",produces ="application/json;charset=UTF-8", method= RequestMethod.POST)
    public Map<String, Object>  queryOperateDetail(@RequestBody String content) {
        return getReturnMap(operateLogRService.queryOperateDetail(JSONObject.parseObject(content).getString("logGuid")));
    }

    /**
     * 查询操作对象历史日志
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/queryOperateHistoryList",produces ="application/json;charset=UTF-8", method= RequestMethod.POST)
    public Map<String, Object>  queryOperateHistoryList(@RequestBody String content) {
        return getReturnMap(operateLogRService.queryOperateDetail(JSONObject.parseObject(content).getString("objGuid")));
    }




    /**
     * 要求子类构造自己的响应数据
     *
     * @return
     */
    @Override
    public Map<String, Object> getResponseMessage() {
        if( null == responseMsg ){
            responseMsg = new HashMap<String, Object>() ;
        }
        return responseMsg;
    }
}
