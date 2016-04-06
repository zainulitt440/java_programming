import java.io.*;
import java.net.*;

class udp_client
{
 public static void main(String args[])throws Exception
 {
  BufferedReader inFromUser = new BufferedReader(new 
InputStreamReader(System.in));
  DatagramSocket clientSocket = new DatagramSocket();
  InetAddress IPAddress = InetAddress.getByName("localhost");
  byte[] sendData = new byte[1024];
  byte[] receiveData = new byte[1024];
  System.out.print("Enter something: ");
  String sentence = inFromUser.readLine();
  sendData = sentence.getBytes();
  DatagramPacket sendPacket = new DatagramPacket(sendData, 
sendData.length, IPAddress, Integer.parseInt(args[0]));
  clientSocket.send(sendPacket);
  DatagramPacket receivePacket = new DatagramPacket(receiveData, 
receiveData.length);
  clientSocket.receive(receivePacket);
  String modifiedSentence = new String(receivePacket.getData());
  System.out.println("From Server: " + modifiedSentence);
  clientSocket.close();
 }
}