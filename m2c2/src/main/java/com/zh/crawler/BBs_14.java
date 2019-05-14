package com.zh.crawler;

import com.zh.utils.AddUrlUtil;
import com.zh.utils.FirstIndex;
import com.zh.utils.UrlUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BBs_14 implements PageProcessor {
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(5).setSleepTime(100);
    static int count = 0;
    public Site getSite() {
        return site;
    }

	public void process(Page page) {
		//爬取页面的url
    	String url = page.getUrl().toString();
    	//网页title
    	String title = page.getHtml().xpath("/html/head/title/text()").get();
    	
    	//判断url
    	UrlUtil urlUtil = new UrlUtil();
    	//添加爬虫
    	AddUrlUtil addUrlUtil = new AddUrlUtil();
    	//										
    	boolean twoThreeUrl = urlUtil.getUrl(page, "http://bbs\\.81\\.cn") || urlUtil.getUrl(page, "http://forum\\.81\\.cn/biggroup(-\\d+)(-\\d+)(-\\d+)\\.htm");
    	
    	//首页  	
    	if (url.equals("http://www.81.cn/")) {
    		System.out.println("首页");
    		new FirstIndex().indexReptile(page);
		}

    	//二三级分页			
    	else if (twoThreeUrl) {
    		//			
    		addUrlUtil.addUrl(page, "//*[@id='header']/div/ul/li/a/@href");
    		addUrlUtil.addUrl(page, "//*[@id='forumleftside']/dl/dd/a/@href");
    		addUrlUtil.addUrl(page, "//*[@id='moderate']/table/tbody/tr/th/a/@href");
    		addUrlUtil.addUrl(page, "//*[@id='fd_page_bottom']/div/a/@href");
		}
    	
		//四级文章		  				  
    	else if (page.getUrl().regex("http://forum\\.81\\.cn/biggroup(-\\d+)(-\\d+)(-\\d+)\\.html").match()) {
    		count++;
			//new FourAllArticle().getArt(page, title, url);
		}
    	
	}
	public static void main(String[] args) {
		//运行爬虫	
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(new BBs_14()).addUrl("http://www.81.cn/").thread(10).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒,爬取数据："+count);
	}
	
}


