import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;


public class Main {
    public static String authorFile;
    public static String commandFile;
    public static ArrayList<ArrayList<Article>> articles= new ArrayList<ArrayList<Article>>();

    public static void main(String[] args) throws IOException {

        authorFile=args[0];
        commandFile=args[1];
        articles=Operations.articleArrays(authorFile);
        command(commandFile);

    }

    public static void command(String commandFile) throws IOException{
        File file = new File(commandFile);
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
        ArrayList<String> lineList = new ArrayList<String>();       /* list for Adding every lines */
        while ((line = bReader.readLine()) != null) {
            lineList.add(line);
        }
        bReader.close();

        File outputFile=new  File("output.txt");

        FileWriter fWriter= new FileWriter(outputFile,false);
        BufferedWriter bWriter = new BufferedWriter(fWriter);

        ArrayList<Author> authorList = new ArrayList<Author>();
        ArrayList<Article> articleList = new ArrayList<Article>();

        authorList=Author.authorList(authorFile);


        for(String command: lineList){

            if(command.startsWith("read")){
                String articleFile=command.split(" ")[1];
                articleList=Article.articleList(articleFile);
                int flag=0;
                for(Author author: authorList){
                    for(Article article: articleList){
                        if(author.getArticle1().equals(article.getPaperid()))
                            (articles.get(flag)).add(article);}

                    for(Article article: articleList){
                        if(author.getArticle2().equals(article.getPaperid()))
                            (articles.get(flag)).add(article);}

                    for(Article article: articleList){
                        if(author.getArticle3().equals(article.getPaperid()))
                            (articles.get(flag)).add(article);}

                    for(Article article: articleList){
                        if(author.getArticle4().equals(article.getPaperid()))
                            (articles.get(flag)).add(article);}
                    for(Article article: articleList){
                        if(author.getArticle5().equals(article.getPaperid()))
                            (articles.get(flag)).add(article);}

                    flag+=1;
                }
            }


            if(command.equals("list")){
                bWriter.write("----------------------------------------------List---------------------------------------------\n");
                int flag=0;
                for(Author author: authorList){
                    String head= author.getId()+"\t"+author.getName()+"\t"+author.getUniversity()+"\t"+author.getDepartment()+"\t"+author.getEmail();
                    bWriter.write("Author:"+head+"\n");
                    for(Article article : articles.get(flag)){
                        String articleStr = String.valueOf(article);
                        articleStr=articleStr.replace(" ","\t");
                        bWriter.write("+"+articleStr+"\n");

                    }bWriter.write("\n");
                    flag++;
                }bWriter.write("----------------------------------------------End----------------------------------------------\n");
            }


            else if(command.equals("sortedAll")){
                for(ArrayList<Article> article:articles){
                    Collections.sort(article, Comparator.comparing(Article::getPaperid));

                }bWriter.write("*************************************SortedAll Successful*************************************\n");
            }


            else if(command.startsWith("del")){
                String delete=command.split(" ")[1];
                int flag;
                for(Author author: authorList){
                    flag=authorList.indexOf(author);
                    if(delete.equals(author.getId())){
                        authorList.remove(author);
                        articles.remove(flag);
                        break;
                    }
                }bWriter.write("*************************************del Successful*************************************\n");
            }


            else if(command.equals("completeAll")){
                for(Author author: authorList){
                    for(Article article: articleList){
                        if((author.getArticle1().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){
                            int flag= authorList.indexOf(author);
                            (articles.get(flag)).add(article);
                            author.setArticle1(article.getPaperid());
                            continue;}
                        if((author.getArticle2().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){
                            int flag= authorList.indexOf(author);
                            (articles.get(flag)).add(article);
                            author.setArticle2(article.getPaperid());
                            continue;}
                        if((author.getArticle3().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){
                            int flag= authorList.indexOf(author);
                            (articles.get(flag)).add(article);
                            author.setArticle3(article.getPaperid());
                            continue;}
                        if((author.getArticle4().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){
                            int flag= authorList.indexOf(author);
                            (articles.get(flag)).add(article);
                            author.setArticle4(article.getPaperid());
                            continue;}
                        if((author.getArticle5().equals(" ")) && (article.getPaperid().startsWith(author.getId()))){
                            int flag= authorList.indexOf(author);
                            (articles.get(flag)).add(article);
                            author.setArticle5(article.getPaperid());
                            continue;}
                    }
                }
                bWriter.write("*************************************CompleteAll Successful*************************************\n");
            }
        }bWriter.close();
    }
}







