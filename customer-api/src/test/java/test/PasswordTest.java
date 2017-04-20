package test;

import com.pzj.base.common.global.PasswordGenerateUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2016-8-5.
 */
public class PasswordTest {

    @Test
    public void genPassword() {
        String password = PasswordGenerateUtil.generatePassword(3666480786833408L, "wuliqing", "g7bplv");
        System.out.println("password = " + password);
        System.out.println();
    }
}
