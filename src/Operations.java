import java.io.IOException;
import java.util.ArrayList;

public class Operations {

    public static ArrayList<ArrayList<Article>> articleArrays(String authorFile) throws IOException {
        ArrayList<ArrayList<Article>> articles= new ArrayList<ArrayList<Article>>();   /* List contains Articles list e.g. [ [], [], []....]*/
        for(Author author: Author.authorList(authorFile)){   /* Creating article lists ; same number as the number of authors */
            ArrayList<Article> empty= new ArrayList<Article>();
            articles.add(empty);
        }
        return articles;
    }
}
