
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class LongestWord {


	static Queue<KeyValue> prefixsuffix =   new LinkedList<KeyValue>();
	public static void main(String[] args) {


		Trie t = new Trie();
		int totallines = 0;

		try{

			File file = new File(args[0]);

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {

				if(!line.trim().isEmpty()){
					totallines++;
					ArrayList<String> prefixes = t.findPrefixAndInsert(line.trim(), t.root);
					if(prefixes!=null){		   ;
					for(int index = 0; index< prefixes.size(); index++)
					{
						String prefix = prefixes.get(index);
						prefixsuffix.add(new KeyValue(line, line.substring(prefix.length())));
					}
					}

				}
			}
			br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		String longestcompound=null;
		String secondlongest = null;
		int totalCompoundWords = 0;
		while(!prefixsuffix.isEmpty())
		{
			KeyValue kv = prefixsuffix.remove();

			Node result;
			if(t.search(kv.value, t.root)!=null)
			{


				if(!(result=t.search(kv.key, t.root)).searched)
				{
					result.searched = true;		
					totalCompoundWords++;
				} 					
				if(longestcompound==null)
				{
					longestcompound = kv.key;
				}
				else
				{
					if(longestcompound.length() > kv.key.length())
					{
						if(secondlongest != null)
						{

							if(secondlongest.length() < kv.key.length())
							{

								secondlongest = kv.key;

							}
						}
						else
						{

							secondlongest = kv.key;
						}

					}
					else if(longestcompound.length() == kv.key.length())
					{
						if(longestcompound.compareTo(kv.key)>0)
						{
							longestcompound = kv.key;
						}
					}
					else{
						longestcompound = kv.key;
					}
				}
			}
			else
			{
				t.returnPrefixNode(kv.value, t.root, 0, true);
				ArrayList<String> prefixList = t.prefixList.get(kv.value);
				if(prefixList != null){
					for(int index=0; index< prefixList.size(); index++)
					{
						String suffix = kv.value.substring(prefixList.get(index).length());
						prefixsuffix.add(new KeyValue(kv.key, suffix));
					}

				}
			}

		}




		System.out.println("The longest compound word is: "+longestcompound);
		System.out.println("The second longest compound word is: "+secondlongest);
		System.out.println("The total number of words that can be constructed from other words is: "+totalCompoundWords);
		System.out.println("The total number of lines in the file are: "+totallines);
		// TODO Auto-generated method stub



	}
}