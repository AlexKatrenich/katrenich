package katrenich.collectionAPI.test1;

/*
 * Дан класс, представляющий собой некоторую бизнес-сущность (entity),
 * объект предметной области (domain object).
 * Необходимо для него корректно определить методы equals(..), hashCode() и toString().
 */

public class EntityA {
	private int age;
	private int height;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;

		EntityA entity = (EntityA) obj;

		if (age != entity.age) return false;
		if (height != entity.height) return false;
		return name.equals(entity.name);
	}

	@Override
	public int hashCode() {
		int result = age;
		result = 37 * result + height;
		result = 37 * result + name.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return (name == null ? "" : "Name: " + this.getName()) + " (age: " + this.getAge()
				+ " height: " + this.getHeight() + ")";
	}
}
