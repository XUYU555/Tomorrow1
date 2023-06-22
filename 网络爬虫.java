package 网络爬虫制造假数据;

import javax.lang.model.type.ArrayType;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String fristnameurl="https://hanyu.baidu.com/s?wd=%E7%99%BE%E5%AE%B6%E5%A7%93&from=poem";
        String boylastnameurl="http://www.haoming8.cn/baobao/10881.html";
        String girlnameurl="http://www.haoming8.cn/baobao/7641.html";

        //爬取网站中的数据
        String FristURL=Webcrawler(fristnameurl);
        String BoyURL=Webcrawler(boylastnameurl);
        String GrilURL=Webcrawler(girlnameurl);

        //在爬取的数据中找到想要的
        ArrayList<String> fristnameTemplist=getDate(FristURL,"(.{4})(，|。)",1);
        ArrayList<String> boynameTemplist=getDate(BoyURL,"([\\u4E00-\\u9FA5]{2})(、)",1);   //保证是中文字符
        ArrayList<String> grilnameTemplist=getDate(GrilURL,"(.. ){4}..",0);

        //姓氏处理
        ArrayList<String> fristnamelist=new ArrayList<>();
        for (String str : fristnameTemplist) {
            for (int i = 0; i < str.length(); i++) {
                fristnamelist.add(str.charAt(i)+"");
            }
        }

        //姓名处理男  去重
        ArrayList<String> boynamelist=new ArrayList<>();
        for (String str : boynameTemplist) {
            if(!boynamelist.contains(str))
            {
                boynamelist.add(str);
            }
        }

        //姓名处理女
        ArrayList<String> grilnamelist=new ArrayList<>();
        for (String str : grilnameTemplist) {
            String[] strs=str.split(" ");
            for (String s : strs) {
                grilnamelist.add(s);
            }
        }

        //生成假数据
        ArrayList<String> namedate=getinfor(fristnamelist,boynamelist,grilnamelist,100,100);
        Collections.shuffle(namedate);  //打乱数据

        //写入文件中
        BufferedWriter br=new BufferedWriter(new FileWriter("C:\\Users\\xy\\IdeaProjects\\XUYU555\\src\\假名字.txt"));
        for (String name : namedate) {
            br.write(name);
            br.newLine();
        }
        br.close();
    }

    //爬取网站数据
    public static String Webcrawler(String net) throws IOException {
        URL url=new URL(net);
        StringBuilder sb=new StringBuilder();
        URLConnection conn=url.openConnection();
        InputStreamReader isr=new InputStreamReader(conn.getInputStream());   //网站中有中文需要字符流
        int ch;
        while((ch= isr.read())!=-1)
        {
            sb.append((char)ch);
        }
        isr.close();
        return sb.toString();
    }

    //获取正确数据                            //数据源        正则表达式      选取
    public static ArrayList<String> getDate(String str,String regex,int index)
    {
        ArrayList<String> list=new ArrayList<>();
        //创建正则表达式
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        //根据表达式寻找数据
        while(matcher.find())
        {
            list.add(matcher.group(index));
        }
        return list;
    }

    //生成假数据（姓名-性别-年龄）
    public static ArrayList<String> getinfor(ArrayList<String> fristnamelist,ArrayList<String> boynamelist,ArrayList<String> grilnamelist,int boycount,int grilcount)
    {
        //男生姓名集合   年龄18~27
        HashSet<String> boylist=new HashSet<>();
        while(true)
        {
            Random random=new Random();
            if(boylist.size()!=boycount)
            {
                int age=random.nextInt(10)+18;
                Collections.shuffle(fristnamelist);     //打乱集合
                Collections.shuffle(boynamelist);       //打乱集合
                boylist.add(fristnamelist.get(0)+boynamelist.get(0)+"-男-"+age);
            }else{
                break;
            }
        }

        //女生姓名集合    年龄18~25
        HashSet<String> grillist=new HashSet<>();
        while(true)
        {
            Random random=new Random();
            if(grillist.size()!=grilcount)
            {
                int age=random.nextInt(8)+18;
                Collections.shuffle(fristnamelist);  //打乱集合
                Collections.shuffle(grilnamelist);      //打乱集合
                grillist.add(fristnamelist.get(0)+grilnamelist.get(0)+"-女-"+age);
            }else{
                break;
            }
        }

        ArrayList<String> list=new ArrayList<>();
        for (String s : boylist) {
            list.add(s);
        }
        for (String s : grillist) {
            list.add(s);
        }
        return list;

    }
}
