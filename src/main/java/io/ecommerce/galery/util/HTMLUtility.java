package io.ecommerce.galery.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import io.ecommerce.galery.entity.DropdownList;




/**
 * HTML Utility class to produce HTML contents like Dropdown List.
 *
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 *
 */
public class HTMLUtility {
	/**
	 * Create HTML SELECT list from MAP paramters values
	 *
	 * @param name
	 * @param selectedVal
	 * @param map
	 * @return
	 */

	public static String getList(String name, String selectedVal,HashMap<String, String> map) {
		
		/*Map<String, String> treeMap = new LinkedHashMap<String, String>(map);*/
	
		StringBuffer sb = new StringBuffer(	"<select class='form-control' name='" + name + "'>");

		Set<String> keys = map.keySet();
		String val = null;
		for (String key : keys) {
			val = map.get(key);
			if (key.trim().equals(selectedVal)) {

				sb.append("<option selected value='" + key + "'>" + val
						+ "</option>");
			} else {
				sb.append("<option value='" + key + "'>" + val + "</option>");
			}
		}
		sb.append("</select>");
		return sb.toString();
	}

	/**
	 * Create HTML SELECT List from List parameter
	 *
	 * @param name
	 * @param selectedVal
	 * @param list
	 * @return
	 */
	public static String getList(String name, String selectedVal, List list) {
		
		Collections.sort(list);

		List<DropdownList> dd = (List<DropdownList>) list;

		StringBuffer sb = new StringBuffer("<select class='form-control' name='" + name + "' id='" + name+ "'>");
		
		String key = null;
		
		String val = null;
		
		String select = "-----Select-----";
		
		sb.append("<option  selected value='" + select + "'>" + select+ "</option>");
		
		for (DropdownList obj : dd) {
			key = obj.getKey();
			val = obj.getValue();

			if (key.trim().equals(selectedVal)) {
				sb.append("<option selected value='" + key + "'>" + val+ "</option>");
			} else {
				sb.append("<option value='" + key + "'>" + val + "</option>");
			}
		}

		sb.append("</select>");
		return sb.toString();
	}
}
