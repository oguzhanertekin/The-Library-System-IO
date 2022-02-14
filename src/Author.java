import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Author {
    private String id;
    private String name;
    private String university;
    private String department;
    private String email;
    private String article1;
    private String article2;
    private String article3;
    private String article4;
    private String article5;

    public Author(){     /* CONSTRUCTOR */
        this.id="null";
        this.name="null";
        this.university="null";
        this.department="null";
        this.email="null";
        this.article1="null";
        this.article2="null";
        this.article3="null";
        this.article4="null";
        this.article5="null";

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArticle1() {
        return article1;
    }

    public void setArticle1(String article1) { this.article1 = article1;}

    public String getArticle2() { return article2; }

    public void setArticle2(String article2) { this.article2 = article2; }

    public String getArticle3() {
        return article3;
    }

    public void setArticle3(String article3) {
        this.article3 = article3;
    }

    public String getArticle4() {
        return article4;
    }

    public void setArticle4(String article4) {
        this.article4 = article4;
    }

    public String getArticle5() {
        return article5;
    }

    public void setArticle5(String article5) {
        this.article5 = article5;
    }

    public String toString(){
        return (this.id+" "+this.name+" "+this.university+" "+this.department+" "+this.email+" "+
                this.article1+" "+this.article2+" "+this.article3+" "+this.article4+" "+this.article5);

    }

    public static ArrayList<Author> authorList(String authorFile) throws IOException {   /* Method for reading author.txt
                                                                                       and adding to list named  authorList */
        File file= new File(authorFile);
        FileReader fReader=new FileReader(file);
        BufferedReader bReader=new BufferedReader(fReader);
        String line;
        ArrayList<String> lineList = new ArrayList<String>();       /* list for Adding every lines */
        while((line= bReader.readLine())!=null){
            String[] splitList= line.split(" ");
            int i=0;
            while(i<(11-splitList.length)){ /* Complete the "line" to the constant length */
                line=line+" null";
                i++;
            }
            lineList.add(line);
        }
        bReader.close();

        ArrayList<Author> authorList=new ArrayList<Author>();

        for (String line2:lineList) {
            Author author1= new Author();
            String[] splitList= line2.split(" ");
            for(int i=0;i<11;i++){
                if(splitList[i].equals("null")){  /* removing empty articles (with null) */
                    splitList[i]=" ";
                }
            }
            author1.setId(splitList[1]);
            author1.setName(splitList[2]);
            author1.setUniversity(splitList[3]);
            author1.setDepartment(splitList[4]);
            author1.setEmail(splitList[5]);
            author1.setArticle1(splitList[6]);
            author1.setArticle2(splitList[7]);
            author1.setArticle3(splitList[8]);
            author1.setArticle4(splitList[9]);
            author1.setArticle5(splitList[10]);
            authorList.add(author1);
        }
        return authorList;
    }
}


