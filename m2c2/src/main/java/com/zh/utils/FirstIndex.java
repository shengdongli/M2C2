package com.zh.utils;

import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.List;

//首页爬虫
public class FirstIndex {
	// 首页索引
	private List<String> indexAll = new ArrayList<String>();
	
	//page.getHtml().xpath("//*[@id='main_nav']/div/ul/li/a/@href").all()
	public void indexReptile(Page page) {
		// 首页索引
		indexAll.addAll(page.getHtml().xpath("//*[@id='main_nav']/div/ul/li/a/tidyText()").all());
		page.putField("81军网",indexAll);
		
		// 从页面发现后续url地址抓取
		page.addTargetRequests(page.getHtml().xpath("//*[@id='main_nav']/div/ul/li/a/@href").all());

	}
	
}
