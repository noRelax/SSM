
package com.norelax.www.listener;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.cyfonly.flogger.FLogger;

/**
 * @ClassName: WebContextListener
 * @Description: TODO(webContext监听器)
 * @author no_relax
 * @date 2017年2月24日 下午4:00:19
 * 
 */
public class WebContextListener extends ContextLoaderListener {
	private static final FLogger log = FLogger.getInstance();

	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		log.info("initing SSM webContext...");
		return super.initWebApplicationContext(servletContext);
	}

}
