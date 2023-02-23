package com.malixi.spring.myzuul.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 鉴权filter
 * @author yueyi2019
 */
@Component
public class AuthFilter extends ZuulFilter {



	/**
	 * 	该过滤器是否生效
	 */
	@Override
	public boolean shouldFilter() {
		//获取上下文
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		System.out.println("nihao");
//		String uri = request.getRequestURI();
//		System.out.println("来源uri："+uri);
//		//只有此接口/api-passenger/api-passenger-gateway-test/hello才被拦截
//		String checkUri = "/api-passenger/api-passenger-gateway-test/hello";
//		if(checkUri.equalsIgnoreCase(uri)) {
//			return true;
//		}
////		 测试路径
//		if(uri.contains("api-driver")) {
//			return true;
//		}
		
		return false;
	}
	
	/**
	 * 	拦截后的具体业务逻辑
	 */
	@Override
	public Object run() throws ZuulException {

		System.out.println("auth 拦截");
		//获取上下文（重要，贯穿 所有filter，包含所有参数）
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();


//        requestContext.set("ifContinue",false);

		return null;
	}
	/**
	 * 拦截类型，4中类型。
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.PRE_TYPE;
	}

	/**
	 * 	值越小，越在前
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 10;
	}


//	private void parseBody(HttpServletRequest request){
//        Map<String,Object> params = new HashMap<String, Object>();
//        BufferedReader br;
//        try {
//            br = request.getReader();
//            String str, wholeStr = "";
//            while((str = br.readLine()) != null){
//                wholeStr += str;
//            }
//            if(StringUtils.isNotEmpty(wholeStr)){
//                JSONObject jsonObject = JSONObject.fromObject(wholeStr);
//            }
//        } catch (IOException e1) {
//
//        }
//
//    }
}