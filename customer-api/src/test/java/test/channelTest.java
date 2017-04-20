package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.common.utils.PageList;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.ChannelService;
import com.pzj.channel.service.impl.ChannelServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class channelTest {

    @Autowired
    private ChannelService channelService = null;

    @Test
    public void getById() throws Exception {
        Long id = 573845L;

        ChannelVo channel = channelService.getById(id);

        assertNotNull(channel);
        // (channel.getFlag());
        // assertEquals("1", channel.getFlag());
        assertNotNull(channel.getSupplierId());

    }

    @Test
    public void getChannelCustomerList() throws Exception {
        ChannelVo channel = channelService.getChannelCustomerList(2216619736563716L);
        assertNotNull(channel);
        assertNotNull(channel.getSupplierId());
    }

    @Test
    public void queryPageByCustomerId() throws Exception {
        PageList<ChannelVo> channel = channelService.queryPageByCustomerId(null, null, 3689511322583040L);
        assertNotNull(channel);
    }

    @Test
    public void bindingDistributors() throws Exception {
        Long channelId = 2216619736563716L;
        Long supplierId = 2216619736563723L;
        List<Long> distributorsIds = Arrays.asList(2216619736563791L);

        boolean result = channelService.bindingDistributors(channelId, distributorsIds, supplierId);
        assertTrue(result);
    }


    @Test
    public void unbundingDistributors() throws Exception {
        Long channelId = 2216619736563716L;
        Long supplierId = 2216619736563723L;
        List<Long> distributorsIds = Arrays.asList(2216619736563791L);

        boolean result = channelService.unbundingDistributors(channelId, distributorsIds, supplierId);
        assertTrue(result);
    }

    @Test
    public void getChannelByMF() throws Exception {
        channelService = new ChannelServiceImpl();
        ChannelVo channel = new ChannelVo();
        channel.setChannelCategory(UserGlobalDict.ChannelGlobalDict.channelMF());
        PageList<ChannelVo> pageList = channelService.queryPageByParamMap(null,
                channel);
        List<ChannelVo> list = pageList.getResultList();
        Long MFchannelId = 0l;
        if (list != null) {
            MFchannelId = list.get(0).getId();
        }
        System.out.println(" MFchannelId = " + MFchannelId);
        // TO
    }

    @Test
    public void queryPageByParamMap() throws Exception {
        ChannelVo channel = new ChannelVo();
//        channel.setName("魔方");
//        channel.setChannelPrincipal("管");
        channel.setSupplierId(2216619746563732L);

        PageList<ChannelVo> pageList = channelService.queryPageByParamMap(null, channel);
        List<ChannelVo> list = pageList.getResultList();
        Long MFchannelId = 0l;
        if (list != null) {
            MFchannelId = list.get(0).getId();
        }
        System.out.println(" MFchannelId = " + MFchannelId);
        // TO
    }
}
