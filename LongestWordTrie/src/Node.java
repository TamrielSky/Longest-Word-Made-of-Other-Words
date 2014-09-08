/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;

/**
 *
 * @author rajeshba
 */
public class Node {
	char letter;
	String prefix;
	int triePosition;
	boolean searched;
	LinkedList<Node> childElement = new LinkedList<Node>();
	boolean isaWord = false;

	public Node(char c)
	{
		letter = c;

	}
}
