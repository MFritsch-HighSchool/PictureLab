import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		Picture beach = new Picture("koala.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}
	
	public static void testZeroRed(){
		Picture beach = new Picture("koala.jpg");
		beach.explore();
		beach.zeroRed();
		beach.explore();
	}
	
	public static void testZeroGreen(){
		Picture beach = new Picture("koala.jpg");
		beach.explore();
		beach.zeroGreen();
		beach.explore();
	}
				

	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		// this should take the left-hand half of the picture and reflect it across 
		// the vertical midline.
		caterpillar.mirrorVertical();// need to write this method in the picture class
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();// this method creates a mirror image for a section of its
		// pixels.  What would happen if we used a different starting 
		// image?  Is mirrorTemple a useful method in the long run?  How
		// could you change it so that it would be more useful?
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();// this method has been written in the Picture class
		// how can it be changed so that we could pass in 
		// pictures that could be added to a collage?
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{

		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
		swan.write("swan outline.jpg");// writes the new picture to a new file
	}

	/** Main method for testing.  Every class can have a main
	 * method in Java */
	public static void main(String[] args){
		//    testZeroBlue();
//		//    testZeroRed();
//		//	  testZeroGreen();
		//    testKeepOnlyBlue();
		//    testKeepOnlyRed();
		//    testKeepOnlyGreen();
//		//    testNegate();
		//    testGrayscale();
		//    testFixUnderwater();
//		//    testMirrorVertical();
//		//    testMirrorTemple();
		//    testMirrorArms();
		//    testMirrorGull();
		//    testMirrorDiagonal();
		//    testCollage();
		//    testCopy();
		//    testEdgeDetection();
		//    testEdgeDetection2();
		//    testChromakey();
		    testEncodeAndDecode();  // use png, gif or bmp because of compression
		//    testGetCountRedOverValue(250);
		//    testSetRedToHalfValueInTopHalf();
		//    testClearBlueOverValue(200);
		//    testGetAverageForColumn(0);
	}

	/*so, you have a choice for this one and the methods that follow.  You can write the
	 * code in the methods below or you can add functionality to the picture class.  Sometimes
	 * it makes sense to add it to the class for reusability reasons.  Sometimes it is too unique
	 * a need to add to the class. 
	 */


	private static void testGetAverageForColumn(int i) {
		// So, you can create a Picture Object, and then call the 
		// Picture's getAverageForColumn(int i) method

	}

// so for this one, any pixels that have blue over a certain value are set 
// to no blue at all.  Or for a different effect, have those pixels set to black.
	private static void testClearBlueOverValue(int i) {


	}

// goes to each pixel in the top half and cuts the red component in half
// So, bottom half of pic should look normal
	private static void testSetRedToHalfValueInTopHalf() {
		

	}
// displays the number of pixels in the pic that have a red component
// greater than the specifies int.
	private static void testGetCountRedOverValue(int i) {


	}

/*
 * The method below is really cool!!  Use the following approach:
 * go through the entire Picture (the one to carry the message), 
 * and make the red component of every pixel an even number.  
 * To do this, mod by 2 and see if remainder>0.  If so, add or 
 * subtract one (subtracting is safer. Why?) 
 * Then, using a Picture of a message (one color on white background), 
 * any pixel from Picture of message that is not white causes you to 
 * add one to the corresponding pixel's red component of the 
 * encoded picture (the one with all even red components).
 * 
 * Then you can send along the encoded picture to someone else and they should 
 * be able to 
 */
	private static void testEncodeAndDecode() {
		Picture beach = new Picture("koala.jpg");
		beach.EncodeDecode();
		beach.explore();

	}

	private static void testChromakey() {
		// chroma key means to superimpose one image over another.  The image to be
		// drawn over the other one, only draws the pixels that aren't the chroma key
		// The common name for this is green screen
		
	}

	private static void testEdgeDetection2() {
		// This method looks for high contrast pixels.  If two adjacent pixels are relatively
		// far apart (in terms of color) then one pixel is set to black, otherwise, white.

	}

	private static void testCopy() {
		// copies a picture onto another

	}

	private static void testMirrorDiagonal() {
		// Creates a new Picture that creates a mirror image along one diagonal

	}

	private static void testMirrorGull() {
		// creates a mirror image of a bird making image look like bird is over water

	}

	private static void testMirrorArms() {
		// TODO Auto-generated method stub

	}

	private static void testFixUnderwater() {
		// This method is an effort to make a Picture taken underwater look
		// more like it would be if the water were drained

	}

	private static void testNegate() {
		// Turns a Picture into its negative
		// flip all the colors:  if color had red = 30, green = 100, blue = 200
		//                      negated color red = 225, green= 155, blue = 55
		Picture beach = new Picture("koala.jpg");
		beach.negate();
		beach.explore();
		
	}

	private static void testKeepOnlyGreen() {
		// pretty obvious...

	}

	private static void testKeepOnlyRed() {
		// turns the pic quite red

	}

	private static void testKeepOnlyBlue() {
		// should get a fairly blue pic :)
	}

	private static void testGrayscale() {
		// converts a color image into grayscale.  There are many algorithms 
		// for this.  The most common is to find the mean of the red, green 
		// and blue components and set each component to that average
		
	}
}