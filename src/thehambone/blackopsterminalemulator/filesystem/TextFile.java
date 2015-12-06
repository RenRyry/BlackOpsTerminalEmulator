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

package thehambone.blackopsterminalemulator.filesystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import thehambone.blackopsterminalemulator.Terminal;

/**
 * A {@code TextFile} is a file containing text data.
 * <p>
 * Created on Nov 30, 2015.
 *
 * @author thehambone <thehambone93@gmail.com>
 */
public final class TextFile extends PrintableFile
{
    /**
     * Creates a new {@code TextFile}.
     * 
     * @param id the filesystem object id
     * @param name the name of this file
     * @param resourcePath the path to the resource containing the file data
     */
    public TextFile(int id, String name, String resourcePath)
    {
        super(id, name, resourcePath);
    }
    
    @Override
    public void print()
    {
        String textData;
        BufferedReader reader;
        String line;
        
        textData = "";
        try {
            // Load text data from resource
            reader = new BufferedReader(new FileReader(getResourcePath()));
            
            // Read text data line-by-line and concatenate it to a buffer string
            while ((line = reader.readLine()) != null) {
                textData += line + "\n";
            }
        } catch (IOException ex) {
            // TODO: log
            ex.printStackTrace();
            return;
        }
        
        // Output the contents of the file
        /* Print entire file as a single string to allow for the "--MORE--"
           pager prompt to show */
        Terminal.print(textData);
    }
}