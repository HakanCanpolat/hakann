package massim.agent;
import massim.agent.AbstractAgent;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;



	
public class Dark extends AbstractAgent {
	public static void main(String[] args) {
		int port =12300;
		String host = "localhost";
		String username = "";
		String pass = "";

		for(int i = 0; i<args.length;i++){
			String arg = args[i];
			if(arg.equalsIgnoreCase("-port")){
				port = Integer.parseInt(args[i+1]);
			}
			
			else if(arg.equalsIgnoreCase("-username")){
				username = args[i+1];
			}
			else if(arg.equalsIgnoreCase("-host")){
				host = args[i+1];
			}
			else if(arg.equalsIgnoreCase("-password"))
				pass = args[i+1];
			else if(arg.equalsIgnoreCase("-help")){
				System.out.println("Usage: Dark -username [name] -password [password] [-host] [host] [-port] [port] [-logpath] [path]");
				System.exit(0);				
			}
			else if(arg.equalsIgnoreCase("-logpath")){
					String path = args[i+1];
					try {
						if(!new File(path).exists()){
							new File(path).mkdirs();
						}
						FileHandler fh = new FileHandler(path+System.getProperty("file.separator")+"Agent_"+username+".txt");
						Dark.logger.addHandler(fh);
						Dark.logger.setLevel(Level.ALL);
						fh.setFormatter(new SimpleFormatter());
					} catch (SecurityException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
			}
		}

		if(username.equalsIgnoreCase("") || pass.equalsIgnoreCase(""))
		{
		System.out.println("Usage: Dark -username [name] -password [password] [-host] [host] [-port] [port] [-logpath] [path]");
		System.exit(0);				
		}
		
		Dark d = new Dark(host,username,pass,port);
		d.start();		
	}
			

		
    protected static int[][] w_m;
    public static  String
                            pass ="",
                            user ="",
                            action1 = "",
                            action2 = "",
                            action3 = "",
                            action4 = "",
                            action5 = "",
                            action6 = "",
                            action7 = "",
                            action8 = "",
                            action9 = "",
                            action10 = "",
                            action11 = "",
                            action12 = "",
                            action13 = "",
                            action14 = "",
                            action15 = "",
                            action16 = "",
                            action17 = "",
                            action18 = "",
                            action19 = "",
                            action20 = "";
    private   int
              posY = 0,
              posX = 0,
              m_2=100000,
              head_right=12300,
              did=0;
              
   public static int agent1f=1,agent2f=1,agent3f=1,agent4f=1,agent5f=1,agent6f=1,agent7f=1,agent8f=1,agent9f=1,
              agent10f=1,agent11f=1,agent12f=1,agent13f=1,agent14f=1,agent15f=1,agent16f=1,agent17f=1,agent18f=1,
              agent19f=1,agent20f=1;
   

   
    public Dark(String host,String username, String pass,int port){
	this.setUsername(username);
	this.setPassword(pass);
	this.setHost(host);
	this.setPort(port);
}
	public Dark(String host, String username, String pass) {
		this.setUsername(username);
		this.setPassword(pass);
		this.setHost(host);
}


	@SuppressWarnings("static-access")
	public void processRequestAction(Element perception, Element target,
			long currenttime, long deadline) {
		String action = "";
		action = processPerception(perception);
		posX = Integer.parseInt(perception.getAttribute("posx"));
		posY = Integer.parseInt(perception.getAttribute("posy"));
		target.setAttribute("type", action);
	}


	public String processPerception(Element a) {
		int i;
		NodeList nl = a.getElementsByTagName("cell");
		Map<String, Integer> dir_point=new HashMap<String, Integer>();
		for (i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);
			Element ne = (Element) n;
			NodeList nnl = n.getChildNodes();
			String content = nnl.item(1).getNodeName();
			int directionX = Integer.parseInt(ne.getAttribute("x"));
			int directionY = Integer.parseInt(ne.getAttribute("y"));
			
			String action = "skip";
       
           
	 if(getUsername()=="a1")
               action=agent1();
          else if(getUsername()=="a2")
               action=agent2();
          else if(getUsername()=="a3")
               action=agent3();
          else if(getUsername()=="a4")
               action=agent4();
          else if(getUsername()=="a5")
               action=agent5();
          else if(getUsername()=="a6")
               action=agent6();
          else if(getUsername()=="a7")
               action=agent7();
          else if(getUsername()=="a8")
               action=agent8();
          else if(getUsername()=="a9")
               action=agent9();
          else if(getUsername()=="a10")
               action=agent10();
          else if(getUsername()=="a11")
               action=agent11();
          else if(getUsername()=="a12")
               action=agent12();
          else if(getUsername()=="a13")
               action=agent13();
          else if(getUsername()=="a14")
               action=agent14();
          else if(getUsername()=="a15")
               action=agent15();
          else if(getUsername()=="a16")
               action=agent16();
          else if(getUsername()=="a17")
               action=agent17();
          else if(getUsername()=="a18")
               action=agent18();
          else if(getUsername()=="a19")
               action=agent19();
          else if(getUsername()=="a20")
               action=agent20();
            }

           
	 
		return username;
	}


		
     public int empty()
        {
        for(int did=0;did<=100;did++)
              for(int i=posX-did;i<=posX+did;i++)
                  for(int j=posY-did;j<=posY+did;j++)
                    {
                       if(w_m[i][j]==0)
                       {
                           System.out.println("find empety "+i+" "+j);
                          return  (i*m_2)+j;
                       }
                   }
            return (posX*m_2)+posY;
        }

