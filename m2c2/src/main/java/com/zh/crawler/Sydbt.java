package com.zh.crawler;

import com.zh.utils.FourAllArticle;
import com.zh.utils.TwoThree;
import com.zh.webmagic.FilePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Sydbt implements PageProcessor {
    static int cont = 0;
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setTimeOut(3000);

    private static String path = "E:\\81www\\";
    public Site getSite() {
        return site;
    }

    public void process(Page page) {

        //爬取页面的url
        String url = page.getUrl().toString();


        //网页主题
        String title = page.getHtml().xpath("/html/head/title/text()").get();

        //首页爬虫


       if (page.getUrl().regex("http://www\\.81\\.cn/sydbt/\\w+\\.htm").match() ) {

           page.addTargetRequests(page.getHtml().xpath("//*[@id=\"main-news-list\"]/li/a/@href").all());
           page.addTargetRequests(page.getHtml().xpath("//*[@id=\"displaypagenum\"]/center/a/@href").all());
        }
        //三级分页===具体文章
        else if (page.getUrl().regex("http://www\\.81\\.cn/sydbt/\\d{4}-\\d{2}/\\d{2}/*").match()){
            cont++;
            new FourAllArticle().getArt(page, title, url,path);

        }

    }

    public static void main(String[] args) {

        //运行爬虫
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(new Sydbt()).addUrl("http://www.81.cn/sydbt/tt.htm").thread(50).addPipeline(new FilePipeline(path)).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000)/60 + "分钟,有");
        System.out.println(cont);
    }


}
