import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoltankrizsan on 2017. 01. 13..
 */
public class BucketList implements Serializable {
	private final List<String> list = new ArrayList<>();

	public void addDream(String newDream) {
		list.add(newDream);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object clone;

		clone = SerializationUtils.clone(this);

		return clone;
	}

	@Override
	public String toString() {
		return "BucketList{" +
				"list=" + list +
				'}';
	}
}
