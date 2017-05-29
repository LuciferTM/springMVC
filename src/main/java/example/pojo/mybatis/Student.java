package example.pojo.mybatis;

/**
 create table tb_student(
     id int primary key auto_increment,
     name varchar(18),
     sex char(3),
     age int,
     class_id int,
     foreign key (class_id) references tb_class(id)
 );

 insert into tb_student(name,sex,age,class_id) values('jack','男',22,1);
 insert into tb_student(name,sex,age,class_id) values('rose','女',20,1);
 insert into tb_student(name,sex,age,class_id) values('tom','男',23,1);
 insert into tb_student(name,sex,age,class_id) values('mary','女',21,1);
 */
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Class aClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", aClass=" + aClass +
                '}';
    }

    public Student() {
    }
}
