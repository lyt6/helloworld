import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
public class TestUriComponentsBuilder {

    @Test
    public void test(){
        JSONObject params = new JSONObject();
        params.put("A", 1);
        params.put("B", 2);
        params.put("C", null);
        URI uri = UriComponentsBuilder.fromHttpUrl("http://39.106.17.209:8888/WebService/SJDDDL/SJDDDL.aspx?url=http://39.106.17.209:8888/JSCXGL/SXTJBBPage/SXTJBBPage.aspx?XMID=0")
                .queryParam("usercode", "ceshi1")
                .build().encode().toUri();
        log.info("uri:{}",uri);
        URI uri1 = UriComponentsBuilder.fromHttpUrl("http://39.106.17.209:8888/WebService/SJDDDL/SJDDDL.aspx?url=http://39.106.17.209:8888/JSCXGL/SXTJBBPage/SXTJBBPage.aspx")
                .queryParam("usercode", "ceshi1")
                .build().toUri();
        log.info("uri1:{}",uri1);
    }

}
