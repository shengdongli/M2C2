package com.zh.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//图片下载
public class DownImageUtil {
	public static void downloadImg(String url,String picUrl,String imgPath){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String name = FilenameUtils.getName(picUrl);
		
		String path = imgPath + getDomain1(url) +getDomain2(url);
		try {
			HttpGet get = new HttpGet(picUrl);
			CloseableHttpResponse response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			InputStream in = entity.getContent();
			
			String dir = imgPath;
			
			File url81 = new File(path);
			if (!url81.exists()) {
				url81.mkdirs();
			}
			
			File file = new File(path, name);
			
			try {
				FileOutputStream fout = new FileOutputStream(file);
				int l = -1;
				byte[] tmp = new byte[1024];
				while ((l = in.read(tmp)) != -1) {
					fout.write(tmp, 0, l);
				}
				fout.flush();
				fout.close();
			} finally {
				in.close();
			}
			
			
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private static String getDomain1(String url){
        String regex = "http://(tv|www)\\.81\\.cn/(?<domain>\\w+)/*";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group("domain");
        }
        return result + "\\";
    }
    private static String getDomain2(String url){
        String regex = "http://(tv|www)\\.81\\.cn/\\w+/\\d{4}-\\d{2}/\\d{2}/(?<domain>content_\\d+)\\w*\\.htm";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group("domain");
        }
        return result + "\\";
    }
}
