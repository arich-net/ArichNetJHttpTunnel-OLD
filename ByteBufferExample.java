import java.nio.*;

public class ByteBufferExample {

   private ByteBuffer buffer_data = null;

   public ByteBufferExample() {
      //buffer_data = ByteBuffer.allocateDirect(1024);
      buffer_data = ByteBuffer.allocateDirect(24);
   }

   public void example() {
      /**
      System.out.println("Is a direct buffer: " + buffer_data.isDirect());
      System.out.println("Buffer has a backing array: " + buffer_data.hasArray());
  
      byte[] data = hexStringToByteArray("e04fd09d56785f");
      
      System.out.println("Buffer size: " + buffer_data.limit());
      System.out.println("Buffer has data: " + buffer_data.hasRemaining());
      System.out.println("Buffer has data remaining: " + buffer_data.remaining());
      System.out.println("Buffer position: " + buffer_data.position());

      //Put some data on the buffer
      buffer_data.put(data, 0, data.length);
      System.out.println("********************************************");
      System.out.println("Buffer size: " + buffer_data.limit());
      System.out.println("Buffer has data: " + buffer_data.hasRemaining());
      System.out.println("Buffer has data remaining: " + buffer_data.remaining());
      System.out.println("Buffer position: " + buffer_data.position());

      //Read Data from the buffer
      System.out.println("********************************************");
      byte tmp;
      int number;
      int limit = buffer_data.position();
      buffer_data.position(0);
      for (int i = 0; i < limit; i++){
         tmp = buffer_data.get();
         number = tmp & 0xFF;
         System.out.println("+++++++++++++++++++++++++++++++");
         System.out.println("Hex number get: " + Integer.toHexString(number));
         System.out.println("Buffer has data remaining: " + buffer_data.remaining());
         System.out.println("Buffer position: " + buffer_data.position());
      }
   
      buffer_data.rewind();
      System.out.println("********************************************");
      System.out.println("Buffer size: " + buffer_data.limit());
      System.out.println("Buffer has data: " + buffer_data.hasRemaining());
      System.out.println("Buffer has data remaining: " + buffer_data.remaining());
      System.out.println("Buffer position: " + buffer_data.position());
      **/

      int length = 1521;
      String hex_value = Integer.toHexString(length);
      byte[] return_data = new byte[2];
      byte tmp = 0;
      int msb_int = Math.abs(length / 256);
      int lsb_int = (length - (msb_int * 256));
      //int lsb_int = msb_int * 255;
      System.out.println("Thread: " + Thread.currentThread().getName() + 
   	   		 " | MSB value:" + msb_int + " LSB Value:" + lsb_int);


   }

   public static byte[] hexStringToByteArray(String s) {
      int len = s.length();
      byte[] data = new byte[len / 2];
      for (int i = 0; i < len; i += 2) {
         data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                              + Character.digit(s.charAt(i+1), 16));
      }
      return data;
   }

   public static void main (String[] args) {
      ByteBufferExample buffer = new ByteBufferExample();
      buffer.example();
   }
}
