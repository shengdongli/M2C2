package com.zh.webmagic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store results in files.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
public class FilePipeline extends FilePersistentBase implements Pipeline {
	
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * create a FilePipeline with default path"/data/webmagic/"
     */
    public FilePipeline() {
        setPath("/data/webmagic/");
    }

    public FilePipeline(String path) {
        setPath(path);
    }


	public void process(ResultItems resultItems, Task task) {
    	
        
        String url = resultItems.getRequest().getUrl();
        String temp1=getDomain1(url);
        String temp2=getDomain2(url);
        String temp3=getDomain3(url);
        String path=this.path + PATH_SEPERATOR + temp1 + PATH_SEPERATOR +  temp2 + PATH_SEPERATOR;
        	
    	Pattern pattern = Pattern.compile("http://(tv|www|vr)\\.81\\.cn/\\w+/\\d{4}-\\d{2}/\\d{2}/*");
    	Matcher matcher = pattern.matcher(url);
    	if (matcher.find()) {
        try {
        	
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(getFile(path + temp3 + ".txt")),"UTF-8"));
            printWriter.println("URL:\t" + resultItems.getRequest().getUrl());
            for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
                if (entry.getValue() instanceof Iterable) {
                    Iterable value = (Iterable) entry.getValue();
                    printWriter.println(entry.getKey()+":");
                    for (Object o : value) {
                        printWriter.println(o);
                    }
                } else {
                    printWriter.println(entry.getKey() + ":\t" + entry.getValue());
                }
            }
            printWriter.close();
        	
        } catch (IOException e) {
            logger.warn("write file error", e);
        }}
    	
    
    }
    
    
    private static String getDomain1(String url){
        String regex = "http://(tv|www|vr)\\.81\\.cn/(?<domain>\\w+)/*";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group("domain");
        }
        return result;
    }
    private static String getDomain2(String url){
        String regex = "http://(tv|www|vr)\\.81\\.cn/\\w+/\\d{4}-\\d{2}/\\d{2}/(?<domain>\\w+)\\w*\\.htm";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group("domain");
        }
        return result;
    }
    private static String getDomain3(String url){
        String regex = "http://(tv|www|vr)\\.81\\.cn/\\w+/\\d{4}-\\d{2}/\\d{2}/(?<domain>\\w+)\\.htm";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String result = null;
        if(matcher.find()){
            result = matcher.group("domain");
        }
        return result;
    }







    


}
