package stusys;

public class Student {
	String name = null, sex = null, id = null, banji = null, major = null;
	int count;
	Student(){
		
	}
	Student(String name, String id, String sex, String banji, String major){
		this.name = name;
		this.id = id;
		this.sex = sex;
		this.banji = banji;
		this.major = major;
	}
	Student(String name, String id){
		this.name = name;
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}

	void setSex(String sex) {
		this.sex = sex;
	}

	void setId(String id) {
		this.id = id;
	}

	void setBanji(String banji) {
		this.banji = banji;
	}

	void setMajor(String major) {
		this.major = major;
	}
	void setCount(int count){
		this.count = count;
	}
	String getName() {
		return this.name;
	}

	String getSex() {
		return this.sex;
	}

	String getId() {
		return this.id;
	}

	String getBanji() {
		return this.banji;
	}

	String getMajor() {
		return this.major;
	}
	int getCount(){
		return this.count;
	}
	public String toString(){
		String con = "姓名" + this.name + "\n"
				+ "性别" + this.sex + "\n"
				+ "学号" + this.id + "\n"
				+ "班级" + this.banji + "\n"
				+ "专业" + this.major + "\n";
		return con;
		
	}
}
