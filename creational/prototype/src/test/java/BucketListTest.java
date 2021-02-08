import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by zoltankrizsan on 2017. 01. 13..
 */
public class BucketListTest {

	@org.junit.Test
	public void testClone() throws CloneNotSupportedException {
		BucketList bucketList = new BucketList();

		bucketList.addDream("dream1");
		bucketList.addDream("dream2");

		BucketList bucketList2 = (BucketList) bucketList.clone();

		String originalString = bucketList2.toString();

		bucketList.addDream("dream3");

		assertThat(originalString, equalTo(bucketList2.toString()));
		assertThat(bucketList.toString(), is(not(equalTo(bucketList2.toString()))));

	}

}