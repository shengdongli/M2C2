package com.zh.utils;

import us.codecraft.webmagic.Page;

public class AddUrlUtil {
	
	//Jwzl_40 军网资料
	public void addUrl(Page page, String url){
			
		page.addTargetRequests(page.getHtml().xpath(url).all());
	}
}
