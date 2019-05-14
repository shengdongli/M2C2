package com.zh.utils;

import us.codecraft.webmagic.Page;

public class UrlUtil {
	
	public boolean getUrl(Page page, String url){
		boolean ifurl = page.getUrl().regex(url).match();
		return ifurl;
	}
}
