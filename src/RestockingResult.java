/**
 * Created by salinn on 11/18/14.
 */
public class RestockingResult {
    private Database db;

    public RestockingResult(Database db){
        this.db = db;
    }

    public Database getdb(){
        return this.db;
    }
}
