package xyz.yuhang.pojo;

public class Academy {
    int id;
    String academyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "id='" + id + '\'' +
                ", academyName='" + academyName + '\'' +
                '}';
    }
}
