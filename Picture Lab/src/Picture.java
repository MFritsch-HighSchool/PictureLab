import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
	public Picture (){
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
		super();  
	}
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
	public Picture(String fileName){
    // let the parent class handle this fileName
		super(fileName);
	}
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
	public Picture(int height, int width){
    // let the parent class handle this width and height
		super(width,height);
	}
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
	public Picture(Picture copyPicture){
    // let the parent class do the copy
		super(copyPicture);
	}
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
	public Picture(BufferedImage image){
		super(image);
	}
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
	public String toString(){
		String output = "Picture, filename " + getFileName() + 
				" height " + getHeight() 
				+ " width " + getWidth();
		return output;
    
	}
  
  /** Method to set the blue to 0 */
	public void zeroBlue(){
		///////////////  I have left this method finished.  This method 
		///////////////  goes to each pixel and zeroes out the blue component
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				pixelObj.setBlue(0);
			}
		}
	}
  
	public void zeroRed(){	
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				pixelObj.setRed(0);
			}
		}
	}
  
	public void zeroGreen(){	
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				pixelObj.setGreen(0);
			}
		}
	}
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    
    
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {// This method makes a mirror image of a section of this picture
   // If this picture is of the temple, it mirror images the top.
   // what if this picture is of a different image?
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
   * This method traverses this picture and changes to pixels to 
   * black and white, depending on the color to each pixel's right.
   * If the color change is large, then the pixel on the left is set to 
   * black, otherwise, if the color is close, then the pixel is set to 
   * white. The result is an image with black pixels where it detected 
   * a significant change in color.
   * 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;// this pixel will always be the one to 
    					   // the left of rightPixel.  If this Pixel
    					   // is far enough away (based on edgeDist), then
    					   // leftPixel is set to Color black, else, white
    
    Pixel rightPixel = null;// this Pixel doesn't change value, it is just
    						// used as a reference for comparing with leftPixel
    
    Pixel[][] pixels = this.getPixels2D();// gets the 2D array of Pixel
    
    
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */

public void negate() {
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] rowArray : pixels){
		for (Pixel pixelObj : rowArray){
			int r = 255 - pixelObj.getRed();
			int g = 255 - pixelObj.getGreen();
			int b = 255 - pixelObj.getBlue();
			pixelObj.setRed(r);
			pixelObj.setGreen(g);
			pixelObj.setBlue(b);
		}
	}
}

public void EncodeDecode() {
	Pixel[][] pixels = this.getPixels2D();
	Picture fo = new Picture("msg.jpg");
	Pixel[][] fop = fo.getPixels2D();
	
	for (Pixel[] rowArray : pixels){
		for (Pixel pixelObj : rowArray){
			int r = pixelObj.getRed();
			int rmod = pixelObj.getRed()%2;
			if(rmod > 0){
				r++;
				pixelObj.setRed(r);
			}
//			for (Pixel[] rowAray : fop){
//				for (Pixel pixelz : rowAray){
//					if(pixelz.getRed()!=0 && pixelz.getBlue()!=0 && pixelz.getGreen()!=0)
//						pixelObj.setRed(pixelObj.getRed()+1);
//				}
//			}
			if(fop[pixelObj.getRow()][pixelObj.getCol()].getRed()!=255 && fop[pixelObj.getRow()][pixelObj.getCol()].getGreen()!=255 && fop[pixelObj.getRow()][pixelObj.getCol()].getBlue()!=255)
				pixelObj.setRed(pixelObj.getRed()+1);
		}
	}
}
  
} // this } is the end of class Picture, put all new methods before this
