package org.example.until;

import java.io.*;
import java.util.logging.Logger;

public class HtmlUtils {

    private HtmlUtils(){}

    /**
     * @return 解析html
     */
    public static String resolveHtml(File htmlFile){
        Logger logger = Logger.getLogger(HtmlUtils.class.getName());
        try {
            StringBuilder html=new StringBuilder();
            String htmlLine="";
            BufferedReader bufferedReader =new BufferedReader(new FileReader(htmlFile));
            while ((htmlLine = bufferedReader.readLine())!=null) {
                html.append(htmlLine);
            }
            String htmlString = html.toString();
            System.out.println(htmlString);
            return htmlString;
        } catch (FileNotFoundException e) {
            logger.warning("文件未找到");
        } catch (IOException e) {
            logger.warning("IO异常");
        }
        return null;
    }


}
