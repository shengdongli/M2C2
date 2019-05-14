package com.zh.utils;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.utils.UrlUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//正文爬虫
public class FourAllArticle {

	// 分类
	private List<String> categoryAll = new ArrayList<String>();
	// 文章名
	private List<String> articleTitleAll = new ArrayList<String>();
	// 描述
	private List<String> fromAll = new ArrayList<String>();
	// 日期
	private List<String> body = new ArrayList<String>();
	// 正文
	private List<String> textAll = new ArrayList<String>();
	// 图片
	private List<String> picturerAll = new ArrayList<String>();

	public void getArt(Page page, String title, String url, String path) {

		System.out.println("============" + title + "==============");
		// 分类
		categoryAll.addAll(page.getHtml().xpath("/html/body/div[2]/p/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("/html/body/div/div/div/ol/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("/html/body/div[2]/ol/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("/html/body/div[4]/div/div/div/h3/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("//*[@id='box-title']/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("//*[@id='pt']/div/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("/html/body/div[2]/span/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("/html/body/div[1]/div/div/div/ul/li/a/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("//*[@id='pt']/div[1]/a/allText()").all());
		categoryAll.addAll(page.getHtml().xpath("/html/head/title/allText()").all());
		page.putField("分类", listUniq(categoryAll));

		// 文章名
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div/div/div[2]/div[1]/h1/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[2]/h2/allText()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[3]/div/div/h2/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("//*[@id='box-title']/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[3]/div[1]/div/div[1]/div[1]/h1/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("//*[@id='thread_subject']/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/h1/text()").all());
		articleTitleAll.addAll(page.getHtml()
				.xpath("//*[@id='content']/table/tbody/tr[1]/td/div/table/tbody/tr/td/font[1]/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[2]/div/div/div[1]/div/h1/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("//*[@id='pt']/div[1]/a[5]/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[2]/div/div/div[1]/div[1]/h1/span/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/body/div[3]/div[1]/div[2]/div/div/div/h1/text()").all());
		articleTitleAll.addAll(page.getHtml().xpath("/html/head/title/text()").all());
		page.putField("文章名", listUniq(articleTitleAll));

		// 描述：来源，作者，编辑
		fromAll.addAll(page.getHtml().xpath("/html/body/div[2]/p/allText()").all());
		fromAll.addAll(htmlXpathAll(page, "/html/body/div/div/div[2]/div[1]/div[2]/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[4]/div[1]/div/div[3]/p/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/head/meta[12]/@content/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/head/meta[11]/@content/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[2]/div/div/div[1]/div/div/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[3]/div[1]/div/div[1]/div[2]/span/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div[1]/allText()"));
		fromAll.addAll(
				htmlXpathAll(page, "//*[@id='content']/table/tbody/tr[1]/td/div/table/tbody/tr/td/font[2]/allText()"));
		fromAll.addAll(htmlXpathAll(page, "//div[@class='authi']/a/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[2]/div/div/div[1]/div[2]/div/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[3]/div[1]/div[2]/div/div/div/ul/allText()"));
		fromAll.addAll(htmlXpathAll(page, "/html/body/div[1]/dl[1]/allText()"));
		page.putField("描述", listUniq(fromAll));

		// 日期
		body.addAll(page.getHtml().xpath("/html/body/div/div/div[2]/div[1]/div[2]/div/small/i[1]/text()").all());
		body.addAll(page.getHtml().xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/small").all());
		body.addAll(page.getHtml().xpath("/html/body/div[2]/p/span[3]/text()").all());
		body.addAll(page.getHtml().xpath("/html/body/div[4]/div[1]/div/div[3]/p[5]/small/text()").all());
		body.addAll(page.getHtml().xpath("/html/head/meta[14]/@content").all());
		body.addAll(page.getHtml().xpath("//*[@id='pid8723451']/tbody/tr[1]/td[1]/div[1]/div/a/text()").all());
		body.addAll(page.getHtml().xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/span[4]/text()").all());
		body.addAll(
				page.getHtml().xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/small/i[1]/text()").all());
		body.addAll(page.getHtml()
				.xpath("//*[@id='content']/table/tbody/tr[1]/td/div/table/tbody/tr/td/font[2]/text()[2]").all());
		body.addAll(page.getHtml().xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/span[3]/text()").all());
		body.addAll(page.getHtml().xpath("//div[@class='authi']/em/text()").all());
		body.addAll(page.getHtml().xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/span[3]/text()").all());
		body.addAll(page.getHtml().xpath("/html/body/div[4]/div[1]/div/div[3]/p[4]/small/text()").all());
		body.addAll(page.getHtml().xpath("/html/body/div[3]/div[1]/div[2]/div/div[3]/div/ul/li[4]/span/text()").all());
		body.addAll(page.getHtml().xpath("/html/head/meta[17]/text()").all());
		page.putField("日期", listUniq(body));

		// 正文
		textAll.addAll(page.getHtml().xpath("//*[@id='article-content']/p/allText()").all());
		textAll.addAll(page.getHtml().xpath("//*[@id='article-content']/span/p/font/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div[5]/p/text()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div/div/div/div/p/text()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div[3]/div[2]/div[2]/div/p/span/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/p[2]/span/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div/div/p/allText()").all());
		textAll.addAll(page.getHtml().xpath("//*[@id='article-conten']/div[2]/span/p/allText()").all());
		textAll.addAll(page.getHtml().xpath("//*[@id='ct']/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/p/allText()").all());
		textAll.addAll(page.getHtml().xpath("//*[@id='article-content']/span/allText()").all());
		textAll.addAll(page.getHtml()
				.xpath("//*[@id='content']/table/tbody/tr[2]/td/table/tbody/tr/td/center[2]/span/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div[2]/div/div/div[3]/div/p/allText()").all());
		textAll.addAll(page.getHtml().xpath("//td[@class='t_f]/font/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div[2]/div/div/div[3]/div/span/allText()").all());
		textAll.addAll(page.getHtml().xpath("/html/body/div[3]/div[1]/div[2]/div/div[3]/div/p/allText()").all());
		textAll.addAll(page.getHtml().xpath("//*[@id='content']/p/allText()").all());
		page.putField("正文", listUniq(textAll));

		// url地址
		page.putField("url", page.getUrl().toString());

		// 图片
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/span/center/img/@src").all());	    		
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/center/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/font/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/center/font/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/center/font/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/center/font/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/center/font/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/strong/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/div[2]/span/font/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='article-content']/p/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='content']/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='content']/font/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("/html/body/p/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='content']/table/tbody/tr/td/table/tbody/tr/td/p/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='content']/table/tbody/tr/td/table/tbody/tr/td/center/img/@src").all());
		picturerAll.addAll(page.getHtml().xpath("//*[@id='content']/table/tbody/tr/td/table/tbody/tr/td/p/a/img/@src").all());

		List<String> pictureUrl = new ArrayList<String>();
		
		for (String s : picturerAll) {
			
			if (StringUtils.isBlank(s) || s.equals("#") || s.startsWith("javascript:")) {
				continue;
			}
			s = UrlUtils.canonicalizeUrl(s, url.toString());
			pictureUrl.add(s);

		}
		List<String> listUniq = listUniq(pictureUrl);
		
		
		page.putField("图片", listUniq);
		
		//下载图片
		/*for (String string : listUniq) {
			new DownImageUtil().downloadImg(url, string, path);
		}*/
		page.addTargetRequests(page.getHtml().xpath("//*[@id='displaypagenum']/center/a/@href").all());
	}

	public static List<String> htmlXpathAll(Page page, String xpath) {
		return page.getHtml().xpath(xpath).all();
	}

	// 列表去重
	public static List<String> listUniq(List<String> list) {
		List<String> listNew = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for (String str : list) {
			if (set.add(str)) {
				listNew.add(str);
			}
		}

		return listNew;
	}
}