        public String short_way(int start,int end)
        {
             System.out.println("endX="+end/m_2+" endY="+end%m_2);
             System.out.println("posX="+posX+" posY="+posY);
            int point_wall=-10;


			return username;
         
        }
        public int find_swich()
        {
            if((w_m[posX+1][posY]==7)||(w_m[posX-1][posY]==7)||(w_m[posX][posY+1]==7)||(w_m[posX][posY-1]==7))
                return (posX*m_2)+posY;
            for(int did=0;did<=100;did++)
                  for(int i=posX-did;i<=posX+did;i++)
                      for(int j=posY-did;j<=posY+did;j++)
                        {
                          if((i>=0)&&(j>=0))
                           if(w_m[j][i]==7)
                           {
                              return  (j*m_2)+i;
                           }
                       }
                return (posX*m_2)+posY;
            }

    public int cow()
    {
        if((w_m[posX+1][posY]==1)||(w_m[posX-1][posY]==1)||(w_m[posX][posY+1]==1)||(w_m[posX][posY-1]==1))
            return (posX*m_2)+posY;
        for(int did=0;did<=100;did++)
              for(int i=posX-did;i<=posX+did;i++)
                  for(int j=posY-did;j<=posY+did;j++)
                    {
                      if((i>=0)&&(j>=0))
                       if(w_m[j][i]==1)
                       {
                          return  (j*m_2)+i;
                       }
                   }
            return (posX*m_2)+posY;
        } 
    public String agent1()
    {
       
       if(agent1f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent1f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent1f==3)
           return action1;
       return "skip";
    }
   public String agent2()
    {
     if(agent2f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent2f==2)
          return  short_way((posX*m_2)+posY,cow());
       else if(agent2f==3)
           return action2;
       return "skip";
    }
   public String agent3()
    {
     if(agent3f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent3f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent3f==3)
           return action3;
       return "skip";
    }
   public String agent4()
    {
     if(agent4f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent4f==2)
          return  short_way((posX*m_2)+posY,cow());
       else if(agent4f==3)
           return action4;
       return "skip";
    }
   public String agent5()
    {
     if(agent5f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent5f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent5f==3)
           return action5;
       return "skip";
    }
   public String agent6()
    {
     if(agent6f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent6f==2)
           return  short_way((posX*m_2)+posY,cow());
       else if(agent6f==3)
           return action6;
       return "skip";
    }
   public String agent7()
    {
     if(agent7f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent7f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent7f==3)
           return action7;
       return "skip";
    }
   public String agent8()
    {
     if(agent8f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent8f==2)
           return  short_way((posX*m_2)+posY,cow());
       else if(agent8f==3)
           return action8;
       return "skip";
    }
   public String agent9()
    {
     if(agent9f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent9f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent9f==3)
           return action9;
       return "skip";
    }
   public String agent10()
    {
     if(agent10f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent10f==2)
           return  short_way((posX*m_2)+posY,cow());
       else if(agent10f==3)
           return action10;
       return "skip";
    }
   public String agent11()
    {
     if(agent11f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent11f==2)
            return  short_way((posX*m_2)+posY,find_swich());
       else if(agent11f==3)
           return action11;
       return "skip";
    }
   public String agent12()
    {
     if(agent12f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent12f==2)
          return  short_way((posX*m_2)+posY,cow());
       else if(agent12f==3)
           return action12;
       return "skip";
    }
   public String agent13()
    {
    if(agent13f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent13f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent13f==3)
           return action13;
       return "skip";
   }
   public String agent14()
    {
     if(agent14f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent14f==2)
          return  short_way((posX*m_2)+posY,cow());
       else if(agent14f==3)
           return action14;
       return "skip";
   }
   public String agent15()
    {
     if(agent15f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent15f==2)
          return  short_way((posX*m_2)+posY,find_swich());
       else if(agent15f==3)
           return action15;
       return "skip";
   }
   public String agent16()
   {
    if(agent16f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent16f==2)
           return  short_way((posX*m_2)+posY,cow());
       else if(agent16f==3)
           return action16;
       return "skip";
   }
   public String agent17()
   {
    if(agent17f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent17f==2)
          return  short_way((posX*m_2)+posY,find_swich());
       else if(agent17f==3)
           return action17;
       return "skip";
   }
   public String agent18()
    {
     if(agent18f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent18f==2)
           return  short_way((posX*m_2)+posY,cow());
       else if(agent18f==3)
           return action18;
       return "skip";
   }
   public String agent19()
   {
        
     if(agent19f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent19f==2)
           return  short_way((posX*m_2)+posY,find_swich());
       else if(agent19f==3)
           return action19;
       return "skip";
   }
   public String agent20()
    {
       if(agent20f==1)
           return short_way((posX*m_2)+posY,empty());
       else if(agent20f==2)
          return  short_way((posX*m_2)+posY,cow());
       else if(agent20f==3)
           return action20;
       return "skip";
   }
}
