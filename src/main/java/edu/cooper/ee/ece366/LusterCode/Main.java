package edu.cooper.ee.ece366.LusterCode;

import edu.cooper.ee.ece366.LusterCode.store.AnswerStore;
import edu.cooper.ee.ece366.LusterCode.store.AnswerStoreJdbi;
import edu.cooper.ee.ece366.LusterCode.store.PostStore;
import edu.cooper.ee.ece366.LusterCode.store.PostStoreImpl;
import edu.cooper.ee.ece366.LusterCode.util.JsonTransformer;
import edu.cooper.ee.ece366.LusterCode.store.AnswerStoreJdbi;
import org.apache.log4j.BasicConfigurator;
import javax.naming.directory.Attributes;
import com.google.gson.Gson;
import java.util.Hashtable;
import static spark.Spark.*;
import edu.cooper.ee.ece366.LusterCode.*;
import org.jdbi.v3.core.Jdbi;
import java.sql.Connection;
import java.sql.DriverManager;

// This comment is to check that the merge worked

public class Main {
    public static void main(String[] args) {

        AnswerStore answerStore = new AnswerStoreJdbi();
        AnswerService answerService = new AnswerService(answerStore);
        final AnswerHandler answerHandler = new AnswerHandler();
        Gson gson = new Gson();
        JsonTransformer jsonTransformer = new JsonTransformer();
        String url = "jdbc:h2:~/LCdb";
        Jdbi jdbi = Jdbi.create(url);

        get("/ping", (req, res) -> "OK");
        Spark.get("/answer", (req, res) -> answerHandler.createAnswerRequest(req), jsonTransformer);

       /* PostStore postStore = new PostStoreImpl();
        AnswerStore answerStore = new AnswerStoreImpl();
        final Handler myHandler = new Handler(postStore, answerStore);
        //Basic Hello World response
        get("/ping", (req, res) -> "OK");

        //Determine what to do with 2-field string
        get("/:action/:field1", (req,res)-> {
            String action = req.params(":action");
            //Call some handler method depending on the specified action
            if (action.contains("returnPost")){
                String handlerReply = myHandler.returnPost(req);
                return "Hello: Post Requested\n" + handlerReply + "\n";
            }
            if (action.contains("getAnswers")){
                return myHandler.getAnswersHandler(req);
            }
            else { return "Hello: Nothing Happened" + "\n";}
        });

        //Determine what to do with 3-field string
        get("/:action/:field1/:field2", (req,res)-> {
            String action = req.params(":action");
            //Call some handler method depending on the specified action
            if (action.contains("removeUser")){
                System.out.print("removeUser selected\n");
                String handlerReply = myHandler.userRemover(req);
                return "Hello: User Deletion Requested\n" + handlerReply + "\n";
            }
            else if (action.contains("addTags")){
                String handlerReply = myHandler.postAddTags(req);
                return handlerReply;
            }
            return "Hello: Nothing Happened" + "\n"; //None of the conditions were met, and so nothing was done
        });


        //Determine what to do with 4-field string
        get("/:action/:field1/:field2/:field3", (req,res)-> {
            String action = req.params(":action");
            //If 'action' has called for creation of a new user, do so and report
            if (action.contains("passChange")){
                String handlerReply = myHandler.passChange(req);
                return "Hello: Password Change Requested\n" + handlerReply + "\n";
            }

            return "Hello: Nothing Happened" + "\n"; //None of the conditions were met, and so nothing was done
        });

        //Determine what to do with 5-field string
        get("/:action/:field1/:field2/:field3/:field4", (req,res)-> {
            String action = req.params(":action");
            //for answering, format: /answer/username/askpostid/type/content
            if (action.contains("answer")){
                String handlerReply = myHandler.answerHandler(req);
                return "Hello: Answer Requested\n" + handlerReply + "\n";
            }
            //for answering, format: /newPost/username/type/tags/postcontent
            if (action.contains("newPost")){
                String handlerReply = myHandler.postCreate(req);
                return "Hello: New Post Requested\n" + handlerReply + "\n";
            }
            return "Hello: Nothing Happened" + "\n"; //None of the conditions were met, and so nothing was done
        });


        //Determine what to do with 6-field string
        get("/:action/:field1/:field2/:field3/:field4/:field5", (req,res)-> {
            String action = req.params(":action");
            //Call some handler method depending on the specified action
            if (action.contains("newUser")){
                String handlerReply = myHandler.userHandler(req);
                return "Hello: New User Requested\n" + handlerReply + "\n";
            }
            return "Hello: Nothing Happened" + "\n"; //None of the conditions were met, and so nothing was done
        });*/

    }
}
