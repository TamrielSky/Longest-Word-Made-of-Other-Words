
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

/**
 *
 * @author rajeshba
 */
public class Trie {

	Node root = new Node(' ');

	HashMap<String, ArrayList<String>> prefixList = new HashMap<String,  ArrayList<String>>();

	public ArrayList<String> findPrefixAndInsert(String word, Node root)
	{
		prefixList.put(word, null);
		Node insertHere = returnPrefixNode(word, root, 0, true);


		int charcount = insertHere.triePosition;
		while(charcount < word.length())
		{
			Node newNode = new Node(word.charAt(charcount));
			insertHere.childElement.add(newNode);
			insertHere = newNode;
			charcount++;
		}
		
		insertHere.isaWord = true;
		ArrayList<String> prefixesInWord = prefixList.get(word);


		return prefixesInWord;
	}


	public Node search(String word, Node root)
	{
		Node result = returnPrefixNode(word, root, 0, false);
		if(result.isaWord)
		{
			return result;
		}
		else
		{
			return null;
		}
	}

	public Node returnPrefixNode(String word, Node root, int position, boolean trackPrefix)
	{
		root.triePosition = position;
		ListIterator<Node> listIterator = root.childElement.listIterator();

		Node returnNode = root;
		if(returnNode.isaWord && trackPrefix)
		{
			String partialWord="";
			int count = 0;
			while(count < position)
			{
				partialWord = partialWord + word.charAt(count); 
				count++;
			}
			if(prefixList.get(word) == null){
				prefixList.put(word, new ArrayList<String>());
				ArrayList<String> addto = prefixList.get(word);
				addto.add(partialWord);
			}
			else
			{
				ArrayList<String> addto = prefixList.get(word);
				if(!addto.contains(partialWord))
					addto.add(partialWord);
			}

		}
		while (listIterator.hasNext()) {
			Node current = listIterator.next();
			if(position == word.length())
			{
				break;
			}
			char letter = word.charAt(position);
			if(letter == current.letter)
			{
				position++;
				returnNode = returnPrefixNode(word, current, position, trackPrefix);
				break;
			}

		}

		return(returnNode);

	}

}
