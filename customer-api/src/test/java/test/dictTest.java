package test;

import org.junit.Test;

import com.pzj.dict.entity.Dict;
import com.pzj.dict.service.DictService;
import com.pzj.dict.service.DictServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class dictTest {

    @Autowired
	private DictService dictService;

    @Test
    public void save() throws Exception {
        Dict dict = new Dict();
        dict.setId(0L);
        dict.setCreateBy("fewfewf");
        dictService.saveDict(dict);
    }

    @Test
    public void getListByType() throws Exception {
        // TEST
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        String type = "product:ticketType";
        List<Dict> dicts = dictService.getListByType(type);
        assertNotNull(dicts);

        System.out.println("总数" + dicts.size());
        for(Dict dict : dicts){
            System.out.println("\t" + dict.getId() + "\t" + dict.getSort());
        }
    }
    @Test
    public void getListByTypeEE() throws Exception {
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        for (int i = 0; i < 1000; i++){
            System.out.println(">>>>>> " + i);
            getListByType();
        }
    }

    @Test
    public void createChannelDict() throws Exception {
        Dict dict = new Dict();
        dict.setType("channel:channeltypeDPT");
        dict.setLabel("大合唱");
        dict.setValue("2016");

        Long id = dictService.createChannelDict(dict);
        System.out.println("id : " + id);
    }

    @Test
    public void modifyChannelDict() throws Exception {
        Dict dict = new Dict();
        dict.setType("channel:channeltypeDPT");
        dict.setLabel("大合唱3");
        dict.setValue("1001");

        boolean modify = dictService.modifyChannelDict(dict);
        System.out.println("id : " + modify);
    }
}