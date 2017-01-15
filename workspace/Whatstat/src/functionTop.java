
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class functionTop
{
	public static void main(String[] args)
	{}
	public static String run(String path, int service)
	{
		String list = null;
		List<Msg> msgs = new ArrayList<Msg>();
		Map<String, Client> clients = new HashMap<String, Client>();
		Charset charset = Charset.forName("UTF-8");
		Path file = Paths.get("C:/Users/roei/Downloads/ex.txt");
		
		try (BufferedReader reader = Files.newBufferedReader(file, charset))
		{
			String line = null;
			
			String MsgRegex = "\\A(\\d+)/(\\d+)/(\\d+), (\\d+):(\\d+) - ([^:]+): (.+)",
					EventRegex = "\\A(\\d+)/(\\d+)/(\\d+), (\\d+):(\\d+) - (.+)";
			Pattern MsgPattern = Pattern.compile(MsgRegex), EventPattern = Pattern.compile(EventRegex);
			Matcher m;
			Msg msg = new Msg();
			msg.ClientID = null;
			Client client = new Client();
			
			while ((line = reader.readLine()) != null)
			{
				if ((m = MsgPattern.matcher(line)).find())
				{
					if (msg.ClientID != null)
					{
						msgs.add(msg);
						
						++clients.get(msg.ClientID).msgCount;
						
						if (msg.msgText.indexOf("<Media omitted>") >= 0)
						{
							++clients.get(msg.ClientID).mediaCount;
						}
						
						String lol = "חחח";
						if (msg.msgText.indexOf(lol) >= 0)
						{
							++clients.get(msg.ClientID).lolCount;
						}
						msg = new Msg();
					}
					
					msg.Day = Integer.parseInt(m.group(1));
					msg.Month = Integer.parseInt(m.group(2));
					msg.Year = Integer.parseInt(m.group(3));
					msg.Hr = Integer.parseInt(m.group(4));
					msg.Min = Integer.parseInt(m.group(5));
					msg.ClientID = m.group(6);
					msg.msgText = m.group(7);
					
					if (clients.get(msg.ClientID) == null)
					{
						client.ID = msg.ClientID;
						client.msgCount = 0;
						client.mediaCount = 0;
						client.lolCount = 0;
						clients.put(client.ID, client);
						client = new Client();
					}
					
				} else if ((m = EventPattern.matcher(line)).find())
				{
					continue;
				} else
				{
					msg.msgText.concat("\n").concat(line);
				}
			}
			
			if(service==1) {list = sortByMsgCount(clients);}
			if(service==2) {list = sortByLOLCount(clients);}
			if(service==3) {list = sortByMediaCount(clients);}

			
		} catch (IOException x)
		{
			System.err.format("IOException: %s%n", x);
		}
		return list;
	}
	
	private static String sortByMsgCount(Map<String, Client> unsortMap)
	{
		
		// 1. Convert Map to List of Map
		List<Client> list = new LinkedList<Client>(unsortMap.values());
		
		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Client>()
		{
			public int compare(Client c1, Client c2)
			{
				return (c1.msgCount < c2.msgCount) ? 1 : -1;
			}
		});
		
		String list_txt = "";
		
		for (Client cl : list)
		{
			list_txt = list_txt + cl.ID + "  -  " + cl.msgCount + "\n" + "\n";
		}
		
		return list_txt;
	}
	
	private static String sortByMediaCount(Map<String, Client> unsortMap)
	{
		
		// 1. Convert Map to List of Map
		List<Client> list = new LinkedList<Client>(unsortMap.values());
		
		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Client>()
		{
			public int compare(Client c1, Client c2)
			{
				return (c1.mediaCount < c2.mediaCount) ? 1 : -1;
			}
		});
		
		String list_txt = "";
		
		for (Client cl : list)
		{
			list_txt = list_txt + cl.ID + "  -  " + cl.mediaCount + "\n"+ "\n";
		}
				
		return list_txt;
	}
	
	private static String sortByLOLCount(Map<String, Client> unsortMap)
	{

        // 1. Convert Map to List of Map
        List<Client> list =
                new LinkedList<Client>(unsortMap.values());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Client>() {
            public int compare(Client c1,
                           		Client c2) {
                return (c1.lolCount < c2.lolCount)?1:-1;
            }
        });


        String list_txt = "";
		
        for (Client cl : list)
		{
			list_txt = list_txt + cl.ID + "  -  " + cl.lolCount + "\n"+ "\n";
		}
		
		return list_txt;
    }
}