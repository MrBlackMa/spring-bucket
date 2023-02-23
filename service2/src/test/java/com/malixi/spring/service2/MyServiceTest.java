package com.malixi.spring.service2;

import com.malixi.spring.service2.dao.MyRepository;
import com.malixi.spring.service2.model.Model;
import com.malixi.spring.service2.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//@SpringBootTest
@RunWith(SpringRunner.class)
public class MyServiceTest {



   // @Mock
    @InjectMocks
   //  @Autowired
    private MyService myService;

    @Mock
    private MyRepository myRepository;
 
    @Test
    public void testInjectMocks(){
        System.out.println(myService.findById(1L));
    }


    @Test
    public void testInjectMocks2(){
//        myRepository.doSomething();
//        myService.doSomething();
        // 打桩 设置参数
        // 参数 anyInt();anyMap();anyList();anyString()
        when(myRepository.findById(anyLong())).thenReturn(new Model(1L,"malixi"));

        System.out.println(myRepository.findById(1L));
        System.out.println(myService.findById(1L));
        System.out.println(1);
    }
}