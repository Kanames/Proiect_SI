package generalHelper;

import java.lang.reflect.Field;

	/**
	 * Aceasta clasa este un helper general de folosit in toata aplicatia.Rolul lui este de a mentine diferite metode refolosibile in aplicatie
	 * intr-un singur loc.
	 * @author Stefan
	 * @category Helper
	 * @version 0.1
	 * @since 25/02/2018
	 */
public class CommonHelper {
	/**
	 * @param object Obiectul pe care il dorim afisat un forma "Human readable"
	 * @return Obiectul reprezentat ca string. String-ul contine detali despre obiect *atribut obiect* - *valoare atribut obiect*; 
	 * @since 25/02/2018
	 */
	public static String trsfOut(Object object){
		StringBuffer representation = new StringBuffer();
		representation.append(object.getClass().getName());
		for (Field field : object.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				String name = field.getName();
				Object value;
				value = field.get(object);
				representation.append(" ["+name+":"+ value+"] ");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return representation.toString();
	}
	
//	public static void main(String[] args) {
//		UserBean user_test = new UserBean();
//		user_test.setName("test");
//		String reprezentare_test = trsfOut(user_test);
//		System.out.println(reprezentare_test);
//	}
	
}
