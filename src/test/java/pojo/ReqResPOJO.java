package pojo;

public class ReqResPOJO {
    /*
    {
                 "name": "John Doe",
                 "job": "Manager"
                  }
     */
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ReqResPOJO(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public ReqResPOJO() {
    }

    @Override
    public String toString() {
        return "ReqResPOJO{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
