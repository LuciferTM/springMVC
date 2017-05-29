package example.pojo.mybatis;


import java.util.List;

/**
create table tb_class(
    id int primary key auto_increment,
    code varchar(18)
);
insert into tb_class(code) values('j1601');
insert into tb_class(code) values('j1602');
*/

public class Class {
    private Integer id;
    private String code;
    private List<Student> students;

    public Class() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", students=" + students +
                '}';
    }
}
