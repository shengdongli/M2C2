package com.zh.test;

import com.zh.utils.DownImageUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

public class ImgTest implements PageProcessor {
	
	// 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		String url = page.getUrl().toString();
		
		List<String> picturerAll = page.getHtml()
				.xpath("//*[@id=\"article-content\"]/center/img/@src").all();

		List<String> pictureUrl = new ArrayList<String>();
		for (String s : picturerAll) {
			if (StringUtils.isBlank(s) || s.equals("#") || s.startsWith("javascript:")) {
				continue;
			}
			s = UrlUtils.canonicalizeUrl(s, url.toString());
			new DownImageUtil().downloadImg(url,s, "F:\\img\\");
			pictureUrl.add(s);
		}
		
		page.putField("图片", pictureUrl);

	}

	public static void main(String[] args) {
		// 运行爬虫
		long startTime, endTime;
		System.out.println("开始爬取...");
		startTime = System.currentTimeMillis();
		Spider.create(new ImgTest()).addUrl("http://www.81.cn/jwzb/2019-04/11/content_9487793.htm").thread(50).run();
		endTime = System.currentTimeMillis();
		System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒");
	}

}
