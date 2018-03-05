import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.vehicle.dto.BindVehicleInput;
import com.ccclubs.vehicle.inf.binding.BindVehicleInf;
import com.ccclubs.vehicle.version.VehicleServiceVersion;
import com.ccclubs.vtsearch.VtsearchApiApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Administrator on 2018/1/15 0015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCase {
    @Autowired
    private BindVehicleInf bindVehicleInf;

    @Test
    public  void tset(){
        BindVehicleInput input =new BindVehicleInput();
        input.setAppId("123");
        input.setTeNo("weewq");
        input.setVin("32424");

        bindVehicleInf.bindVehicle(input);
    };




}
