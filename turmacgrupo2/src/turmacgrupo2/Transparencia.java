package turmacgrupo2;

import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;

public class Transparencia {
     public void TransCompFrame(JFrame frm) {
        frm.setUndecorated(true);
        AWTUtilities.setWindowOpaque(frm, false);
    }
}
