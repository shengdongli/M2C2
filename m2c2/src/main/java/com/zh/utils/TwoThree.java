package com.zh.utils;

import us.codecraft.webmagic.Page;

public class TwoThree {

	public void getTT81(Page page){
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/div/h3/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@id='main-news-list']/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@id='displaypagenum']/center/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@class='main_nav']/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@class='nav list-unstyled']/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@class='content']/h3/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@class='one-list']/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@class='main_nav_row2']/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@class='Heroes_list fl']/ul/li/a/@href").all());
		
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/ul/li/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/h4/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/h2/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/div/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/h3/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/ul/li/span/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/div/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/div/div/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/divdiv/ul/li/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@id='sync2']/div/div/div/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/div/div/div/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@id='binggong']/div/div/div/div/ul/li/h4/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/div/div/h2/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("/html/body/div/h1/a/@href").all());
		page.addTargetRequests(page.getHtml().xpath("//*[@id='main-news-list']/div/li/a/@href").all());
	}
}
