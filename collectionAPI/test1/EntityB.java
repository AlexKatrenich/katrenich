package katrenich.collectionAPI.test1;

import java.util.Arrays;

/*
 * Дан класс, представляющий собой некоторую бизнес-сущность (entity),
 * объект предметной области (domain object).
 * Необходимо для него корректно определить методы equals(..), hashCode() и toString().
 */
public class EntityB {
	private final String[][] stringArr;
	private final double[] doubleArr;

	public EntityB(String[][] stringArr, double[] doubleArr) {
		this.stringArr = stringArr;
		this.doubleArr = doubleArr;
	}

	public String[][] getStringArr() {
		return stringArr;
	}

	public double[] getDoubleArr() {
		return doubleArr;
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (String[] str: stringArr) {
			result = Arrays.deepHashCode(str);
			result = 31 * result + Arrays.hashCode(doubleArr);
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;

		EntityB ent = (EntityB) obj;
		return Arrays.equals(this.getStringArr(), ent.getStringArr())
				&& Arrays.equals(this.getDoubleArr(), ent.getDoubleArr());
	}

	@Override
	public String toString() {
		String s = "";
		s += "[";
		for (int i = 0; i < stringArr.length; i++) {
			s += Arrays.toString(stringArr[i]);
			if(i < stringArr.length - 1){
				s += ", ";
			}
		}

		s = s + "]\n" + Arrays.toString(this.getDoubleArr());
		return s;
	}
}
