import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Article {
    private String paperid;
    private String name;
    private String publishername;
    private String publishYear;

    public Article() {     /* CONSTRUCTOR */
        this.paperid = "null";
        this.name = "null";
        this.publishername = "null";
        this.publishYear = "null";
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String toString(){
        return (this.paperid+"\t"+this.name+" "+this.publishername+" "+this.publishYear);

    }

    public static ArrayList<Article> articleList(String articleFile) throws IOException {   /* Method for reading article.txt
                                                                                          and adding to list named articleFile */
        File file = new File(articleFile);
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
        ArrayList<String> lineList = new ArrayList<String>();       /* list for Adding every lines */
        while ((line = bReader.readLine()) != null) {
            lineList.add(line);
        }
        bReader.close();

        ArrayList<Article> articleList = new ArrayList<Article>();
        for (String line2 : lineList) {
            Article article = new Article();
            String[] splitList = line2.split(" ");

            article.setPaperid(splitList[1]);
            article.setName(splitList[2]);
            article.setPublishername(splitList[3]);
            article.setPublishYear(splitList[4]);
            articleList.add(article);
        }
        return articleList;
    }

}