package baseproject.com.beans;

/**
 * Created by lin on 11/7/16.
 */

public class UserBean {

    private int Id = 1;
    private String FName = "Vaivha";
    private String SName = "abhjsd";

    public UserBean() {
    }

    public UserBean(int id, String FName, String SName) {
        Id = id;
        this.FName = FName;
        this.SName = SName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }
}
