package xyz.yuhang.pojo;

public class StudyroomTime {
    String id;
    String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StudyroomTime{" +
                "id=" + id +
                ", time='" + time + '\'' +
                '}';
    }
}
