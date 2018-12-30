import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class transition{
  public static int formatPix(int a, int r, int g, int b){
    int p = 0;
    p = (a<<24) | (r<<16) | (g<<8) | b;
    return p;
  }

  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    BufferedImage ret = null;
    File f = null;
    //read image
    try{
      f = new File("cat.jpg");
      img = ImageIO.read(f);
      int width = img.getWidth();
      int height = img.getHeight();
      int[][][] pixels = new int[width][height][4]; //x, y, [a, r, g, b]
      int p;
      for(int x = 0; x < width; x++){
        for(int y = 0; y < height; y++){
          p = img.getRGB(x,y);
          pixels[x][y][0] = (p>>24) & 0xff;
          pixels[x][y][1] = (p>>16) & 0xff;
          pixels[x][y][2] = (p>>8) & 0xff;
          pixels[x][y][3] = p & 0xff;
        }
      }
      ret = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      for(int x = 0; x < width; x++){
        for(int y = 0; y < height; y++){

          ret.setRGB(x, y, formatPix(
            pixels[x][y][0],
            (pixels[x][y][1]+100>255)?255:pixels[x][y][1]+100,
            (pixels[x][y][2]+100>255)?255:pixels[x][y][2]+100,
            (pixels[x][y][3]+100>255)?255:pixels[x][y][3]+100));
        }
      }
    }catch(IOException e){
      System.out.println(e);
    }

    //write
    try{
      f = new File("Output.jpg");
      ImageIO.write(ret, "jpg", f);
    }catch(IOException e){
      System.out.println(e);
    }
    // some code goes here...

  }//main() ends here
}//class ends here
