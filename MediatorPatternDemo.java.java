Step 1:

Create a ApnaChatRoom interface.

//This is an interface.  
public interface ApnaChatRoom {  
      
    public void showMsg(String msg, Participant p);  
  
}// End of the ApnaChatRoom interface.  
Step 2:

Create a ApnaChatRoomIml class that will implement ApnaChatRoom interface and will also use the number of participants involved in chatting through Participant interface.

//This is a class.  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
public class ApnaChatRoomImpl implements ApnaChatRoom{  
    //get current date time   
    DateFormat dateFormat = new SimpleDateFormat("E dd-MM-yyyy hh:mm a");  
    Date date = new Date();  
    @Override  
    public void showMsg(String msg, Participant p) {  
          
        System.out.println(p.getName()+"'gets message: "+msg);  
        System.out.println("\t\t\t\t"+"["+dateFormat.format(date).toString()+"]");    
    }     
}// End of the ApnaChatRoomImpl class.  
Step 3:

Create a Participant abstract class.

//This is an abstract class.  
public abstract class Participant {  
      public abstract void sendMsg(String msg);  
      public abstract void setname(String name);  
      public abstract String getName();  
}// End of the Participant abstract class.  
Step 4:

Create a User1 class that will extend Participant abstract class and will use the ApnaChatRoom interface.

//This is a class.  
  
public class User1 extends Participant {  
      
    private String name;  
    private ApnaChatRoom chat;  
      
    @Override  
    public void sendMsg(String msg) {  
    chat.showMsg(msg,this);  
          
    }  
  
    @Override  
    public void setname(String name) {  
        this.name=name;  
    }  
  
    @Override  
    public String getName() {  
        return name;  
    }  
      
    public User1(ApnaChatRoom chat){  
        this.chat=chat;  
    }     
      
}// End of the User1 class.  
Step 5:

Create a User2 class that will extend Participant abstract class and will use the ApnaChatRoom interface.

//This is a class.  
  
public class User2 extends Participant {  
  
    private String name;  
    private ApnaChatRoom chat;  
      
    @Override  
    public void sendMsg(String msg) {  
    this.chat.showMsg(msg,this);  
          
    }  
  
    @Override  
    public void setname(String name) {  
        this.name=name;  
    }  
  
    @Override  
    public String getName() {  
        return name;  
    }  
      
    public User2(ApnaChatRoom chat){  
        this.chat=chat;  
    }  
  
      
      
}  
// End of the User2 class.  
Step 6:

Create a MediatorPatternDemo class that will use participants involved in chatting.

//This is a class.  
  
public class MediatorPatternDemo {  
      
    public static void main(String args[])  
    {  
          
          ApnaChatRoom chat = new ApnaChatRoomImpl();  
      
          User1 u1=new User1(chat);  
          u1.setname("Ashwani Rajput");  
          u1.sendMsg("Hi Ashwani! how are you?");  
        
                
          User2 u2=new User2(chat);  
          u2.setname("Soono Jaiswal");  
          u2.sendMsg("I am Fine ! You tell?");  
    }  
  
}