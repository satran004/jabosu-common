package org.jabosu.common.util;

import org.jabosu.common.exception.BusinessRuntimeException;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
/**
 *
 * @author satya
 */
public class CaptchaUtil {
    
    public static String generateCaptcha() {
        
        boolean recaptchaDisabled = false;       
        try {
            recaptchaDisabled = ConfigLoader.getConfig().getBoolean("disable.recaptcha");
        } catch(Exception e) {}
        
        if(recaptchaDisabled)
            return "";
        
        String publickey = ConfigLoader.getConfig().getString("recaptcha.public.key");
        String privatekey = ConfigLoader.getConfig().getString("recaptcha.private.key");
        
        if(StringUtil.isEmpty(privatekey) || StringUtil.isEmpty(publickey)) {
            throw new BusinessRuntimeException("Recaptcha public / private key is empty. Please set it and restart the system.");
        }
        
//        ReCaptcha c = ReCaptchaFactory.newReCaptcha(publickey, privatekey, false);
//        
//        String captchaStr = c.createRecaptchaHtml(null, null);
//        captchaStr = captchaStr.replace("http:", "https:");
        
        String captchaStr = "<script type=\"text/javascript\" src=\"//www.google.com/recaptcha/api/challenge?k=" + publickey + "\"></script>";
        return captchaStr;
    }
    
    public static boolean checkCaptcha(String remoteAddress, String challenge, String response) {
        
        boolean recaptchaDisabled = false;     
        try {
            recaptchaDisabled = ConfigLoader.getConfig().getBoolean("disable.recaptcha");
        } catch(Exception e) {}
        
        if(recaptchaDisabled)
            return true;
        
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey(ConfigLoader.getConfig().getString("recaptcha.private.key"));

        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddress, challenge, response);

        if (reCaptchaResponse.isValid()) {
          return true;
        } else {
          return false;
        }
    }
}
