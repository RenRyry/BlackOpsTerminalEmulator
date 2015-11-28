/*
 * The MIT License
 *
 * Copyright 2015 thehambone <thehambone93@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package thehambone.blackopsterminalemulator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * This class handles program initialization.
 * <p>
 * Created on Nov 17, 2015.
 *
 * @author thehambone <thehambone93@gmail.com>
 */
public class Main
{
    public static final String PROGRAM_TITLE
            = "Call of Duty: Black Ops Terminal Emulator";
    public static final String PROGRAM_VERSION
            = "1.0-alpha (dev build)";
    
    /**
     * Program entry point.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        String title = PROGRAM_TITLE + " - " + PROGRAM_VERSION;
        Terminal.setTitle(title);
        Terminal.show();
        
        Terminal.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Terminal.println("Central Intelligence Agency Data system\n");
        Terminal.println("Unauthorized use of this system is against the law.\n");
        Terminal.println("Security Privileges Required");
        Terminal.println("USER:amason");
        Terminal.println("PASSWORD:********\n");
        
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("res/bb77b895.txt"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Terminal.println(line);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/reznov1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Terminal.println(img);
        while (true) {
            Terminal.print("$");
            String input = Terminal.readLine();
            if (!input.isEmpty()) {
                Terminal.println("Error:  Unknown Command - try \"help\"");
            }
        }
    }
}