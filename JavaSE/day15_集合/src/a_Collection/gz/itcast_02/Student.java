package a_Collection.gz.itcast_02;

public class Student {
	//成员变量
	private String name;
	private int age;
	
	//构造方法
	public Student(){
		super();
	}
	
	public Student(String name,int age){
		super();
		this.name=name;
		this.age=age;
	}
	
	//成员方法
	//getXxx()/setXxx()
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	
}
