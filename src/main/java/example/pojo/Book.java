package example.pojo;

import java.io.Serializable;

public class Book implements Serializable {

    private Integer id;
    private String name;
    private String author;

//    原来的代码没有默认构造函数，结果无法使用json
    public Book(){

    }

    public Book(int id, String name, String author) {
        this.id=id;
        this.name=name;
        this.author=author;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
    }

}