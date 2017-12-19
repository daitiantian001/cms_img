package oos.lmnml.com.img;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgApplicationTests {

	@Test
	public void contextLoads() {

	}

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		Stream stream = list.stream();
		stream.forEach(k->{
			System.out.println(k);
		});
	}

}
